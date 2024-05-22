package mk.ukim.finki.emt.ordermanagment.domain.model;

import jakarta.persistence.Embeddable;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class OrderItemId extends DomainObjectId {

    protected OrderItemId(String uuid){
        super(uuid);
    }
}
