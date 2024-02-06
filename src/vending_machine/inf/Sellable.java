package vending_machine.inf;

import java.util.List;

import vending_machine.customers.Customer;
import vending_machine.handlers.InsertMoneyHandler;
import vending_machine.handlers.PressButtonHandler;
import vending_machine.handlers.PrintHandler;

/**
 * <I extends Product> ==> Product 클래스를 상속한 타입만 가능(X)
 *                     ==> Product 클래스를 상속한 타입 혹은
 *                         Product 인터페이스를 구현한 타입 (O)
 * @param <I>
 */
public interface Sellable<I> {

	// interface 에서 상수를 정의할 때, 
	// static final 은 자동으로 적용되므로 생략한다.
//	public static final int PRODUCT_COUNT = 1;
//	public static final String MACHINE_NAME = "자판기";
	public int PRODUCT_COUNT = 1;
	public String MACHINE_NAME = "자판기";
	
	public List<I> getProductArray();
	
	public int getMoney();
	
	public void setMoney(int money);
	
	public void setInsertMoneyHandler(InsertMoneyHandler<I> handler);
	
	public void setPressButtonHandler(PressButtonHandler<I> handler);
	
	public void setPrintHandler(PrintHandler<I> handler);
	
	public void addProduct(String productName, int price, int quantity);
	
	/**
	 * 돈을 넣는다.
	 * @param customer 돈을 넣은 고객
	 * @param productName 구매할 제품의 이름 (제로펩시, 제로콜라, 제로스프라이트)
	 */
	public void insertMoney(Customer customer, String productName);
	
	/**
	 * 버튼을 누른다.
	 * @param customer 버튼을 누른 고객
	 * @param productName 구매할 제품의 이름 (제로펩시, 제로콜라, 제로스프라이트)
	 */
	public void pressButton(Customer customer, String productName);
	
	public void pressButton(Customer customer, String productName, int orderCount);
	
//	/**
//	 * 고객에게 환불처리 한다.
//	 * 상속된 클래스에서만 사용할 수 있도록 한다.
//	 * @param customer 환불 받을 고객
//	 * @param refundMoney 환불 받을 금액
//	 */
//	public void refund(Customer customer, int refundMoney);
	
	public void printProducts();
	
	
}









