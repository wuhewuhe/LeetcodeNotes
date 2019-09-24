package Google;

import java.util.stream.IntStream;

import org.junit.Test;

/**
 * @author he.wu You are a gardener and you take care of your plants. The plants
 *         are planted in a row and each of them needs a specific amount of
 *         water. You are about to water them using a watering can. To avoid
 *         mistakes like applying too much water, or not watering a plant at
 *         all, you have decided to:
 * 
 *         water the plants in the order in which they appear, from left to
 *         right; water each plant if you have sufficient water for it,
 *         otherwise refill your watering can; water each plant in one go, i.e.
 *         without taking a break to refill the watering can in the middle of
 *         watering a single plant. This means that you may sometimes have to
 *         refill your watering can before or after watering a plant, even
 *         though it's not completely empty. You start at the water container,
 *         which is positioned one step before the first plant. How many steps
 *         will you take, in order to water all the plants in the row? You must
 *         take one step to move to the next or the previous plant (all plants
 *         are positioned one step apart from each other).
 * 
 *         Given an array plants of n integers (for the amount of water needed
 *         by each plan) and the watering can capacity, return the number of
 *         steps needed to water all the plants.
 *
 * 
 *         Input: plants = [2, 4, 5, 1, 2], capacity = 6 Output: 17 Explanation:
 *         First you water plants[0] and plants[1] (2 steps). Then you have to
 *         go back to refill (2 steps) and water plants[2] and plants[3] (4
 *         steps). Then again you have to refill (4 steps) and water plants[4]
 *         (5 steps). So 2 + 2 + 4 + 4 + 5 = 17.
 * 
 * 
 *         Constraints:
 * 
 *         n is an integer within the range [1..1,000]; each element of array
 *         plants is an integer within the range [1..1,000,000]; capacity is an
 *         integer within the range [1..1,000,000,000]; the watering can is
 *         large enough to fully water any single plant.
 */
public class WateringFlowers {

	// capacity is large enough to full water any single plant
	public int steps(int[] flowers, int capacity) {
		if (flowers.length == 0 || flowers == null || capacity == 0)
			return 0;
		int count = 0;
		int can = capacity;
		for (int i = 0; i < flowers.length; i++) {
			if (can >= flowers[i]) {
				count++;
				can -= flowers[i];
			} else {
				count += (2 * i + 1);
				can = capacity - flowers[i];// refill a water and plant
			}
		}
		return count;
	}

	public int wateringPlantsSteps(int[] flowers, int capacity) {
		if (flowers == null || flowers.length == 0) {
			return 0;
		}
		int count = 0;
		int waterCapacity = capacity;
		for (int i = 0; i < flowers.length; i++) {
			if (waterCapacity < flowers[i]) {
				count += 2 * i;
				waterCapacity = capacity;
			}
			count++;
			waterCapacity = waterCapacity - flowers[i];
		}

		return count;
	}

	//if capacity not enough for a single plant
	public int WaterFlower(int[] flowers, int capacity) {
		if (flowers == null || flowers.length == 0)
			return 0;
		if (capacity == 0)
			return -1;
		int can = capacity;
		int count = 1;
		int i =0;
		while(IntStream.of(flowers).anyMatch(x -> x>=0)) {
			if (can < flowers[i]) {
				flowers[i] -= can;
				can = capacity;
				count += 2 * (i+1);
				flowers[i] -= can;
				can = flowers[i] < 0 ? Math.abs(flowers[i]) : 0;
			} else {
				i++;
				count++;
				flowers[i] -= can;
				can = flowers[i] < 0 ? Math.abs(flowers[i]) : 0;
			}
		}

		return count;
	}

	@Test
	public void test() {
		int[] flowers = { 2, 4, 5, 1, 2 };
		int capacity = 6;
		System.out.println(wateringPlantsSteps(flowers, capacity));
		int[] nums = { 14, 6 };
		System.out.println(WaterFlower(nums, capacity));
	}

}
