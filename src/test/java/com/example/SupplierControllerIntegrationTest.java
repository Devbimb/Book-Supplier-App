package com.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.example.model.Supplier;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class SupplierControllerIntegrationTest {

	@Autowired
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper;

	private final Supplier TEST_SUPPLIER = new Supplier(null, "funbim", "pas1s234", "akanji@gmail.com","Oxford",
	         "Uganda", 123456, 0, null);

	private final Supplier TEST_SAVED_SUPPLIER = new Supplier(1L, "funbim", "pas1s234", "akanji@gmail.com","Oxford",
	         "Uganda", 123456, 0, null);

	@Test
	public void testCreate() throws JsonProcessingException, Exception {
		String resultString = this.mockMVC
				.perform(post("/Supplier/create").contentType(MediaType.APPLICATION_JSON)
						.content(this.mapper.writeValueAsString(TEST_SUPPLIER)))
				.andExpect(status().isCreated()).andReturn().getRequest().getContentAsString();

		Supplier result = this.mapper.readValue(resultString, Supplier.class);
		assertThat(result).isEqualTo(TEST_SUPPLIER);

	}

	@Test
	public void testReadOne() throws Exception {
		this.mockMVC.perform(get("/Supplier/read/1")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(TEST_SAVED_SUPPLIER)));

	}

	@Test
	public void testReadAll() throws Exception {
		final List<Supplier> PEOPLE = new ArrayList<>();
		PEOPLE.add(TEST_SAVED_SUPPLIER);

		final String resultString = this.mockMVC
				.perform(request(HttpMethod.GET, "/supplier/readAll").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		List<Supplier> results = Arrays.asList(mapper.readValue(resultString, Supplier[].class));
		assertThat(results).contains(this.TEST_SUPPLIER).hasSize(3);
	}

	@Test
	public void testUpdate() throws Exception {
		final Supplier newSupplier = new Supplier(null, "funbim", "pas1s234", "akanji@gmail.com","Oxford",
		         "Uganda", 123456, 0, null);
		String resultString = this.mockMVC
				.perform(put("/Supplier/update/3").contentType(MediaType.APPLICATION_JSON)
						.content(this.mapper.writeValueAsString(newSupplier)))
				.andExpect(status().isAccepted()).andReturn().getRequest().getContentAsString();

		Supplier result = this.mapper.readValue(resultString, Supplier.class);
		assertThat(result).isEqualTo(newSupplier);
	}

	@Test
	public void testDelete() throws Exception {
		this.mockMVC.perform(delete("/Supplier/delete/2")).andExpect(status().isNoContent());
	}

}
