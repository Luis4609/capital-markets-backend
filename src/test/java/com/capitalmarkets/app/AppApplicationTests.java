package com.capitalmarkets.app;

import com.capitalmarkets.app.core.controller.CurrencyRestController;
import com.capitalmarkets.app.data.daos.ICurrencyDao;
import com.capitalmarkets.app.data.entities.CurrencyModel;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AppApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void shouldPassIfStringMatches() throws Exception {
		assertThat(restTemplate.getForObject("http://localhost:" + port + "/currencies/list-string",
				String.class)).contains("Australian Dollar");
	}

}
