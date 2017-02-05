package app.pistachevegane.com;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import app.pistachevegane.com.components.VeganProductListAdapter;
import app.pistachevegane.com.model.VeganProduct;

public class VeganOrNotActivity extends CommonActivity {

    private VeganProductListAdapter adapter;
    private List<VeganProduct> veganProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veganornot);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_veganornot);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.menu_item_veganornot);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout_veganornot);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view_veganornot);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(4).setChecked(true);

        // Manage search and list initialisation
        initializeListVeganProduct();
        ListView lv = (ListView) findViewById(R.id.list_veganProducts);
        // Adding items to listview
        adapter = new VeganProductListAdapter(this, veganProducts);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        EditText inputSearchVeganOrNot = (EditText) findViewById(R.id.inputSearchVeganOrNot);
        inputSearchVeganOrNot.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                VeganOrNotActivity.this.adapter.getFilter().filter(cs);
            }
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // nothing to do here
            }
            @Override
            public void afterTextChanged(Editable arg0) {
                // nothing to do here
            }
        });
    }

    @Override
    protected void onRestart() {
        if(navigationView != null){
            navigationView.getMenu().getItem(4).setChecked(true);
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

    private void initializeListVeganProduct(){
        veganProducts = new ArrayList<VeganProduct>();
        VeganProduct veganProduct1 = new VeganProduct();
        veganProduct1.setTitleProduct("E131 Bleu patenté V");
        veganProduct1.setTypeProduct("Colorants bleu");
        veganProduct1.setSourceProduct(getResources().getString(R.string.veganproduct_source_vegan));

        VeganProduct veganProduct2 = new VeganProduct();
        veganProduct2.setTitleProduct("E524 Hydroxyde de sodium");
        veganProduct2.setTypeProduct("Acidifiants");
        veganProduct2.setSourceProduct(getResources().getString(R.string.veganproduct_source_vegan));

        VeganProduct veganProduct3 = new VeganProduct();
        veganProduct3.setTitleProduct("E1521 Polyéthylène-glycol");
        veganProduct3.setTypeProduct("Divers");
        veganProduct3.setSourceProduct(getResources().getString(R.string.veganproduct_source_animal));

        VeganProduct veganProduct4 = new VeganProduct();
        veganProduct4.setTitleProduct("E1101ii Papaïne");
        veganProduct4.setTypeProduct("Exhausteurs");
        veganProduct4.setSourceProduct(getResources().getString(R.string.veganproduct_source_animal));

        VeganProduct veganProduct5 = new VeganProduct();
        veganProduct5.setTitleProduct("E942 Octafluorocyclobutane");
        veganProduct5.setTypeProduct("Divers");
        veganProduct5.setSourceProduct(getResources().getString(R.string.veganproduct_source_animal));

        VeganProduct veganProduct6 = new VeganProduct();
        veganProduct6.setTitleProduct("E560 Silicate de potassium");
        veganProduct6.setTypeProduct("Divers");
        veganProduct6.setSourceProduct(getResources().getString(R.string.veganproduct_source_animal));

        veganProducts.add(veganProduct1);
        veganProducts.add(veganProduct2);
        veganProducts.add(veganProduct3);
        veganProducts.add(veganProduct4);
        veganProducts.add(veganProduct5);
        veganProducts.add(veganProduct6);
    }
}
