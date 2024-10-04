import { createStore } from "redux";
import memberReducer from "./memberReducer";

const storage = createStore(memberReducer)

export default storage;