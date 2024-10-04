import { useState } from "react";

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

    const [stateBoard, setBoardList] = useState(boardList);

	const list = () => {
		/* ��� table�� �����Ѵ�. */
        return(
            stateBoard.map( (board) =>{
                return(
                    <tr>
                        <td>{board.num}</td>
                        <td>{board.title}</td>
                        <td>{board.createDt}</td>
                        <td>{board.hit}</td>
                    </tr>
                )
            })
        )
	};

	const insertForm = () => {
		/* �Է� table�� �����Ѵ�. */
        let num = document.querySelector('#num').value;
        let title = document.querySelector('#title').value;
        let createDt = document.querySelector('#createDt').value;
        let hit = document.querySelector('#hit').value;

        let data = {
            'num': num,
            'title': title,
            'createDt': createDt,
            'hit':hit
        }

        setBoardList([...stateBoard, data])

        console.log(stateBoard);

	}

    return (
		/* ȭ���� �����Ѵ�. */
        <> 
        <h1>Board List</h1>
        <hr/>
        <table border='1'>
                <thead>
                    <tr>
                        <th>Num</th>
                        <th>Title</th>
                        <th>Create Date</th>
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
                    <th>Mum</th>
                    <td><input type="text" id="num"/></td>
                </tr>
                <tr>
                    <th>Title</th>
                    <td><input type="text" id='title'/></td>
                </tr>
                <tr>
                    <th>createDate</th>
                    <td><input type="text" id='createDt'/></td>
                </tr>
                <tr>
                    <th>Hit</th>
                    <td><input type="text" id="hit" value='0' readOnly/></td>
                </tr>
                <tr>
                    <th colSpan='2'><button onClick={insertForm}>ADD</button></th>
                </tr>
            </table>          
        </>
    );
};

export default MissionThree;