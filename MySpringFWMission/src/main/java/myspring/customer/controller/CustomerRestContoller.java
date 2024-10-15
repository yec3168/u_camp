package myspring.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String getCustomer(@PathVariable("email")String email, Model model) {
		CustomerVO customer = customerService.getCustomer(email);
		model.addAttribute("customer", customer);
		return "customerDetail";
	}
	@GetMapping("/")
	public String getCustomer( Model model) {
		List<CustomerVO> customerList = customerService.getCustomerList();
		model.addAttribute("customerList", customerList);
		return "customerList";
	}
}
