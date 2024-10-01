import HeaderComponent from './HeaderComponent'

const CmpComponent = () =>{

    let n = "전역변수 n"
    let dataList = [
        {
            "id": 'abcd',
            'pw': '1234',
            'name': 'hong',
            'addr': 'seoul'
        },
        {
            "id": 'qwed',
            'pw': '1234',
            'name': 'dong',
            'addr': 'seoul'
        },
        {
            "id": 'zxcv',
            'pw': '1234',
            'name': 'gong',
            'addr': 'seoul'
        }
    ]
    return(
        <>
        {   
            dataList.map((data) => {
                return (<p>{data.id}</p>);
            })
            // dataList.map((data) => (<p>{data.id}</p>))

            //for(let i = 0; i< data.length; i++){} x
        }
            <HeaderComponent title="첫번째" isDel = {false}/> {/* <h1>제일 큰 타이틀 태그 입니다.*/}
            <HeaderComponent name="이름입니다"/>
            <HeaderComponent location="seoul"/>
            <HeaderComponent title="숫자" location={20000}/>
            <HeaderComponent title="문자열" name='20000'/>
            <HeaderComponent title={n} name={1000}/>


            {/* 
                <div>
                    <h1>제일 큰 타이틀 태그 입니다.</h1>
                </div>
                <div>
                    <h1>제일 큰 타이틀 태그 입니다.</h1>
                </div>
                <div>
                    <h1>제일 큰 타이틀 태그 입니다.</h1>
                </div>
             */}
        </>
    )
}

export default CmpComponent;