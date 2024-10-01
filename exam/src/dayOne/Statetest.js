import { useState } from "react";

const StateTest = () => {
    // let result = "성공";
    let [result, setResult] = useState('성공');
    let [memberList, setMemberList] = useState([]);
    // let memberList = [];
    let countNumber = 0;
    const messageChange = () =>{
        //렌더링이 안돼서 html에서 반영이 안됨.
        result = "실패"

        // 1.강제로 바꾸기
//        document.querySelector('h1').innerHTML = result;


        // 2. useState
        setResult('useState 수정')

//=-===============================================================

        // memberList
        
        setMemberList(memberList.push(`data-${countNumber++}`));

        console.log(memberList);
    }
    return (
        <p>
            <h1>{result}</h1>
            <button onClick={messageChange}>결과 바꾸기</button>
            <div>
                {/* {
                    memberList.map( (member) =>{
                        return (
                            <h1>{member}</h1>
                        )
                    })
                } */}
            </div>
        </p>
    )
}


export default StateTest;