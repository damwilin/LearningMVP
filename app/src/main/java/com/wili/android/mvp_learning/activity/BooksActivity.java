package com.wili.android.mvp_learning.activity;

import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.wili.android.mvp_learning.presenter.BooksActivityPresenter;
import com.wili.android.mvp_learning.repository.DatabaseBookRepository;
import com.wili.android.mvp_learning.view.BooksActivityView;
import com.wili.android.mvp_learning.R;
import com.wili.android.mvp_learning.repository.model.Book;

import java.util.List;

public class BooksActivity extends AppCompatActivity implements BooksActivityView {

    private static final String TAG = BooksActivity.class.getSimpleName();
    private BooksActivityPresenter presenter;
    private TextView emptyListLayout;
    private List<Book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new BooksActivityPresenter(this, new DatabaseBookRepository(getApplication()));
        presenter.loadBooks();
    }

    @Override
    public void displayBooks(List<Book> bookList) {
        Log.d(TAG,"displayBooks: found some books");
        this.bookList = bookList;
        emptyListLayout.setVisibility(View.INVISIBLE);
    }

    @Override
    public void displayNoBooks() {
        Log.d(TAG,"displayBooks: found NO books");
        emptyListLayout.setVisibility(View.VISIBLE);

    }
}
