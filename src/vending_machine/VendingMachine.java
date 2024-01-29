package vending_machine;

/**
 * 상속 받은 클래스가 추상 메소드가 존재하는 추상 클래스라면<br/>
 * 추상 메소드를 이 클래스에서 구현을 시키거나<br/>
 * 이 클래스도 추상 클래스로 만들어 주어야 한다.<br/>
 * <b>환불 불가능한 자판기</b>
 */
public class VendingMachine implements Sellable {

	/**
	 * 상품 수량
	 */
	private Product[] productArray;
	
	/**
	 * 돈
	 */
	private int money;
	
	@Override
	public Product[] getProductArray() {
		return this.productArray;
	}

	@Override
	public int getMoney() {
		return this.money;
	}

	@Override
	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public void insertMoney(Customer customer, String productName) {
		for ( Product product : this.productArray ) {
			if (product.equals(productName)) {
				this.money += product.getPrice();
				customer.pay(product.getPrice());
				break; // 반복을 중단.
			}
		}
	}

	@Override
	public void pressButton(Customer customer, String productName) {
		this.pressButton(customer, productName, VendingMachine.PRODUCT_COUNT);
	}

	@Override
	public void pressButton(Customer customer, String productName, int orderCount) {
		for ( Product product : this.productArray ) {
			if (product.equals(productName)) {
				if (product.getQuantity() <= 0) {
					this.refund(customer, product.getPrice());
					return; // 메소드를 종료.
				}
				
				int quantity = product.getQuantity();
				quantity -= orderCount;
				product.setQuantity(quantity);
				
				customer.addStock(productName, product.getPrice(), orderCount);
				break;
			}
		}
	}

	@Override
	public void refund(Customer customer, int refundMoney) {
		
	}

	@Override
	public void printProducts() {
		System.out.println("자판기의 잔액: " + this.money);
		for ( Product product : this.productArray ) {
			if ( product != null ) {
				System.out.println("자판기의 상품 수량: " + product.getQuantity());
				System.out.println("자판기의 상품 이름: " + product.getName());
			}
		}
	}
	
// public class VendingMachine extends Seller {
	
//	public VendingMachine() {
//		super(); // 슈퍼 클래스의 파라미터가 없는 기본 형태 생성자를 호출한다.
//	}
//	
//	public VendingMachine(int money) {
//		super(money); // 슈퍼 클래스의 int 파라미터가 있는 생성자를 호출한다.
//	}
//	
//	@Override
//	public final void insertMoney(Customer customer, String productName) {
//		super.insertMoney(customer, productName);
//	}
//	
//	@Override
//	public final void pressButton(Customer customer, String productName) {
//		super.pressButton(customer, productName);
//	}
//	
//	@Override
//	public final void pressButton(Customer customer, String productName, int orderCount) {
//		super.pressButton(customer, productName, orderCount);
//	}
//	
//	@Override
//	protected void refund(Customer customer, int refundMoney) {
//		System.out.println("재고가 없습니다.");
//		System.out.println("환불은 못해드려요.");
//	}
	
	
	
}










