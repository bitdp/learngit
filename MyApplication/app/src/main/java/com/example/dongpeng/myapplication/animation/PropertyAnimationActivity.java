package com.example.dongpeng.myapplication.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dongpeng.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 属性动画
 * Created by dongpeng on 2016/8/25.
 */
public class PropertyAnimationActivity extends Activity {
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.myAnimatorView)
    MyAnimatorView myAnimatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation_layout);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.button, R.id.myAnimatorView})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.myAnimatorView:
                Toast.makeText(PropertyAnimationActivity.this, "myAnimatorView", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button:
                ObjectAnimator animator1=ObjectAnimator.ofObject(myAnimatorView,"point",new MyTypeEvaluator(),new Point(50,50),new Point(720,1000));
//                animator1.setDuration(5000);
//                animator1.start();
                ObjectAnimator animator2=ObjectAnimator.ofObject(myAnimatorView,"color",new MyColorTypeEvaluator(),"#ff00ff","#00ff00");
                AnimatorSet set=new AnimatorSet();
                set.play(animator1).with(animator2);
                set.setDuration(5000);
                set.start();
                break;

        }
    }
}
