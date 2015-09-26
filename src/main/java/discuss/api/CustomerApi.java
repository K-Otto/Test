package discuss.api;

import discuss.Services.CustomerService;
import discuss.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by student on 2015/09/26.
 */
public class CustomerApi {
    @Autowired
    private CustomerService service;
    @RequestMapping(value = "/addBeekeeper", method = RequestMethod.GET)
    public String SaveCustomer(HttpServletRequest request){
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");



        return service.saveCustomer(firstName, lastName, email);
    }
    @RequestMapping(value="/getEmployeeDetails", method= RequestMethod.GET)
    public Customer getCustomerDetails(HttpServletRequest request) {
        String customerID = request.getParameter("customerID");
        Long id = Long.parseLong(customerID);
        return service.getCustomer(id);
    }
}