package com.example.jumping.fragmentpractice;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by Jumping on 2016/8/5.
 */
public class NewsContentActivity extends Activity {
    public static void  actionstart(Context context,String newstitle,String newscontent){
        Intent intent = new Intent(context, NewsContentActivity.class);
        intent.putExtra("news_title", newstitle);
        intent.putExtra("news_content", newscontent);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.news_content);
        String newstitle = getIntent().getStringExtra("news_title");
        String newscontent = getIntent().getStringExtra("news_content");
        NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment2);
        newsContentFragment.refresh(newstitle, newscontent);
    }
}
