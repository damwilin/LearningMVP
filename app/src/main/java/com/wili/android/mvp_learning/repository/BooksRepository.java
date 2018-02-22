package com.wili.android.mvp_learning.repository;

import com.wili.android.mvp_learning.repository.model.Book;

import java.util.List;

/**
 * Created by Damian on 22.02.2018.
 */

public interface BooksRepository {

    List<Book> getBooks();
}
