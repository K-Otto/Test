package discuss.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hashcode on 2015/06/02.
 */
@RestController
@RequestMapping("/**")
public class HomePage {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String Index(){
        return "Welcome to the Home Page of The Discuss Comment System";
    }
}