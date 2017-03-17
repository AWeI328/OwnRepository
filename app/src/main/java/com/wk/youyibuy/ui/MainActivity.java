package com.wk.youyibuy.ui;


import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.wk.youyibuy.R;
import com.wk.youyibuy.databinding.ActivityMainBinding;
import com.wk.youyibuy.ui.fragment.category.CategoryFragment;
import com.wk.youyibuy.ui.fragment.home.HomeFragment;
import com.wk.youyibuy.ui.fragment.shopingcart.ShoppingCartFragment;
import com.wk.youyibuy.ui.fragment.usercenter.UserCenterFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fragment> fragmentList;
    private int currentIndex;
    private ActivityMainBinding dataBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initFragment();
        onClick();
    }

    private void onClick() {
        dataBinding.setClick(v->{
            switch (v.getId()){
                case R.id.rb_home_page:
                    setFragmentIndex(0);
                    dataBinding.rbHomePage.setChecked(true);
                    break;
                case R.id.rb_category:
                    setFragmentIndex(1);
                    dataBinding.rbCategory.setChecked(true);
                    break;
                case R.id.rb_shopping_cart:
                    setFragmentIndex(2);
                    dataBinding.rbShoppingCart.setChecked(true);
                    break;
                case R.id.rb_user_center:
                    setFragmentIndex(3);
                    dataBinding.rbUserCenter.setChecked(true);
                    break;
            }
        });
    }

    private void initFragment() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new CategoryFragment());
        fragmentList.add(new ShoppingCartFragment());
        fragmentList.add(new UserCenterFragment());
        setFragmentIndex(0);
        dataBinding.rbHomePage.setChecked(true);
    }

    private void setFragmentIndex(int index){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.hide(fragmentList.get(currentIndex));
        if (!fragmentList.get(index).isAdded()){
            transaction.add(R.id.main_content,fragmentList.get(index)).show(fragmentList.get(index));
        }else{
            transaction.show(fragmentList.get(index));
        }
        transaction.commit();
        currentIndex=index;
    }
}
