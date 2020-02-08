package com.altimetrik.interview;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class InterviewApplicationTests {

	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("http://localhost:8080/myrestservce/JH4TB2H26CC000000"))
					.andExpect(status().isOk());
				    //.andExpect(content().string(containsString("Hello, World")));
	}
	
	@Test
	public void shouldReturnBadRequestMessage() throws Exception {
		this.mockMvc.perform(get("http://localhost:8080/myrestservce/JH4TB2H26CC0000"))
					.andExpect(status().isBadRequest())
				    .andExpect(content().string(containsString("Invalid Vehicle Identification number")));
	}
}
