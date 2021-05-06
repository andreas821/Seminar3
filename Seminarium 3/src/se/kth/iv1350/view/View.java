package se.kth.iv1350.view;

import se.kth.iv1350.DTO.ItemDTO;
import se.kth.iv1350.DTO.ReceiptDTO;
import se.kth.iv1350.DTO.SaleDTO;
import se.kth.iv1350.controller.Controller;

public class View {
	
	private Controller controller;
	
	public View(Controller controller) {
		this.controller = controller;
		
		System.out.println("Starting a new sale");
		controller.beginSale();
		
		int firstItemToScan = 123456;
		int secondItemToScann = 123;
		
		System.out.println("Scanning item " + firstItemToScan);
		ItemDTO itemDTO = controller.scanItem(firstItemToScan, 1);
		System.out.println("Item price :" + itemDTO.getPrice());
		System.out.println("Item VAT :" + itemDTO.getVAT());
		System.out.println("Item Description :" + itemDTO.getDescription());
		
		System.out.println("Getting sale data");
		SaleDTO saleDTO = controller.getSaleDTO();
		System.out.println("Running total:" + saleDTO.getTotalPrice());
		System.out.println("Total VAT:" + saleDTO.getVAT());
		
		System.out.println("Scanning item " + secondItemToScann +" quantity of 3");
		itemDTO = controller.scanItem(secondItemToScann, 3);
		System.out.println("Item price :" + itemDTO.getPrice());
		System.out.println("Item VAT :" + itemDTO.getVAT());
		System.out.println("Item Description :" + itemDTO.getDescription());
		
		System.out.println("Getting sale data");
		saleDTO = controller.getSaleDTO();
		System.out.println("Running total:" + saleDTO.getTotalPrice());
		System.out.println("Total VAT:" + saleDTO.getVAT());
		
		System.out.println("Ending sale");
		saleDTO = controller.endSale();
		System.out.println("Running total:" + saleDTO.getTotalPrice());
		System.out.println("Total VAT:" + saleDTO.getVAT());
		
		System.out.println("Paid amount 5000");
		int change = controller.getChangeAmount(5000);
		System.out.println("Change to return: " + change);
		
		
	}
	
	

}
