import React from 'react';
import BookItem from './BookItem';

const BookList = () => {

    let book1 = { name: "React Beginner", author: "Amber", id: 1 };
    let book2 = { name: "Angular Beginner", author: "Xiong", id: 2 };
    let book3 = { name: "Vuejs Beginner", author: "Dragon", id: 3 };

    return (
        <div id="container" className='container'>
            <div className='group'>
                <BookItem book={book1} />
                <BookItem book={book2} />
                <BookItem book={book3} />
            </div>
        </div>

    )
}

export default BookList;