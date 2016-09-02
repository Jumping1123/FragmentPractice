package com.example.jumping.fragmentpractice;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Jumping on 2016/8/5.
 */
public class NewsContentFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_content_fragment, container, false);
        return view;
    }

    public void refresh(String newstitle, String newscontent){
        View visibilitylayout = view.findViewById(R.id.visibility_layout);
        visibilitylayout.setVisibility(View.VISIBLE);
        TextView newstitletext = (TextView) view.findViewById(R.id.news_title);
        TextView newscontenttext = (TextView) view.findViewById(R.id.news_content);
        newstitletext.setText(newstitle);
        newscontenttext.setText(newscontent);

    }
}
