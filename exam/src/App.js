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

const App = () => {
  
  return (
    <>
      <BrowserRouter>
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
        </BrowserRouter>
    </>

  );
}

export default App;
