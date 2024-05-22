package mk.ukim.finki.emt.ordermanagment.domain.model;

import jakarta.persistence.*;
import mk.ukim.finki.emt.ordermanagment.domain.valueObjects.TrainersId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.yaml.snakeyaml.events.Event;

@Entity
@Table(name = "order_item")
public class OrderItem extends AbstractEntity<OrderItemId>{

    private Money orderItemPrice;

    @Column(name = "orderItemQuantity", nullable = false)
    private int orderItemQuantity;

    @AttributeOverride(name = "id", column = @Column(name = "trainers_id", nullable = false))
    private TrainersId trainersId;

}
