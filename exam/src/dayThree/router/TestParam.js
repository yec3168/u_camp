import { useLocation, useParams, useSearchParams } from "react-router-dom";

const TestParam = () => {
    // 경로에 있는 parma을 가져옴.
    const {id, pw} = useParams();
    // location의 대한 정보가 들어 있음.
    const location = useLocation();
    // 객체를 하나 얻어와서 파라미터의 정보를 가져옴
    const [searchParam, setSearchParams] = useSearchParams();

    return(
        <>
        {/* http://localhost:3000/TestParam/honh/1234?productName=1234&productPrice=1000&qty=12#test1234 */}
            
            {/* hong */}
            ID : {id}<br />  
            {/* 1234 */}
            pw : {pw}<br />
            <hr />


            {/* /TestParam/honh/1234 */}
            LOCATION PATHNAME : {location.pathname} <br />
            {/* ? 뒤에 오는 것들 
                ex)?productName=asd&productPrice=1000&qty=10 */}
            LOCATION SEARCH : {location.search} <br />
            {/* 뒤에 # 이 붙으면 */}
            {/* #test1234 */}
            LOCATION HASH : {location.hash}<br />

            <hr />
            {/* 1234 */}
            Product Name : {searchParam.get("productName")}<br />
            {/* 1000 */}
            Product Price : {searchParam.get("productPrice")}<br />
            {/* 12 */}
            Product Quantity : {searchParam.get("qty")}<br />
        </>
    )
}

export default TestParam;