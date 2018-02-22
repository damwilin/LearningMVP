package com.wili.android.mvp_learning;

import com.wili.android.mvp_learning.respositories.Book;

import java.util.List;

/**
 * Created by Damian on 22.02.2018.
 */

public interface BooksActivityView {

    void displayBooks(List<Book> bookList);
    void displayNoBooks();
}
