package myspring.customer.service;

import java.util.List;
import java.util.Map;

import myspring.customer.vo.CustomerVO;

public interface CustomerService {
	
	public void insertCustomer(CustomerVO customer);

	public List<CustomerVO> getCustomerList();

	public void deleteCustomerUser(Long id);

	public CustomerVO getCustomer(String email);

	public void updateCustomer(CustomerVO customer);
	
}
