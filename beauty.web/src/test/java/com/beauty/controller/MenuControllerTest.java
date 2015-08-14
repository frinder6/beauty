package com.beauty.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Log4jConfigurer;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring-conf/applicationContext-junit.xml" })
public class MenuControllerTest {
	

	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	static {
		try {
			Log4jConfigurer.initLogging("file:src/main/webapp/WEB-INF/props/log4j.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Before
	public void init() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	//@Test
	public void testLoadLevelMenu() {
		fail("Not yet implemented");
	}

	//@Test
	public void testLoadMenu() {
		fail("Not yet implemented");
	}

	//@Test
	public void testQueryPage() {
		try {
			// String url = "/menu/load/page.action";
			String url = "/table/load/table/config.action";
			mockMvc.perform(post(url)).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQuery(){
		try {
			String url = "/table/load/table/config.action";
			mockMvc.perform(post(url).param("tableName", "TB_TABLE_CONFIG")).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
