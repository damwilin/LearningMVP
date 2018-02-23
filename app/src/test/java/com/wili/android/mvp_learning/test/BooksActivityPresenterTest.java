package com.wili.android.mvp_learning.test;

import com.wili.android.mvp_learning.presenter.BooksActivityPresenter;
import com.wili.android.mvp_learning.repository.BooksRepository;
import com.wili.android.mvp_learning.repository.model.Book;
import com.wili.android.mvp_learning.view.BooksActivityView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)

/**
 * Created by Damian on 22.02.2018.
 */
public class BooksActivityPresenterTest {

    @Mock
    BooksRepository booksRepository;

    @Mock
    BooksActivityView view;

    BooksActivityPresenter presenter;
    private final List<Book> MANY_BOOKS = Arrays.asList(new Book(), new Book(), new Book());

    @Before
    public void setUp() throws Exception {
        presenter = new BooksActivityPresenter(view, booksRepository);
    }

    @Test
    public void shouldPassBooksToView() {


        Mockito.when(booksRepository.getBooks()).thenReturn(MANY_BOOKS);

        presenter.loadBooks();

        Mockito.verify(view).displayBooks(MANY_BOOKS);
    }

    @Test
    public void shouldHandleNoBooksFound() {

        Mockito.when(booksRepository.getBooks()).thenReturn(Collections.EMPTY_LIST);

        presenter.loadBooks();

        Mockito.verify(view).displayNoBooks();
    }
}