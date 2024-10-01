import './App.css';
import {BrowserRouter, Route, Routes} from 'react-router-dom' 
import MissionOne from './one/problem/MissionOne_stu';
import MissionTwo from './one/problem/MissionTwo_stu';
import MissionThree from './one/problem/MissionThree_stu';
import MissionFour from './one/problem/MissionFour_stu';
import MainComponent from './one/problem/MainComponent';

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<MainComponent />}></Route>
          <Route path="missionOne" element={<MissionOne />}></Route>
          <Route path="missionTwo" element={<MissionTwo />}></Route>
          <Route path="missionThree" element={<MissionThree />}></Route>
          <Route path="missionFour" element={<MissionFour />}></Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
