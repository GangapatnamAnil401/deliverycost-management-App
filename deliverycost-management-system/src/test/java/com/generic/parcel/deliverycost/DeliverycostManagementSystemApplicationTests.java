package com.generic.parcel.deliverycost;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.generic.parcel.deliverycost.bean.ParcelProduct;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class DeliverycostManagementSystemApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void contextLoads() {
	}

	@Test
	void registrationWorksThroughAllLayers() throws Exception {
		ParcelProduct user = new ParcelProduct(9.0,10.0,10.0,10.0);
		String user1 = objectMapper.writeValueAsString(user);
		mockMvc.perform(post("/getparceldeliverycost").contentType(MediaType.APPLICATION_JSON)
				.content(user1).param("voucherCode", "MYNT")).andExpect(status().isOk());
	}
}
