package vending_machine;

/**
 * 환불 기능이 있는 자판기
 */
public class RefundableVendingMachine<I>
				extends VendingMachine<I> 
				implements Sellable<I> {

	public RefundableVendingMachine(I[] itemArray) {
		super(itemArray);
	}
	
	public RefundableVendingMachine(int money, I[] itemArray) {
		super(money, itemArray);
	}
	
	@Override
	protected void refund(Customer customer, int refundMoney) {
		System.out.println("재고가 없네요.");
		System.out.println(refundMoney + "원 환불 해드릴게요.");
		// 1. 자판기의 금액을 환불 해줄 금액만큼 감소시킨다.
//		super.money -= refundMoney;
		int money = super.getMoney();
		money -= refundMoney;
		super.setMoney(money);
		
		// 2. 고객에게 환불 해준다.
		customer.addMoney(refundMoney);
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







