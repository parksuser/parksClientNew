package com.tlalim.masa.parksclient.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.parse.ParseException;
import com.tlalim.masa.parksclient.R;
import com.tlalim.masa.parksclient.commondata.CommonDataSingleton;
import com.tlalim.masa.parksclient.parsetables.News;

import java.text.SimpleDateFormat;

/**
 * Created by Marina on 27.12.2015.
 */
public class ClientNewsAdapter extends BaseAdapter {


    private Context context;
    private SimpleDateFormat sdf;
    private News news;

    public ClientNewsAdapter(Context context) {

        this.context = context;
    }

    @Override
    public int getCount() {
        return CommonDataSingleton.getInstance().getArrayHotNews().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        RelativeLayout rl = (RelativeLayout) inflater.inflate(R.layout.news,
                viewGroup, false);

        news = CommonDataSingleton.getInstance().getArrayHotNews().get(position);

        ImageView iv = (ImageView) rl.findViewById(R.id.imageView);

        try {
            iv.setImageBitmap(BitmapFactory.decodeByteArray(news.getPreviewpic().getData(), 0, news.getPreviewpic().getData().length));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        TextView title = (TextView) rl.findViewById(R.id.textViewTitle);
        title.setText(news.getTitle());
        title.setTextColor(Color.BLACK);

        sdf = new SimpleDateFormat("yyyy/MM/dd");
        TextView date = (TextView) rl.findViewById(R.id.textViewDate);
        date.setText(sdf.format(news.getDateToPublish()));
        date.setTextColor(Color.BLACK);

        TextView shortcut = (TextView) rl.findViewById(R.id.textViewShortcut);
        shortcut.setText(news.getPreviewtext());
        shortcut.setTextColor(Color.BLACK);

        return rl;
    }
}
