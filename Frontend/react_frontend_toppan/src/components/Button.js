import { React, useContext } from 'react';
import BookDataService from './../api/book-action';
import AppContext from './../context/app-context';

const Button = () => {
  const { appContext, dispatch } = useContext(AppContext);

  const filterByCountry = () => {
    BookDataService.getRandomCountry()
      .then((response) => {
        let country = response.data;
        console.log("Random Country", country)
        dispatch({
          type: 'SET_COUNTRY',
          country
        });
        getBookByCountryCode(country.country.country_code);
      })
      .catch((e) => {
        console.log(e.response);
      });
  }

  const getBookByCountryCode = (country_code) => {
    BookDataService.getTop3ReadBooksByCountry(country_code)
      .then((response) => {
        let items = response.data;
        if (items.message === undefined) {
          //data found
          let i = 0;
          const bookList = (items).map((item) => {
            item.id = ++i;
            return item;
          });
          console.log("Book List", bookList)
          dispatch({
            type: 'SET_BOOK_LIST',
            bookList
          });
        }
        else {
          //no data found
          dispatch({
            type: 'SET_BOOK_LIST',
            bookList: []
          });
        }
      })
      .catch((e) => {
        console.log(e.response);
        dispatch({
          type: 'SET_BOOK_LIST',
          bookList: []
        });
      });
  }

  return (
    <div id='action-btn' className='button' onClick={() => filterByCountry()}>
      <div className='btn-text'>
        Get country : {appContext.country.country.country_code}
      </div>
    </div>
  )
}

export default Button;