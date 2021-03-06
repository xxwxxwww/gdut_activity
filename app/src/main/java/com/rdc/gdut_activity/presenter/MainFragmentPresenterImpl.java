package com.rdc.gdut_activity.presenter;

import com.rdc.gdut_activity.bean.ActivityInfoBean;
import com.rdc.gdut_activity.contract.MainFragmentContract;
import com.rdc.gdut_activity.contract.MainFragmentContract;
import com.rdc.gdut_activity.model.MainFragmentModelImpI;

import java.util.List;

/**
 * Created by zjz on 2017/5/17.
 */

public class MainFragmentPresenterImpl implements MainFragmentContract.Presenter {
    private MainFragmentContract.View mView;
   // private MainFragmentContract.DetailView mDetailView;
    private MainFragmentContract.Model mModel = new MainFragmentModelImpI(this);

    public MainFragmentPresenterImpl(MainFragmentContract.View view){
        mView = view;
    }

//    public MainFragmentPresenterImpl(MainFragmentContract.DetailView detailView){
//        mDetailView = detailView;
//    }

    /**
     * view调用
     */
    @Override
    public void onRefresh(String type) {
        mModel.refreshData(type);
    }

    @Override
    public void onLoadMore(String type) {
        mModel.loadMoreData(type);
    }


    @Override
    public void onRefreshByName(String type, String name) {
        mModel.refreshDataByName(type,name);
    }

    @Override
    public void onLoadMoreByName(String type,String name) {
        mModel.loadaMoreDataByName(type,name);
    }

    /**
     * model调用
     */
    @Override
    public void refreshDataSuccess(List<ActivityInfoBean> list) {
        mView.onRefreshSuccess(list);
    }

    @Override
    public void refreshDataError(String s) {
        mView.onRefreshError(s);
    }

    @Override
    public void loadMoreDataSuccess(List<ActivityInfoBean> list) {
        mView.onLoadMoreSuccess(list);
    }

    @Override
    public void loadMoreDataError(String s) {
        mView.onLoadMoreError(s);
    }

}
