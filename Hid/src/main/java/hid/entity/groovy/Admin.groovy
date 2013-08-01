package hid.entity.groovy

import org.hibernate.validator.constraints.NotEmpty
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import static javax.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "ADMIN")
class Admin {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_ADMIN", nullable = false)
	long id
	
	@NotEmpty
	@Column(name = "LOGIN", length = 32, nullable = false)
	String login
	
	@NotEmpty
	@Column(name = "PASSWORD", length = 32, nullable = false)
	String password
	
	@NotEmpty
	@Column(name = "SALT", nullable = false)
	int salt
	
	Admin(){}

}
