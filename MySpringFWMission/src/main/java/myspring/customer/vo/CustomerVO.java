package myspring.customer.vo;

import java.util.Date;

public class CustomerVO {

	private Long id;
	private String email;
	private String name;
	private int age;
	private Date entryDate;

	public CustomerVO() {}
	

	public CustomerVO(String email, String name, int age, Date entryDate) {
		this.email = email;
		this.name = name;
		this.age = age;
		this.entryDate = entryDate;
	}
	
	public CustomerVO(Long id, String email, String name, int age, Date entryDate) {
		this(email,name,age,entryDate);
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
		return entryDate;
	}


	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}


	@Override
	public String toString() {
		return "UserVO [id=" + id + ", email=" + email + ", name=" + name + ", age=" + age + ", entryDate=" + entryDate
				+ "]";
	}

}
