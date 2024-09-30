const DataComponent = () =>{
    const data =[
        {
            "num": 1,
            "name":"김",
            "dept":"개발",
            "location" : '서울'
            
        },
        {
            "num": 1,
            "name":"박",
            "dept":"영업",
            "location" : '인천'

        }
    ];

    const dataInfo =()=>{

        let list = "";
        for(let i =0; i < data.length; i++){
            let num = data[i].num;
            let name = data[i].name;
            let dept = data[i].dept;
            let location = data[i].location;

            list += `<tr>`;
                list += `<td>${num}</td>`;
                list += `<td>${name}</td>`;
                list += `<td>${dept}</td>`;
                list += `<td>${location}</td>`;
            list += "</tr>";
        }

        data.map((item, index) => {
            console.log(item)
        })
        
        return (
            list   
        );
    }

    return (
        <>
            <table border="1">
                <tr>
                    <th>번호</th>
                    <th>이름</th>
                    <th>부서</th>
                    <th>위치</th>
                </tr>
                {dataInfo()}
            </table>
        </>
    );
}

export default DataComponent;