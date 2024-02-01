package vending_machine;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	/**
	 * 고객이 가진 돈
	 */
	private int wallet;
	
	/**
	 * 고객이 가진 상품의 수량
	 */
//	int stock;
	private List<Product> productArray;
	
	public int getWallet() {
		return this.wallet;
	}
	
	public List<Product> getProductArray() {
		return this.productArray;
	}
	
	/**
	 * 생성자.
	 */
//	public Customer(int wallet, int stock) {
	public Customer(int wallet) {
		this.wallet = wallet;
//		this.stock = stock;
		this.productArray = new ArrayList<>(); // 0 1 2
	}
	
	/**
	 * 지출한다.
	 */
	public void pay(int price) {
		if (this.wallet - price <= 0) {
			return; // 메소드 즉시 종료
		}
		this.wallet -= price;
	}
	
	/**
	 * 환불 받는다.
	 * @param money 환불 받은 금액
	 */
	public void addMoney(int money) {
		this.wallet += money;
	}
	
	/**
	 * 상품이 하나 증가한다.
	 */
	public void addStock(String name, int price, int productCount) {
		
		// 고객이 방금 구매한 제품이 고객의 제품목록(this.productArray)에 있는지 확인한다.
		// 있다면, productCount만큼 수량만 증가시킨다.
		// 없다면, 비어있는 인덱스를 찾아서 새롭게 할당해 준다.
		Product product = this.getProductByName(name);
		
		if (product != null) {
			int quantity = product.getQuantity();
			quantity += productCount;
			product.setQuantity(quantity);
		}
		else {
			Product buyProduct = new Product();
			buyProduct.setName(name);
			buyProduct.setPrice(price);
			buyProduct.setQuantity(productCount);
			this.productArray.add(buyProduct);
		}
	}
	
	protected Product getProductByName(String name) {
		for ( Product product : this.productArray) {
			if ( product != null && product.getName().equals(name) ) {
				return product;
			}
		}
		
		return null;
	}
	
	public void printProducts() {
		System.out.println("고객의 잔액: " + this.wallet);
		for ( Product product : this.productArray ) {
			if ( product != null ) {
				System.out.println("고객의 상품 수량: " + product.getQuantity());
				System.out.println("고객의 상품 이름: " + product.getName());
			}
		}
	}
	
}








