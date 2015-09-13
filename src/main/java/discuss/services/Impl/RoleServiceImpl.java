package discuss.services.Impl;

import discuss.domain.Role;
import discuss.respository.RoleRepository;
import discuss.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by [PUT NAME AND STUDENT NUMBER HERE ] on 2015/06/03.
 *
 */
@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository repository;
    @Override
    public String getRoleDescription(String name) {
        String description="ROLE NOT FOULD";
        // GEt ALL THE ROLES
        Iterable<Role> roles = repository.findAll();
        // GO THROUGH EACH ROLE
        for (Role role : roles) {
            //DO A CHECK ON EACH ROLE
            if(name.equalsIgnoreCase(role.getName()))
                // IF FOUND CHANGE THE DESCRIPTION VALUE
                // TO WHAT WAS FOUND
                description=role.getDescription();
        }
        //RETURN THE DESCRIPTION
        return description;
    }

    @Override
    public Role findRoleById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void saveRole(Role role) {
        repository.save(role);

    }

    @Override
    public void cleanUp() {
        repository.deleteAll();
    }
}
