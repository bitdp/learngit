package com.example.dongpeng.myapplication.bottomsheet;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;
import com.cocosw.bottomsheet.BottomSheet;
import com.example.dongpeng.myapplication.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 * 底部弹窗
 * 需要添加依赖 compile 'com.cocosw:bottomsheet:1.3.0'
 * Created by dongpeng on 2016/8/24.
 */
public class BottomSheetActivity extends Activity {
    @BindView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rx_layout);
        ButterKnife.bind(this);
        button.setText("BottomSheetDialog");
    }

    @OnClick(R.id.button)
    public void onClick() {
        BottomSheet.Builder builder = new BottomSheet.Builder(BottomSheetActivity.this);
        builder.title("选择城市").icon(R.mipmap.a).sheet(R.menu.bottom_menu).listener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.beijing:
                        Toast.makeText(BottomSheetActivity.this, "beijing", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.shanghai:
                        Toast.makeText(BottomSheetActivity.this, "shanghai", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        }).build().show();
    }
}
