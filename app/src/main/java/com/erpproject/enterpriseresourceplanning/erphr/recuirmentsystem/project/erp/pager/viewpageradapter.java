package com.erpproject.enterpriseresourceplanning.erphr.recuirmentsystem.project.erp.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;



public class viewpageradapter  extends FragmentPagerAdapter {

    List<Fragment>fragments = new ArrayList<>();
    List<String> tabtitles = new ArrayList<>();

    public  void addfragment(Fragment fragment , String tabtitles){
        this.fragments.add(fragment);
        this.tabtitles.add(tabtitles);

    }

    public viewpageradapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles.get(position);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
