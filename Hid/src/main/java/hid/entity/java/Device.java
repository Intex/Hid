package hid.entity.java;

import java.util.Set;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "DEVICES")
public class Device {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_DEVICE", nullable = false)
	private long id;

	@NotNull
	@Column(name = "VENDOR_ID", nullable = false)
	private int vendorId;

	@NotNull
	@Column(name = "PRODUCT_ID", nullable = false)
	private int productId;

	@Fetch(FetchMode.SELECT)
	@OneToMany(orphanRemoval = true, mappedBy = "device", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Connection> connections;

	@Fetch(FetchMode.SELECT)
	@OneToMany(orphanRemoval = true, mappedBy = "device", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<RegDevice> regDevices;

	public Set<RegDevice> getRegDevices() {
		return regDevices;
	}

	public void setRegDevices(Set<RegDevice> regDevices) {
		this.regDevices = regDevices;
	}

	public Set<Connection> getConnections() {
		return connections;
	}

	public void setConnections(Set<Connection> connections) {
		this.connections = connections;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
}
