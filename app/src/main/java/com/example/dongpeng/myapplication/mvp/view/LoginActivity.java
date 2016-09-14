package com.example.dongpeng.myapplication.mvp.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dongpeng.myapplication.R;
import com.example.dongpeng.myapplication.mvp.presenter.ILoginPresenter;
import com.example.dongpeng.myapplication.mvp.presenter.LoginPresenterCompl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dongpeng on 2016/9/1.
 */
public class LoginActivity extends Activity implements ILoginView {
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_age)
    EditText etAge;
    @BindView(R.id.button_login)
    Button buttonLogin;
    @BindView(R.id.button_clear)
    Button buttonClear;
    ILoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_lay);
        ButterKnife.bind(this);
        presenter = new LoginPresenterCompl(this);
    }


    @OnClick({R.id.button_clear, R.id.button_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_clear:
                presenter.clearText();
                break;
            case R.id.button_login:
                presenter.getLoginResult(etName.getText().toString(),etAge.getText().toString());
                break;
        }
    }

    @Override
    public void onClear() {
        etName.setText("");
        etAge.setText("");
    }

    @Override
    public void onLoginResult(String name ,String age) {
        etName.setText(name);
        etAge.setText(age);
        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed() {
        Toast.makeText(this,"登录失败",Toast.LENGTH_SHORT).show();
    }
}
