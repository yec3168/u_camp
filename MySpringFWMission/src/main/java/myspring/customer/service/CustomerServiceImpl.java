package myspring.customer.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myspring.customer.dao.CustomerDao;
import myspring.customer.vo.CustomerVO;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;


	@Override
	public void insertCustomer(CustomerVO customer) {
		customerDao.insert(customer);
	}

	@Override
	public List<CustomerVO> getCustomerList() {
		return customerDao.readAll();
	}

	@Override
	public void deleteCustomerUser(Long id) {
		customerDao.delete(id);
		
	}

	@Override
	public CustomerVO getCustomer(String email) {
		return customerDao.read(email);
	}

	@Override
	public void updateCustomer(CustomerVO customer) {
		customerDao.update(customer);
	}


	
}
