package org.onehippo.gogreen.android.ui;

import org.onehippo.gogreen.android.R;
import org.onehippo.gogreen.android.utils.UIUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Activity for the home screen.
 * @author Jeroen Reijn
 */
public class HomeActivity extends Activity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    /**
     * Handle "refresh" title-bar action.
     */
    public void onRefreshClick(View v) {

    }

    /**
     * Handle "search" title-bar action.
     */
    public void onSearchClick(View v) {
        UIUtils.goSearch(this);
    }

    /**
     * Handle "schedule" action.
     */
    public void onEventsClick(View v) {
        // Launch events view
        startActivity(new Intent(this, EventsActivity.class));
    }

    /**
     * Handle "products" action.
     */
    public void onProductsClick(View v) {
        // Launch events view
        startActivity(new Intent(this, ProductsActivity.class));
    }

}
