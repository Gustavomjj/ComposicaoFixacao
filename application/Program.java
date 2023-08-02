package fixacao.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import fixacao.entities.Client;
import fixacao.entities.Order;
import fixacao.entities.OrderItem;
import fixacao.entities.Product;
import fixacao.entities.enums.OrderStatus;

public class Program {
	
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date moment = new Date();
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.next();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client c1 = new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = sc.next();
		
		Order order = new Order(moment, OrderStatus.valueOf(status), c1);
		
		System.out.print("How many items to this order: ");
		int nItems = sc.nextInt();
		
		for (int i = 0; i < nItems; i++) {
			System.out.printf("Enter #%d item data: %n", i+1);
			System.out.print("Product name: ");
			String productName = sc.next();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = sc.nextInt();
			
			Product p = new Product(productName,productPrice);
			OrderItem items = new OrderItem(p, productQuantity);
			order.addItem(items);
		}
		
		
		System.out.println();
		System.out.println("ORDER SUMARY: ");
		System.out.println(order);

		
				
		sc.close();
	}

}
