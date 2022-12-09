package com.generic.parcel.deliverycost.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.generic.parcel.deliverycost.bean.ParcelProduct;
import com.generic.parcel.deliverycost.bean.ResponseDeliveryCost;
import com.generic.parcel.deliverycost.service.DeliveryCostService;

/**
 * 
 * @author anilg
 *
 */
@RestController
public class DeliveryCostController {
	
	@Autowired
	private DeliveryCostService deliveryCostService;
	
	/**
	 * 
	 * @param item
	 * @param voucherCode
	 * @return
	 */
	@PostMapping("/getparceldeliverycost")
	public ResponseDeliveryCost getParcelDeliverycost(@RequestBody ParcelProduct parcelProduct,@RequestParam("voucherCode") String voucherCode) {
		return  deliveryCostService.getParcelDeliverycost(parcelProduct,voucherCode);
	}
}
