package org.onehippo.gogreen.android.ui;

import java.util.ArrayList;

import org.onehippo.gogreen.android.R;
import org.onehippo.gogreen.android.adapter.ProductAdapter;
import org.onehippo.gogreen.android.data.Product;
import org.onehippo.gogreen.android.service.ProductService;
import org.onehippo.gogreen.android.utils.UIUtils;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Activity for the events screen
 * 
 * @author Jeroen Reijn
 */
public class TopProductsActivity extends Activity {

    private ArrayList<Product> products;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topproducts);

    }

    private void getProducts() {
        try {
            products = ProductService.getAllProductsFromHippo();
            Log.i("ARRAY", "" + products.size());
        } catch (Exception e) {
            Log.e("BACKGROUND_PROC", e.getMessage());
        }
    }

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
