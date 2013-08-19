package com.intexsoft.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "REG_DEVICES")
public class RegDevice {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_REG_DEVICE", nullable = false)
	private long id;
	
	@NotEmpty
	@Column(name = "ID_DEVICE", nullable = false)
	private long deviceId;
	
	@NotEmpty
	@Column(name = "REG_DATE", nullable = false)
	private Date registrationDate;
	
	@NotEmpty
	@Column(name = "END_LICENSE", nullable = false)
	private Date endLicenseDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
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
