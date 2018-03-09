package cn.com.emp.common.exception;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by home on 2017/11/1.
 */
@Component("exceptionHandler")

public class CustomExceptionResolver implements HandlerExceptionResolver, ApplicationContextAware {
    private org.apache.log4j.Logger errorlogger= org.apache.log4j.Logger.getLogger("Error");
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this .applicationContext=applicationContext;
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView  modelAndView=new ModelAndView();
        try {
            modelAndView.setViewName("/error");
            errorlogger.error(e.getMessage(),e);

        }catch(Exception e1) {
        }finally {
            return modelAndView;
        }
    }





}
