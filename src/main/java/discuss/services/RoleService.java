package discuss.services;

import discuss.domain.Role;

/**
 * Created by [PUT NAME AND STUDENT NUMBER HERE ] on 2015/06/03.
 *
 */
public interface RoleService {
     String getRoleDescription(String role);
     Role findRoleById(Long id);
     void  saveRole(Role role);
     void cleanUp();
}
