package discuss.conf.factories;

import discuss.domain.Role;

/**
 * Created by [PUT NAME AND STUDENT NUMBER HERE ] on 2015/06/03.
 *
 */
public class RoleFactory {
    public static Role create(String name, String description){
        Role role = new Role.Builder(name)
                .description(description)
                .build();
        return role;
    }
}
