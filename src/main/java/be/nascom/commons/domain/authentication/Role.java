package be.nascom.commons.domain.authentication;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * User: bart
 * Date: May 11, 2009
 * Time: 12:06:47 PM
 */
@Entity
public class Role implements Comparable<Role>, Serializable {
    @Id
    @SuppressWarnings({"UnusedDeclaration"})
    private long id;

    private String name;

    public Role() {
        super();
    }

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Role role) {
        if (role == null) return 1;
        if (getId() == role.getId()) return 0;
        return (getId() > role.getId()) ? 1 : -1;        
    }

    @Override
    public int hashCode() {
        return Long.valueOf(id).intValue();
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Role && compareTo((Role) object) == 0;
    }
}
