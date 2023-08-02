package fixacao.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fixacao.entities.enums.OrderStatus;

public class Order {
	
	private Date moment;
	private OrderStatus status;
	private Client client;
	
	private List<OrderItem> items = new ArrayList<>();
	SimpleDateFormat sdfMoment = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public Order() {
	}
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public void addItem (OrderItem item) {
		items.add(item);
	}

	public void removeItem (OrderItem item) {
		items.remove(item);
	}
	
	public double total() {
		double sum = 0;
		for (OrderItem i : items) {
			sum += i.subTotal(i.getQuantity(), i.getProduct().getPrice());
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: " + sdfMoment.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append(client + "\n");
		
		for (OrderItem i : items) {
			sb.append(i.getProduct());
			sb.append(", Quantity: " + i.getQuantity());
			sb.append(", Subtotal: $" + i.subTotal(i.getQuantity(), i.getProduct().getPrice()));
			sb.append("\n");
		}
		
		sb.append("Total price: $" + total());
		
		return sb.toString();
	}
	
}
