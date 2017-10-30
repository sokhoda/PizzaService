package web.app.controllers;

import domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pizzaservice.CustomerService;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private static final String CUSTOMER_PAGE = "customer/customeredit";
    private static final String REDIRECT_CUSTOMER_LIST_PAGE = "redirect:../customer/list";
    private static final String UTILS_UPLOAD_CUSTOMER_LIST = "utils/upload/customerListUpload";
    private static final String INVALID_FIELD = "Invalid %s (%s)";
    @Autowired
    private CustomerService customerService;

    @Inject
    private Validator customerValidator;

    @RequestMapping("/create")
//    @Secured("ROLE_ADMIN")
//    @Secured("hasRole('ADMIN')")
    public String create() {
        return CUSTOMER_PAGE;
    }


    @RequestMapping("/edit")
    public String edit(@RequestParam Long customerId, Model model) {
        return CUSTOMER_PAGE;
    }

    @RequestMapping(value = "/addnew", method = RequestMethod.POST)
    public String addnew(@ModelAttribute @Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return CUSTOMER_PAGE;
        }
        customerService.save(customer);
        return REDIRECT_CUSTOMER_LIST_PAGE;
    }


    @RequestMapping(value = "/customerlist/upload", method = RequestMethod.POST)
    public String uploadFiles(@RequestParam("nname") String name,
                              @RequestParam("ffile") MultipartFile file,
                              Model model) {

        model.addAttribute("resultMessage", customerService.uploadFile(file));
        return UTILS_UPLOAD_CUSTOMER_LIST;
    }

    @RequestMapping("/customerlist/upload")
    public String showMultipart() {
        return UTILS_UPLOAD_CUSTOMER_LIST;
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(@ModelAttribute Customer customer) {
        customerService.remove(customer);
        return REDIRECT_CUSTOMER_LIST_PAGE;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    @Secured("IS_AUTHENTICATED_FULLY")
    public String getAllCustomers(HttpSession session,
                                  HttpServletRequest req,
                                  HttpEntity<byte[]> httpEntity) {
        session.setAttribute("ed", new Customer());
        req.getHeader("er");
        byte[] body = httpEntity.getBody();
        return "customer/customerlist";
    }

    //    @PostFilter("filterObject.type != T (domain.CustomerType).MEAT")
//    @PostFilter("filterObject.customerId > 5")
    @ModelAttribute("customerlist")
    public List<Customer> getCustomers() {
        return customerService.findAll();
    }


}
