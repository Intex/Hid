package hid.entity.java;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "CONNECTION")
public class Connection {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_CONNECTION", nullable = false)
	private long id;

	@ManyToOne
	@JoinColumn(name = "ID_DEVICE")
	private Device device;

	//@NotEmpty
	@Column(name = "DATE")//, nullable = false)
	private Date date;

	//@NotEmpty
	@Column(name = "DATA")//, nullable = false)
	private byte[] data;

	@NotEmpty
	@Column(name = "COUNTRY", length = 32, nullable = false)
	private String country;

	@NotEmpty
	@Column(name = "CITY", length = 32, nullable = false)
	private String city;

	@NotNull
	@Column(name = "CONNECTION_TIME", nullable = false)
	private int connectionTime;

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