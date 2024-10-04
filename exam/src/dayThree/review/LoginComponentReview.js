import { useDispatch } from "react-redux";
import { add, remove} from './memberReducer'
const LoginComponentReview = () =>{

    const dispatch = useDispatch();
    
    const saveMember = () => {
        let id = document.querySelector("#id").value;
        let pw = document.querySelector("#pw").value;
        let name = document.querySelector("#name").value;

        dispatch(add(id, name));
    }

    const removeMember = () =>{
        dispatch(remove())
    }
    
    return(
        <>
            Id : <input type="text" id ='id' /> <br/>
            pw : <input type="password" id='pw' /> <br />
            name : <input type="text" id='name' / ><br />

            <p>
                <button onClick={saveMember}>저장</button>
                <button onClick={removeMember}>제거</button>
            </p>
        </>
    );
}

export default LoginComponentReview;