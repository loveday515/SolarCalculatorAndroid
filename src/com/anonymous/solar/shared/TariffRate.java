package com.anonymous.solar.shared;

import java.util.ArrayList;
import java.util.List;

public class TariffRate  implements Comparable<TariffRate>{

	private Long key;

	String tariffProvider;

	String tariffState;

	Double tariffFeedIn;

	Double tariff11Cost;

	Double tariff33Cost;

	Double tariff11Fee;

	Double tariff33Fee;

	public static final String TARIFF_11_COST = "tariff11Cost";
	public static final String TARIFF_33_COST = "tariff33Cost";
	public static final String TARIFF_11_FEE = "tariff11Fee";
	public static final String TARIFF_33_FEE = "tariff33Fee";
	public static final String TARIFF_FEE_IN = "tariffFeedIn";
	public static final String TARIFF_STATE = "tariffState";
	public static final String TARIFF_PROVIDER = "tariffProvider";

	public TariffRate(){
		this.tariffProvider = new String();
		this.tariffState = new String();
		this.tariffFeedIn = 0.0;
		this.tariff11Cost = 0.0;
		this.tariff11Fee = 0.0;
		this.tariff33Cost = 0.0;
		this.tariff33Fee = 0.0;
	}

	public TariffRate(String provider, String state, Double feedIn, Double t11C, Double t11F, Double t33C, Double t33F) {
		this.tariffProvider = provider;
		this.tariffState = state;
		this.tariffFeedIn = feedIn;
		this.tariff11Cost = t11C;
		this.tariff11Fee = t11F;
		this.tariff33Cost = t33C;
		this.tariff33Fee = t33C;
	}

	/****************************
	 * Getters
	 ****************************/

	public Long getKey() {
		return key;
	}

	/**
	 * Get the provider of the tariff
	 * 
	 * @return tariff provider
	 */
	public String getTariffProvider() {
		return tariffProvider;
	}

	/**
	 * Get the state of the tariff data
	 * 
	 * @return tariff State
	 */
	public String getTariffState() {
		return tariffState;
	}

	/**
	 * Get the cost of the fee in fee in cents
	 * 
	 * @return feed in fee
	 */
	public Double getTariffFeedInFee() {
		return tariffFeedIn;
	}

	/**
	 * get the cost of tariff 11
	 * 
	 * @return tariff 11 cost in cents
	 */
	public Double getTariff11Cost() {
		return tariff11Cost;
	}

	/**
	 * Get the tariff 11 fee in cents
	 * 
	 * @return tariff 11 fee in cents
	 */
	public Double getTariff11Fee() {
		return tariff11Fee;
	}

	/**
	 * get the cost of tariff 33
	 * 
	 * @return tariff 33 cost in cents
	 */
	public Double getTariff33Cost() {
		return tariff33Cost;
	}

	/**
	 * Get the tariff 33 fee in cents
	 * 
	 * @return tariff 33 fee in cents
	 */
	public Double getTariff33Fee() {
		return tariff33Fee;
	}

	/****************************
	 * Setters
	 ****************************/

	/**
	 * Set the provider of the tariff rate
	 * 
	 * @param provider
	 *            - company that provides the electricity
	 * @throws TariffRateException
	 */
	public void setTariffProvider(String provider) throws TariffRateException {
		if (provider == null || provider.compareTo("") == 0) {
			throw new TariffRateException();
		}
		this.tariffProvider = provider;
	}

	/**
	 * Set the state the tariff is for
	 * 
	 * @param state
	 *            - location of the tariff (NSW, QLD, VIC...)
	 * @throws TariffRateException
	 */
public void setTariffState(String state) throws TariffRateException{
		
		List<String> goodStates = new ArrayList<String>();
		goodStates.add("QLD");
		goodStates.add("NSW");
		goodStates.add("VIC");
		goodStates.add("TAS");
		goodStates.add("NT");
		goodStates.add("SA");
		goodStates.add("WA");
		goodStates.add("ACT");
		
		if(state == null || state.compareTo("") == 0){
			throw new TariffRateException();
		}
		state = state.toUpperCase();
		
		if(!goodStates.contains(state)){
			throw new TariffRateException();
		}
		
		this.tariffState = state;
	}

	/**
	 * Set the rate/kwh for feeding in power
	 * 
	 * @param feedInFee
	 *            - c/kWh for feeding in power
	 * @throws TariffRateException
	 */
	public void setTariffFeedInFee(Double feedInFee) throws TariffRateException {

		if (feedInFee == null || feedInFee < 0) {
			throw new TariffRateException();
		}
		this.tariffFeedIn = feedInFee;
	}

	/**
	 * Set the cost per kwh for tariff 11
	 * 
	 * @param t11C
	 *            - cost of kwh in cents
	 * @throws TariffRateException
	 */
	public void setTariff11Cost(Double t11C) throws TariffRateException {
		if (t11C == null || t11C < 0) {
			throw new TariffRateException();
		}
		this.tariff11Cost = t11C;
	}

	/**
	 * Fee per day in cents for tariff 11
	 * 
	 * @param t11F
	 *            - fee of day in cents
	 * @throws TariffRateException
	 */
	public void setTariff11Fee(Double t11F) throws TariffRateException {
		if (t11F == null || t11F < 0) {
			throw new TariffRateException();
		}
		this.tariff11Fee = t11F;
	}

	/**
	 * Set the cost per kwh for tariff 33
	 * 
	 * @param t13C
	 *            - cost of kwh in cents
	 * @throws TariffRateException
	 */
	public void setTariff33Cost(Double t33C) throws TariffRateException {
		if (t33C == null || t33C < 0) {
			throw new TariffRateException();
		}
		this.tariff33Cost = t33C;
	}

	/**
	 * Fee per day in cents for tariff 33
	 * 
	 * @param t33F
	 *            - fee of day in cents
	 * @throws TariffRateException
	 */
	public void setTariff33Fee(Double t33F) throws TariffRateException {
		if (t33F == null || t33F < 0) {
			throw new TariffRateException();
		}
		this.tariff33Fee = t33F;
	}

	@Override
	public String toString() {
		return tariffProvider + " (" + tariffState + ")";
	}

	@Override
	public int compareTo(TariffRate arg0) {
		return this.toString().compareTo(arg0.toString());
	}
}
