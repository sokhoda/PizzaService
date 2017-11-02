package web.app.services;

import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

public interface CommonService {
    ModelAndView populateModelAndView(Principal principal, org.springframework.web.servlet.ModelAndView model);
}