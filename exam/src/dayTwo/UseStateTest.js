import { useState } from "react";

const UseStateTest = () =>{
    /**
     *          useState
     *  - const [변수, 함수] = useState(초기값);
     *  - state는 변화를 감지해줌.
     *  - 만약 변수의 값이 변화가 생기면 rendering을 새로 해줌.
     *  - 함수를 통해 변수의 값을 재설정이 가능하며, 초기값을 설정을 해줘야함.
     *      ex) const [cnt, setCnt] = useState(0);
     *          setCnt(cnt+1);
     */
    const [checked, setChecked] = useState([]);
    const boxList = ['first', 'second', 'third'];

    const checkedHandler = (id) =>{

        let isDups = false;
        
        for(let i = 0; i< checked.length; i++){
            if(checked[i] === id){
                isDups = true;
            } 
        }
        if(!isDups){
            console.log([...checked])
            setChecked([...checked, id])
        }
        setTimeout(function() { 
            // Code here 
            console.log(checked)
        }, 1000);
        
    }

    const allHandler = (e) =>{
        if(e.target.checked){
            setChecked(boxList);
        }
    }
    return(
        <>
            All or Nothing<input type="checkbox" id='all' onChange={(e)=>{ allHandler(e)}}/>
            <hr />

            {
                boxList.map( (box) => {
                    return(
                        <>
                            <input type='checkbox' value={box} checked={ checked.includes({box})} onChange={()=>{checkedHandler({box})}}/> {box}
                        </>
                    )
                })
            }
            <br />
            <input type='checkbox' className="exam" value='first' onChange={() =>{ checkedHandler('first')} }/>one
            <input type='checkbox' className="exam" value='second' onChange={() =>{ checkedHandler('second')}}/>two
            <input type='checkbox' className="exam" value='third' onChange={() =>{ checkedHandler('third')}}/>three
        </>
    )
}

export default UseStateTest;