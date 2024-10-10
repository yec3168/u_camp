package myspring.di.xml;

import java.util.List;

public class Hello {
	String name;
	Printer printer;
	List<String> names;

	public Hello() {
		System.out.println(this.getClass().getName() + " 기본생성자 호출됨.");
	}

	public Hello(String name, Printer printer) {
		this.name = name;
		this.printer = printer;
		System.out.println(this.getClass().getName() + " 오버로딩 생성자 호출됨.");
	}

	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> list) {
		this.names = list;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("setName 메소드 실행  ::" + name);
	}

	public void setPrinter(Printer printer) { // StringPrinter
		this.printer = printer;
		System.out.println("setPrinter 메소드 실행 ::" + printer.getClass().getName());
	}

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}
