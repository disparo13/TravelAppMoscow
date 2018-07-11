package su.mikheev.alex.travelappmoscow;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Displays a {@link ViewPager} where each page shows a fragment.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Getting tab titles from strings array to pass it to FragmentPagerAdapter later
        String tabTitles[] = getApplicationContext().getResources().getStringArray(R.array.tabs_array);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        MoscowFragmentPagerAdapter adapter = new MoscowFragmentPagerAdapter(getSupportFragmentManager(),
                MainActivity.this, tabTitles);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);

        tabLayout.setupWithViewPager(viewPager);

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);
    }
}