package go.tripservice.server.web.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: bobmouse
 * Date: 01.02.12
 * Time: 17:04
 * Test controller
 */
public class TestController extends MultiActionController{

    public ModelAndView test(HttpServletRequest request, HttpServletResponse response){
        ModelAndView resultView = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        view.setObjectMapper(new ObjectMapper());
        view.addStaticAttribute("woowoowoo", "hoo");
        resultView.setView(view);
        return resultView; 
    }

}
