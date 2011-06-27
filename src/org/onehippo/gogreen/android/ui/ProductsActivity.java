package org.onehippo.gogreen.android.ui;

import java.util.ArrayList;

import org.onehippo.gogreen.android.R;
import org.onehippo.gogreen.android.adapter.ProductAdapter;
import org.onehippo.gogreen.android.data.Product;
import org.onehippo.gogreen.android.service.ProductService;
import org.onehippo.gogreen.android.utils.UIUtils;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

/**
 * Products activity for displaying a list of products
 * @author Jeroen Reijn
 */
public class ProductsActivity extends ListActivity {

    private ArrayList<Product> products;
    private ProductAdapter productAdapter;
    private ProgressDialog progressDialog = null;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topproducts);

        products = new ArrayList<Product>();
        productAdapter = new ProductAdapter(this, R.layout.list_item_product, products);
        setListAdapter(productAdapter);

        final Runnable viewProducts = new Runnable() {

            public void run() {
                getProducts();
            }
        };

        Thread thread = new Thread(null, viewProducts, "MagentoBackground");
        thread.start();
        progressDialog = ProgressDialog.show(ProductsActivity.this,
                "Please wait...", "Retrieving data ...", true);
    }

    /**
     * Get the products
     */
    private void getProducts() {
        try {
            products = ProductService.getAllProductsFromHippo();
            Log.i("ARRAY", "" + products.size());
        } catch (Exception e) {
            Log.e("BACKGROUND_PROC", e.getMessage());
        }
        runOnUiThread(returnRes);
    }

    @Override
    protected void onListItemClick(final ListView l, final View v, final int position, final long id) {
        Product product = (Product) l.getItemAtPosition(position);
        Product.selected = product;
        Intent intent = new Intent(this,ProductDetailActivity.class);
        startActivity(intent);
    }

    private Runnable returnRes = new Runnable() {

        public void run() {
            if (products != null && products.size() > 0) {
                productAdapter.notifyDataSetChanged();
                for (Product product : products) {
                    productAdapter.add(product);
                }
            }
            progressDialog.dismiss();
            productAdapter.notifyDataSetChanged();
        }
    };

    /**
     * Handle "search" title-bar action.
     * @param v the view
     */
    public void onEventsSearchClick(View v) {
        UIUtils.goSearch(this);
    }


    public void onHomeClick(View v) {
        UIUtils.goHome(this);
    }

}
