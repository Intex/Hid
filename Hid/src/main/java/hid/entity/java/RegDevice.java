package hid.entity.java;

import java.util.Date;

//import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "REG_DEVICES")
public class RegDevice {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_REG_DEVICE", nullable = false)
	private long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_DEVICE")
	private Device device;

	//@NotEmpty
	@Column(name = "REG_DATE")//, nullable = false)
	private Date registrationDate;

	//@NotEmpty
	@Column(name = "END_LICENSE")//, nullable = false)
	private Date endLicenseDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getEndLicenseDate() {
		return endLicenseDate;
	}

	public void setEndLicenseDate(Date endLicenseDate) {
		this.endLicenseDate = endLicenseDate;
	}
}