package com.springboot.thymeprj;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.springboot.thymeprj.model.Student;
import com.springboot.thymeprj.repository.StudentRepository;
import com.springboot.thymeprj.service.StudentService;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ThymeprjApplicationTests {
	
	 @Autowired
	    private MockMvc mockMvc;
	 
	 @MockBean
	 	private StudentService studentService;
	 @MockBean
	 	private StudentRepository studentRepository; 

	@Test
	public void findAll() throws Exception {
		Student student= new Student();
		student.setId(1);
		student.setFirstName("Sonam");
		student.setLastName("Gadekari");
		student.setEmail("sonam.gadekari@gmail.com");
		List<Student> students = Arrays.asList(student);
        given(studentService.findAll()).willReturn(students);
        this.mockMvc.perform(get("/students/list"))
        .andExpect(status().isOk());
        //.andExpect(content().json("[{'id': 1,'name': 'Stock 1';'price': 1}]"));
	}
	
	@Test
	public void whenFindByName_thenReturnStudent() {
	    // given
	    Student sonam = new Student();	
	    sonam.setId(1);
		sonam.setFirstName("Sonam");
		sonam.setLastName("Gadekari");
		sonam.setEmail("sonam.gadekari@gmail.com");
	    // when
	    Student found = studentRepository.findByFirstName("Sonam");	 
	    // then
	    assertEquals(found.getFirstName(), sonam.getFirstName());
	    //as3sertThat()
//	      .isEqualTo();
	}

}
