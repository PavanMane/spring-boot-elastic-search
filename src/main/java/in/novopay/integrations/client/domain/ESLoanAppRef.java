package in.novopay.integrations.client.domain;

public class ESLoanAppRef {
	
	private int productId;
	private String productType;
	private String tenure;
	private String tenure_type;
	private String amount;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getTenure() {
		return tenure;
	}
	public void setTenure(String tenure) {
		this.tenure = tenure;
	}
	public String getTenure_type() {
		return tenure_type;
	}
	public void setTenure_type(String tenure_type) {
		this.tenure_type = tenure_type;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
}
