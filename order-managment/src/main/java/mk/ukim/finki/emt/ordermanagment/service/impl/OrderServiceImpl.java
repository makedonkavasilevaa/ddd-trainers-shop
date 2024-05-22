package mk.ukim.finki.emt.ordermanagment.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.ordermanagment.domain.exceptions.OrderIDNotExistsException;
import mk.ukim.finki.emt.ordermanagment.domain.exceptions.OrderItemIDNotExistsException;
import mk.ukim.finki.emt.ordermanagment.domain.model.Order;
import mk.ukim.finki.emt.ordermanagment.domain.model.OrderId;
import mk.ukim.finki.emt.ordermanagment.domain.model.OrderItemId;
import mk.ukim.finki.emt.ordermanagment.domain.repository.OrderRepository;
import mk.ukim.finki.emt.ordermanagment.service.OrderService;
import mk.ukim.finki.emt.ordermanagment.service.forms.OrderForm;
import mk.ukim.finki.emt.ordermanagment.service.forms.OrderItemForm;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final Validator validator;


    @Override
    public OrderId placeOrder(OrderForm orderForm) {
        Objects.requireNonNull(orderForm, "Order must not be null!");
        var constraintViolations = validator.validate(orderForm);
        if (constraintViolations.size()>0){
            throw new ConstraintViolationException("The order form is not valid!", constraintViolations);
        }
        var newOrder = orderRepository.saveAndFlush(toDomainObject(orderForm));
        return newOrder.getId();
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(OrderId orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
    public void addItem(OrderId orderId, OrderItemForm orderItemForm) throws OrderIDNotExistsException {
        Order order = orderRepository.findById(orderId).orElseThrow(OrderIDNotExistsException::new);
        order.addItem(orderItemForm.getTrainers(), orderItemForm.getQuantity());
        orderRepository.saveAndFlush(order);
    }

    @Override
    public void deleteItem(OrderId orderId, OrderItemId orderItemId) throws OrderIDNotExistsException, OrderItemIDNotExistsException {
        Order order = orderRepository.findById(orderId).orElseThrow(OrderIDNotExistsException::new);
        order.removeItem(orderItemId);
        orderRepository.saveAndFlush(order);
    }

    private Order toDomainObject(OrderForm orderForm){
        var order = new Order(Instant.now(), orderForm.getCurrency());
        orderForm.getItems().forEach(item -> order.addItem(item.getTrainers(), item.getQuantity()));
        return order;
    }
}
