package go.tripservice.server.web.controller;

import go.tripservice.server.model.dao.TestDAO;
import go.tripservice.server.model.entity.TestEntity;
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
    private TestDAO testDAO;

    public ModelAndView test(HttpServletRequest request, HttpServletResponse response){
        ModelAndView resultView = new ModelAndView();
        MappingJacksonJsonView view = new MappingJacksonJsonView();
        view.setObjectMapper(new ObjectMapper());
        for(TestEntity entity : testDAO.loadAll()){
            view.addStaticAttribute("woowoowoo" + entity.getId(), "hoo" + entity.getId());
        }

        resultView.setView(view);
        return resultView; 
    }
    
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response){
        testDAO.save(new TestEntity());
        return new ModelAndView();
    }

    public void setTestDAO(TestDAO testDAO) {
        this.testDAO = testDAO;
    }

}
