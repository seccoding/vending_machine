package vending_machine;

/**
 * 환불 기능이 있는 자판기
 */
public class RefundableVendingMachine implements Sellable {

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
		System.out.println("재고가 없네요.");
		System.out.println(refundMoney + "원 환불 해드릴게요.");
		// 1. 자판기의 금액을 환불 해줄 금액만큼 감소시킨다.
//		super.money -= refundMoney;
		int money = this.getMoney();
		money -= refundMoney;
		this.setMoney(money);
		
		// 2. 고객에게 환불 해준다.
		customer.addMoney(refundMoney);
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
//public class RefundableVendingMachine extends Seller {

//	public RefundableVendingMachine() {
//		super();
//	}
//	
//	public RefundableVendingMachine(int money) {
//		super(money);
//	}
//	
//	@Override
//	protected void refund(Customer customer, int refundMoney) {
//		System.out.println("재고가 없네요.");
//		System.out.println(refundMoney + "원 환불 해드릴게요.");
//		// 1. 자판기의 금액을 환불 해줄 금액만큼 감소시킨다.
////		super.money -= refundMoney;
//		int money = super.getMoney();
//		money -= refundMoney;
//		super.setMoney(money);
//		
//		// 2. 고객에게 환불 해준다.
//		customer.addMoney(refundMoney);
//	}
}







