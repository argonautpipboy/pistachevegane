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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import app.pistachevegane.com.components.RecipeListAdapter;
import app.pistachevegane.com.model.Recipe;

public class RecipesActivity extends CommonActivity {

    private ListView lv;
    private RecipeListAdapter adapter;
    private EditText inputSearch;
    private List<Recipe> recipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_recipes);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.menu_item_receipesbyingredients);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout_recipes);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view_recipes);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(2).setChecked(true);

        // Manage search and list initialisation
        initialiseListRecipes();
        lv = (ListView) findViewById(R.id.list_myrecipes);
        inputSearch = (EditText) findViewById(R.id.inputSearch);
        // Adding items to listview
        adapter = new RecipeListAdapter(this, recipes);
        lv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                RecipesActivity.this.adapter.getFilter().filter(cs);
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
            navigationView.getMenu().getItem(2).setChecked(true);
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

    private void initialiseListRecipes(){
        recipes = new ArrayList<Recipe>();
        Recipe recipe1 = new Recipe();
        recipe1.setTitle("Bun's aux légumes d'été");
        recipe1.setComplexity("HARD");
        recipe1.setIdentifierDrawablePicture(1);
        recipe1.setLabelTime("60 Min");
        recipe1.setTimeToCook(10);
        recipe1.setType("ENTREE");

        Recipe recipe2 = new Recipe();
        recipe2.setTitle("Lasagnes, Légumes et Soja");
        recipe2.setComplexity("EASY");
        recipe2.setIdentifierDrawablePicture(2);
        recipe2.setLabelTime("60 Min");
        recipe2.setTimeToCook(30);
        recipe2.setType("PLAT");

        Recipe recipe3 = new Recipe();
        recipe3.setTitle("Le superbe flageolet burger");
        recipe3.setComplexity("VEASY");
        recipe3.setIdentifierDrawablePicture(1);
        recipe3.setLabelTime("20 Min");
        recipe3.setTimeToCook(60);
        recipe3.setType("DESSERT");

        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
    }
}
