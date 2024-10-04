// import $ from 'jquery';

const MissionTwo = () => {

	const validation = (e) => {
		/* ID, PW�� üũ�Ѵ�. */
		let id = document.querySelector('#id').value;
		let pw = document.querySelector('#pw').value;
		console.log(id.length + " | " + pw.length)
		if(id == '' || pw == ''){
			printAlert();
		}
		else if ( (id.length >= 3 && id.length <=15) && (pw.length >=3 && pw.length <=15) ){
			alert('통과')
		}
		else
			printAlert();
	}

	const printAlert = () =>{
		alert('please input data to ID')
	}

    return (
		/* ȭ���� �����Ѵ�. */
		<>
			<h1>Login</h1>
			<hr></hr>

			<table border='1'>
				<tr>
					<th>ID</th>
					<td><input type="text" id="id"/></td>
				</tr>
				<tr>
					<th>PW</th>
					<td><input type="password" id='pw'/></td>
				</tr>
				<tr>
					<th colSpan='2'><input type="submit" value='Login' onClick={validation}/></th>
				</tr>
			</table>
		</>
    );
};

export default MissionTwo;