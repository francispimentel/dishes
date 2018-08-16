package br.com.francispimente.dishes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.francispimentel.dishes.Dishes;

public class DishesTest {

	private Dishes dishes;

	@Before
	public void setup() {
		dishes = new Dishes();
	}

	@Test
	public void shouldShowSameOutputRegardlessOfInputOrder() {
		Assert.assertEquals("eggs, toast, coffee", dishes.orderDishes("morning, 1, 2, 3"));
		Assert.assertEquals("eggs, toast, coffee", dishes.orderDishes("morning, 2, 1, 3"));
		Assert.assertEquals("steak, potato, wine, cake", dishes.orderDishes("night, 1, 2, 3, 4"));
		Assert.assertEquals("steak, potato, wine, cake", dishes.orderDishes("night, 4, 2, 1, 3"));
	}
	
	@Test
	public void shouldAcceptRepeatedDishesForPotatoOrCoffee() {
		Assert.assertEquals("eggs, toast, coffee(x3)", dishes.orderDishes("morning, 1, 2, 3, 3, 3"));
		Assert.assertEquals("steak, potato(x2), cake", dishes.orderDishes("night, 1, 2, 2, 4"));
		Assert.assertEquals("eggs, toast, coffee(x4)", dishes.orderDishes("morning, 3, 1, 2, 3, 3, 3"));
	}
	
	@Test
	public void shouldShowErrorWhenChoosingUnavailableOption() {
		Assert.assertEquals("eggs, toast, coffee, error", dishes.orderDishes("morning, 1, 2, 3, 4"));
		Assert.assertEquals("steak, potato, error", dishes.orderDishes("night, 1, 2, 5"));
	}
}
