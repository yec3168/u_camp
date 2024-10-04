import { Outlet } from "react-router-dom";
import Footer from "./Footer";
import Header from "./Header";
import Other from "./Other";
import TestParam from "./TestParam";

const MainLayout = () =>{
    return(
        <>
           <Header />
           {/* route 안에 route가 존재하면 해당 링크로 이동할 때 필요 컴포넌트가 동적으로 선택돼서 들어옴. */}
           <Outlet /> 
           <Footer />
        </>
    );
}

export default MainLayout;