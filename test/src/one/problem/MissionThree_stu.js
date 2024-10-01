import {useState} from 'react';

const MissionThree = () => {
    const boardList = [
        {
            "num" : 1,
            "title" : "board-1",
            "createDt" : "2024-09-30",
            "hit" : 1
        },
        {
            "num" : 2,
            "title" : "board-2",
            "createDt" : "2024-09-30",
            "hit" : 10
        }
    ];
    
    const [newBoard, setBoardList] = useState(boardList);

	const list = () => {
		return(
            newBoard.map((board) =>{
                return(
                    <tr>
                        <td>{board.num}</td>
                        <td>{board.title}</td>
                        <td>{board.createDt}</td>
                        <td>{board.hit}</td>
                    </tr>
                )
            })
        );
	};

	const insertForm = () => {
		/* �Է� table�� �����Ѵ�. */
        let num = document.querySelector('#num').value;
        let title = document.querySelector('#title').value;
        let createDt = document.querySelector('#date').value;
        let hit = 0;

        //console.log(num + " | " + title + " | " + createDt + " | " + hit )
        
        let data ={
            "num" : num,
            "title" : title,
            "createDt" : createDt,
            "hit" : hit
        };
        
        let setData = [...newBoard, data];
        //console.log(setData)
        setBoardList(setData);
        //console.log(boardList)

        document.querySelector('#num').value = "";
        document.querySelector('#title').value = "";
        document.querySelector('#date').value = "";
        
    }

    return (
		/* ȭ���� �����Ѵ�. */
        <>
            <h1>Board List</h1>
            <hr />
            <table border='1' id="printList">
                <thead>
                    <tr>
                        <th>Num</th>
                        <th>Title</th>
                        <th>Date</th>
                        <th>Hit</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        list()
                    }
                </tbody>
            </table>
            
            <hr />
            <table border='1'>
                <tr>
                    <th>Num</th>
                    <td><input type="text" id="num"/></td>
                </tr>
                <tr>
                    <th>Title</th>
                    <td><input type="text" id="title"/></td>
                </tr>
                <tr>
                    <th>Date</th>
                    <td><input type="date" id="date"/></td>
                </tr>
                <tr>
                    <th>Hit</th>
                    <td><input type="text" value='0' readOnly/></td>
                </tr>
                <tr>
                    <th colSpan='2'>
                        <button type="button" onClick={insertForm}>ADD</button>
                    </th>
                </tr>
            </table>
        </>
    );
};

export default MissionThree;