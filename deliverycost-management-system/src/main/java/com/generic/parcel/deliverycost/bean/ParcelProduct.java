package com.generic.parcel.deliverycost.bean;


/**
 * 
 * @author anilg
 *
 */
public class ParcelProduct {
	
	private Double weight;
	private Double height;
	private Double width;
	private Double length;
	
	/**
	 * @return the weight
	 */
	public Double getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	/**
	 * @return the height
	 */
	public Double getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(Double height) {
		this.height = height;
	}
	/**
	 * @return the width
	 */
	public Double getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(Double width) {
		this.width = width;
	}
	/**
	 * @return the length
	 */
	public Double getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(Double length) {
		this.length = length;
	}
	public ParcelProduct(Double weight, Double height, Double width, Double length) {
		super();
		this.weight = weight;
		this.height = height;
		this.width = width;
		this.length = length;
	}
	
	
}
