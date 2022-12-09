package com.generic.parcel.deliverycost.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author anilg
 *
 */
@ConfigurationProperties(prefix="mynt.iat.voucher")
@Configuration
public class VoucherCodeConfig {
	
	private String requestUrl;
	private String apikey;
	private Double weightReject;
	private Double heavyParcel;
	private Double smallParcel;
	private Double mediumParcel;

	
	/**
	 * @return the requestUrl
	 */
	public String getRequestUrl() {
		return requestUrl;
	}
	/**
	 * @param requestUrl the requestUrl to set
	 */
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	/**
	 * @return the apikey
	 */
	public String getApikey() {
		return apikey;
	}
	/**
	 * @param apikey the apikey to set
	 */
	public void setApikey(String apikey) {
		this.apikey = apikey;
	}
	/**
	 * @return the weightReject
	 */
	public Double getWeightReject() {
		return weightReject;
	}
	/**
	 * @param weightReject the weightReject to set
	 */
	public void setWeightReject(Double weightReject) {
		this.weightReject = weightReject;
	}
	/**
	 * @return the heavyParcel
	 */
	public Double getHeavyParcel() {
		return heavyParcel;
	}
	/**
	 * @param heavyParcel the heavyParcel to set
	 */
	public void setHeavyParcel(Double heavyParcel) {
		this.heavyParcel = heavyParcel;
	}
	/**
	 * @return the smallParcel
	 */
	public Double getSmallParcel() {
		return smallParcel;
	}
	/**
	 * @param smallParcel the smallParcel to set
	 */
	public void setSmallParcel(Double smallParcel) {
		this.smallParcel = smallParcel;
	}
	/**
	 * @return the mediumParcel
	 */
	public Double getMediumParcel() {
		return mediumParcel;
	}
	/**
	 * @param mediumParcel the mediumParcel to set
	 */
	public void setMediumParcel(Double mediumParcel) {
		this.mediumParcel = mediumParcel;
	}
}
