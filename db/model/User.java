package db.model;

public class User {
	private Integer id;
	private String name;
	private String password;
	private Boolean isRegister;
	
	public User() {}
	public User(String name,String password, Boolean isRegister) {
		
		this.name=name;
		this.password=password;
		this.isRegister=isRegister;
		
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public Boolean getIsRegister() {
		return isRegister;
	}
	public void setIsRegister(Boolean isRegister) {
		this.isRegister=isRegister;
	}

	@Override
	public String toString() {
		 return "User{" +
	                "name='" + name + '\'' +
	                ", password='" + password + '\'' +
	                '}';
	}
    
}
