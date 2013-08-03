package hid.entity.groovy

import org.hibernate.validator.constraints.NotEmpty
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import static javax.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "DEVICES")
class Device {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_DEVICE", nullable = false)
	long id

	@NotEmpty
	@Column(name = "VENDOR_ID", nullable = false)
	int vendorId
	
	@NotEmpty
	@Column(name = "PRODUCT_ID", nullable = false)
	int productId	
}
