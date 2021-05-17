package se.kth.iv1350.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import se.kth.iv1350.DTO.ItemDTO;
import se.kth.iv1350.DTO.ReceiptDTO;
import se.kth.iv1350.DTO.SaleDTO;

class SaleProcessingTest {

	@Test
	void testScanItem() {
		SaleProcessing saleProcessing = new SaleProcessing();
		
		int scanItemQuantity = 1;
		int scanItemPrice = 1000;
		int scanItemVAT = 200;
		String scanItemDescription = "Test item";
		
		ItemDTO itemToBeScanned = new ItemDTO(scanItemPrice, scanItemVAT, scanItemDescription);
		
		saleProcessing.scanItem(itemToBeScanned, scanItemQuantity);
		
		SaleDTO saleData = saleProcessing.getSaleDTO();
		
		int expectedPrice = itemToBeScanned.getPrice() * scanItemQuantity;
		int resultPrice = saleData.getTotalPrice();
		
		int expectedVAT = itemToBeScanned.getVAT() * scanItemQuantity;
		int resultVat = saleData.getVAT();
		
		assertEquals(expectedPrice, resultPrice, "Expected price and resulting price are not equal");
		assertEquals(expectedVAT, resultVat, "Expected VAT and resulting VAT are not equal");
		
	}
	
	@Test
	void testScanMultipleItem() {
		SaleProcessing saleProcessing = new SaleProcessing();
		
		int scanItemQuantity = 10;
		int scanItemPrice = 1000;
		int scanItemVAT = 200;
		String scanItemDescription = "Test item";
		
		ItemDTO itemToBeScanned = new ItemDTO(scanItemPrice, scanItemVAT, scanItemDescription);
		
		saleProcessing.scanItem(itemToBeScanned, scanItemQuantity);
		
		SaleDTO saleData = saleProcessing.getSaleDTO();
		
		int expectedPrice = itemToBeScanned.getPrice() * scanItemQuantity;
		int resultPrice = saleData.getTotalPrice();
		
		int expectedVAT = itemToBeScanned.getVAT() * scanItemQuantity;
		int resultVat = saleData.getVAT();
		
		assertEquals(expectedPrice, resultPrice, "Expected price and resulting price are not equal");
		assertEquals(expectedVAT, resultVat, "Expected VAT and resulting VAT are not equal");
	}
	
	//test get change
	@Test
	void testGetReceipt() {
		SaleProcessing saleProcessing = new SaleProcessing();
		
		int scanItemQuantity = 5;
		int scanItemPrice = 999;
		int scanItemVAT = 300;
		String scanItemDescription = "Test item";
		int amountPaid = 10000;
		
		ItemDTO itemToBeScanned = new ItemDTO(scanItemPrice, scanItemVAT, scanItemDescription);
		
		saleProcessing.scanItem(itemToBeScanned, scanItemQuantity);
		
		ReceiptDTO receipt = saleProcessing.getReceiptDTO(amountPaid);
		
		int expectedChange = amountPaid - (scanItemPrice * scanItemQuantity);
		int resultChange = receipt.getChange();
		
		assertEquals(expectedChange, resultChange, "Expected Change and resulting Change are not equal");
	}
	
	

}
