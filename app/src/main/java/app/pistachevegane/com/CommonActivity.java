package app.pistachevegane.com;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class CommonActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    protected NavigationView navigationView = null;
    protected DrawerLayout drawer = null;

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.menu_item_myreceipes) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.menu_item_favoris) {
            Intent intent = new Intent(this, FavoritesActivity.class);
            startActivity(intent);
        } else if (id == R.id.menu_item_receipesbyingredients) {
            Intent intent = new Intent(this, RecipesActivity.class);
            startActivity(intent);
        } else if (id == R.id.menu_item_alternativesvegans) {
            Intent intent = new Intent(this, AlternativesVeganActivity.class);
            startActivity(intent);
        } else if (id == R.id.menu_item_veganornot) {
            Intent intent = new Intent(this, VeganOrNotActivity.class);
            startActivity(intent);
        } else if (id == R.id.menu_item_parameters) {
            Intent intent = new Intent(this, ParametersActivity.class);
            startActivity(intent);
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawer != null) {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }
    }
}
