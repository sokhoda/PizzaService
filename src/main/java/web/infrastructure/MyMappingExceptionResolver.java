package web.infrastructure;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyMappingExceptionResolver extends SimpleMappingExceptionResolver {

    public MyMappingExceptionResolver() {
        setWarnLogCategory(MyMappingExceptionResolver.class.getName());
    }

    @Override
    public String buildLogMessage(Exception e, HttpServletRequest req) {
        return "MVC exception: " + e.getLocalizedMessage();
    }

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = super.doResolveException(request, response, handler, ex);
        modelAndView.addObject("url", request.getRequestURL());

        return modelAndView;
    }
}
