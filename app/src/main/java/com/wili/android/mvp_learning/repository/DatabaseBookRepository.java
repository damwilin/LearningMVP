package com.wili.android.mvp_learning.repository;

import android.content.Context;

import com.wili.android.mvp_learning.repository.model.Book;

import java.util.List;

/**
 * Created by Damian on 22.02.2018.
 */

public class DatabaseBookRepository implements BooksRepository {

    public DatabaseBookRepository(Context context) {

    }

    @Override
    public List<Book> getBooks() {
        return null;
    }
}
