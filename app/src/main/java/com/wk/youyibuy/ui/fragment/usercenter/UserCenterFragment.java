package com.wk.youyibuy.ui.fragment.usercenter;


import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wk.youyibuy.R;
import com.wk.youyibuy.databinding.FragmentUserCenterBinding;
import com.wk.youyibuy.ui.fragment.usercenter.adapter.UserCenterAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserCenterFragment extends Fragment {

    private FragmentUserCenterBinding dataBinding;
    private Activity mActivity;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataBinding = DataBindingUtil.inflate(
                LayoutInflater.from(mActivity),R.layout.fragment_user_center,container,false);
        initView();
        return dataBinding.getRoot();
    }

    private void initView() {
        UserCenterAdapter adapter = new UserCenterAdapter(mActivity);
        dataBinding.recyclerViewUserCenter.setLayoutManager(new GridLayoutManager(mActivity,2));
        dataBinding.recyclerViewUserCenter.setAdapter(adapter);
    }

}
