package hid.entity.groovy

import org.hibernate.validator.constraints.NotEmpty
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import static javax.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "REG_DEVICES")
class RegDevice {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_REG_DEVICE", nullable = false)
	long id
	
	@NotEmpty
	@Column(name = "ID_DEVICE", nullable = false)
	long deviceId
	
	@NotEmpty
	@Column(name = "REG_DATE", nullable = false)
	Date registrationDate
	
	@NotEmpty
	@Column(name = "END_LICENSE", nullable = false)
	Date endLicenseDate
}
