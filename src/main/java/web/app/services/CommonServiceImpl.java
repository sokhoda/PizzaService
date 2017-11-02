package web.app.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class CommonServiceImpl implements CommonService{
    private static final String TITLE = "title";
    private static final String MESSAGE = "message";
    private static final String USER_NAME = "userName";
    private static final String USER_ROLES = "userRoles";
    private static final String DASHBOARD = "dashboard";

    @Override
    public ModelAndView populateModelAndView(Principal principal, ModelAndView model) {
        model.addObject(TITLE, "SECURE AREA");
        model.addObject(MESSAGE, "Only Authorised Users Can See This Page");
        model.addObject(USER_NAME, getUserName(principal));
        model.addObject(USER_ROLES, getUserRoles(principal));
        model.setViewName(DASHBOARD);
        return model;
    }

    private String getUserName(Principal principal) {
        if (principal == null) {
            return "anonymous";
        } else {

            final UserDetails currentUser = (UserDetails) ((Authentication) principal).getPrincipal();
            Collection<? extends GrantedAuthority> authorities = currentUser.getAuthorities();
            for (GrantedAuthority grantedAuthority : authorities) {
                System.out.println(grantedAuthority.getAuthority());
            }
            return principal.getName();
        }
    }

    private Collection<String> getUserRoles(Principal principal) {
        if (principal == null) {
            return Arrays.asList("none");
        } else {

            Set<String> roles = new HashSet<String>();

            final UserDetails currentUser = (UserDetails) ((Authentication) principal).getPrincipal();
            Collection<? extends GrantedAuthority> authorities = currentUser.getAuthorities();
            for (GrantedAuthority grantedAuthority : authorities) {
                roles.add(grantedAuthority.getAuthority());
            }
            return roles;
        }
    }
}