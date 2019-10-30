package io.github.mariyamkhalid.rocketmiles.interfaces;

import io.github.mariyamkhalid.rocketmiles.models.CashCollection;

public interface ChangeApplicationController {

	public void put(CashCollection c);

	public boolean take(CashCollection c);

	public CashCollection changeCash(int i);

	public CashCollection getCurrentCashCollection();


}
