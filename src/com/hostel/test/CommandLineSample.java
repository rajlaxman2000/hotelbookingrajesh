package com.hostel.test;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CommandLineSample {
	
	public static void main (String[] args){
		/*
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("classpath:spring-beans-actions.xml");
		context.load("classpath:spring-beans-dao.xml");
		context.refresh();
		*/
			Scanner scanner = new Scanner(System.in);  
			boolean exit=false; 
			do{		       
				 System.out.print("Enter your name: ");
		        String name = scanner.nextLine();  
		        
		         
		        System.out.print("Enter your Zodiac sign: ");        
		        String zodiac = scanner.next();  
		          
		        System.out.println("Enter your weight (kg): ");  
		        double weight = scanner.nextDouble();  
		          
		        System.out.println("Enter your lucky number: ");  
		        int luckyNum = scanner.nextInt();  
		       
		        System.out.println("Hello, " + name + ".");  
		        System.out.println("Your lucky number is  " + luckyNum + ".");  
		        System.out.println("You weigh " + weight + " kg.");  
		        System.out.println("Your Zodiac sign is " + zodiac + ".");  
		       
		        System.out.println("You want to continue (y/n)"); 
		        System.out.println("\n");
		        String exitString = scanner.nextLine(); 
		        exit = (exitString.equalsIgnoreCase("y"))?true:false;
			}while(exit);
	}	
}
