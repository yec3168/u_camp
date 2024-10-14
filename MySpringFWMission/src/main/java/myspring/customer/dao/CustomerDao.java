package myspring.customer.dao;

import java.util.List;

import myspring.customer.vo.CustomerVO;

public interface CustomerDao {
	public void insert(CustomerVO customer);

	public List<CustomerVO> readAll();

	public void update(CustomerVO customer);

	public void delete(Long id);

	public CustomerVO read(String email);

}
