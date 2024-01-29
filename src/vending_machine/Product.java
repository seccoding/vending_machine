package vending_machine;

/**
 * 자판기에서 판매할 상품의 정보 (데이터 클래스)
 */
public class Product {

	/**
	 * 상품의 이름
	 */
	private String name;
	
	/**
	 * 상품의 가격
	 */
	private int price;
	
	/**
	 * 상품의 재고
	 */
	private int quantity;
	
	public String getName() {
		return this.name;
	}
	
	
	public int getPrice() {
		return this.price;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	// setter
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override // Annotation
	public String toString() {
		
		String superToStringResult = super.toString();
		System.out.println(superToStringResult);
		
		StringBuffer sb = new StringBuffer();
		sb.append("제품명 : " + this.name);
		sb.append(", 가격 : " + this.price);
		sb.append(", 재고 : " + this.quantity);
		
		return sb.toString();
	}
	
	/*
	 * Product p = new Product();
	 * if ( p.equals("박카스") ) { ... }
	 */
	@Override
	public boolean equals(Object obj) {
		
		if ( obj instanceof String) {
			return this.name.equals( (String) obj );
		}
		
		return super.equals(obj);
	}
	
}






