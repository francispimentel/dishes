package br.com.francispimentel.dishes;

public class DishOption {

	private String name;

	private Integer dishCode;

	private Integer amountLimit;

	public DishOption(String name, Integer dishCode, Integer amountLimit) {
		this.name = name;
		this.dishCode = dishCode;
		this.amountLimit = amountLimit;
	}

	public String getName() {
		return name;
	}

	public Integer getDishCode() {
		return dishCode;
	}

	public Integer getAmountLimit() {
		return amountLimit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amountLimit == null) ? 0 : amountLimit.hashCode());
		result = prime * result + ((dishCode == null) ? 0 : dishCode.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
}
