package hid.entity.groovy

import java.security.acl.Group;

import org.hibernate.validator.constraints.NotEmpty
import org.hibernate.validator.constraints.Length

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.Table
import javax.persistence.Transient

import static javax.persistence.GenerationType.IDENTITY

import hid.validation.AddAdminFormValidationGroup
import hid.validation.LoginFormValidationGroup
import hid.validation.annotation.FieldMatch

@Entity
@Table(name = "ADMIN")
@FieldMatch(first = "password", second = "confirmPassword", groups = [AddAdminFormValidationGroup.class])
class Admin {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_ADMIN", nullable = false)
	long id
	
	@NotEmpty(groups = [AddAdminFormValidationGroup.class, LoginFormValidationGroup.class])
	@Length(min = 4, max = 16, groups = [AddAdminFormValidationGroup.class, LoginFormValidationGroup.class])
	@Column(name = "LOGIN", length = 32, nullable = false)
	String login
	
	@NotEmpty(groups = [AddAdminFormValidationGroup.class, LoginFormValidationGroup.class])
	@Length(min = 4, max = 16, groups = [AddAdminFormValidationGroup.class, LoginFormValidationGroup.class])
	@Transient
	String password
	
	@Column(name = "PASSWORD", length = 32, nullable = false)
	String hashPassword
	
	@NotEmpty(groups = [AddAdminFormValidationGroup.class])
	@Transient
	String confirmPassword
	
	@Column(name = "SALT", nullable = false)
	String salt
}