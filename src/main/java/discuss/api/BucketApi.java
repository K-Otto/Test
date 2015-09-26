package discuss.api;

import discuss.Services.BucketService;
import discuss.domain.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by student on 2015/09/26.
 */
public class BucketApi {
    @Autowired
    private BucketService service;
    @RequestMapping(value = "/addBeekeeper", method = RequestMethod.GET)
    public String SaveBucket(HttpServletRequest request){
        String bucWeightString =request.getParameter("bucWeight");
        double bucWeight = Double.parseDouble(bucWeightString);
        String harvestDate =request.getParameter("harvestDate");
        String harWeightString =request.getParameter("harWeight");
        double harWeight = Double.parseDouble(harWeightString);
        String subLocationName =request.getParameter("subLocationName");
        String locationName = request.getParameter("locationName");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");




        return service.saveBucket(bucWeight, harvestDate, harWeight, subLocationName, locationName, firstname, lastname, email);
    }
    @RequestMapping(value="/getEmployeeDetails", method= RequestMethod.GET)
    public Bucket getBucketDetails(HttpServletRequest request) {
        String BucketID = request.getParameter("BucketID");
        Long id = Long.parseLong(BucketID);
        return service.getBucket(id);
    }
}
