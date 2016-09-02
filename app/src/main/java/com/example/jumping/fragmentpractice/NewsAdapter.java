package com.example.jumping.fragmentpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jumping on 2016/8/5.
 */
public class NewsAdapter extends ArrayAdapter<News> {
    private int resourceid;

    public NewsAdapter(Context context, int textviewresourceid, List<News> objects) {
        super(context, textviewresourceid, objects);
        resourceid = textviewresourceid;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        News news = getItem(position);
        View view;
        if (convertView==null){
            view = LayoutInflater.from(getContext()).inflate(resourceid, null);
        } else {
            view = convertView;
        }
        TextView newstitletext = (TextView) view.findViewById(R.id.news_title);
        newstitletext.setText(news.getTitle());
        return view;
    }
}
