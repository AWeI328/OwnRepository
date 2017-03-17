package com.wk.youyibuy.ui.fragment.category.adapter;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wk.youyibuy.R;
import com.wk.youyibuy.databinding.ItemCategoryTitleBinding;
import com.wk.youyibuy.entity.Category;

import java.util.List;

public class CategoryTitleAdapter extends RecyclerView.Adapter<CategoryTitleAdapter.ViewHolder>{

    private Context mContext;
    private List<Category> categories;
    private int currentPosition;
    private ItemCategoryTitleBinding binding;

    public CategoryTitleAdapter(Context context, List<Category> categories){
        mContext = context;
        this.categories = categories;
    }
    @Override
    public CategoryTitleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.item_category_title,parent,false);
        return new ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(CategoryTitleAdapter.ViewHolder holder, int position) {
//        holder.bindTo(categories.get(position),position);
        Category category = categories.get(position);
        holder.tvTitle.setText(category.getTitle());
        holder.tvTitle.setOnClickListener(v->{
            currentPosition=position;
            category.setChecked(true);
            for (int i=0;i<categories.size();i++){
                if (currentPosition==i){
                    continue;
                }
                categories.get(i).setChecked(false);
            }
            notifyDataSetChanged();
        });
        if (category.isChecked()){
            holder.tvTitle.setBackgroundColor(Color.parseColor("#f1f3f5"));
            holder.tvTitle.setTextColor(Color.RED);
        }else{
            holder.tvTitle.setBackgroundColor(Color.WHITE);
            holder.tvTitle.setTextColor(Color.parseColor("#111111"));
        }
    }


    @Override
    public int getItemCount() {
        if (categories==null){
            return 0;
        }
        return categories.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        ViewHolder(View itemView) {
            super(itemView);
            tvTitle = binding.tvCategoryTitle;
        }
    }
}
