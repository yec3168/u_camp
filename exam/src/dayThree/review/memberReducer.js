export const add = (paramId, paramName) =>{
    return {
        type:"ADD",
        id: paramId,
        name: paramName
    };
    // 객체 형태로 return
}

export const remove = () =>{
    return{
        type : 'REMOVE'
    }

    // 호출하면 객체 형태로 return
}
const initState ={
    id : 'hong',
    name : '홍길동'
}

const memberReducer = (state = initState , action) => {
    switch(action.type){
        case 'ADD':
            return{
                id : action.id,
                name : action.name
            } 
        case 'REMOVE':
            return{
                id: 'undefined',
                name: 'undefined',
            }
        default:
            return state;
    }
}

export default memberReducer;