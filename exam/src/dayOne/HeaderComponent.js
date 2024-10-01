import PropsTypes  from 'prop-types';

const HeaderComponent = (props) => {
    const result = props.isDel ? "True": "False";
    console.log(result)
    return (
        <div>
            <h1>제일 큰 타이틀 태그.</h1>
            <p>{props.title} + {props.isDel}</p> 
            <p>{props.name}</p>
            <p>{props.location}</p>
        </div>
    );
}
// 타입을 지정해줌.
HeaderComponent.propsTypes ={
    title:PropsTypes.string,
    name:PropsTypes.string,
    location: PropsTypes.number.isRequired
}

//값을 입력하지 않으면 default값을 지정해줌.
// HeaderComponent.defaultProps = {
//     title:"지정된 제목",
//     name :"지정된 이름",
//     location:1
// }

export default HeaderComponent;