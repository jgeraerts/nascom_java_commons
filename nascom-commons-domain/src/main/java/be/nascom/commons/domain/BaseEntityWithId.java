package be.nascom.commons.domain;

import com.google.common.base.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * User: jgeraerts
 * Date: Nov 3, 2009
 * Time: 12:11:32 PM
 */

@MappedSuperclass
public class BaseEntityWithId<T> implements Serializable {

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
        if (o instanceof BaseEntityWithId) {
            BaseEntityWithId that = (BaseEntityWithId) o;
            return Objects.equal(this.id, that.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("BaseEntityWithId");
        sb.append("{id=").append(id);
        sb.append('}');
        return sb.toString();
    }

    @SuppressWarnings({"unchecked"})
    public T withId(Long id) {
        this.id = id;
        return (T) this;
    }
}
