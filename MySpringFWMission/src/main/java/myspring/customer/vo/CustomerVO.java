package myspring.customer.vo;

import java.util.Date;

public class CustomerVO {

	private Long id;
	private String email;
	private String name;
	private int age;
	private Date entry_date;

	public CustomerVO() {}
	

	public CustomerVO(String email, String name, int age) {
		this.email = email;
		this.name = name;
		this.age = age;
	}
	
	public CustomerVO(Long id, String email, String name, int age) {
		this(email,name,age);
		this.id = id;
	}

	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public Date getEntryDate() {
		return entry_date;
	}


	public void setEntryDate(Date entry_date) {
		this.entry_date = entry_date;
	}


	@Override
	public String toString() {
		return "UserVO [id=" + id + ", email=" + email + ", name=" + name + ", age=" + age + ", entryDate=" + entry_date
				+ "]";
	}

}
