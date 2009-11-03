package be.nascom.commons.domain;

import javax.persistence.*;

/**
 * User: jgeraerts
 * Date: Nov 3, 2009
 * Time: 12:14:07 PM
 */

@MappedSuperclass
public class BaseEntityWithIdAndVersion {

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


    public BaseEntityWithIdAndVersion withId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntityWithIdAndVersion that = (BaseEntityWithIdAndVersion) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
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
