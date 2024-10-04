// import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import MainComponent from './dayOne/MainComponent'
import LoginComponent from './dayOne/LoginComponent'
import ClsComponent from './dayOne/ClsComponent'
import DivComponent from './dayOne/DivComponent'
import DataTest from './dayOne/DataComponent';
import CmpComponent from './dayOne/CmpComponent';
import MapTest from './dayOne/MapTest'
import MyEventComponent from './dayOne/MyEventComponent'
import StateTest from './dayOne/Statetest';
import LifeCycleTest from './dayTwo/LifeCycleTest';
import UseStateTest from './dayTwo/UseStateTest';
import EffectTest from './dayTwo/EffectTest';
import AjaxTest from './dayTwo/AjaxTest';
import MemberInsetComponent from './dayTwo/MemberInsertComponent';
import MemberListComponent from './dayTwo/MemberListComponent';
import MemberDetailComponent from './dayTwo/MemberDetailComponent';
import MissionOne from './exam/MissionOne_stu'
import MissionTwo from './exam/MissionTwo_stu'
import MissionThree from './exam/MissionThree_stu'
import MissionFour from './exam/MissionFour_stu'
import { useDispatch, useSelector } from 'react-redux';
import { plus, minus } from './dayThree/config/counterReducer';
import TestParam from './dayThree/router/TestParam';
import MainLayout from './dayThree/router/MainLayout'
import Other from './dayThree/router/Other';

const App = () => {
  // store의 값을 변경 함.
  const dispatch = useDispatch();
  // store의 state값을 가져옴.
  const number = useSelector((state) => {
    console.log(state.number)
    return state.number;
  });

  const plusNumber = () => {
    // dispatch({
    //   type: 'PLUS'
    // })

    dispatch(plus())
  }

  const minusNumber = () => {
    // dispatch({
    //   type: 'PLUS'
    // })

    dispatch(minus())
  }


  return (
    <>
      <BrowserRouter>
        {/* 1일차 */}
        <Routes>
          {/* <Route path="/" element={<MainComponent />}></Route> */}
          <Route path="addMember" element={<LoginComponent name="testName" />}></Route>
          <Route path="classType" element={<ClsComponent />}></Route>
          <Route path="divComponent" element={<DivComponent />}></Route>
          <Route path="dataTest" element={<DataTest />}></Route>
          <Route path="cmpComponent" element={<CmpComponent />}></Route>
          <Route path="mapTest" element={<MapTest />}></Route>
          <Route path="myEventComponent" element={<MyEventComponent />}></Route>
          <Route path="stateTest" element={<StateTest />}></Route>
        </Routes>

        {/* 2일차 */}
        <Routes>
          <Route path='lifeCycleTest' element={<LifeCycleTest />}></Route>
          <Route path='useStateTest' element={<UseStateTest />}></Route>
          <Route path='effectTest' element={<EffectTest />}></Route>
          <Route path='ajaxTest' element={<AjaxTest />}></Route>
          <Route path='memberInsertComponent' element={<MemberInsetComponent />}></Route>
          <Route path='memberListComponent' element={<MemberListComponent />}></Route>
          {/* :id 같이 선언시 유동적으로 바뀜 */}
          <Route path='memberDetailComponent/:id' element={<MemberDetailComponent />}></Route>
        </Routes>

        <Routes>
          <Route path='missionOne' element={<MissionOne />}></Route>
          <Route path='missionTwo' element={<MissionTwo />}></Route>
          <Route path='missionThree' element={<MissionThree />}></Route>
          <Route path='missionFour' element={<MissionFour />}></Route>
        </Routes>

        {/* 3일차 */}
        <Routes>
          <Route path='/' element={<MainLayout />}>
            <Route path='testParam/:id/:pw' element={<TestParam />}></Route>
            <Route path='other' element={<Other />}></Route>
          </Route>
        </Routes>
      </BrowserRouter>

      {/* Redux 테스트 */}
      {/* <h1>Number 값 변화 확인</h1>
      <hr />
      <button onClick={plusNumber}>플러스</button>
      <button onClick={minusNumber}>마이너스</button>
      <input type='text' value={number} readOnly /> */}
    </>

  );
}

export default App;
