package discuss.api;

import discuss.Services.HarvestService;
import discuss.domain.Harvest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by student on 2015/09/26.
 */
public class HarvestApi {
    @Autowired
    private HarvestService service;
    @RequestMapping(value = "/addBeekeeper", method = RequestMethod.GET)
    public String SaveHarvest(HttpServletRequest request){
        String harvestDate =request.getParameter("harvestDate");
        String weightString =request.getParameter("weight");
        double weight = Double.parseDouble(weightString);
        String subLocationName =request.getParameter("subLocationName");
        String locationName = request.getParameter("locationName");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");




        return service.saveHarvest(harvestDate,weight,subLocationName, locationName, firstname, lastname, email);
    }
    @RequestMapping(value="/getEmployeeDetails", method= RequestMethod.GET)
    public Harvest getHarvestDetails(HttpServletRequest request) {
        String HarvestID = request.getParameter("HarvestID");
        Long id = Long.parseLong(HarvestID);
        return service.getHarvest(id);
    }
}