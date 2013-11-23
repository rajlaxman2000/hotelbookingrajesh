package com.hostel.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Echo {
    public static void main (String[] args) {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	 try {
			String command = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}


