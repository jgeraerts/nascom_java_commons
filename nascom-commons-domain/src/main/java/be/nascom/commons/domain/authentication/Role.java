package be.nascom.commons.domain.authentication;

import com.google.common.collect.Lists;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

/**
 * User: bart
 * Date: May 11, 2009
 * Time: 12:06:47 PM
 */
@Entity
public class Role implements Comparable<Role>, Serializable {
    public static final Role ROLE_USER = new Role(1, "ROLE_USER");
    public static final Role ROLE_CONTRIBUTOR = new Role(2, "ROLE_CONTRIBUTOR");
    public static final Role ROLE_ADMIN = new Role(3, "ROLE_ADMIN");
    public static final Role ROLE_SUPER_ADMIN = new Role(4, "ROLE_SUPER_ADMIN");

    public static final List<Role> ALL_ROLES = Lists.newArrayList(ROLE_USER, ROLE_CONTRIBUTOR, ROLE_ADMIN, ROLE_SUPER_ADMIN);

    @Id
    @SuppressWarnings({"UnusedDeclaration"})
    private long id;

    private String name;

    public Role() {
        super();
    }

    public Role(long id) {
        this.id = id;
    }

    public Role(long id, String name) {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(id).append(";").append(name);
        return sb.toString();
    }
}
