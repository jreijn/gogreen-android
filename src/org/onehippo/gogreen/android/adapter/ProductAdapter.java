package org.onehippo.gogreen.android.adapter;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import org.onehippo.gogreen.android.R;
import org.onehippo.gogreen.android.data.Product;
import org.onehippo.gogreen.android.utils.ImageUtils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Adapter for showing products in a list view.
 *
 * @author Jeroen Reijn
 */
public class ProductAdapter extends ArrayAdapter<Product> {

    private ArrayList<Product> items;
    private Context context;

    public ProductAdapter(Context context, int textViewResourceId, ArrayList<Product> items) {
        super(context, textViewResourceId, items);
        this.items = items;
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View itemView = view;
        if (itemView == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = vi.inflate(R.layout.list_item_product, null);
        }
        Product product = items.get(position);
        if (product != null) {
            addProductToView(itemView, product);
        }
        return itemView;
    }

    private void addProductToView(final View itemView, final Product product) {
        setProductName(itemView, product);
        setPrice(itemView, product);
        setImage(itemView, product);
    }

    private void setProductName(final View itemView, final Product product) {
        TextView productName = (TextView) itemView.findViewById(R.id.product_title);
        if (productName != null) {
            productName.setText(product.getLocalizedName());
        }
    }

    private void setImage(final View itemView, final Product product) {
        ImageView imageView = (ImageView) itemView.findViewById(R.id.product_image);
        if(imageView!=null) {
            imageView.setImageBitmap(ImageUtils.fetchImage(product.getSmallThumbnail()));
        }
    }

    private void setPrice(final View itemView, final Product product) {
        TextView price = (TextView) itemView.findViewById(R.id.product_price);
        if (price != null) {
            NumberFormat numberFormat = new DecimalFormat("0.00");
            numberFormat.setParseIntegerOnly(false);
            double doublePrice = Double.valueOf(product.getPrice());
            price.setText("€ "+numberFormat.format(doublePrice));
        }
    }
}