package com.wili.android.mvp_learning.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wili.android.mvp_learning.presenter.BooksActivityPresenter;
import com.wili.android.mvp_learning.view.BooksActivityView;
import com.wili.android.mvp_learning.R;
import com.wili.android.mvp_learning.repository.model.Book;

import java.util.List;

public class BooksActivity extends AppCompatActivity implements BooksActivityView {

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
