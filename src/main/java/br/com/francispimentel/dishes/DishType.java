package br.com.francispimentel.dishes;

public enum DishType {
	MORNING("morning"), NIGHT("night");

	private String name;

	private DishType(String name) {
		this.name = name;
	}

	public static DishType getType(String name) {
		for (DishType type : values()) {
			if (type.name.equalsIgnoreCase(name)) {
				return type;
			}
		}
		return null;
	}
}
