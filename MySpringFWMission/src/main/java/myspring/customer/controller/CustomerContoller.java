package myspring.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import myspring.customer.service.CustomerService;
import myspring.customer.vo.CustomerVO;

@Controller
public class CustomerContoller {

	@Autowired
	CustomerService customerService;
	
	
	@RequestMapping("/getCustomerList")
	public ModelAndView getCustomerList() {
		List<CustomerVO> customerList = customerService.getCustomerList();
		return new ModelAndView("customerList", "customerList", customerList);
	}
	
	@RequestMapping("/customers")
	public String getCustomers(Model model) {
		List<CustomerVO> customerList = customerService.getCustomerList();
		model.addAttribute("customerList", customerList);
		return "customerList";
	}
	
	@RequestMapping("/getCustomerDetail")
	public String getCustomerDetail(@RequestParam("email")String email, Model model) {
		CustomerVO customer = customerService.getCustomer(email);
		model.addAttribute("customer", customer);
		return "customerDetail";
	}
}
