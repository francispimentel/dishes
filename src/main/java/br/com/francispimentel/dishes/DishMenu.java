package br.com.francispimentel.dishes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DishMenu {

	private Map<DishType, List<DishOption>> availableDishes;

	public DishMenu() {
		setupAvailableDishes();
	}

	private void setupAvailableDishes() {
		List<DishOption> morningDishes = new ArrayList<>();
		List<DishOption> nightDishes = new ArrayList<>();

		morningDishes.add(new DishOption("eggs", 1, 1));
		morningDishes.add(new DishOption("toast", 2, 1));
		morningDishes.add(new DishOption("coffee", 3, null));

		nightDishes.add(new DishOption("steak", 1, 1));
		nightDishes.add(new DishOption("potato", 2, null));
		nightDishes.add(new DishOption("wine", 3, 1));
		nightDishes.add(new DishOption("cake", 4, 1));

		availableDishes = new ConcurrentHashMap<>();
		availableDishes.put(DishType.MORNING, morningDishes);
		availableDishes.put(DishType.NIGHT, nightDishes);
	}

	public DishOption checkDishAvailability(DishType type, Integer dishCode) {
		List<DishOption> availableOptions = availableDishes.get(type);

		if (availableOptions == null) {
			return null;
		}
		
		for (DishOption option : availableOptions) {
			if (option.getDishCode().equals(dishCode)) {
				return option;
			}
		}

		return null;
	}
}
