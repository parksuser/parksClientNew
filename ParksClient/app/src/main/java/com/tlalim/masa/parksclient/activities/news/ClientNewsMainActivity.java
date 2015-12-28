package com.tlalim.masa.parksclient.activities.news;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.tlalim.masa.parksclient.R;
import com.tlalim.masa.parksclient.adapter.ClientNewsAdapter;
import com.tlalim.masa.parksclient.commondata.CommonDataSingleton;
import com.tlalim.masa.parksclient.parsetables.News;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClientNewsMainActivity extends AppCompatActivity {

    private ClientNewsAdapter adapter;
    private ListView listView;
    private ParseQuery<ParseObject> query;
    private List<ParseObject> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_news_main);
        adapter = new ClientNewsAdapter(getApplicationContext());
        listView = (ListView) findViewById(R.id.listViewHotNews);
        listView.setAdapter(adapter);

        setNewListView(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ClientNewsMainActivity.this, ChosenNews.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }

    public void HotNews(View view) {
        setNewListView(true);
    }

    public void NewsOfNature(View view) {
        setNewListView(false);
    }

    public void setNewListView(boolean typeOfNews) {
        CommonDataSingleton.getInstance().getArrayHotNews().clear();

        query = ParseQuery.getQuery("News");
        query.whereEqualTo("category", typeOfNews);
        try {
            list = query.find();
            for (int i = 0; i < list.size(); i++) {
                News news = new News(
                        list.get(i).getObjectId(),
                        list.get(i).getString("title"),
                        list.get(i).getDate("dateToPublish"),
                        list.get(i).getString("previewtext"),
                        list.get(i).getParseFile("previewpic"),
                        (ArrayList<ParseFile>) list.get(i).get("pics"),
                        list.get(i).getString("text"));

                CommonDataSingleton.getInstance().getArrayHotNews().add(news);
                Collections.sort(CommonDataSingleton.getInstance().getArrayHotNews(), new Comparator<News>() {
                    @Override
                    public int compare(News object1, News object2) {
                        return object2.getDateToPublish().compareTo(object1.getDateToPublish());
                    }
                });
                listView.invalidateViews();
            }
        } catch (ParseException e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
    }
}


/*

SLIDESHOW!!!!!!!!!!!!!!!!!!!!
viewFlipper = (ViewFlipper) this.findViewById(R.id.view_flipper);
            fade_in = AnimationUtils.loadAnimation(this,
                    android.R.anim.fade_in);
            fade_out = AnimationUtils.loadAnimation(this,
                    android.R.anim.fade_out);
            viewFlipper.setInAnimation(fade_in);
            viewFlipper.setOutAnimation(fade_out);
//sets auto flipping
            viewFlipper.setAutoStart(true);
            viewFlipper.setFlipInterval(5000);
            viewFlipper.startFlipping();
 */