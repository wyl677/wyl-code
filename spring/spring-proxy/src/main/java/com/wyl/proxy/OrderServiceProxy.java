package com.wyl.proxy;

/**
 * @auther yanl.wang
 * @date 2023/2/8
 **/
public class OrderServiceProxy implements OrderService{

    private OrderServiceImpl orderService = new OrderServiceImpl();
    @Override
    public void showOrder() {
        System.out.println("---------log----------");
        orderService.showOrder();
    }
}
