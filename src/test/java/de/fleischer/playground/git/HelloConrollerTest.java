package de.fleischer.playground.git;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by fleischer on 12.01.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class HelloConrollerTest {
    /**
     * MVC mock
     */
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        // Initialize mock
        mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void testGetGreeting() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                                                       .andExpect(MockMvcResultMatchers.status().isOk())
                                                       .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("Greetings from Spring Boot!")));
    }

    @Test
    public void testSecondTest() throws Exception {
        System.out.println("Second test...");
    }
}
