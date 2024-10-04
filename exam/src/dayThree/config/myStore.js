import counterReducer from "./counterReducer";
import {createStore} from 'redux'

// const rootReducer = combineReducers( {counterReducer, memberReducer})
const myStore = createStore(counterReducer);

export default myStore;