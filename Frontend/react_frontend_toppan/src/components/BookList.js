import { React, useReducer } from 'react';
import BookItem from './BookItem';

import BookContext from '../context/book-context';
import {bookReducer,initialState} from '../reducers/book-reducer';

const BookList = () => {
    const [bookContext, dispatch] = useReducer(bookReducer,initialState);
    let book1 = { name: "React Beginner", author: "Amber", id: 1 };
    let book2 = { name: "Angular Beginner", author: "Xiong", id: 2 };
    let book3 = { name: "Vuejs Beginner", author: "Dragon", id: 3 };

    return (
        <div id="container" className={bookContext.accordion.open?'accordionWrapper open':'accordionWrapper'}>
            {
                bookContext &&
                <BookContext.Provider value={{ bookContext, dispatch }}>
                        <BookItem book={book1} />
                        <BookItem book={book2} />
                        <BookItem book={book3} />
                </BookContext.Provider>
            }
        </div>

    )
}

export default BookList;