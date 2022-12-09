package com.generic.parcel.deliverycost.bean;

/**
 * 
 * @author anilg
 *
 */
public class ResponseVoucherEntity {

	private String code;
	private Double discount;
	private String expiry;
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the discount
	 */
	public Double getDiscount() {
		return discount;
	}
	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	/**
	 * @return the expiry
	 */
	public String getExpiry() {
		return expiry;
	}
	/**
	 * @param expiry the expiry to set
	 */
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
}
