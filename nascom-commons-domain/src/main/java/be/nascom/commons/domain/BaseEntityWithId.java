package be.nascom.commons.domain;

import javax.persistence.MappedSuperclass;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * User: jgeraerts
 * Date: Nov 3, 2009
 * Time: 12:11:32 PM
 */

@MappedSuperclass
public class BaseEntityWithId {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntityWithId that = (BaseEntityWithId) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("BaseEntityWithId");
        sb.append("{id=").append(id);
        sb.append('}');
        return sb.toString();
    }


    public BaseEntityWithId withId(Long id) {
        this.id = id;
        return this;
    }
}
