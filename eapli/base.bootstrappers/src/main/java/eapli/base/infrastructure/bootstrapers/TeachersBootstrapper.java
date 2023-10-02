package eapli.base.infrastructure.bootstrapers;

import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.Role;

import java.util.HashSet;
import java.util.Set;

public class TeachersBootstrapper extends UsersBootstrapperBase implements Action {
    @Override
    public boolean execute() {
        registerTeacher("jorge", "Password1", "Jorge", "Armindo", "jorgearmindo@gmail.com");
        return true;
    }


    private void registerTeacher(final String username, final String password,
                                 final String shortName, final String fullName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.TEACHER);

        registerUser(username, password, shortName, fullName, email, roles);
    }
}
