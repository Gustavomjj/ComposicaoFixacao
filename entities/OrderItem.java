package fixacao.entities;

public class OrderItem {
	
	private Product product;
	private Double price;
	private Integer quantity;
	
	public OrderItem () {
	}

	public OrderItem(Product product, Integer quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public double subTotal(int quantity, double price) {
		return quantity * price;
	}

	public static Product Product(String productName, double productPrice) {
		// TODO Auto-generated method stub
		return null;
	}


}
