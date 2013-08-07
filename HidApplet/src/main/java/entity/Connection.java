package entity;

import java.util.Date;

class Connection {

	
	private long id;
	private long deviceId;
	private Date date;
	private byte[] data;
	private String country;
	private String city;
	private int connectionTime;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getConnectionTime() {
		return connectionTime;
	}

	public void setConnectionTime(int connectionTime) {
		this.connectionTime = connectionTime;
	}
}