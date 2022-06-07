package ar.com.redlink.domain;

import javax.validation.constraints.NotBlank;

public class Usuario {
	
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	private String mail;
	
	
	public Usuario(String n, String p) {
		this.username = n;
		this.password = p;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	

}
