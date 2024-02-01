package vending_machine;

import java.util.List;

import vending_machine.util.FileUtil;

/**
 * 상속 받은 클래스가 추상 메소드가 존재하는 추상 클래스라면<br/>
 * 추상 메소드를 이 클래스에서 구현을 시키거나<br/>
 * 이 클래스도 추상 클래스로 만들어 주어야 한다.<br/>
 * <b>환불 불가능한 자판기</b>
 */
public class VendingMachine<I> implements Sellable<I> {
	
	private InsertMoneyHandler<I> insertMoneyHandler;
	private PressButtonHandler<I> pressButtonHandler;
	private PrintHandler<I> printHandler;
	
	/**
	 * 상품 수량
	 */
	private List<I> productArray;
	
	/**
	 * 돈
	 */
	private int money;
	
	public VendingMachine(List<I> itemArray) {
		this(100_000, itemArray);
	}
	
	public VendingMachine(int money, List<I> itemArray) {
		this.money = money;
		this.productArray = itemArray;
	}
	
	@Override
	public List<I> getProductArray() {
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
	public void setInsertMoneyHandler(InsertMoneyHandler<I> handler) {
		this.insertMoneyHandler = handler;
	}
	
	@Override
	public void setPressButtonHandler(PressButtonHandler<I> handler) {
		this.pressButtonHandler = handler;
	}
	
	@Override
	public void setPrintHandler(PrintHandler<I> handler) {
		this.printHandler = handler;
	}

	@Override
	public void addProduct(String productName, int price, int quantity) {
		String description = String.join(",", 
										productName, 
										price + "", 
										quantity + "");
		
		FileUtil.writeFile("C:\\Java Exam", "goods.csv", description, true);
	}
	
	@Override
	public void insertMoney(Customer customer, String productName) {
		for ( I product : this.productArray ) {
			this.insertMoneyHandler.handle(this, customer, product, productName);
		}
	}

	@Override
	public void pressButton(Customer customer, String productName) {
		this.pressButton(customer, productName, VendingMachine.PRODUCT_COUNT);
	}

	@Override
	public void pressButton(Customer customer, String productName, int orderCount) {
		for ( I product : this.productArray ) {
			this.pressButtonHandler.handle(this, customer, product, productName, orderCount);
		}
	}

	protected void refund(Customer customer, int refundMoney) {
		
	}

	@Override
	public void printProducts() {
		System.out.println("자판기의 잔액: " + this.money);
		for ( I product : this.productArray ) {
			if ( product != null ) {
				this.printHandler.handle(product);
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










