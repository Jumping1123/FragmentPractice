package com.example.jumping.fragmentpractice;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jumping on 2016/8/5.
 */
public class NewsTitleFragment extends Fragment{
    private ListView newstitlelistview;
    public List<News> newsList;
    private NewsAdapter adapter;
    private boolean istwopane;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        initNews();
        adapter = new NewsAdapter(activity, R.layout.news_item, newsList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_fragment, container, false);
        newstitlelistview = (ListView) view.findViewById(R.id.news_title_list_view);
        newstitlelistview.setAdapter(adapter);
        newstitlelistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News news = newsList.get(position);
                if (istwopane){
                    NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment);
                    newsContentFragment.refresh(news.getTitle(), news.getContent());
                } else {
                    NewsContentActivity.actionstart(getActivity(), news.getTitle(), news.getContent());
                }
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.news_content_layout)!=null){
            istwopane = true;
        } else {
            istwopane = false;
        }
    }

    private void initNews(){
        newsList = new ArrayList<News>();
        News news1 = new News();
        news1.setTitle("Succeed in College as a Learning Disabled Student");
        news1.setContent("College freshmen will soon learn to live with a roommate,adjust to a new social scene and survive less-than-stellar dining hall food.Students with learning disabilities will face these transitions while also grappling with a few more hurdles.");
        newsList.add(news1);
        News news2 = new News();
        news2.setTitle("Google Android exec poached by China's Xiaomi");
        news2.setContent("China's Xiaomi has poached a key Google excecutive involved in the tech giant's Ansroid phones,in a move seen as a coup for the rapidly growing Chinese smartphone maker.");
        newsList.add(news2);
    }
}
