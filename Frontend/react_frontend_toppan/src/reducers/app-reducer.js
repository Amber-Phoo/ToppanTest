export const initialState = {
    bookList: [],
    country: {
        country:{
            country_code:""
        }
    }
};

export const appReducer = (state = initialState, action) => {
    switch (action.type) {
        case 'SET_BOOK_LIST':
            return { ...state, bookList: action.bookList };
        case 'SET_COUNTRY':
            return { ...state, country: action.country };
        default:
            return state;
    }
}
