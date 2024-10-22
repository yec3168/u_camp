import axios from "axios";

const REST_API_BASE_URL =  'http://localhost:8080/api'

const DEPARTMENT_REST_API_URL = `${REST_API_BASE_URL}/departments`
//'http://localhost:8080/api/departments'

// department 목록 조회
export const getAllDepartments = () => axios.get(DEPARTMENT_REST_API_URL);


// 등록
export const createDepartment = (department) => axios.post(DEPARTMENT_REST_API_URL, department);


// id로 department 조회
export const getDepartmentById = (departmentId) => axios.get(`${DEPARTMENT_REST_API_URL} /${departmentId}`);


//수정
export const updateDepartment = (departmentId, department) => axios.put(DEPARTMENT_REST_API_URL + '/' + departmentId, department);


//삭제
export const deleteDepartment = (departmentId) => axios.delete(DEPARTMENT_REST_API_URL + '/' + departmentId);