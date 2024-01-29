package vending_machine;

public class TemperatureProduct extends Product {

	/**
	 * 상품이 뜨거운지 차가운지에 대한 정보 
	 * true: 뜨거운 상품 
	 * false: 차가운 상품.
	 */
	private boolean isHot;

	public boolean getIsHot() {
		return this.isHot;
	}

	public void setIsHot(boolean isHot) {
		this.isHot = isHot;
	}
	
}





