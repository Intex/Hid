package com.intexsoft.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "DEVICES")
public class Device {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID_DEVICE", nullable = false)
	private long id;

	@NotEmpty
	@Column(name = "VENDOR_ID", nullable = false)
	private int vendorId;
	
	@NotEmpty
	@Column(name = "PRODUCT_ID", nullable = false)
	private int productId;

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
