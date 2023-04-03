import React from 'react';

const BookItem = ({ book }) => {
    const { author, name, id } = book;
    return (
        <div id={id}>
            <div className='rectangle'>
                <div className='book-item-detail'>
                    <p className='no'>{id}</p>
                    <div className='book-name overflow'>
                        {name}
                    </div>
                    <div className='vector'><span className='arrow up'></span></div>
                    <p className='book-item-footer '>by {author}</p>
                </div>
            </div>
        </div>
    )
}

export default BookItem;