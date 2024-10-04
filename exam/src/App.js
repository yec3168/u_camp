// import logo from './logo.svg';
import './App.css';
import {BrowserRouter, Route, Routes} from 'react-router-dom' 
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

const App = () => {
  
  return (
    <>
      <BrowserRouter>
            {/* 1일차 */}
            <Routes>
                <Route path="/" element={<MainComponent />}></Route>
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
        </BrowserRouter>
    </>

  );
}

export default App;
