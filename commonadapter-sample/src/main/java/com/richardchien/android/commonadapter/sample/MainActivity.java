package com.richardchien.android.commonadapter.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.richardchien.android.commonadapter.CommonAdapter;
import com.richardchien.android.commonadapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private List<Bean> mDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDataList();

        mListView = (ListView) findViewById(R.id.list_view);
        mListView.setAdapter(new CommonAdapter<Bean>(this, mDataList, R.layout.list_item) {
            @Override
            public void onPostCreateView(ViewHolder holder, Bean bean) {
                holder.setViewText(R.id.text_title, bean.getTitle())
                        .setViewText(R.id.text_description, bean.getDesciption())
                        .setViewImageResource(R.id.image_view, bean.getImageResId());
            }
        });
    }

    private void initDataList() {
        mDataList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mDataList.add(new Bean("Title " + (i + 1), "This is description " + (i + 1), R.mipmap.ic_launcher));
        }
    }

    class Bean {
        private String title;
        private String desciption;
        private int imageResId;

        public Bean(String title, String desciption, int imageResId) {
            this.title = title;
            this.desciption = desciption;
            this.imageResId = imageResId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesciption() {
            return desciption;
        }

        public void setDesciption(String desciption) {
            this.desciption = desciption;
        }

        public int getImageResId() {
            return imageResId;
        }

        public void setImageResId(int imageResId) {
            this.imageResId = imageResId;
        }
    }
}
