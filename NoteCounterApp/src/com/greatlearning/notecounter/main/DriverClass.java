package com.greatlearning.notecounter.main;

import java.util.Scanner;

import com.greatlearning.notecounter.util.ArrayUtils;

public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sizeOfDenominations,ammoutToPay; 
		int[] currencyDenominations;
		
		System.out.println("enter the size of currency denominations");
		Scanner sc  = new Scanner(System.in);
		sizeOfDenominations = sc.nextInt();
		currencyDenominations = new int[sizeOfDenominations];
		
		System.out.println("enter the currency denominations value");
		for(int i = 0 ; i <sizeOfDenominations; i++) {	
			currencyDenominations[i] = sc.nextInt();
		}
		
		System.out.println("enter the amount you want to pay");
		ammoutToPay = sc.nextInt();
		
		ArrayUtils.mergeSort(currencyDenominations);
		
				
		for(int i = 0 ; i < currencyDenominations.length; i++) {
			System.out.println(currencyDenominations[i]);
		}
		
		
		int [] counter = new int[sizeOfDenominations];
		
		
		int remainingAmount = countNotes(currencyDenominations, counter, 0, sizeOfDenominations - 1, ammoutToPay);
		
		if (remainingAmount > 0)
		{
			System.out.println("Amount cannot be paid in give denominations!");
		}
		else
		{
			for(int i = sizeOfDenominations - 1; i>=0; i--)
			{
				if(counter[i] != 0)
				{
					System.out.println("Denomination of " + currencyDenominations[i] + ":" + counter[i]);
				}
			}
		}
		
		sc.close();
	}



	public static int countNotes(int[] arrDenominations, int[] counter, int low, int high, int amountToPay )
	{
		
		if (amountToPay == 0)
		{
			return 0;
		}
		if (amountToPay < arrDenominations[0])
		{
			return amountToPay;
		}
		
		
		if(amountToPay >= arrDenominations[high])
		{
			counter[high] = amountToPay / arrDenominations[high];
			amountToPay %= arrDenominations[high];
			return countNotes(arrDenominations, counter, 0, high - 1, amountToPay);
		}
		int mid = (low+high)/2;
		if(amountToPay <= arrDenominations[mid])
		{
			return countNotes(arrDenominations, counter, 0, mid - 1, amountToPay);
		}
		return countNotes(arrDenominations, counter, 0, high - 1, amountToPay);
	}
	
}
