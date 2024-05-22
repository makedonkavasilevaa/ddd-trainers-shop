package mk.ukim.finki.emt.trainerscatalog.domain.valueObjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

@Embeddable
@Getter
public class Stock implements ValueObject {

    private final int stock;

    protected Stock(){
        this.stock = 0;
    }
}
