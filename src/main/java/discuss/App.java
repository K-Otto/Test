package discuss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by [PUT NAME AND STUDENT NUMBER HERE ] on 2015/06/03.
 *
 */
@Configuration
@ComponentScan
@EnableWebMvc
@EnableAutoConfiguration
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "The Discuss Comments Systems Has STARTED" );
        SpringApplication.run(App.class, args);
    }
}