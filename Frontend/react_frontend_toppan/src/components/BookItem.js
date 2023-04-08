
import { React, useContext } from 'react';
import BookContext from '../context/book-context';
import Customer from './Customer';

const BookItem = ({ book }) => {
    const { author, name, id, borrower } = book;
    const { bookContext, dispatch } = useContext(BookContext);

    const handleClick = () => {
        if (!bookContext.accordion.open || bookContext.accordion.bookId !== id) {
            bookContext.accordion = { open: true, bookId: id };
            dispatch({ type: 'SET_ACCORDION', accordion: bookContext.accordion });
        }
        else {
            bookContext.accordion = { open: false, bookId: id };
            dispatch({ type: 'SET_ACCORDION', accordion: bookContext.accordion });
        }
    }

    return (
        <div id={id}>
            <div className='rectangle'>
                <div className='book-item-detail'>
                    <p className='no'>{id}</p>
                    <div className='book-name overflow'>
                        {name}
                    </div>
                    <div className='vector' onClick={() => handleClick()}><span className='arrow up'></span></div>
                    <p className='book-item-footer '>by {author}</p>
                </div>
            </div>
            {
                bookContext.accordion.bookId === id && bookContext.accordion.open &&
                <div className='book-borrowers'>
                    {borrower.map((b, index) => (
                        <Customer key={index} customer={{ name: b }} />
                    ))}
                </div>
            }
        </div>
    )
}

export default BookItem;