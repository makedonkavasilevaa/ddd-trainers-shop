package mk.ukim.finki.emt.ordermanagment.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import mk.ukim.finki.emt.ordermanagment.domain.valueObjects.TrainersId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.antlr.v4.runtime.misc.NotNull;
import org.yaml.snakeyaml.events.Event;

@Entity
@Table(name = "order_item")
@Getter
public class OrderItem extends AbstractEntity<OrderItemId> {

    private Money orderItemPrice;

    @Column(name = "qty", nullable = false)
    private int orderItemQuantity;

    @AttributeOverride(name = "id", column = @Column(name = "trainers_id", nullable = false))
    private TrainersId trainersId;

    public OrderItem(@NotNull TrainersId trainersId, @NotNull Money orderItemPrice, int orderItemQuantity) {
        super(DomainObjectId.randomId(OrderItemId.class));
        this.trainersId = trainersId;
        this.orderItemPrice = orderItemPrice;
        this.orderItemQuantity = orderItemQuantity;
    }

    public OrderItem() {
    }

    public Money subtotal() {
        return orderItemPrice.multiply(orderItemQuantity);
    }


}
