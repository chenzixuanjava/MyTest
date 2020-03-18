package com.segi.springMvc;

import com.google.common.collect.Lists;
import com.segi.springmvc.controller.HomeController;
import com.segi.springmvc.controller.SpitterController;
import com.segi.springmvc.controller.SpittleController;
import com.segi.springmvc.model.Spitter;
import com.segi.springmvc.model.Spittle;
import com.segi.springmvc.service.SpitterReposoty;
import com.segi.springmvc.service.SpittleReposoty;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.Date;
import java.util.List;

/**
 * @author chenzx
 * @date 2018-10-09 下午 2:07
 */
public class SpringMvcTest {

    private List<Spittle> expectedSpittles = createSpittles(20);

    private List<Spittle> createSpittles(int count) {
        List<Spittle> spittles = Lists.newArrayList();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle" + i, new Date()));
        }
        return spittles;
    }

    @Test
    public void homeControllerTest() throws Exception {
        //MockMvc是servlet3.0以后才引入的，所以pom中的maven包版本不能低于此版本
        //当请求路径和视图名相同时会控制器无法区分，会发生错误。因此显示的用setSingleView方法来指定视图名
        //如果没有返回视图名(void)，将会将请求路径去掉"/"作为视图名
        //如果返回其它对象，将会将此对象放入model里，key由对象类型推断得出。
        HomeController homeController = new HomeController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(homeController)
                .setSingleView(new InternalResourceView("/WEB-INF/views/home.jsp"))
                .build();
        mockMvc.perform(MockMvcRequestBuilders.get("/home"))
                .andExpect(MockMvcResultMatchers.view().name("home"));
    }

    @Test
    public void shouldShowRecentSpittles() throws Exception {
        Spittle expectedSpittle = new Spittle("hello", new Date());
        SpittleReposoty mock = Mockito.mock(SpittleReposoty.class);
        Mockito.when(mock.findOne(123456L))
                .thenReturn(expectedSpittle);
        SpittleController spittleController = new SpittleController(mock);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(spittleController)
                .setSingleView(new InternalResourceView("spittles"))
                .build();
        mockMvc.perform(MockMvcRequestBuilders.get("/spittles/123456"))
                .andExpect(MockMvcResultMatchers.view().name("spittles"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("spittle"))
                .andExpect(MockMvcResultMatchers.model().attribute("spittle", expectedSpittle));

    }

    @Test
    public void processRegistration() throws Exception {
        Spitter unSaved = new Spitter("chenzixuan", "123");
        Spitter saved = new Spitter(1L, "chenzixuan", "123", null);
        SpitterReposoty mock = Mockito.mock(SpitterReposoty.class);
        Mockito.when(mock.save(unSaved))
                .thenReturn(saved);
        SpitterController spitterController = new SpitterController(mock);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(spitterController)
                .build();
        mockMvc.perform(MockMvcRequestBuilders.post("/spitter/register")
                .param("username", "chenzixuan")
                .param("password", "123"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/spitter/chenzixuan"));
        Mockito.verify(mock, Mockito.atLeastOnce()).save(unSaved);
    }

}
