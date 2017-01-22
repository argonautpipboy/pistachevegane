package app.pistachevegane.com;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import app.pistachevegane.com.components.ExpandableListAdapter;

public class ParametersActivity extends CommonActivity {

    private ExpandableListAdapter listAdapter;
    private ExpandableListView expListView;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;

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

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.list_params);
        // prepare the datas
        prepareDatas();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        // setting list adapter
        expListView.setAdapter(listAdapter);
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

    private void prepareDatas(){
        listDataHeader = new ArrayList<String>();

        listDataHeader.add(getString(R.string.parameters_title_whoweare));
        listDataHeader.add(getString(R.string.parameters_title_contactus));
        listDataHeader.add(getString(R.string.parameters_title_licenceandthanks));

        List<String> listDataWho = new ArrayList<String>();
        listDataWho.add(getString(R.string.parameters_label_whoweare));

        List<String> listDataContact = new ArrayList<String>();
        listDataContact.add(getString(R.string.parameters_label_contactus));

        List<String> listDataLicence = new ArrayList<String>();
        listDataLicence.add(getString(R.string.parameters_label_licenceandthanks1));
        listDataLicence.add(getString(R.string.parameters_label_licenceandthanks2));

        listDataChild = new HashMap<String, List<String>>();
        listDataChild.put(listDataHeader.get(0), listDataWho);
        listDataChild.put(listDataHeader.get(1), listDataContact);
        listDataChild.put(listDataHeader.get(2), listDataLicence);
    }
}
