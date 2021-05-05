package se.kth.iv1350.model;

import se.kth.iv1350.DTO.SaleDTO;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.DTO.ItemDTO;
import se.kth.iv1350.DTO.ReceiptDTO;

public class SaleProcessing {

	private List<ItemDTO> listOfItems = new ArrayList<ItemDTO>();
	
	/**
	 * Creates a instance to process a sale.
	 * 
	 */
	public SaleProcessing() {
		
	}
	
	/**
	 * Adds a scanned item.
	 *  
	 * @param itemDTO The item to be added
	 * @param quantity The quantity of item added
	 * 
	 */
	public void scanItem(ItemDTO itemDTO, int quantity) {
		
		for(int i = 0; i < quantity; i++) {
			listOfItems.add(itemDTO);
		}
	}
	
	/**
	 * Gets information about the current sale.
	 *  
	 * @return A object representing the sale
	 * 
	 */
	public SaleDTO getSaleDTO() {
		int totalPrice = 0;
		int totalVAT = 0;
		
		for(int i = 0; i < listOfItems.size(); i++) {
			totalPrice += listOfItems.get(i).getPrice();
			totalVAT += listOfItems.get(i).getVAT();
		}
		
		SaleDTO saleDTO = new SaleDTO(totalPrice, totalVAT, listOfItems);
		
		return saleDTO;
	}
	
	/**
	 * Gets the receipt associated with the sale.
	 *  
	 * @return The receipt
	 * 
	 */
	public ReceiptDTO getReceiptDTO(int amountPaid) {
		
		SaleDTO saleDTO = getSaleDTO();
		
		int change = amountPaid - saleDTO.getTotalPrice();
		
		ReceiptDTO receipt = new ReceiptDTO(05052021, 123243, "Matbutik", "Afärsvägen 52", saleDTO.getItems(), saleDTO.getTotalPrice(), saleDTO.getVAT(), amountPaid, change);
	
		return receipt;
	}
	
	
}
