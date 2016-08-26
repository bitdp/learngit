package com.example.dongpeng.myapplication.fresco;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.example.dongpeng.myapplication.R;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dongpeng on 2016/8/23.
 */
public class FrescoActivity extends Activity {
    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.button_clear)
    Button buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myfragment_lay);
        ButterKnife.bind(this);
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add("http://www.baidu.com/");
//            data.add("http://img1.imgtn.bdimg.com/it/u=2363027421,438461014&fm=206&gp=0.jpg");
            data.add("http://img2.imgtn.bdimg.com/it/u=4136314775,1144845973&fm=206&gp=0.jpg");
            data.add("http://img1.imgtn.bdimg.com/it/u=3314956664,1309829475&fm=206&gp=0.jpg");
        }
        GridLayoutManager manager = new GridLayoutManager(FrescoActivity.this, 1);
        MyFrescoAdapter adapter = new MyFrescoAdapter(FrescoActivity.this,data);
        recycleView.setLayoutManager(manager);
        recycleView.setAdapter(adapter);
        recycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                switch (newState) {
                    case RecyclerView.SCROLL_STATE_DRAGGING:
                        Fresco.getImagePipeline().pause();
                        break;
                    case RecyclerView.SCROLL_STATE_SETTLING:
                        if (Fresco.getImagePipeline().isPaused()) {
                            Fresco.getImagePipeline().resume();
                        }
                        break;
                    case RecyclerView.SCROLL_STATE_IDLE:
                        if (Fresco.getImagePipeline().isPaused()) {
                            Fresco.getImagePipeline().resume();
                        }
                        break;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    @OnClick(R.id.button_clear)
    public void onClick() {
        Uri uri=Uri.parse("http://img2.imgtn.bdimg.com/it/u=4136314775,1144845973&fm=206&gp=0.jpg");
        Fresco.getImagePipeline().evictFromCache(uri);
    }
}
