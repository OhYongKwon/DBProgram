package model;

public class Company {
	int id;
	String name;
	String department;
	int salary;
	String ceatrion_date;
	public Company(){};
	public Company(int id, String name, String department, int salary, String ceatrion_date) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.ceatrion_date = ceatrion_date;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int number) {
		this.salary = number;
	}
	public String getCeatrion_date() {
		return ceatrion_date;
	}
	public void setCeatrion_date(String ceatrion_date) {
		this.ceatrion_date = ceatrion_date;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary
				+ ", ceatrion_date=" + ceatrion_date + "]";
	}
	
}

