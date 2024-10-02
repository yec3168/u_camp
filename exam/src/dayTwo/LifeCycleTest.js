import {Component} from 'react';

class LifeCycleTest extends Component{
    //생성자
    constructor(props){
        super(props); // 없으면 오류 발생.
        this.state = {number : 0};
        console.log('---> 1. constrouct (처음실행)')
    }

    //update가 진행되면 실행됨.
    // default가 true이기 때문에 render()가 다시 실행.
    shouldComponentUpdate(){
        console.log('---> a.shouldComponentUpdate')
        return true;// true로 하면 랜더링을 함
                    // false면 안함. 
                    //자동으로 호출되는 함수.

    }
    
    // shouldComponentupdate return 값이 true라면 
    // 해당 함수가 실행됨.
    // 정확히 뭐하는 함수인지는 아직 모름.
    getSnapshotBeforeUpdate(){
        console.log('---> b.getSnapshotbeforeUpdate');
        return null;
    }

   



    // 화면을 구성( 화면에 보여준다.)
    // return을 써야 화면에 보여줌.
    render(){
        console.log("---> 2. render 호출")
        return(
                <>
                    <p>
                        <input type='text' />
                        <button onClick={()=>{
                            this.setState({number : 10})
                            document.querySelector('input').value = this.state.number
                        }}>버튼</button>
                    </p>
                </>
            )
    }

    // 컴포넌트가 mount되면 즉시 호출되는 함수.
    // 여기서 re-rendering을 하거나 state를 세팅?
    componentDidMount(){
        console.log('---> 3. compnentDidMount 호출.')
    }

    // update하면 호출.
    componentDidUpdate(){
        console.log('---> c.componentDidUpdate');
    }

    // 반납, 이벤트를 사용하면 제거하는 역할.4
    // 랜더링과 컴포넌트 mount 후 제거하는 역할.
    componentWillUnmount(){
        console.log('---> ㄱ.componentWillUnmount');
    }

}

export default LifeCycleTest;