import { useSelector } from "react-redux"
import LoginComponentReview from "./LoginComponentReview"

const MainComponentReview = () =>{
    const state = useSelector( (state) => {
        return state
    })

    return (
        <>
            ID : {state.id}<br/>
            Name : {state.name} <br/>
            <hr />
            <LoginComponentReview />
        </>
    )
}

export default MainComponentReview;