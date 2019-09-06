package com.example.xl.wanandroidmvp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.xl.wanandroidmvp.R;
import com.example.xl.wanandroidmvp.base.BaseMvpActivity;
import com.example.xl.wanandroidmvp.base.BasePresenter;
import com.example.xl.wanandroidmvp.bean.LoginBean;
import com.example.xl.wanandroidmvp.bean.RegistBean;
import com.example.xl.wanandroidmvp.presenter.LoginPresenter;
import com.example.xl.wanandroidmvp.utils.PreferencesUtil;
import com.example.xl.wanandroidmvp.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseMvpActivity implements LoginView {

    @BindView(R.id.iv_login)
    ImageView mIvLogin;
    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.et_password)
    EditText mEtPassword;
    @BindView(R.id.et_repassword)
    EditText mEtRepassword;
    @BindView(R.id.bt_login)
    Button mBtLogin;
    @BindView(R.id.bt_register)
    Button mBtRegister;

    private LoginPresenter mPresenter;
    private String mName;
    private String mPassWord;
    private String mRepassWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    protected BasePresenter createPresenter() {
        return mPresenter=new LoginPresenter(this);
    }

    @OnClick({R.id.bt_login, R.id.bt_register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                login();
                break;
            case R.id.bt_register:
                viewChange();
                break;
        }
    }

    private void login() {
        mName = mEtName.getText().toString().trim();
        mPassWord = mEtPassword.getText().toString().trim();
        if (mName.isEmpty()){
            toastShort("请输入名称");
        }
        if (mPassWord.isEmpty()){
            toastShort("请输入密码");
        }

        mPresenter.login(mName,mPassWord);
    }

    private void viewChange() {
        if (mEtRepassword.getVisibility()==View.VISIBLE){
            regist();
        }else {
            mBtLogin.setVisibility(View.GONE);
            mEtRepassword.setVisibility(View.VISIBLE);
        }
    }

    private void regist() {
        mName = mEtName.getText().toString().trim();
        mPassWord = mEtPassword.getText().toString().trim();
        mRepassWord = mEtRepassword.getText().toString().trim();
        if (mName.isEmpty()){
            toastShort("请输入名称");
            return;
        }
        if (mPassWord.isEmpty()){
            toastShort("请输入密码");
            return;
        }
        if (mRepassWord.isEmpty()){
            toastShort("请确认密码");
            return;
        }

        mPresenter.regist(mName, mPassWord, mRepassWord);

    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {
        if (loginBean!=null){
            PreferencesUtil.putString(LoginActivity.this,"usename",loginBean.getData().getUsername());
            PreferencesUtil.putBoolean(LoginActivity.this,"islogin",true);
            finish();
        }
    }

    @Override
    public void onSusses(RegistBean registBean) {
        if (registBean!=null){
//            注册成功
            mEtPassword.setVisibility(View.GONE);
            mEtRepassword.setVisibility(View.GONE);
            mBtLogin.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onFail(String errorMsg) {
        toastShort(errorMsg);
    }
}
