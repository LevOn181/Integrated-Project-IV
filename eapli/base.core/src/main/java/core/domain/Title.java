package core.domain;

import core.domain.Application;
import eapli.framework.strings.util.StringPredicates;
import java.util.Objects;

public class Title {

    public final String title;
    public Title(String title){
        if(!validate(title))
            throw new IllegalArgumentException("Title is Invalid");
        this.title = title;
    }

    private boolean validate(String title){
        return StringPredicates.isNullOrWhiteSpace(title) && title.length() < Application.settings().getTitleMaxLength();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title1 = (Title) o;
        return this.title.equals(title1.title);
    }

    @Override
    public String toString() {
        return this.title;
    }
    @Override
    public int hashCode() {
        return Objects.hash(title);
    }


}

