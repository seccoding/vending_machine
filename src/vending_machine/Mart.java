package vending_machine;

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
		
		
		// Seller
		//  --> VendingMachine
		//  --> RefundableVendingMachine
		// IS A ( 다형성 )
		// VendingMachine is a Seller
		// RefundableVendingMachine is Seller
		// Seller drinkVendingMachine = new VendingMachine();
		// Seller drinkVendingMachine = new RefundableVendingMachine();
		
		
		// 객체지향 방식으로 개발.
		Seller drinkMachine = new VendingMachine();
		
		Customer musk = new Customer(200_000);
		
		drinkMachine.insertMoney(musk, "제로펩시");
		drinkMachine.pressButton(musk, "제로펩시", 50);
		
		drinkMachine.insertMoney(musk, "제로펩시");
		drinkMachine.pressButton(musk, "제로펩시");
		
		drinkMachine.printProducts();
		musk.printProducts();
		
		Seller snackMachine = new RefundableVendingMachine(400);
		snackMachine.insertMoney(musk, "제로펩시");
		snackMachine.pressButton(musk, "제로펩시", 50);
		
		snackMachine.insertMoney(musk, "제로펩시");
		snackMachine.pressButton(musk, "제로펩시", 2);
		
		snackMachine.printProducts();
		musk.printProducts();
	}
	
}








