package com.cortek.calcuthebook;
import java.util.ArrayList;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

public class FragPagerAdapter extends FragmentPagerAdapter {
        ArrayList<Fragment> list;
        public FragPagerAdapter(FragmentManager fm,ArrayList<Fragment> list) {
            super(fm);
            this.list = list;

        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Fragment getItem(int arg0) {
            return list.get(arg0);
        }
}
