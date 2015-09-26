package discuss.api;

import discuss.Services.HiveService;
import discuss.domain.Hive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by student on 2015/09/26.
 */
public class HiveApi {
    @Autowired
    private HiveService service;
    @RequestMapping(value = "/addBeekeeper", method = RequestMethod.GET)
    public String SaveLocation(HttpServletRequest request){
        String hiveState =request.getParameter("hiveState");
        String subLocationName =request.getParameter("subLocationName");
        String locationName = request.getParameter("locationName");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");




        return service.saveHive(hiveState,subLocationName, locationName, firstname, lastname, email);
    }
    @RequestMapping(value="/getEmployeeDetails", method= RequestMethod.GET)
    public Hive getHiveDetails(HttpServletRequest request) {
        String hiveID = request.getParameter("hiveID");
        Long id = Long.parseLong(hiveID);
        return service.getHive(id);
    }
}
