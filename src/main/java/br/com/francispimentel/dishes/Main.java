package br.com.francispimentel.dishes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String args[]) throws IOException {
		Dishes dishes = new Dishes();
		System.out.print("Input: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Output: " + dishes.orderDishes(br.readLine()));
	}
}
