package su.mikheev.alex.travelappmoscow;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MoscowFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context context;
    // The number of pages
    final int PAGE_COUNT = 4;

    // Defining Tab titles
    private String tabTitles[] = new String[]{"Parks", "Museums", "Monuments", "Clubs"};

    public MoscowFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ParksFragment();
        } else if (position == 1) {
            return new MuseumsFragment();
        } else if (position == 2) {
            return new MonumentsFragment();
        } else {
            return new ClubsFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

}

