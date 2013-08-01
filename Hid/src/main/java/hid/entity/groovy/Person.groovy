package hid.entity.groovy;

import org.hibernate.validator.constraints.NotEmpty

class Person {
	@NotEmpty
	String firstName
	
	@NotEmpty
	String lastName
	
	Person() {}
	
	Person(String firstName, String lastName) {
		this.firstName = firstName
		this.lastName = lastName
	}
}
