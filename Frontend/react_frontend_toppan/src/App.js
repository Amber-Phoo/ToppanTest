import { React, useReducer, useEffect } from 'react';
import './styles/App.css';
import Button from './components/Button';
import BookList from './components/BookList';
import NoData from './components/NoData';
import AppContext from './context/app-context';
import { appReducer, initialState } from './reducers/app-reducer';
import BookDataService from './api/book-action';

function App() {
  const [appContext, dispatch] = useReducer(appReducer, initialState);

  useEffect(() => {
    const initBooks = () => {
      BookDataService.getTop3ReadBooksGlobal()
        .then((response) => {
          let items = response.data;
          let i = 0;
          const bookList = (items).map((item) => {
            item.id = `book-item-${++i}`;
            return item;
          });
          console.log("Book List", bookList)
          dispatch({
            type: 'SET_BOOK_LIST',
            bookList
          });
        })
        .catch((e) => {
          console.log(e.response);
          dispatch({
            type: 'SET_BOOK_LIST',
            bookList: []
          });
        });
    };
    initBooks();
  }, []);

  return (
    <div className='frame1'>
      <div className='body1'>
        {
          appContext &&
          <AppContext.Provider value={{ appContext, dispatch }}>
            <Button></Button>
            {
              appContext.bookList.length > 0 ?
                <BookList books={appContext.bookList}></BookList> : <NoData></NoData>
            }
          </AppContext.Provider>
        }
      </div>
    </div>
  );
}

export default App;
