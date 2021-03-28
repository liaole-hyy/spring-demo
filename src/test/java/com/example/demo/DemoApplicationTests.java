package com.example.demo;

import com.example.demo.service.ServiceMapper;
import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;
import javafx.beans.binding.When;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;
//(classes = {DemoApplication.class})
@SpringBootTest(classes = {DemoApplication.class})
@AutoConfigureMockMvc
class DemoApplicationTests {

   /* @Test
    void contextLoads() {
    }
*/
   @Autowired
   private UserService userService;

   
   @MockBean
   private ServiceMapper serviceMapper;

   @Autowired
   private MockMvc mvc ;

   private MockHttpSession session;

   @BeforeEach
   public void setupMockMvc(){
        session = new MockHttpSession();
       //MockitoAnnotations.initMocks(this);
       System.out.println(this.serviceMapper);

   }

   @Test
   public void testHello() throws  Exception{
       MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/hello").
               accept(MediaType.ALL).session(session).param("name","liaole")
       ).andExpect(MockMvcResultMatchers.status().isOk())
               .andDo(MockMvcResultHandlers.print()).andReturn();

       int status= mvcResult.getResponse().getStatus();
       String context = mvcResult.getResponse().getContentAsString();

       System.out.println(context);

   }

   @Test
   public void testService(){
      Mockito.when(serviceMapper.query()).thenReturn("liaole");
      String name = userService.query();

      System.out.println("unit-------"+name);
   }
}
