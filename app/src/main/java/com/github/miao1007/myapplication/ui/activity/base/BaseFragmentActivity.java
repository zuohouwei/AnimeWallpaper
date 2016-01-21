package com.github.miao1007.myapplication.ui.activity.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.github.miao1007.myapplication.R;;

/**
 * Created by leon on 1/28/15.
 * Best for : Webview, Settings , About
 * UI elements included only
 */
public abstract class BaseFragmentActivity extends AppCompatActivity {

  @Bind(R.id.toolbar_holder) RelativeLayout mToolbarHolder;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // Init the swipe back
    setTheme(android.R.style.Theme_DeviceDefault_Light_NoActionBar);
    setContentView(R.layout.activity_base_fragment);
    ButterKnife.bind(this);
    getSupportFragmentManager().beginTransaction()
        .replace(R.id.base_fragment_container, getSupportFragment())
        .commit();
  }

  abstract public Fragment getSupportFragment();

  public void trySetupToolbar(Toolbar mToolbar) {
    try {
      setSupportActionBar(mToolbar);
      //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    } catch (NullPointerException e) {
      Log.e(getClass().getSimpleName(), "toolbar is null!");
    }
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == android.R.id.home) {
      onBackPressed();
    }
    return super.onOptionsItemSelected(item);
  }
}
