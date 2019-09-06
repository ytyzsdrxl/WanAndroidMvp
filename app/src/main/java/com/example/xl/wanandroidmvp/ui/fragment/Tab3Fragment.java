package com.example.xl.wanandroidmvp.ui.fragment;


import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xl.wanandroidmvp.R;
import com.example.xl.wanandroidmvp.base.BaseMvpFragment;
import com.example.xl.wanandroidmvp.base.BasePresenter;
import com.example.xl.wanandroidmvp.bean.TreeBean;
import com.example.xl.wanandroidmvp.presenter.Tab3Presenter;
import com.example.xl.wanandroidmvp.ui.adapter.TreeAdapter;
import com.example.xl.wanandroidmvp.view.Tab3View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author xulei
 * @date 2019/7/19
 */
public class Tab3Fragment extends BaseMvpFragment implements Tab3View {

    private Tab3Presenter mPresenter;

    @BindView(R.id.tv_tree)
    TextView mTvTree;
    @BindView(R.id.rv_tree)
    RecyclerView mRvTree;
    Unbinder unbinder;
    private TreeAdapter mAdapter;

    public Tab3Fragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        mRvTree.setLayoutManager(new GridLayoutManager(getContext(),3));
        mAdapter = new TreeAdapter(getContext());
        mRvTree.setAdapter(mAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.getTree();
    }

    @Override
    protected BasePresenter createPresenter() {
        return mPresenter=new Tab3Presenter(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onSusses(TreeBean treeBean) {
        if (treeBean!=null){
            mAdapter.setData(treeBean.getData());
        }
    }

    @Override
    public void onFail(String errorMsg) {
        toastShort(errorMsg);
    }
}
