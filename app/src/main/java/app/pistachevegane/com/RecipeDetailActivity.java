package app.pistachevegane.com;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import app.pistachevegane.com.components.RecipeDetailsViewPagerAdapter;
import app.pistachevegane.com.fragment.IngredientsFragment;
import app.pistachevegane.com.fragment.RealisationFragment;

public class RecipeDetailActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        this.overridePendingTransition(R.anim.enter, R.anim.exit);

        //viewPager = (ViewPager) findViewById(R.id.recipeDetailsViewPager);
        //setupViewPager(viewPager);

        //tabLayout = (TabLayout) findViewById(R.id.recipeDetailsTabs);
        //tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        RecipeDetailsViewPagerAdapter adapter = new RecipeDetailsViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new IngredientsFragment(), getString(R.string.title_tab_ingredients).toUpperCase());
        adapter.addFragment(new RealisationFragment(), getString(R.string.title_tab_realisation).toUpperCase());
        viewPager.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        this.overridePendingTransition(R.anim.enter, R.anim.exit);
        super.onStart();
    }

    @Override
    protected void onRestart() {
        this.overridePendingTransition(R.anim.enter, R.anim.exit);
        super.onRestart();
    }
}
