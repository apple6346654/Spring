package hello.core.order;

public interface OrderService {

    Order createOrder(Long membmerId,String itemName, int itemPrice);

}
