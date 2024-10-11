package myspring.di.annot;

import org.springframework.stereotype.Component;

@Component("springPrinter") // bean에 자동으로 등록하여 생성할 수 있도록 도와줌. id값은 필수
public class StringPrinterBean implements PrinterBean {
	private StringBuffer buffer = new StringBuffer();
	
	public StringPrinterBean() {
		System.out.println(this.getClass().getName());
	}
	
	public void print(String message) {
		this.buffer.append(message);
	}

	public String toString() {
		return this.buffer.toString();
	}
}
