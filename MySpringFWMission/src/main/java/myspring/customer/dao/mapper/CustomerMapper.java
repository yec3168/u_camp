package myspring.customer.dao.mapper;
import java.util.List;

import myspring.customer.vo.CustomerVO;

//@MyMapper
public interface CustomerMapper {
	//@Select("select * from users where userid=#{id}")
	//UserVO selectUserById(@Param("id") String id);
	CustomerVO selectCustomerByEmail(String email);
	List<CustomerVO> selectCustomerList();
	void insertCustomer(CustomerVO userVO);
	void updateCustomer(CustomerVO userVO);
	void deleteCustomer(Long id);
}

