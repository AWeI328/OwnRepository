package com.wk.youyibuy.ui.fragment.usercenter.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wk.youyibuy.R;
import com.wk.youyibuy.databinding.ItemRecommendProductBinding;
import com.wk.youyibuy.databinding.ItemUserCenter0UnloginBinding;
import com.wk.youyibuy.databinding.ItemUserCenterListBinding;
import com.wk.youyibuy.databinding.ItemUserCenterOrderBinding;
import com.wk.youyibuy.databinding.ItemUserCenterTextBinding;


public class UserCenterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private static final int ITEM_HEAD = 101;
    private static final int ITEM_ODER_STATUS = 102;
    private static final int ITEM_LIST = 103;
    private static final int ITEM_TEXT = 104;
    private static final int ITEM_PRODUCT_RECOMMENDED = 105;
    private static final int ITEM_COUNT = 5;

    private Context mContext;

    public UserCenterAdapter(Context context){
        mContext = context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case ITEM_HEAD:
                ItemUserCenter0UnloginBinding loginBinding = DataBindingUtil
                        .inflate(LayoutInflater.from(mContext), R.layout.item_user_center_0_unlogin,parent,false);
                return new HeadViewHolder(loginBinding);
            case ITEM_ODER_STATUS:
                ItemUserCenterOrderBinding orderBinding = DataBindingUtil
                        .inflate(LayoutInflater.from(mContext),R.layout.item_user_center_order,parent,false);
                return new OrderStatusViewHolder(orderBinding);
            case ITEM_LIST:
                ItemUserCenterListBinding listBinding = DataBindingUtil
                        .inflate(LayoutInflater.from(mContext),R.layout.item_user_center_list,parent,false);
                return new ListViewHolder(listBinding);
            case ITEM_TEXT:
                ItemUserCenterTextBinding textBinding = DataBindingUtil
                        .inflate(LayoutInflater.from(mContext),R.layout.item_user_center_text,parent,false);
                return new TextViewHolder(textBinding);
            case ITEM_PRODUCT_RECOMMENDED:
                ItemRecommendProductBinding productBinding = DataBindingUtil
                        .inflate(LayoutInflater.from(mContext),R.layout.item_recommend_product,parent,false);
                return new RecommendedViewHolder(productBinding);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return ITEM_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        if (0==position){
            return ITEM_HEAD;
        }else if(1==position){
            return ITEM_ODER_STATUS;
        }else if (2==position){
            return ITEM_LIST;
        }else if (3==position){
            return ITEM_TEXT;
        }
        return ITEM_PRODUCT_RECOMMENDED;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup(){
            @Override
            public int getSpanSize(int position) {
                int type = getItemViewType(position);
                switch (type){
                    case ITEM_HEAD:
                    case ITEM_ODER_STATUS:
                    case ITEM_LIST:
                    case ITEM_TEXT:
                        return 2;//跨两行
                    default:
                        return 1;//跨一行
                }
            }
        });
    }

    /**头像列表项holder*/
    private class HeadViewHolder extends RecyclerView.ViewHolder{
        HeadViewHolder(ItemUserCenter0UnloginBinding  loginBinding) {
            super(loginBinding.getRoot());

        }
    }

    /**订单状态列表项holder*/
    private class OrderStatusViewHolder extends RecyclerView.ViewHolder{
        OrderStatusViewHolder(ItemUserCenterOrderBinding  orderBinding) {
            super(orderBinding.getRoot());
        }
    }

    /**列表holder*/
    private class ListViewHolder extends RecyclerView.ViewHolder{
        LinearLayout mLinearLayout;
        private Context context;
        ListViewHolder(ItemUserCenterListBinding  listBinding) {
            super(listBinding.getRoot());
            context = listBinding.getRoot().getContext();
            mLinearLayout = listBinding.listLinearLayout;
            mLinearLayout.removeAllViews();
            mLinearLayout.setOrientation(LinearLayout.VERTICAL);
            View spec = new View(context);
            spec.setBackgroundResource(R.color.fragment_background);
            spec.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 30));
            mLinearLayout.addView(spec);
            BaseItemViewHolder.createListHolder(context,mLinearLayout,R.drawable.vector_usercenter_privilege,context.getString(R.string.text_my_privilege),v->{
                //TODO
            });
            BaseItemViewHolder.createListHolder(context,mLinearLayout,R.drawable.vector_usercenter_electronic_purse,context.getString(R.string.text_my_wallet),v->{
                //TODO
            });
            BaseItemViewHolder.createListHolder(context,mLinearLayout,R.drawable.vector_usercenter_coupons,context.getString(R.string.text_my_coupons),v->{
                //TODO
            });
            BaseItemViewHolder.createListHolder(context,mLinearLayout,R.drawable.vector_usercenter_collection,context.getString(R.string.text_my_collection),v->{
                //TODO
            });
            BaseItemViewHolder.createListHolder(context,mLinearLayout,R.drawable.vector_usercenter_footprint,context.getString(R.string.text_my_footprint),v->{
                //TODO
            });
            BaseItemViewHolder.createListHolder(context,mLinearLayout,R.drawable.vector_usercenter_share_wine,context.getString(R.string.text_share),v->{
                //TODO
            });
        }


    }

    /**为您推荐*/
    private class TextViewHolder extends RecyclerView.ViewHolder{
        TextViewHolder(ItemUserCenterTextBinding  textBinding) {
            super(textBinding.getRoot());
        }
    }

    /**推荐商品*/
    private class RecommendedViewHolder extends RecyclerView.ViewHolder{
        RecommendedViewHolder(ItemRecommendProductBinding  productBinding) {
            super(productBinding.getRoot());
        }
    }

    private static class BaseItemViewHolder extends RecyclerView.ViewHolder{
        private TextView listTitle;
        BaseItemViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            ItemUserCenterListBinding listBinding = (ItemUserCenterListBinding) binding;
            listTitle = listBinding.tvList;
        }

        static BaseItemViewHolder createListHolder(Context context,ViewGroup parent,int resId
                ,String title,View.OnClickListener listener){
            ItemUserCenterListBinding listBinding = DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.item_user_center_list,parent,false);
            listBinding.getRoot().setOnClickListener(listener);
            parent.addView(listBinding.getRoot());
            BaseItemViewHolder holder = new BaseItemViewHolder(listBinding);
            holder.listTitle.setText(title);
            Drawable drawableStart = ContextCompat.getDrawable(context,resId);
            Drawable drawableEnd = ContextCompat.getDrawable(context,R.drawable.vector_usercenter_right_arrow_large);
            holder.listTitle.setCompoundDrawablesRelativeWithIntrinsicBounds(drawableStart,null,drawableEnd,null);
            return holder;
        }
    }
}
