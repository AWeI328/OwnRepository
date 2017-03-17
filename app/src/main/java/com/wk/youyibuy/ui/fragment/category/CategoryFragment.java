package com.wk.youyibuy.ui.fragment.category;


import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.wk.youyibuy.R;
import com.wk.youyibuy.databinding.FragmentCategoryBinding;
import com.wk.youyibuy.entity.Category;
import com.wk.youyibuy.ui.fragment.category.adapter.CategoryTitleAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {


    private FragmentCategoryBinding dataBinding;
    private Activity mActivity;
    private List<String> titles;
    private List<Category> categories;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mActivity!=null){
            dataBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(mActivity),R.layout.fragment_category,container,false);
            initData();
            initView();
            return dataBinding.getRoot();
        }else {
            return null;
        }
    }

    private void initData() {
        titles = Arrays.asList(getResources().getStringArray(R.array.categoryList));

        categories = new ArrayList<>();
        for (int i=0;i<titles.size();i++){
            Category category = new Category();
            category.setTitle(titles.get(i));
            categories.add(category);
        }
        Log.i("eawei", "categories size:"+categories.size());
    }

    private void initView() {
        dataBinding.recyclerViewCategoryTitle.setLayoutManager(new LinearLayoutManager(mActivity));
        CategoryTitleAdapter titleAdapter = new CategoryTitleAdapter(mActivity,categories);
        dataBinding.recyclerViewCategoryTitle.setAdapter(titleAdapter);
        dataBinding.recyclerViewCategoryTitle.addItemDecoration(new MyItemDecoration());
//        dataBinding.recyclerViewCategoryTitle.addOnItemTouchListener(new RecyclerClickListener(mActivity, (view, position) -> {
//
//        }));
    }


    private class MyItemDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.set(0,0,0,1);
        }
    }
}


