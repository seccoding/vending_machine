package vending_machine;

public class VipCustomer extends Customer {

	public VipCustomer(int wallet) {
		super(wallet);
	}
	
	@Override
	protected Product getProductByName(String name) {
		return super.getProductByName(name);
	}
	
}
