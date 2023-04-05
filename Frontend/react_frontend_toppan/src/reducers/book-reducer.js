export const initialState = {
    accordion: {
        open: false,
        bookId: 0,
    },
};

export const bookReducer = (state = initialState, action) => {
    switch (action.type) {
        case 'SET_ACCORDION':
            return { ...state, accordion: action.accordion };
        default:
            return state;
    }
}
