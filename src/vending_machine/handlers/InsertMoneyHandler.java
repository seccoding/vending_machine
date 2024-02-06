package vending_machine.handlers;

import vending_machine.customers.Customer;
import vending_machine.machines.VendingMachine;

public interface InsertMoneyHandler<I> {

//	if (product.equals(productName)) {
//		this.money += product.getPrice();
//		customer.pay(product.getPrice());
//		break; // 반복을 중단.
//	}
	public void handle(VendingMachine<I> machine, Customer customer, 
					  I item, String productName);
	
}
