package myspring.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myspring.customer.service.CustomerService;
import myspring.customer.vo.CustomerVO;

@RestController
@RequestMapping("/customers")
public class CustomerRestContoller {
	
	@Autowired
	CustomerService customerService;
	
	
	@GetMapping("/{email}/")
	public CustomerVO getCustomer(@PathVariable("email")String email, Model model) {
		CustomerVO customer = customerService.getCustomer(email);
		return customer;
	}
	@GetMapping("")
	public List<CustomerVO> getCustomer() {
		List<CustomerVO> customerList = customerService.getCustomerList();
		return customerList;
	}
	
	@PostMapping("")
	public List<CustomerVO> insertCustomer(@RequestBody CustomerVO customerVo){
		customerService.insertCustomer(customerVo);
		return customerService.getCustomerList();
	}
}
