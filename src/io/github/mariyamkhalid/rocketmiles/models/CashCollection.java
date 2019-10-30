package io.github.mariyamkhalid.rocketmiles.models;

public class CashCollection {
	int ones;
	int twos;
	int fives;
	int tens;
	int twenties;

	public CashCollection() {

	}

	public CashCollection(int ones, int twos, int fives, int tens, int twenties) {
		this.ones = ones;
		this.twos = twos;
		this.fives = fives;
		this.tens = tens;
		this.twenties = twenties;
	}

	public CashCollection(CashCollection c) {
		ones = c.ones;
		twos = c.twos;
		fives = c.fives;
		tens = c.tens;
		twenties = c.twenties;
	}

	public void addOne() {
		ones++;
	}

	public void addTwo() {
		twos++;
	}

	public void addFive() {
		fives++;
	}

	public void addTen() {
		tens++;
	}

	public void addTwenty() {
		twenties++;
	}
	
	public void removeOne() {
		if(ones > 0)
		{
			ones--;
		}
		
	}

	public void removeTwo() {
		if(twos > 0)
		{
			twos--;
		}
	}

	public void removeFive() {
		if(fives > 0)
		{
			fives--;
		}
	}

	public void removeTen() {
		if(tens > 0)
		{
			tens--;
		}
	}

	public void removeTwenty() {
		if(twenties > 0)
		{
			twenties--;
		}
	}
	
	public int getOnes() {
		return ones;
	}

	public int getTwos() {
		return twos;
	}

	public int getFives() {
		return fives;
	}

	public int getTens() {
		return tens;
	}

	public int getTwenties() {
		return twenties;
	}

	public int getTotalValue() {
		int total = (20 * twenties) + (10 * tens) + (5 * fives) + (2 * twos) + (1 * ones);
		return total;
	}

	public void addCashCollection(CashCollection c) {
		ones = ones + c.ones;
		twos = twos + c.twos;
		fives = fives + c.fives;
		tens = tens + c.tens;
		twenties = twenties + c.twenties;
	}

	public boolean removeCashCollection(CashCollection c) {

		if (ones >= c.ones || fives >= c.fives || tens >= c.tens || twenties > c.twenties) {
			ones = ones - c.ones;
			twos = twos - c.twos;
			fives = fives - c.fives;
			tens = tens - c.tens;
			twenties = twenties - c.twenties;
			return true;
		}
		return false;
	}

}
