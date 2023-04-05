export const initialState = {
    data: [],
};

export const appReducer = (state = initialState, action) => {
    switch (action.type) {
        case 'SET_DATA':
            return { ...state, data: action.data };
        default:
            return state;
    }
}
