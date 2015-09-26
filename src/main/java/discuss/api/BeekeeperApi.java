package discuss.api;

import discuss.Services.BeekeeperService;
import discuss.domain.Beekeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by student on 2015/09/26.
 */
@RestController
@RequestMapping("/api/**")
public class BeekeeperApi {
    @Autowired
    private BeekeeperService service;
    @RequestMapping(value = "/addBeekeeper", method = RequestMethod.GET)
    public String SaveBeekeeper(HttpServletRequest request){
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String email = request.getParameter("email");



        return service.saveBeekeeper(firstName, lastName, email);
    }
    @RequestMapping(value="/getEmployeeDetails", method= RequestMethod.GET)
    public Beekeeper getBeekeeperDetails(HttpServletRequest request) {
        String employeeID = request.getParameter("employeeID");
        Long id = Long.parseLong(employeeID);
        return service.getBeekeeper(id);
    }
}