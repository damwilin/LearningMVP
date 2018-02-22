package com.wili.android.mvp_learning.test;

import com.wili.android.mvp_learning.presenter.BooksActivityPresenter;
import com.wili.android.mvp_learning.view.BooksActivityView;
import com.wili.android.mvp_learning.repository.model.Book;
import com.wili.android.mvp_learning.repository.BooksRepository;

import junit.framework.Assert;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Damian on 22.02.2018.
 */
public class BooksActivityPresenterTest {

    @Test
    public void shouldPassBooksToView() {

        //given
        BooksActivityView view = new MockView();
        BooksRepository booksRepository = new MockBooksRepository(true);

        //when
        BooksActivityPresenter presenter = new BooksActivityPresenter(view, booksRepository);
        presenter.loadBooks();

        //then
        Assert.assertEquals(true, ((MockView) view).displayBooksWithBooksCalled);

    }

    @Test
    public void shouldHandleNoBooksFound() {

        //given
        BooksActivityView view = new MockView();
        BooksRepository booksRepository = new MockBooksRepository(false);

        //when
        BooksActivityPresenter presenter = new BooksActivityPresenter(view, booksRepository);
        presenter.loadBooks();

        //then
        Assert.assertEquals(true, ((MockView) view).displayBooksWithNoBooksCalled);
    }

    private class MockView implements BooksActivityView {

        boolean displayBooksWithBooksCalled;
        boolean displayBooksWithNoBooksCalled;

        @Override
        public void displayBooks(List<Book> bookList) {
            if (bookList.size() == 3)
                displayBooksWithBooksCalled = true;
        }

        @Override
        public void displayNoBooks() {
            displayBooksWithNoBooksCalled = true;
        }
    }

    private class MockBooksRepository implements BooksRepository {

        private boolean returnSomeBook;

        public MockBooksRepository(boolean returnSomeBook) {
            this.returnSomeBook = returnSomeBook;
        }

        @Override
        public List<Book> getBooks() {

            if (returnSomeBook)
                return Arrays.asList(new Book(), new Book(), new Book());
            else
                return Collections.emptyList();
        }
    }
}