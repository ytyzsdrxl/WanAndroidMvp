package com.example.xl.wanandroidmvp.ui.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xl.wanandroidmvp.R;
import com.example.xl.wanandroidmvp.app.ActivityManager;
import com.example.xl.wanandroidmvp.base.BaseMvpFragmentActivity;
import com.example.xl.wanandroidmvp.base.BasePresenter;
import com.example.xl.wanandroidmvp.presenter.MainPresenter;
import com.example.xl.wanandroidmvp.ui.adapter.MyPagerAdapter;
import com.example.xl.wanandroidmvp.utils.PreferencesUtil;
import com.example.xl.wanandroidmvp.view.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends BaseMvpFragmentActivity implements MainView {

    @BindView(R.id.viewpager_id)
    ViewPager mViewpagerId;
    @BindView(R.id.line)
    View mLine;
    @BindView(R.id.tablayout_id)
    TabLayout mTablayoutId;
    @BindView(R.id.rl_search)
    RelativeLayout mRlSearch;
    @BindView(R.id.headimg)
    CircleImageView mHeadimg;
    @BindView(R.id.draw_layout)
    RelativeLayout mDrawLayout;
    @BindView(R.id.login_text)
    TextView mLoginText;
    @BindView(R.id.logout_text)
    TextView mLogoutText;

    private long firstTime = 0;//第一次点击返回按键的时间
    private boolean mIsLogin;
    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    protected BasePresenter createPresenter() {
        return mPresenter=new MainPresenter(this);
    }


    private void initView() {
        setDrawLayoutWeith(mDrawLayout);
        mViewpagerId.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), 4));
        mViewpagerId.setOffscreenPageLimit(3);

        mTablayoutId.addTab(mTablayoutId.newTab().setCustomView(R.layout.tab1_item));
        mTablayoutId.addTab(mTablayoutId.newTab().setCustomView(R.layout.tab2_item));
        mTablayoutId.addTab(mTablayoutId.newTab().setCustomView(R.layout.tab3_item));
        mTablayoutId.addTab(mTablayoutId.newTab().setCustomView(R.layout.tab4_item));
        mTablayoutId.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewpagerId.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mViewpagerId.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTablayoutId));

    }

    @Override
    protected void onResume() {
        super.onResume();
        mIsLogin = PreferencesUtil.getBoolean(MainActivity.this, "islogin", false);
        if (mIsLogin) {
            mLoginText.setClickable(false);
            mLoginText.setText(PreferencesUtil.getString(MainActivity.this, "usename", null));
            mLogoutText.setVisibility(View.VISIBLE);
        } else {
            mLoginText.setClickable(true);
            mLoginText.setText("去登陆");
            mLogoutText.setVisibility(View.GONE);
        }
    }

    public void setDrawLayoutWeith(RelativeLayout relativeLayout) {
        //获取屏幕宽高
        WindowManager wm = this.getWindowManager();
        int width1 = wm.getDefaultDisplay().getWidth();
        //获取drawerlayout的布局
        ViewGroup.LayoutParams para = relativeLayout.getLayoutParams();
        //修改宽度
        para.width = width1 / 3 * 2;
        //设置修改后的布
        relativeLayout.setLayoutParams(para);
    }

    @Override
    public void onBackPressed() {
        //按两次退出
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 2000) {
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
            //更新firstTime
            firstTime = secondTime;
        } else {
            ActivityManager.finishAll();
            System.exit(0);
            Process.killProcess(Process.myPid());
        }
    }

    @OnClick({R.id.rl_search, R.id.login_text,R.id.logout_text})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_search:
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
                break;
            case R.id.login_text:
                Intent intent1 = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent1);
                break;
            case R.id.logout_text:
                shoeLogoutDialog();
                break;
        }
    }

    private void shoeLogoutDialog() {
        new AlertDialog.Builder(this).setMessage("确定退出登陆？").setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mPresenter.logout();
                dialog.dismiss();
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).setCancelable(false).show();
    }

    @Override
    public void onSusses(String data) {
        if (data!=null){
            toastShort("退出成功");
            PreferencesUtil.putString(MainActivity.this,"username","");
            PreferencesUtil.putBoolean(MainActivity.this,"islogin",false);
            mLoginText.setClickable(true);
            mLoginText.setText("去登陆");
            mLogoutText.setVisibility(View.GONE);
        }
    }

    @Override
    public void onFail(String errorMsg) {
        toastShort(errorMsg);
    }
}
