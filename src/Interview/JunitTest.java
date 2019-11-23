package Interview;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class JunitTest {

	PartitionList test;

	@Test
	public void test1() {
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
		int k = 2;
		List<List<Integer>> result = PartitionList.PartitionList(nums, k);
		List<List<Integer>> test = new ArrayList<List<Integer>>();
		test.add(Arrays.asList(1, 2));
		test.add(Arrays.asList(3, 4));
		test.add(Arrays.asList(5));
		assertEquals(test, result);
	}

	@Test
	public void test2() {
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
		int k = 3;
		List<List<Integer>> result = PartitionList.PartitionList(nums, k);
		List<List<Integer>> test = new ArrayList<List<Integer>>();
		test.add(Arrays.asList(1, 2, 3));
		test.add(Arrays.asList(4, 5));
		assertEquals(test, result);
	}

}
