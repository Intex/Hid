package entity;

import java.util.Date;

class RegDevice {
	
	private long id;
	private long deviceId;
	private Date registrationDate;
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