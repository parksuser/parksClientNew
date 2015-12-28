package com.tlalim.masa.parksclient.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.tlalim.masa.parksclient.activities.news.ChosenNews;
import com.tlalim.masa.parksclient.activities.news.SwipeOfChosenNewsFragment;

/**
 * Created by Marina on 27.12.2015.
 */
public class ImageAdapterChosenNews extends FragmentStatePagerAdapter {

    private ChosenNews chosenNews;
    private byte[] data;

    public ImageAdapterChosenNews(FragmentManager fm, ChosenNews news) {
        super(fm);
        this.chosenNews = news;
    }

    @Override
    public int getCount() {

        return chosenNews.getByteArray().size();
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = new SwipeOfChosenNewsFragment();
        Bundle bundle = new Bundle();

        data = chosenNews.getByteArray().get(position);
        bundle.putByteArray("pictures", data);
        fragment.setArguments(bundle);

        return fragment;
    }
}


// View Flipper
// Еще один вариант осуществления Swipe, но без использования фрагментов

//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//
//
//        imageView = new ImageView(context);
//
//        int padding = context.getResources().getDimensionPixelSize(R.dimen.activity_vertical_margin);
//        imageView.setPadding(padding, padding, padding, padding);
//        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
//        imageView.setImageDrawable(myDrawable.get(position));
//        //imageView.setImageDrawable(arrayofpics().get(position));
//        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" +(myDrawable.get(position)));
//        ((ViewPager) container).addView(imageView, 0);
//        return imageView;
//    }

//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        ((ViewPager) container).removeView((ImageView) object);
//    }
