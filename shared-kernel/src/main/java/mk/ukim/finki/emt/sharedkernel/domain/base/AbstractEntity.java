package mk.ukim.finki.emt.sharedkernel.domain.base;

import org.springframework.data.util.ProxyUtils;

import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;

import lombok.Getter;

@Getter
@MappedSuperclass
public abstract class AbstractEntity<ID extends DomainObjectId> implements IdentifiableDomainObject<ID> {

    @EmbeddedId
    private ID id;

    public AbstractEntity(){

    }

    public AbstractEntity(ID id){
        this.id = id;
    }

    @Override
    public int hashCode() {
        return this.id != null? super.hashCode() : this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !getClass().equals(ProxyUtils.getUserClass(obj))) {
            return false;
        }

        var other = (AbstractEntity<?>) obj;
        return id != null && id.equals(other.id);    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return String.format("%s[%s]", getClass().getSimpleName(), id);
    }

    @Override
    public ID id() {
        return this.id;
    }
}
