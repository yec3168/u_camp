/*
            선언방식
        1. 함수형 선언 방식  -> 주로 사용.
        2. 클래스 선언 방식

    
        **라이프 사이클
        - 컴포넌트 수명 주기가 존재한다.
        - 렌더링되기 전인 준비 과정에서 시작하여 페이지에서 사라질 때 까지 생존.
        - 컴포너트가 생겨나고 변화하고 없어지는 과정을 말함.
*/ 


//1. 함수 선언 방식.
// state, lifeCycle 관련 기능사용 불가능, Hook를 사용.
// 메모리 자원을 함수형 컴포넌트보다 덜 사용한다.
// useState함수로 state를 선언해서 사용한다.
// useState함수를 사용해서 state값 호출및 초기화가 가능하다.
// 첫 번째 원소는 변수, 두번째 원소는 함수로서 상태를 바꾸어주는 함수이다.
// props를 불러올 필요없이 바로 사용이 가능함.
// const와 함수 형태로 선언해야한다. (익명함수)
//      ex) const addNum = () => {
        //         setNumber(num+1)    
        // }
// 요소에 접근시 this를 통해 접근x.


import React, {Component} from "react";



function Home(){
    return <h1>home 화면입니다.</h1>
}

export default Home;





// 2. 클래스 선언 방식
// state, lifeCycle 관련 기능사용 가능
// 메모리 자원을 함수형 컴포넌트보다 조금 더 사용한다.
// 임의 메서드를 정의할 수 있다.
// 생성자에서 this.state 초기값 설정 가능.
// construct 없이 state 초기값 설정가능.
// state는 객체 형식
// this.setState 함수로 state의 값을 변경할 수 있다
// this.props를 선언하여 변수를 지정한 후 사용이 가능하다.
//      ex) const {name, age} = this.props;
// 함수를 선언시 화살표함수(람다식) 으로 바로 사용이 가능하고, 요소를 적용 시 'this.' 를 붙여줘야한다.
// 해당 선언방식을 주로 사용할 때에는 기존에 클래스형 컴포넌트로 작성된 렉시를 유지보수 하는 상황에서만 사용.



// import React, {Component} from "react";


// class Home extends Component{
//     state = {
//         type : 'class',
//         state: 'without constructor'
//     }
    
//     render () {
//         return <h1>q</h1>
//     }
// }


// 아래 코드가 존재해야, Component로서 작동함
// export default Home;