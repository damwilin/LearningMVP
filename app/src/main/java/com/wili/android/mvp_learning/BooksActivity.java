package com.wili.android.mvp_learning;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wili.android.mvp_learning.respositories.Book;

import java.util.List;

public class BooksActivity extends AppCompatActivity implements  BooksActivityView {

    private BooksActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new BooksActivityPresenter(this, null);

    }

    @Override
    public void displayBooks(List<Book> bookList) {

    }

    @Override
    public void displayNoBooks() {

    }
}
