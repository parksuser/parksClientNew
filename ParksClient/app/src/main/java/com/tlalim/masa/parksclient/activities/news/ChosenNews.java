package com.tlalim.masa.parksclient.activities.news;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.parse.GetDataCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.tlalim.masa.parksclient.R;
import com.tlalim.masa.parksclient.adapter.ImageAdapterChosenNews;
import com.tlalim.masa.parksclient.commondata.CommonDataSingleton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ChosenNews extends AppCompatActivity {

    private int position;
    private SimpleDateFormat sdf;
    private ViewPager viewPager;
    private ArrayList<byte[]> byteArray;
    private ImageAdapterChosenNews imageAdapter;

    public ArrayList<byte[]> getByteArray() {
        return byteArray;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chosen_news);
        Intent intent = getIntent();
        position = intent.getIntExtra("position", 0);

        byteArray = new ArrayList<>();

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        imageAdapter = new ImageAdapterChosenNews(getSupportFragmentManager(), this);

        if (CommonDataSingleton.getInstance().getArrayHotNews().get(position).getPics()!=null) {
            for (ParseFile pf : CommonDataSingleton.getInstance().getArrayHotNews().get(position).getPics()) {
                pf.getDataInBackground(new GetDataCallback() {
                    @Override
                    public void done(byte[] bytes, ParseException e) {
                        byteArray.add(bytes);
                        viewPager.setAdapter(imageAdapter);
                    }
                });
            }
        }
        else {
            ParseFile pf=CommonDataSingleton.getInstance().getArrayHotNews().get(position).getPreviewpic();
            pf.getDataInBackground(new GetDataCallback() {
                @Override
                public void done(byte[] bytes, ParseException e) {
                    byteArray.add(bytes);
                    viewPager.setAdapter(imageAdapter);
                }
            });

        }

        TextView tvTitle = (TextView) findViewById(R.id.ChosenNewsTitle);
        tvTitle.setText(CommonDataSingleton.getInstance().getArrayHotNews().get(position).getTitle());

        sdf = new SimpleDateFormat("yyyy/MM/dd");
        TextView tvDate = (TextView) findViewById(R.id.ChosenNewsDate);
        tvDate.setText(sdf.format(CommonDataSingleton.getInstance().getArrayHotNews().get(position).getDateToPublish()));

        TextView tvText = (TextView) findViewById(R.id.textViewChosenNews);
        tvText.setText(CommonDataSingleton.getInstance().getArrayHotNews().get(position).getText());
    }
}