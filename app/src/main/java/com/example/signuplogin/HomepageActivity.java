package com.example.signuplogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class HomepageActivity extends AppCompatActivity  {

//    private RecyclerView rcvCategory;
//    private CategoryAdapter categoryAdapter;

    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter recyclerViewAdapter;

    int []arr = {R.drawable.f1, R.drawable.f2, R.drawable.f3, R.drawable.f4, R.drawable.f1, R.drawable.f2, R.drawable.f3, R.drawable.f4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

//        rcvCategory = findViewById(R.id.rcv_category);
//        categoryAdapter = new CategoryAdapter(this);
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
//
//        categoryAdapter.setData(getListCategory());
//        rcvCategory.setAdapter(categoryAdapter);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(arr);

        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);
    }

//    private List<Category> getListCategory(){
//
//        List<Category> listCategory = new ArrayList<>();
//        List<Book> listBook = new ArrayList<>();
//
//        listBook.add(new Book(R.drawable.f1, "Food 1"));
//        listBook.add(new Book(R.drawable.f2, "Food 2"));
//        listBook.add(new Book(R.drawable.f3, "Food 3"));
//        listBook.add(new Book(R.drawable.f4, "Food 4"));
//
//        listBook.add(new Book(R.drawable.f1, "Food 1"));
//        listBook.add(new Book(R.drawable.f2, "Food 2"));
//        listBook.add(new Book(R.drawable.f3, "Food 3"));
//        listBook.add(new Book(R.drawable.f4, "Food 4"));
//
//        listCategory.add(new Category("Category 1", listBook));
//        listCategory.add(new Category("Category 2", listBook));
//        listCategory.add(new Category("Category 3", listBook));
//
//        return listCategory;
//    }

}