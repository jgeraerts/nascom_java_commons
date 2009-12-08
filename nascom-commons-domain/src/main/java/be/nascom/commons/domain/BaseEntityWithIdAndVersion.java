package be.nascom.commons.domain;

import com.google.common.base.Objects;

import javax.persistence.*;

/**
 * User: jgeraerts
 * Date: Nov 3, 2009
 * Time: 12:14:07 PM
 */

@MappedSuperclass
public class BaseEntityWithIdAndVersion<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    @SuppressWarnings({"unchecked"})
    public T withId(Long id) {
        this.id = id;
        return (T)this;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof BaseEntityWithIdAndVersion) {
            BaseEntityWithIdAndVersion that = (BaseEntityWithIdAndVersion) o;
            return Objects.equal(this.id, that.id) && Objects.equal(this.version, that.version);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, version);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("BaseEntityWithIdAndVersion");
        sb.append("{id=").append(id);
        sb.append(", version=").append(version);
        sb.append('}');
        return sb.toString();
    }
}
