package vending_machine;

import java.util.ArrayList;
import java.util.List;

public class Mart {

//	public static void printProduct(Product p) {
//		System.out.println(p.getName()); // null
//		
//		if ( p instanceof TemperatureProduct) {
//			TemperatureProduct tp = (TemperatureProduct) p;
//			tp.setIsHot(true);
//			System.out.println(tp.getIsHot());
//		}
//		
//	}
	
	public static void main(String[] args) {
		
		// 모든 클래스의 슈퍼클래스는 Object
		
		/*
		 * Object
		 *  --> Product
		 *     --> TemperatureProduct
		 * Product is a Object
		 * TemperatureProduct is a Product
		 * TemperatureProduct is a Object
		 */
		
//		Product p = new Product();
//		TemperatureProduct tp = new TemperatureProduct();
//		tp.setName("티피");
//		printProduct(tp);
//		printProduct(p);
		
//		printTemperatureProduct(tp);
		
		Product p = new Product();
		p.setName("보드마카");
		p.setPrice(500);
		p.setQuantity(40);
		
		System.out.println(p); 
		// vending_machine.Product@279f2327
		// 제품명 : 보드마카, 가격 : 500, 재고 : 40
		
		
		// Seller (추상클래스)
		//  --> VendingMachine
		//  --> RefundableVendingMachine
		// IS A ( 다형성 )
		// VendingMachine is a Seller
		// RefundableVendingMachine is Seller
		// Seller drinkVendingMachine = new VendingMachine();
		// Seller drinkVendingMachine = new RefundableVendingMachine();
		
		// Sellable (인터페이스)
		//   --> (구현) VendingMachine
		//   --> (구현) RefundableVendingMachine
		// 인터페이스를 구현 ( IS A )
		// VendingMachine is a Sellable
		// RefundableVendingMachine is Sellable
		// Sellable drinkVendingMachine = new VendingMachine();
		// Sellable drinkVendingMachine = new RefundableVendingMachine();
		
		List<Product> productList = new ArrayList<>();
		Product product1 = new Product();
		product1.setName("제로펩시");
		product1.setPrice(1600);
		product1.setQuantity(50);
		productList.add(product1);
		
		Product product2 = new Product();
		product2.setName("제로콜라");
		product2.setPrice(1500);
		product2.setQuantity(30);
		productList.add(product2);
		
		Product product3 = new Product();
		product3.setName("제로스프라이트");
		product3.setPrice(1400);
		product3.setQuantity(20);
		productList.add(product3);
		
		// 객체지향 방식으로 개발.
		Sellable<Product> drinkMachine = new VendingMachine<>(100_000, productList);
		drinkMachine.setInsertMoneyHandler(new InsertMoneyHandler<Product>() {
			@Override
			public void handle(VendingMachine<Product> machine, Customer customer, 
							    Product item, String productName) {
				if (item.equals(productName)) {
					int money = machine.getMoney();
					money += item.getPrice();
					machine.setMoney(money);
					
					customer.pay(item.getPrice());
				}
			}});
		
		drinkMachine.setPressButtonHandler(new PressButtonHandler<Product>() {
			@Override
			public void handle(VendingMachine<Product> machine, Customer customer, 
							   Product item, String productName, int orderCount) {
				if (item.equals(productName)) {
					if (item.getQuantity() <= 0) {
						machine.refund(customer, item.getPrice());
						return; // 메소드를 종료.
					}
					
					int quantity = item.getQuantity();
					quantity -= orderCount;
					item.setQuantity(quantity);
					
					customer.addStock(productName, item.getPrice(), orderCount);
				}
			}});
		
		drinkMachine.setPrintHandler(new PrintHandler<Product>() {
			@Override
			public void handle(Product item) {
				System.out.println("자판기의 상품 수량: " + item.getQuantity());
				System.out.println("자판기의 상품 이름: " + item.getName());
			}});
		
		Customer musk = new Customer(200_000);
		
		drinkMachine.insertMoney(musk, "제로펩시");
		drinkMachine.pressButton(musk, "제로펩시", 50);
		
		drinkMachine.insertMoney(musk, "제로펩시");
		drinkMachine.pressButton(musk, "제로펩시");
		
		drinkMachine.printProducts();
		musk.printProducts();
		
		Sellable<Product> snackMachine = new RefundableVendingMachine<>(400, productList);
		snackMachine.setInsertMoneyHandler(new InsertMoneyHandler<Product>() {
			@Override
			public void handle(VendingMachine<Product> machine, Customer customer, 
							    Product item, String productName) {
				if (item.equals(productName)) {
					int money = machine.getMoney();
					money += item.getPrice();
					machine.setMoney(money);
					
					customer.pay(item.getPrice());
				}
			}});
		
		snackMachine.setPressButtonHandler(new PressButtonHandler<Product>() {
			@Override
			public void handle(VendingMachine<Product> machine, Customer customer, 
							   Product item, String productName, int orderCount) {
				if (item.equals(productName)) {
					if (item.getQuantity() <= 0) {
						machine.refund(customer, item.getPrice());
						return; // 메소드를 종료.
					}
					
					int quantity = item.getQuantity();
					quantity -= orderCount;
					item.setQuantity(quantity);
					
					customer.addStock(productName, item.getPrice(), orderCount);
				}
			}});
		
		snackMachine.setPrintHandler(new PrintHandler<Product>() {
			@Override
			public void handle(Product item) {
				System.out.println("자판기의 상품 수량: " + item.getQuantity());
				System.out.println("자판기의 상품 이름: " + item.getName());
			}});
		
		snackMachine.insertMoney(musk, "제로펩시");
		snackMachine.pressButton(musk, "제로펩시", 50);
		
		snackMachine.insertMoney(musk, "제로펩시");
		snackMachine.pressButton(musk, "제로펩시", 2);
		
		snackMachine.printProducts();
		musk.printProducts();
	}
	
}








