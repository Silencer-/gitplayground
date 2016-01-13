package de.fleischer.playground.git;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

/**
 * Created by fleischer on 12.01.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({"service.port=0"})
public class HelloControllerITTest {
    @Value("${local.server.port}")
    private int port;

    private URL base;
    private RestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
        base = new URL("http://localhost:" + port + "/");
        restTemplate = new RestTemplate();
    }

    @Test
    public void testGetGreeting() throws Exception {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(base.toString(), String.class);
        Assert.assertThat(responseEntity.getBody(), Matchers.equalTo("Greetings from Spring Boot!"));

    }
}
