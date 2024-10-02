import { useEffect, useState } from "react";

const EffectTest = () =>{
    const [cnt, setCnt] = useState(0);
    const [name, setName] = useState('kim');

    const clickHandler = (props) =>{
        setCnt(cnt+1)
        setName('park' + name)
    }

    /**
     *          useEffect
     *  - useEffect( ()=>{
     *          // 이벤트
     *  }, [])
     *   = 뒤에 빈 배열을 넣어주면 한 번만 실행됨
     *   = 없으면 계속 실행됨.
     *   = 배열안에 값을 넣어 줄 수 있음.
     *       배열안에 값이 바뀌면 작동한다는 것.
     *   = 만약, 이벤트를 통해 [값] 이 바뀌지 않으면 실행이 안됨.
     * 
     * 
     *  - javascript에서 onload
     *  - jQeury 에서 Document.ready
     *  - return을 적어주면 unmount라는것을 실행.
     */
    useEffect(() =>{
        console.log("effect")

        return (() =>{
            console.log("--> unmount")
            return true;
        })
    }, [cnt])
    return(
        <>
            <input type="text" value={cnt} />
            <button onClick={clickHandler}>클릭</button>
        </>
    );
}

export default EffectTest;