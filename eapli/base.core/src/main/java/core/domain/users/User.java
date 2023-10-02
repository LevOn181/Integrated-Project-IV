package core.domain.users;

import core.domain.AppDate;
import eapli.framework.validations.Preconditions;

import java.util.Calendar;
import java.util.Objects;

public class User {

    private UserName name;
    private Password pwd;
    private EmailAddress email;
    private AppDate birthdate;
    private Calendar createdOn;
    private Calendar deactivatedOn;

    private boolean active;

    protected User(){
    }

    public User(final UserName name, final Password pwd, final EmailAddress email, final Calendar createdOn, final AppDate birthdate){
        Preconditions.noneNull(name, pwd, email, createdOn, birthdate);
        this.name = name;
        this.pwd = pwd;
        this.email = email;
        this.createdOn = createdOn;
        this.birthdate = birthdate;
        active = true;
    }

    public User(final UserName name, final EmailAddress email, final Calendar createdOn, final AppDate birthdate){
        Preconditions.noneNull(name, email, createdOn);
        this.name = name;
        try {
            this.pwd = new Password();
        }catch (RuntimeException e){
            throw new RuntimeException("Error! Password was not generated!");
        }
        this.email = email;
        this.createdOn = createdOn;
        this.birthdate = birthdate;
        active = true;
    }

    public String shortName() { return this.name.shortName(); }

    public String fullName(){
        return this.name.fullName();
    }

    public EmailAddress email() {
        return this.email;
    }

    public AppDate birthdate(){ return this.birthdate; }

    public boolean isActive() {
        return this.active;
    }

    public Calendar createdOn() {
        return (Calendar)this.createdOn.clone();
    }

    protected byte[] encodedPassword() {
        return this.pwd.value();
    }

    public void changePassword(final Password newPassword) {
        this.pwd = newPassword;
    }


    public void deactivate(final Calendar deactivatedOn) {
        if (deactivatedOn != null && !deactivatedOn.before(this.createdOn)) {
            if (!this.active) {
                throw new IllegalStateException("Cannot deactivate an inactive user");
            } else {
                this.active = false;
                this.deactivatedOn = deactivatedOn;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return this.email.equals(user.email());
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    // missing requirements described in g002.md


}


