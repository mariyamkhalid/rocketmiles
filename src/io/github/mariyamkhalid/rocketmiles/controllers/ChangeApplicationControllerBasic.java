package io.github.mariyamkhalid.rocketmiles.controllers;

import io.github.mariyamkhalid.rocketmiles.interfaces.ChangeApplicationController;
import io.github.mariyamkhalid.rocketmiles.models.CashCollection;

public class ChangeApplicationControllerBasic implements ChangeApplicationController {

	CashCollection register;

	public ChangeApplicationControllerBasic() {
		register = new CashCollection();
	}

	public CashCollection getCurrentCashCollection() {
		return new CashCollection(register);
	}

	public void put(CashCollection c) {
		register.addCashCollection(c);
	}

	public boolean take(CashCollection c) {
		return register.removeCashCollection(c);
	}

	public CashCollection changeCash(int i) {
		CashCollection change = new CashCollection();
		boolean result = getChangeCollection(new CashCollection(register), change, i);
		if (result) {
			register.removeCashCollection(change);
			return change;
		}
		return null;
	}

	private boolean getChangeCollection(CashCollection currentRegister, CashCollection change, int amount) {

		if (amount == 0) {
			return true;
		}

		boolean result;
		if (amount >= 20 && currentRegister.getTwenties() > 0) {
			change.addTwenty();
			currentRegister.removeTwenty();
			result = getChangeCollection(currentRegister, change, amount - 20);
			if (result) {
				return true;
			}
			change.removeTwenty();
			currentRegister.addTwenty();
		}
		if (amount >= 10 && currentRegister.getTens() > 0) {
			change.addTen();
			currentRegister.removeTen();
			result = getChangeCollection(currentRegister, change, amount - 10);
			if (result) {
				return true;
			}
			change.removeTen();
			currentRegister.addTen();
		}
		if (amount >= 5 && currentRegister.getFives() > 0) {
			change.addFive();
			currentRegister.removeFive();
			result = getChangeCollection(currentRegister, change, amount - 5);
			if (result) {
				return true;
			}
			change.removeFive();
			currentRegister.addFive();
		}
		if (amount >= 2 && currentRegister.getTwos() > 0) {
			change.addTwo();
			currentRegister.removeTwo();
			result = getChangeCollection(currentRegister, change, amount - 2);
			if (result) {
				return true;
			}
			change.removeTwo();
			currentRegister.addTwo();
		}
		if (amount >= 1 && currentRegister.getOnes() > 0) {
			change.addOne();
			currentRegister.removeOne();
			result = getChangeCollection(currentRegister, change, amount - 1);
			if (result) {
				return true;
			}
			change.removeOne();
			currentRegister.removeOne();
		}

		return false;

	}

}
