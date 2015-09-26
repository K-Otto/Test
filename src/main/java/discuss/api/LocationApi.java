package discuss.api;

import discuss.Services.LocationService;
import discuss.domain.Beekeeper;
import discuss.domain.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by student on 2015/09/26.
 */
public class LocationApi {
    @Autowired
    private LocationService service;
    @RequestMapping(value = "/addBeekeeper", method = RequestMethod.GET)
    public String SaveLocation(HttpServletRequest request){
        String locationName = request.getParameter("locationName");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");




        return service.saveLocation(locationName, firstname, lastname, email);
    }
    @RequestMapping(value="/getEmployeeDetails", method= RequestMethod.GET)
    public Location getLocationDetails(HttpServletRequest request) {
        String locationID = request.getParameter("locationID");
        Long id = Long.parseLong(locationID);
        return service.getLocation(id);
    }
}