package br.com.francispimentel.dishes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Dishes {

	private static final DishMenu MENU = new DishMenu();

	public String orderDishes(String input) {
		String[] orderStr = input.split(",");

		DishType type = DishType.getType(orderStr[0]);

		if (type == null) {
			return "error";
		}

		boolean showError = false;

		Map<DishOption, Integer> order = new ConcurrentHashMap<>();
		for (int i = 1; i < orderStr.length; i++) {
			if (!addOrderItem(order, type, orderStr[i])) {
				showError = true;
			}
		}

		return generateOutput(order, showError);
	}

	private boolean addOrderItem(Map<DishOption, Integer> order, DishType type, String code) {
		Integer dishCode;
		try {
			dishCode = Integer.parseInt(code.trim());
		} catch (NumberFormatException e) {
			return false;
		}
		DishOption option = MENU.checkDishAvailability(type, dishCode);
		if (option == null) {
			return false;
		}

		Integer amount = order.get(option);
		if (amount != null && option.getAmountLimit() != null && option.getAmountLimit() <= amount) {
			return false;
		}

		order.put(option, amount == null ? 1 : amount + 1);
		return true;
	}

	private String generateOutput(Map<DishOption, Integer> order, boolean showError) {
		List<DishOption> orderedOutput = new ArrayList<>(order.keySet());
		Collections.sort(orderedOutput, new Comparator<DishOption>() {

			@Override
			public int compare(DishOption o1, DishOption o2) {
				return o1.getDishCode().compareTo(o2.getDishCode());
			}
		});

		StringBuffer output = new StringBuffer();
		for (DishOption dish : orderedOutput) {
			if (output.length() > 0) {
				output.append(", ");
			}
			output.append(dish.getName());
			int amount = order.get(dish);

			if (amount > 1) {
				output.append(String.format("(x%d)", amount));
			}
		}

		if (showError) {
			output.append(", error");
		}

		return output.toString();
	}

}
