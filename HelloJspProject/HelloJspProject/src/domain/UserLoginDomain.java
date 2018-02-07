package domain;

public class UserLoginDomain {
	private int UserLoginId;
	private String username;
	private String password;
	
	public int getUserLoginId() {
		return UserLoginId;
	}
	public void setUserLoginId(int userLoginId) {
		UserLoginId = userLoginId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
