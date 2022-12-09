package com.generic.parcel.deliverycost.service;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.generic.parcel.deliverycost.bean.ParcelProduct;
import com.generic.parcel.deliverycost.bean.ResponseDeliveryCost;
import com.generic.parcel.deliverycost.bean.ResponseVoucherEntity;
import com.generic.parcel.deliverycost.configuration.DeliveryCostConstants;
import com.generic.parcel.deliverycost.configuration.VoucherCodeConfig;

/**
 * 
 * @author anilg
 *
 */
@Service
public class DeliveryCostService {

	@Autowired
	private VoucherCodeConfig voucherconfig;

	/**
	 * 
	 * @param item
	 * @param voucherCode
	 * @return
	 */
	public ResponseDeliveryCost getParcelDeliverycost(ParcelProduct item,String voucherCode) {

		ResponseDeliveryCost responseDeliveryCost = new ResponseDeliveryCost();
		double discountCost = 0.0; 
		double volume = item.getHeight()*item.getLength()*item.getWidth();
		if(item.getWeight() > voucherconfig.getWeightReject()) {
			responseDeliveryCost.setErrorMsg(DeliveryCostConstants.EXCEED_WEIGHT);
			return responseDeliveryCost;
		}else if(item.getWeight() < voucherconfig.getWeightReject() && item.getWeight() > voucherconfig.getHeavyParcel()) {
			responseDeliveryCost.setDeliveryCost(20*item.getWeight());
		}else if(volume < voucherconfig.getSmallParcel()) {
			responseDeliveryCost.setDeliveryCost(0.03*volume);
		}else if(volume > voucherconfig.getSmallParcel() && volume < voucherconfig.getMediumParcel()) {
			responseDeliveryCost.setDeliveryCost(0.04*volume);
		}else if(volume > voucherconfig.getMediumParcel())
			responseDeliveryCost.setDeliveryCost(0.05*volume);

		if(StringUtils.isNotEmpty(voucherCode)) {
			ResponseEntity<ResponseVoucherEntity> entityResponse = new RestTemplate().getForEntity(voucherconfig.getRequestUrl(), ResponseVoucherEntity.class,voucherCode,"apikey");
			ResponseVoucherEntity voucherResponse = entityResponse.getBody();
			String expireDate =Optional.ofNullable(voucherResponse.getExpiry()).orElse("");
			if("".equals(expireDate)) {
				responseDeliveryCost.setErrorMsg(DeliveryCostConstants.INVALID_VOUCHERCODE);
			}
			else {
				/**
				 * Checking voucher code is expired or not
				 */
				LocalDate localDate = LocalDate.parse(expireDate,  DateTimeFormatter.ofPattern("yyyy-MM-d"));
				if(localDate.isAfter(LocalDate.now()))
					discountCost += voucherResponse.getDiscount();
				else
				     responseDeliveryCost.setErrorMsg(DeliveryCostConstants.EXPIRED_VOUCHERCODE);
				return responseDeliveryCost;

			}
		}

		responseDeliveryCost.setDeliveryCost(responseDeliveryCost.getDeliveryCost()-discountCost);
		return responseDeliveryCost;
	}
}


