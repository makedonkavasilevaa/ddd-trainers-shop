package mk.ukim.finki.emt.ordermanagment.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import mk.ukim.finki.emt.ordermanagment.domain.valueObjects.Trainers;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.Instant;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
public class Order extends AbstractEntity<OrderId> {

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(name = "order_currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<OrderItem> orderItemsList;

    public Order(Instant now, @javax.validation.constraints.NotNull Currency currency) {
        super(OrderId.randomId(OrderId.class));
        this.currency = currency;
    }

    public Order() {
    }

    public Money orderTotal() {
        return orderItemsList.stream().map(OrderItem :: subtotal).reduce(
                new Money(currency, 0), Money::add);
    }

    public OrderItem addItem(@NotNull Trainers trainers, int qty){
        Objects.requireNonNull(trainers, "Trainers most not be null");
        var item = new OrderItem(trainers.getTrainersId() , trainers.getTrainersPrice(), qty);
        orderItemsList.add(item);
        return item;
    }

    public void removeItem(@NotNull OrderItemId orderItemId){
        Objects.requireNonNull(orderItemId, "Order Item must not be null!");
        orderItemsList.removeIf(v -> v.getId().equals(orderItemId));

    }

}
