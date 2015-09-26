package discuss.api;

import discuss.Services.SuperService;
import discuss.domain.Super;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by student on 2015/09/26.
 */
public class SuperApi {
    @Autowired
    private SuperService service;
    @RequestMapping(value = "/addBeekeeper", method = RequestMethod.GET)
    public String SaveLocation(HttpServletRequest request){
        String superState =request.getParameter("superState");
        String hiveState =request.getParameter("hiveState");
        String subLocationName =request.getParameter("subLocationName");
        String locationName = request.getParameter("locationName");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");




        return service.saveSuper(superState,hiveState, subLocationName, locationName, firstname, lastname, email);
    }
    @RequestMapping(value="/getEmployeeDetails", method= RequestMethod.GET)
    public Super getSuperDetails(HttpServletRequest request) {
        String superID = request.getParameter("superID");
        Long id = Long.parseLong(superID);
        return service.getSuper(id);
    }
}
