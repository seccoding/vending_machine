package vending_machine;

public interface PrintHandler<I> {

//	System.out.println("자판기의 상품 수량: " + product.getQuantity());
//	System.out.println("자판기의 상품 이름: " + product.getName());
	public void handle(I item);
}
