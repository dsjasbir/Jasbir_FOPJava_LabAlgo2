package com.greatlearning.paymoney.main;

import java.util.Scanner;

public class DriverClass {

	public static void main(String[] args) {
		int transArrSize,targetArrSize,target; 
		int[] transArr,cumlativeValue;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the size of transaction array");
		transArrSize = sc.nextInt();
		transArr = new int [transArrSize];
		cumlativeValue = new int [transArrSize];
		
		
		System.out.println("enter the values of array");
		for(int i = 0 ; i<transArrSize; i++) {
			
			transArr[i] = sc.nextInt();
			cumlativeValue[i] =  (i==0) ? transArr[i] : cumlativeValue[i-1] +transArr[i] ;
			
		}
		
		
		System.out.println("enter the total no of targets that needs to be achieved");
		targetArrSize = sc.nextInt(); 
	
		
		for(int i = 0 ; i<targetArrSize; i++) {
			System.out.println("enter the values of Target");
			
			target = sc.nextInt();
			System.out.println((getNoOfTransations(cumlativeValue,target)>0? "Target achieved in "+ getNoOfTransations(cumlativeValue,target)+" Transation":"Given target is not achieved "));
		}
			
		
		
		
		sc.close();
	}

	private static int getNoOfTransations(int[] cumlativeValue, int target) {
		int noOfTransation = 0;
		for (int i = 0 ; i <cumlativeValue.length; i++) {
			
			if (cumlativeValue[i]>=target) {
				 noOfTransation = i+1;
				 break;
			}
		}
		return noOfTransation;
	}


}
