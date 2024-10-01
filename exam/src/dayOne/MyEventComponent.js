import { useEffect } from "react";

const MyEventComponent = () => {

    const myClickHandler = () =>{
        alert("클릭이벤트");
    }

    const calculation = () =>{
        console.log("asd")

        let firstNum = Number(document.querySelector('#firstNum').value );
        let oper = (document.querySelector('#oper').value );
        let secondNum = Number(document.querySelector('#secondNum').value )

        console.log( firstNum + " | " + secondNum + " | " + oper)

        let result = 0;
        switch(oper){
            case '+':
                result = firstNum + secondNum;
                break;
            case '-':
                result = firstNum - secondNum;
                break;
            case '*':
                result = firstNum * secondNum;
                break;
            case '%':
                result = firstNum % secondNum;
                break;
            default:
                result = firstNum / secondNum;
                break;
        }
        console.log(result)
    }

    // document.ready,   onload
    useEffect(() =>{
        // server request
        // json load
        // init
        let btn = document.querySelector("#save");

        btn.addEventListener('cilck', function(){
            alert("useEffect클릭메소드")
        })
    }, [])
    return(
        <>
            <input type="text" onChange={(event) => {
                console.log(event.target.value)
            }}/> <br />

            <hr/>
            <input type="text" width='100' id='firstNum' />
            <select id='oper'>
                <option>+</option>
                <option>-</option>
                <option>*</option>
                <option>%</option>
                <option>/</option>
            </select>
            <input type="text" width='100' id='secondNum' /> <br />
            <button onClick={calculation}>계산</button>
            
            <hr />

            <button onClick={myClickHandler}>클릭이벤트 테스트 버튼</button>
            <button id='save'>함수 핸들러 이벤트 클릭.</button>
        </>
    )
};

export default MyEventComponent;