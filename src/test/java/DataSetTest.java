import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataSetTest {

	private HashMap<Double, Integer> createExpected(double[] values, int[] frequencies) {
		HashMap<Double, Integer> hm = new HashMap<>();
		for (int i = 0; i < Math.min(values.length, frequencies.length); i++) {
			hm.put(values[i], frequencies[i]);
		}

		return hm;
	}

	@Test
	void frequencyThree() {
		assertEquals(createExpected(new double[]{1, 2, 3, 4, 5, 6}, new int[]{1, 1, 1, 1, 1, 1}), new DataSet(new double[] {1, 2, 3, 4, 5, 6}).frequency());
	}

	@Test
	void frequencyOne() {
		assertEquals(createExpected(new double[]{4, 5}, new int[]{1, 3}), new DataSet(new double[] {4, 5, 5, 5}).frequency());
	}

	@Test
	void frequencyTwo() {
		assertEquals(createExpected(new double[]{1}, new int[]{5}), new DataSet(new double[] {1, 1, 1, 1, 1}).frequency());
	}

	@Test
	void frequencyThreeUnsorted() {
		assertEquals(createExpected(new double[]{1, 2, 3, 7}, new int[]{2, 1, 2, 1}), new DataSet(new double[] {1, 2, 1, 3, 7, 3}).frequency());
	}
}
