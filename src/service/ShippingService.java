package service;

import cart.Cart;
import cart.CartItem;

public class ShippingService {
    public static void ship(Cart cart) {
        double totalWeight = 0;
        System.out.println("** Shipment notice **");
        for (CartItem item : cart.getItems()) {
            if (item.getProduct().requiresShipping()) {
                System.out.print( item.getQuantity()+"x "+
                        item.getProduct().getName()+"\t"+
                        item.getProduct().getWeight()+"g\n");
                totalWeight += item.getProduct().getWeight() * item.getQuantity();
            }
        }
        System.out.println("------------------------");
        System.out.print("Total package weight: "+ totalWeight / 1000+"Kg\n");
        System.out.println("------------------------");
    }
}
