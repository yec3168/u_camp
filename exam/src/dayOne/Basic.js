    /*
                React 특징
        - 부모의 요소는 무조건 하나여야 한다.
                    :div라는 부모 딱 한개만 존재.
                    : HTML에서 <body>처럼.
            - 컴포넌트파일은 대문자로 시작한다.
                    : App.js ...
            - <> </>로도 가능하다.
                : 보통 필드에서 <>를 사용한다.
        - js에서 `${}` 같이 사용한 것 처럼, JSX에서도 {}를 사용하여 변수를 사용할 수 있음.
        - 
    */
const Basic = () => {

    /**
   *      변수
   * - 변수는 {}로 묶어서 사용하면 JSX에서도 사용이 가능함.
   * - 인자로 받은 변수도 사용이 가능.
   * - className으로 클래스를 줘야한다.
   */
    const name = '이름';
    //스타일을 외부에서 지정이 가능.
    const style = {
        fontSize: '30px'
    }
    return (
    
    <>
        <h1>Basic js 파일입니다.</h1>
        <h2 className={style}>{name}!</h2>
        {/* {
            for(let i =0; i < 10; i++){
                console.log(i)
            }
        } */}
    </>

    );
}

export default Basic;
