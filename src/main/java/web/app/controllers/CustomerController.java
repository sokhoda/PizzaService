package web.app.controllers;

import domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pizzaservice.CustomerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    public CustomerService customerService;

    @RequestMapping("/create")
//    @Secured("ROLE_ADMIN")
//    @Secured("hasRole('ADMIN')")
    public String create() {
        return "customer/customeredit";
    }

//    @RequestMapping("/edit")
//    public String edit(@RequestParam Long pizzaID, Model model){
//        model.addAttribute("pizza", customerService.find(pizzaID));
//        return "pizzaedit";
//    }

    @RequestMapping("/edit")
    public String edit(@RequestParam Long customerId) {
        return "customer/customeredit";
    }

    @RequestMapping(value = "/addnew", method = RequestMethod.POST)
    public String addnew(@ModelAttribute Customer customer) {
        System.out.println(customer);
        customerService.save(customer);
        return "redirect:../customer/list";
    }


    @RequestMapping(value = "/customerlist/upload", method = RequestMethod.POST)
    public String uploadFiles(@RequestParam("nname") String name,
                              @RequestParam("ffile") MultipartFile file,
                              Model model) {

        model.addAttribute("resultMessage", customerService.uploadFile(file));
        return "utils/upload/customerListUpload";
    }

    @RequestMapping("/customerlist/upload")
    public String showMultipart() {
        return "utils/upload/customerListUpload";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(@ModelAttribute Customer customer) {
        customerService.remove(customer);
        return "redirect:../customer/list";
    }


//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    @Secured("IS_AUTHENTICATED_FULLY")
//    public ModelAndView getAllPizzas(ModelAndView modelAndView){
//        List<Pizza> pizzaList = customerService.findAll();
//        modelAndView.setViewName("pizzalist");
//        modelAndView.addObject("pizzalist", pizzaList);
//        return modelAndView;
//    }

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
