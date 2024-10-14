package myspring.customer.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myspring.customer.dao.mapper.CustomerMapper;
import myspring.customer.vo.CustomerVO;

@Repository("customerDao")
public class CustomerDaoImplMapper implements CustomerDao {
	
	@Autowired
	private CustomerMapper customerMapper;	
	
	
	@Override
	public CustomerVO read(String email) {
		CustomerVO customer = customerMapper.selectCustomerByEmail(email);
		return customer;
	}
	
	public List<CustomerVO> readAll() {
		List<CustomerVO> customerList = customerMapper.selectCustomerList();
		return customerList;
	}

	public void insert(CustomerVO customer) {
		customerMapper.insertCustomer(customer);
		System.out.println("등록된 Record Email=" + customer.getEmail() + 
				" Name=" + customer.getName());
	}

	@Override
	public void update(CustomerVO customer) {
		customerMapper.updateCustomer(customer);
	}
	
	@Override
	public void delete(Long id) {
		customerMapper.deleteCustomer(id);
		System.out.println("삭제된 Record with ID = " + id ); 
	}
}










