package org.onehippo.gogreen.android.adapter;

import java.util.ArrayList;

import org.onehippo.gogreen.android.R;
import org.onehippo.gogreen.android.data.Product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
            addTitleToView(itemView, product);
        }
        return itemView;
    }

    private void addTitleToView(final View itemView, final Product product) {
        TextView tt = (TextView) itemView.findViewById(R.id.product_title);
        if (tt != null) {
            tt.setText(product.getLocalizedName());
        }
    }
}