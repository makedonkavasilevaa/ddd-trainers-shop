package mk.ukim.finki.emt.ordermanagment.service;

import mk.ukim.finki.emt.ordermanagment.domain.exceptions.OrderIDNotExistsException;
import mk.ukim.finki.emt.ordermanagment.domain.exceptions.OrderItemIDNotExistsException;
import mk.ukim.finki.emt.ordermanagment.domain.model.Order;
import mk.ukim.finki.emt.ordermanagment.domain.model.OrderId;
import mk.ukim.finki.emt.ordermanagment.domain.model.OrderItemId;
import mk.ukim.finki.emt.ordermanagment.service.forms.OrderForm;
import mk.ukim.finki.emt.ordermanagment.service.forms.OrderItemForm;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface OrderService {

    OrderId placeOrder(OrderForm orderForm);

    List<Order> findAll();

    Optional<Order> findById(OrderId orderId);

    void addItem(OrderId orderId, OrderItemForm orderItemForm) throws OrderIDNotExistsException;

    void deleteItem(OrderId orderId, OrderItemId orderItemId) throws OrderIDNotExistsException, OrderItemIDNotExistsException;
}
