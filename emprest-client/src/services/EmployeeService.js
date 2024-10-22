import axios from "axios";

const REST_API_BASE_URL =  'http://localhost:8080/api'

const REST_API_URL = `${REST_API_BASE_URL}/employees`
//'http://localhost:8080/api/employees';

//export const listEmployees = () => axios.get(REST_API_BASE_URL);
// Employees와 department의 목록을 출력.
export const listEmployees = () => axios.get(`${REST_API_URL}/departments`);

// Employee등록
export const createEmployee = (employee) => axios.post(REST_API_URL, employee);


// Employee id로 조회
export const getEmployee = (employeeId) => axios.get(REST_API_URL + '/' + employeeId);


// 수정
export const updateEmployee = (employeeId, employee) => axios.put(REST_API_URL + '/' + employeeId, employee);


//삭제
export const deleteEmployee = (employeeId) => axios.delete(REST_API_URL + '/' + employeeId);