package app.pistachevegane.com;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class ParametersActivity extends CommonActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parameters);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_parameters);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.menu_item_parameters);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout_parameters);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view_parameters);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(5).setChecked(true);
    }

    @Override
    protected void onRestart() {
        if(navigationView != null){
            navigationView.getMenu().getItem(5).setChecked(true);
            super.onRestart();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        if(drawer != null){
            drawer.closeDrawer(GravityCompat.START);
        }
        return super.onNavigationItemSelected(item);
    }
}
