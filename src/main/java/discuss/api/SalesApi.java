package discuss.api;

import discuss.Services.SaleService;
import discuss.domain.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by student on 2015/09/26.
 */
public class SalesApi {
    @Autowired
    private SaleService service;
    @RequestMapping(value = "/addBeekeeper", method = RequestMethod.GET)
    public String SaveSales(HttpServletRequest request){
        String salesDate =request.getParameter("salesDate");
        String priceString =request.getParameter("price");
        double price = Double.parseDouble(priceString);
        String bucWeightString =request.getParameter("bucWeight");
        double bucWeight = Double.parseDouble(bucWeightString);
        String harvestDate =request.getParameter("harvestDate");
        String harWeightString =request.getParameter("harWeight");
        double harWeight = Double.parseDouble(harWeightString);
        String subLocationName =request.getParameter("subLocationName");
        String locationName = request.getParameter("locationName");
        String bFirstname = request.getParameter("bFirstname");
        String bLastname = request.getParameter("bLastname");
        String bEmail = request.getParameter("bEmail");
        String cFirstname = request.getParameter("cFirstname");
        String cLastname = request.getParameter("cLastname");
        String cEmail = request.getParameter("cEmail");




        return service.saveSales(salesDate,price,bucWeight, harvestDate, harWeight, subLocationName, locationName, bFirstname, bLastname, bEmail,cFirstname,cLastname,cEmail);
    }
    @RequestMapping(value="/getEmployeeDetails", method= RequestMethod.GET)
    public Sales getBucketDetails(HttpServletRequest request) {
        String SalesID = request.getParameter("SalesID");
        Long id = Long.parseLong(SalesID);
        return service.getSales(id);
    }
}