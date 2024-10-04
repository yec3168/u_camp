// action = 뭐를 해야할지 구분하는 구분자.
// initstate = 초기값.

export const plus = () =>{
    return{
        type:'PLUS'
    };
}

export const minus = () =>{
    return{
        type:'MINUS'
    };
}
const initState ={
    number : 0
};

// reducer : store의 state 값을 변경시켜줌.
const counterReducer = (state = initState, action) =>{
    switch(action.type){
        case "PLUS":
            return{
                number : state.number + 1 
            };
        case "MINUS":
            return{
                number : state.number - 1 
            };
        default :
            return state;
    }
}

export default counterReducer;