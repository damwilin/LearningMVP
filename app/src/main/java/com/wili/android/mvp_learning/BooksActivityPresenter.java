package com.wili.android.mvp_learning;

import com.wili.android.mvp_learning.respositories.Book;
import com.wili.android.mvp_learning.respositories.BooksRepository;

import java.util.List;

/**
 * Created by Damian on 22.02.2018.
 */

public class BooksActivityPresenter {

    private BooksActivityView view;
    private BooksRepository booksRepository;

    public BooksActivityPresenter(BooksActivityView view, BooksRepository booksRepository) {
        this.view = view;
        this.booksRepository = booksRepository;
    }

    public void loadBooks() {
        List<Book> bookList = booksRepository.getBooks();
        if (bookList.isEmpty()) {
            view.displayNoBooks();
        } else {
            view.displayBooks(bookList);
        }
    }
}
