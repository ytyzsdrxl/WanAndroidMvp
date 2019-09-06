package com.example.xl.wanandroidmvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.xl.wanandroidmvp.R;
import com.example.xl.wanandroidmvp.base.BaseMvpActivity;
import com.example.xl.wanandroidmvp.base.BasePresenter;
import com.example.xl.wanandroidmvp.bean.HotKeysBean;
import com.example.xl.wanandroidmvp.bean.HotkeyDB;
import com.example.xl.wanandroidmvp.presenter.SearchPresenter;
import com.example.xl.wanandroidmvp.view.SearchView;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends BaseMvpActivity implements SearchView {

    @BindView(R.id.iv_search_back)
    ImageView mIvSearchBack;
    @BindView(R.id.iv_search)
    ImageView mIvSearch;
    @BindView(R.id.et_search)
    EditText mEtSearch;
    @BindView(R.id.rl_search)
    RelativeLayout mRlSearch;
    @BindView(R.id.fl_search)
    TagFlowLayout mFlSearch;
    @BindView(R.id.rv_key_db)
    RecyclerView mRvKeyDb;

    private SearchPresenter mPresenter;
    private List<String> hotKeys=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.getHot();
    }

    @Override
    protected BasePresenter createPresenter() {
        return mPresenter=new SearchPresenter(this);
    }

    @OnClick(R.id.iv_search_back)
    public void onClick() {
        finish();
    }

    @Override
    public void onSusses(HotKeysBean hotKeysBean) {
        for (int i = 0; i < hotKeysBean.getData().size(); i++) {
            hotKeys.add(hotKeysBean.getData().get(i).getName());
        }
        mFlSearch.setAdapter(new TagAdapter<String>(hotKeys)
        {
            @Override
            public View getView(FlowLayout parent, int position, String s)
            {
                TextView tv = new TextView(SearchActivity.this);
                tv.setTextSize(14);
                tv.setBackgroundResource(R.drawable.flow_layout_bg);
                tv.setText(s);
                return tv;
            }
        });

        mFlSearch.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                String key=hotKeys.get(position);
                saveKey2DB(key);
                jumpToSearchResult(key);
                return true;
            }
        });
    }

    private void jumpToSearchResult(String key) {
        Intent intent=new Intent(SearchActivity.this,SearchResultActivity.class);
        intent.putExtra("key",key);
        startActivity(intent);
    }

    private void saveKey2DB(String key) {
        List<HotkeyDB> hotkeyDBS = LitePal.where("key = ?", key).find(HotkeyDB.class);
        if (hotkeyDBS.isEmpty()){
            HotkeyDB hotkeyDB=new HotkeyDB();
            hotkeyDB.setKey(key);
            hotkeyDB.setTime(1);
            hotkeyDB.save();
        }else {
            HotkeyDB hotkeyDB=new HotkeyDB();
            hotkeyDB.setTime(hotkeyDBS.get(0).getTime()+1);
            hotkeyDB.update(hotkeyDBS.get(0).getId());
        }

    }

    @Override
    public void onFail(String errorMsg) {
        toastShort(errorMsg);
    }
}
