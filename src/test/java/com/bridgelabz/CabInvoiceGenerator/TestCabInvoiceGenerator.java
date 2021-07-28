package com.bridgelabz.CabInvoiceGenerator;

import org.junit.Assert;
import org.junit.Test;

public class TestCabInvoiceGenerator {

	@Test
	public void whenGivenDistanceAndTimeShouldReturnTotalFare() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		double distance = 2.0;
		int time = 5;
		double totalFare = cabInvoiceGenerator.calculateFare(distance, time);
		System.out.println("Total Fare = " + totalFare);
		Assert.assertEquals(25, totalFare, 0.0);
	}
}