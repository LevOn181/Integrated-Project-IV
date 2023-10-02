package eapli.base.infrastructure.bootstrapers;

import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.Role;

import java.util.HashSet;
import java.util.Set;

public class StudentsBootstrapper extends UsersBootstrapperBase implements Action  {

    @Override
    public boolean execute() {
        registerStudent("bea", "Password1", "Bea", "Silva", "beasilva@gmail.com");
        return true;
    }


    private void registerStudent(final String username, final String password,
                                 final String shortName, final String fullName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.STUDENT);

        registerUser(username, password, shortName, fullName, email, roles);

    }
}
