package com.bridgelabz.CabInvoiceGenerator;

import java.util.Arrays;

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

	@Test
	public void whenGivenLessDistanceOrTimeShouldReturnMinimumFare() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		double distance = 0.1;
		int time = 1;
		double fare = cabInvoiceGenerator.calculateFare(distance, time);
		System.out.println("Minimum Fare = " + fare);
		Assert.assertEquals(5, fare, 0.0);
	}

	@Test
	public void whenGivenMultipleRidesShouldReturnInvoiceSummary() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		double totalFare = cabInvoiceGenerator.calculateTotalFare(rides);
		System.out.println("Total Fare = " + totalFare);
		Assert.assertEquals(30, totalFare, 0.0);
	}

	@Test
	public void givenMultipleRidesshouldReturnSizeAndAverageFare() {
		CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();

		Ride[] rides = { new Ride(20.0, 4), new Ride(45.0, 1), new Ride(75.0, 1), new Ride(45.5, 1) };

		double totalFare = cabInvoiceGenerator.calculateTotalFare(rides);
		int numberOfRides = cabInvoiceGenerator.getNumberOfRides(rides);
		double averageTotalFare = cabInvoiceGenerator.calculateAverageRideCost(rides);

		System.out.println("Total Fare = " + totalFare);
		System.out.println("Number of ride = " + numberOfRides);
		System.out.println("Average Total Fare " + averageTotalFare);

		Assert.assertEquals(1862, totalFare, 0.0);
		Assert.assertEquals(4, numberOfRides);
		Assert.assertEquals(465, averageTotalFare, 0.5);
	}

	@Test
	public void whenGivenUserIdShouldReturnAllRidersInvoice() {
		CabInvoiceGenerator firstUserInvoiceGenerator = new CabInvoiceGenerator(151270);
		CabInvoiceGenerator secondUserInvoiceGenerator = new CabInvoiceGenerator(151271);

		Ride[] firstUserRides = { new Ride(20.0, 4), new Ride(45.0, 1), new Ride(75.0, 1), new Ride(45.5, 1) };

		Ride[] secondUserRides = { new Ride(20.0, 4), new Ride(45.0, 1), new Ride(75.0, 1) };

		firstUserInvoiceGenerator.addUserRideRegister(firstUserInvoiceGenerator, firstUserRides);
		secondUserInvoiceGenerator.addUserRideRegister(secondUserInvoiceGenerator, secondUserRides);

		double[] firstUserTotalFare = firstUserInvoiceGenerator.getRideDetails(firstUserInvoiceGenerator.getUserId());
		double[] secondUserTotalFare = secondUserInvoiceGenerator
				.getRideDetails(secondUserInvoiceGenerator.getUserId());

		System.out.println("First User Total RidesFare : " + Arrays.toString(firstUserTotalFare));
		System.out.println("Second User Total RidesFare : " + Arrays.toString(secondUserTotalFare));

		Assert.assertEquals("[465.5, 1862.0, 4.0]", Arrays.toString(firstUserTotalFare));
		Assert.assertEquals("[468.6666666666667, 1406.0, 3.0]", Arrays.toString(secondUserTotalFare));

	}
}