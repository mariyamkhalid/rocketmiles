package io.github.mariyamkhalid.rocketmiles;

import java.util.Scanner;
import io.github.mariyamkhalid.rocketmiles.controllers.ChangeApplicationControllerBasic;
import io.github.mariyamkhalid.rocketmiles.interfaces.ChangeApplicationController;
import io.github.mariyamkhalid.rocketmiles.models.CashCollection;

public class ChangeApplication {

	ChangeApplicationController controller;

	public static void main(String[] args) {
		ChangeApplication app = new ChangeApplication();
		app.run();

	}

	public ChangeApplication() {
		controller = new ChangeApplicationControllerBasic();
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ready");
		boolean running = true;
		while (running) {
			String input = scanner.nextLine();
			if (input == null || input.isEmpty()) {
				System.out.println("Please input a correctly formatted command");
			}

			String[] inputTokens = input.split(" ");
			boolean success;
			switch (inputTokens[0]) {
			case "show":
				show();
				break;
			case "put":
				success = put(inputTokens);
				if (success) {
					show();
				} else {
					System.out.println("There was an error putting the amount");
				}
				break;
			case "take":
				success = take(inputTokens);
				if (success) {
					show();
				} else {
					System.out.println("There was an error taking the amount");
				}
				break;
			case "change":
				success = change(inputTokens);
				if (!success) {
					System.out.println("There was an error getting change for the amount");
				}
				break;
			case "quit":
				running = false;
				break;
			default:
				System.out.println("Please enter a valid input");

			}
		}
		System.out.println("Bye");
		scanner.close();
	}

	private void show() {
		CashCollection c = controller.getCurrentCashCollection();
		printCashCollection(c);

	}

	public boolean put(String[] inputTokens) {
		CashCollection c = parseInputCollection(inputTokens);
		if (c == null) {
			return false;
		}
		controller.put(c);
		return true;

	}

	public boolean take(String[] inputTokens) {
		CashCollection c = parseInputCollection(inputTokens);
		if (c == null) {
			return false;
		}
		return controller.take(c);
	}

	public boolean change(String[] inputTokens) {
		int val = parseInputSingleVal(inputTokens);
		if (val == -1) {
			return false;
		}
		CashCollection result = controller.changeCash(val);
		if (result == null) {
			return false;
		}
		printCashCollection(result);
		return true;

	}

	private CashCollection parseInputCollection(String[] inputTokens) {
		if (inputTokens.length != 6) {
			return null;
		}

		try {
			int twenties = Integer.parseInt(inputTokens[1]);
			int tens = Integer.parseInt(inputTokens[2]);
			int fives = Integer.parseInt(inputTokens[3]);
			int twos = Integer.parseInt(inputTokens[4]);
			int ones = Integer.parseInt(inputTokens[5]);
			CashCollection c = new CashCollection(ones, twos, fives, tens, twenties);
			return c;
		} catch (Exception e) {
			return null;
		}
	}

	private int parseInputSingleVal(String[] inputTokens) {
		if (inputTokens.length != 2) {
			return -1;
		}

		try {
			int value = Integer.parseInt(inputTokens[1]);
			return value;
		} catch (Exception e) {
			return -1;
		}

	}

	private void printCashCollection(CashCollection c) {
		System.out.print("$" + String.valueOf(c.getTotalValue()) + " ");
		System.out.print(c.getTwenties() + " ");
		System.out.print(c.getTens() + " ");
		System.out.print(c.getFives() + " ");
		System.out.print(c.getTwos() + " ");
		System.out.print(c.getOnes() + " ");
		System.out.println(" ");

	}

}
