import { React, useReducer } from 'react';
import BookItem from './BookItem';

import BookContext from '../context/book-context';
import { bookReducer, initialState } from '../reducers/book-reducer';

const BookList = ({ books }) => {
    const [bookContext, dispatch] = useReducer(bookReducer, initialState);
    return (
        <div id="container" className={bookContext.accordion.open ? 'accordionWrapper open' : 'accordionWrapper'}>
            {
                bookContext &&
                <BookContext.Provider value={{ bookContext, dispatch }}>
                    {books.map((book, index) => (
                        <BookItem key={book.name} book={book} index={index}/>
                    ))}
                </BookContext.Provider>
            }
        </div>

    )
}

export default BookList;