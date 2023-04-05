import { React, useReducer } from 'react';
import './styles/App.css';
import Button from './components/Button';
import BookList from './components/BookList';
import NoData from './components/NoData';
import AppContext from './context/app-context';
import { appReducer, initialState } from './reducers/app-reducer';

function App() {
  const [appContext, dispatch] = useReducer(appReducer, initialState);
  return (
    <div className='frame1'>
      <div className='body1'>
        {
          appContext &&
          <AppContext.Provider value={{ appContext, dispatch }}>
            <Button></Button>
            {
              appContext.data.length > 0 ?
                <BookList></BookList> : <NoData></NoData>
            }
          </AppContext.Provider>
        }
      </div>
    </div>
  );
}

export default App;
