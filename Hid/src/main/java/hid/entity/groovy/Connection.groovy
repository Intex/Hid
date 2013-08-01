package hid.entity.groovy

import org.hibernate.validator.constraints.NotEmpty

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import static javax.persistence.GenerationType.IDENTITY


@Entity
@Table(name = "CONNECTION")
class Connection {

	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_CONNECTION", nullable = false)
	long id
	
	@NotEmpty
	@Column(name = "ID_DEVICE", nullable = false)
	long id_device
	
	@NotEmpty
	@Column(name = "DATE", nullable = false)
	Date date
	
	@NotEmpty
	@Column(name = "DATA", nullable = false)
	byte[] data
	
	@NotEmpty
	@Column(name = "COUNTRY", length = 32, nullable = false)
	String country
	
	@NotEmpty
	@Column(name = "CITY", length = 32, nullable = false)
	String city
	
	@NotEmpty
	@Column(name = "TIME_CONNECTION", nullable = false)
	int time_connection
	
	Connection(){}
}
