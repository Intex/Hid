package hid.entity.java;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "PERSONS")
public class Person {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", nullable = false)
	private long id;

	@NotEmpty
	@Column(name = "FIRST_NAME", length = 32, nullable = false)
	private String firstName;	
	
	@NotEmpty
	@Column(name = "LAST_NAME", length = 32, nullable = false)
	private String lastName;
	
	public Person() {}	

	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
