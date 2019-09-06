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
import com.example.xl.wanandroidmvp.bean.WXCBean;
import com.example.xl.wanandroidmvp.presenter.Tab4Presenter;
import com.example.xl.wanandroidmvp.ui.activity.ChapterArticleActivity;
import com.example.xl.wanandroidmvp.ui.adapter.WXCAdapter;
import com.example.xl.wanandroidmvp.view.Tab4View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author xulei
 * @date 2019/7/19
 */
public class Tab4Fragment extends BaseMvpFragment implements Tab4View {


    @BindView(R.id.tv_chapter)
    TextView mTvChapter;
    @BindView(R.id.rv_chapter)
    RecyclerView mRvChapter;
    Unbinder unbinder;
    private Tab4Presenter mPresenter;
    private WXCAdapter mAdapter;

    public Tab4Fragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_four, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        mRvChapter.setLayoutManager(new LinearLayoutManager(this.getContext()));
        mAdapter = new WXCAdapter(getContext());
        mRvChapter.setAdapter(mAdapter);

        initListener();
    }

    private void initListener() {
        mAdapter.setClickItemListener(new WXCAdapter.ClickItemListener() {
            @Override
            public void onIiem(String name, String id) {
                Intent intent=new Intent(getContext(), ChapterArticleActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.getData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    protected BasePresenter createPresenter() {
        return mPresenter=new Tab4Presenter(this);
    }

    @Override
    public void onSusses(WXCBean wxcBean) {
        if (wxcBean!=null){
            mAdapter.setData(wxcBean.getData());
        }
    }

    @Override
    public void onFail(String errorMsg) {
        toastShort(errorMsg);
    }
}
