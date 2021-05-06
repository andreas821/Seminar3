package se.kth.iv1350.integration;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

import se.kth.iv1350.DTO.ItemDTO;
import se.kth.iv1350.DTO.SaleDTO;

public class Inventory {
	
	private List<SaleDTO> sales;
	private HashMap<Integer, ItemDTO> items;

	/**
	 * Creates a instance of the inventory.
	 */
	public Inventory() {
		sales = new ArrayList<SaleDTO>();
		items = new HashMap<Integer, ItemDTO>();
		
		items.put(123456, new ItemDTO(199, 59, "Honey 500g"));
		items.put(123, new ItemDTO(1199, 259, "Milk 1,5L"));
	}
	
	/**
	 * Gets a item given its identifier.
	 *  
	 * @param itemIdentifier The identifier of the item
	 * 
	 * @return A item matching the identifier
	 * 
	 */
	public ItemDTO getItemDTO(int itemIdentifier) {
		return items.get(itemIdentifier);
	}
	
	/**
	 * Updates the inventory.
	 *  
	 * @param saleDTO The sale to be used when updating
	 * 
	 */
	public void updateInventory(SaleDTO saleDTO) {
		sales.add(saleDTO);
	}
}
