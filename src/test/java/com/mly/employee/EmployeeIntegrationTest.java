package com.mly.employee;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mly.employee.model.Employee;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = EmployeeApplication.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class EmployeeIntegrationTest {

	private static final String RESOURCE = "/employees";
	private static final ObjectMapper MAPPER = new ObjectMapper();

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testCreateEmployee() throws Exception {
		Employee employee = new Employee();
		String name = "Muhammed Taha";
		employee.setSalary(300);
		employee.setAge(23);
		employee.setFullName(name);
		mockMvc.perform(post(RESOURCE).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(MAPPER.writeValueAsString(employee))).andDo(print()).andExpect(status().isOk())
				.andDo(document("Employee"));
	}

	@Test
	public void testUpdateEmployee() throws Exception {
		Employee employee = new Employee();
		String name = "Muhammed Talha";
		employee.setSalary(300);
		employee.setAge(23);
		employee.setFullName(name);
		mockMvc.perform(put(RESOURCE + "/1").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(MAPPER.writeValueAsString(employee)))
				.andDo(print()).andExpect(status().isOk()).andDo(document("Employee"));
	}

	@Test
	public void testGetEmployees() throws Exception {
		mockMvc.perform(get(RESOURCE).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print()).andExpect(status().isOk()).andDo(document("Employee"));
	}

	@Test
	public void testDeleteEmployee() throws Exception {

		mockMvc.perform(delete(RESOURCE + "/1").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(print()).andExpect(status().isOk())
				.andDo(document("Employee"));
	}

}
