package org.sandec.klinik.puskesmas.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import org.sandec.klinik.puskesmas.fragment.LayananFinishedFragment;
import org.sandec.klinik.puskesmas.fragment.LayananProgressFragment;

/**
 * Created by wakhyudi on 23/12/17.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int tabCount;
    public PagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                LayananProgressFragment tab1 = new LayananProgressFragment();
                return tab1;
            case 1:
                LayananFinishedFragment tab2 = new LayananFinishedFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
