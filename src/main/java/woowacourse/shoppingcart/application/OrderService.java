package woowacourse.shoppingcart.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import woowacourse.shoppingcart.dao.CartItemDao;
import woowacourse.shoppingcart.dao.CustomerDao;
import woowacourse.shoppingcart.dao.OrderDao;
import woowacourse.shoppingcart.dao.OrdersDetailDao;
import woowacourse.shoppingcart.dao.ProductDao;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderService {

    private final OrderDao orderDao;
    private final OrdersDetailDao ordersDetailDao;
    private final CartItemDao cartItemDao;
    private final CustomerDao customerDao;
    private final ProductDao productDao;

    public OrderService(final OrderDao orderDao, final OrdersDetailDao ordersDetailDao,
                        final CartItemDao cartItemDao, final CustomerDao customerDao, final ProductDao productDao) {
        this.orderDao = orderDao;
        this.ordersDetailDao = ordersDetailDao;
        this.cartItemDao = cartItemDao;
        this.customerDao = customerDao;
        this.productDao = productDao;
    }

//    public Long addOrder(final List<OrderRequest> orderDetailRequests, final String customerName) {
//        final Long customerId = customerDao.getIdByUsername(customerName);
//        final Long ordersId = orderDao.addOrders(customerId);
//
//        for (final OrderRequest orderDetail : orderDetailRequests) {
//            final Long cartId = orderDetail.getCartId();
//            final Long productId = cartItemDao.findProductIdById(cartId);
//            final int quantity = orderDetail.getQuantity();
//
//            ordersDetailDao.addOrdersDetail(ordersId, productId, quantity);
//            cartItemDao.deleteCartItemByCustomer(cartId);
//        }
//
//        return ordersId;
//    }
//
//    public Orders findOrderById(final String customerName, final Long orderId) {
//        validateOrderIdByCustomerName(customerName, orderId);
//        return findOrderResponseDtoByOrderId(orderId);
//    }
//
//    private void validateOrderIdByCustomerName(final String customerName, final Long orderId) {
//        final Long customerId = customerDao.getIdByUsername(customerName);
//
//        if (!orderDao.isValidOrderId(customerId, orderId)) {
//            throw new InvalidOrderException("유저에게는 해당 order_id가 없습니다.");
//        }
//    }
//
//    public List<Orders> findOrdersByCustomerName(final String customerName) {
//        final Long customerId = customerDao.getIdByUsername(customerName);
//        final List<Long> orderIds = orderDao.findOrderIdsByCustomerId(customerId);
//
//        return orderIds.stream()
//                .map(this::findOrderResponseDtoByOrderId)
//                .collect(Collectors.toList());
//    }
//
//    private Orders findOrderResponseDtoByOrderId(final Long orderId) {
//        final List<OrderDetail> ordersDetails = new ArrayList<>();
//        for (final OrderDetail productQuantity : ordersDetailDao.findOrdersDetailsByOrderId(orderId)) {
//            final Product product = productDao.findProductById(productQuantity.getProductId());
//            final int quantity = productQuantity.getQuantity();
//            ordersDetails.add(new OrderDetail(product, quantity));
//        }
//
//        return new Orders(orderId, ordersDetails);
//    }
}
