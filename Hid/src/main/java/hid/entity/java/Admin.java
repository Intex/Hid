package hid.entity.java;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import static javax.persistence.GenerationType.IDENTITY;

import hid.validation.annotation.FieldMatch;

@Entity
@Table(name = "ADMIN")
@FieldMatch(first = "password", second = "confirmPassword")
class Admin {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_ADMIN", nullable = false)
	private long id;
	
	@NotEmpty
	@Length(min = 4, max = 16)
	@Column(name = "LOGIN", length = 32, nullable = false)
	private String login;
	
	@NotEmpty
	@Length(min = 4, max = 16)
	@Transient
	private String password;
	
	@Column(name = "PASSWORD", length = 32, nullable = false)
	private String hashPassword;
	
	@NotEmpty
	@Transient
	private String confirmPassword;
	
	@Column(name = "SALT", nullable = false)
	private String salt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHashPassword() {
		return hashPassword;
	}

	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
}