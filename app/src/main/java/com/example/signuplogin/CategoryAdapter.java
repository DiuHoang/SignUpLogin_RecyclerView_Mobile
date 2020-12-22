package com.example.signuplogin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private Context mContext;
    private List<Category> mCateList;

    public CategoryAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Category> list){
        this.mCateList = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category categoty = mCateList.get(position);
        if(categoty == null){
            return;
        }
        holder.cateName.setText(categoty.getNameCategory());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false);
        holder.recyclerViewbook.setLayoutManager(linearLayoutManager);

        BookAdapter bookAdapter = new BookAdapter();
        bookAdapter.setData(categoty.getBooks());

        holder.recyclerViewbook.setAdapter(bookAdapter);
    }

    @Override
    public int getItemCount() {
        if(mCateList != null){
            return mCateList.size();
        }
        return 0;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{

        private TextView cateName;
        private RecyclerView recyclerViewbook;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            cateName = itemView.findViewById(R.id.nameCate);
            recyclerViewbook = itemView.findViewById(R.id.cate_book);
        }
    }
}
