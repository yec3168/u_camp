package myspring.di.annot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component("helloBeanCons") // 자동으로 helloBenaCons가 붙음
public class HelloBeanCons {
	
	String name;
	PrinterBean printer;
	List<String> names;

	@Autowired
	public HelloBeanCons(@Value("${mynameAnnot2}")String name, 
						 @Qualifier("consolePrinterBean")PrinterBean printer) {
		this.name = name;
		this.printer = printer;
	}

	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> list) {
		this.names = list;
	}

//	public void setName(String name) {
//		this.name = name;
//		System.out.println("setName 메소드 실행  ::" + name);
//	}
//
//	public void setPrinter(PrinterBean printer) { // StringPrinter
//		this.printer = printer;
//		System.out.println("setPrinter 메소드 실행 ::" + printer.getClass().getName());
//	}

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}
