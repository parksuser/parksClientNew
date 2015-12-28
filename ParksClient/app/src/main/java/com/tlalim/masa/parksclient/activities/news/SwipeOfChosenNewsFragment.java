package com.tlalim.masa.parksclient.activities.news;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tlalim.masa.parksclient.R;


public class SwipeOfChosenNewsFragment extends android.support.v4.app.Fragment {
    ImageView imageView;
    Bitmap bitmap;
    byte[] data;


    public SwipeOfChosenNewsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_swipe_of_chosen_news, container, false);
        imageView = (ImageView) view.findViewById(R.id.swipeImageOfChosenNews);
        Bundle bundle = getArguments();
        data = bundle.getByteArray("pictures");

        bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
        imageView.setImageBitmap(bitmap);

        return view;
    }

}
