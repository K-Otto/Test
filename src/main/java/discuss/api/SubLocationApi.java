package discuss.api;

import discuss.Services.SubLocationService;
import discuss.domain.SubLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by student on 2015/09/26.
 */
public class SubLocationApi {
    @Autowired
    private SubLocationService service;
    @RequestMapping(value = "/addBeekeeper", method = RequestMethod.GET)
    public String SaveLocation(HttpServletRequest request){
        String subLocationName =request.getParameter("subLocationName");
        String locationName = request.getParameter("locationName");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");




        return service.saveSubLocation(subLocationName, locationName, firstname, lastname, email);
    }
    @RequestMapping(value="/getEmployeeDetails", method= RequestMethod.GET)
    public SubLocation getSubLocationDetails(HttpServletRequest request) {
        String subLocationID = request.getParameter("subLocationID");
        Long id = Long.parseLong(subLocationID);
        return service.getSubLocation(id);
    }
}