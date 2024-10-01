
const MissionTwo = () => {

	const validation = (e) => {
		/* ID, PW�� üũ�Ѵ�. */
		let id = document.querySelector('#id').value;
		let pw = document.querySelector('#pw').value;
		
		if(id.length === 0 || pw.length === 0)
			printAlter();
		else if( (id.length >= 3 && id.length <=15) && (pw.length >=3 && pw.length <=15) )
			alert('통과');
		else{
			printAlter();
		} 
	}

	const printAlter = () =>{
		alert("please input data to ID")
	}

    return (
		/* ȭ���� �����Ѵ�. */
		<>
			<h1>Login</h1>
			<hr />
			<table border='1'>
				<tr>
					<th>ID</th>
					<td><input type="text" id="id" /></td>
				</tr>
				<tr>
					<th>PW</th>
					<td><input type="password" id="pw" /></td>
				</tr>
				<tr>
					<th colSpan='2'>
						<button type="button" onClick={validation}>Login</button>
					</th>
				</tr>
			</table>
		</>
    );
};

export default MissionTwo;