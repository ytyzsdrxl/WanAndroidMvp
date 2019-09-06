package com.example.xl.wanandroidmvp.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xl.wanandroidmvp.R;
import com.example.xl.wanandroidmvp.base.BaseMvpFragment;
import com.example.xl.wanandroidmvp.base.BasePresenter;
import com.example.xl.wanandroidmvp.bean.HotKeysTextBean;
import com.example.xl.wanandroidmvp.bean.HotkeyDB;
import com.example.xl.wanandroidmvp.presenter.Tab2Presenter;
import com.example.xl.wanandroidmvp.ui.activity.SearchResultActivity;
import com.example.xl.wanandroidmvp.ui.adapter.HotKeysAdapter;
import com.example.xl.wanandroidmvp.view.Tab2View;

import org.litepal.LitePal;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author xulei
 * @date 2019/7/19
 */
public class Tab2Fragment extends BaseMvpFragment implements Tab2View {

    @BindView(R.id.tv_hot_key)
    TextView mTvHotKey;
    @BindView(R.id.tv_hot_key_tips)
    TextView mTvHotKeyTips;
    @BindView(R.id.rv_hot_key)
    RecyclerView mRvHotKey;
    Unbinder unbinder;
    private Tab2Presenter mPresenter;
    private HotKeysAdapter mAdapter;

    public Tab2Fragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        mRvHotKey.setLayoutManager(new LinearLayoutManager(this.getContext()));
        mAdapter = new HotKeysAdapter(this.getContext());
        mRvHotKey.setAdapter(mAdapter);

        initListener();
    }

    private void initListener() {
        mAdapter.setOnItemClickListerer(new HotKeysAdapter.OnItemClickListerer() {
            @Override
            public void onItem(String keys) {
                Intent intent=new Intent(getActivity(),SearchResultActivity.class);
                intent.putExtra("key",keys);
                startActivity(intent);
            }
        });
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
    public void onResume() {
        super.onResume();
        mPresenter.getHotKey();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        mPresenter.getHotKey();
    }

    @Override
    protected BasePresenter createPresenter() {
        return mPresenter = new Tab2Presenter(this);
    }

    @Override
    public void onSusses(HotKeysTextBean hotKeysTextBean) {
        if (hotKeysTextBean!=null){
            mAdapter.setData(hotKeysTextBean.getData());
        }
    }

    @Override
    public void onFail(String errorMsg) {
        toastShort(errorMsg);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
