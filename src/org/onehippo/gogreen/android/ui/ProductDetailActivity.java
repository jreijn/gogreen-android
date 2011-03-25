package org.onehippo.gogreen.android.ui;

import org.onehippo.gogreen.android.R;
import org.onehippo.gogreen.android.data.Product;
import org.onehippo.gogreen.android.service.ProductService;
import org.onehippo.gogreen.android.utils.ImageUtils;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Detail activity for a {@link Product}
 * 
 * @author Jeroen Reijn
 */
public class ProductDetailActivity extends Activity {

    private static final String PRODUCT = "product";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
    }

    @Override
	protected void onResume() {
		super.onResume();

        Product product = ProductService.getProductByURL(Product.selected.getProductLink());

		TextView nameView = (TextView) findViewById(R.id.product_name);
        nameView.setText(product.getLocalizedName());
        ImageView imageView = (ImageView) findViewById(R.id.product_image);
        imageView.setImageBitmap(ImageUtils.fetchImage(product.getImage()));

        TextView descriptionView = (TextView) findViewById(R.id.product_description);
        descriptionView.setText(Html.fromHtml(product.getDescription()));
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		Product.selected = (Product) savedInstanceState.getSerializable(PRODUCT);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putSerializable(PRODUCT, Product.selected);
	}
}