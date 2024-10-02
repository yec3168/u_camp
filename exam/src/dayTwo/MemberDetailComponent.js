import axios from "axios";
import { useEffect, useState } from "react";

const MemberDetailComponent = (props) =>{
    console.log(props)

    const [member, setMember] = useState({});

    const getMember = () =>{
        let url= `http://10.81.23.170:8080/ucamp/detail.jsp?id=${props.params.id}`
        
        axios.get(url)
        .then((response) => {
            setMember(response.data)
        })
    }

    useEffect(() =>{
        getMember();
    }, [])

    return (
        <>
            <h1>회원상세정보</h1>
            <hr/>
            <table border='1'>
                <tr>
                    <th>ID</th>
                    <td>{member.id}</td>
                </tr>
                <tr>
                    <th>PW</th>
                    <td>{member.pw}</td>
                </tr>
                <tr>
                    <th>NAME</th>
                    <td>{member.name}</td>
                </tr>
                <tr>
                    <th>ADDR</th>
                    <td>{member.addr}</td>
                </tr>
            </table>
        </>
    );
}

export default MemberDetailComponent;