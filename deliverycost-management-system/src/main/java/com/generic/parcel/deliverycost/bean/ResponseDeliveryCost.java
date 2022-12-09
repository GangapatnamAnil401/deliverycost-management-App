package com.generic.parcel.deliverycost.bean;

/**
 * 
 * @author anilg
 *
 */
public class ResponseDeliveryCost {
	
	private String errorMsg;
	private Double deliveryCost;
	
	/**
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}
	/**
	 * @param errorMsg the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	/**
	 * @return the deliveryCost
	 */
	public Double getDeliveryCost() {
		return deliveryCost;
	}
	/**
	 * @param deliveryCost the deliveryCost to set
	 */
	public void setDeliveryCost(Double deliveryCost) {
		this.deliveryCost = deliveryCost;
	}
}
