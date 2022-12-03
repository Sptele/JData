import Exceptions.EmptyDataSetException;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class DataSet {
	private double[] data;
	private final int length;
	private Statistics stats;

	public DataSet getSorted() {
		return new DataSet(Arrays.stream(data).sorted().toArray());
	}

	public double get(int index) {
		return data[index];
	}

	public double[] toArray() {
		return data;
	}

	public Double[] toObjectArray() {
		return Arrays.stream(data).boxed().toArray(Double[]::new);
	}

	public Statistics stats() {
		return stats;
	}

	public DataSet(double[] data) {
		if (data.length == 0) throw new EmptyDataSetException();

		this.data = data;
		this.length = data.length;
		this.stats = new Statistics(data);
	}

	public HashMap<Double, Integer> frequency() {
		HashMap<Double, Integer> freqs = new HashMap<>();

		for (double num : data) {
			freqs.put(num, freqs.getOrDefault(num, 0) + 1);
		}

		return freqs;
	}

	public int size() {
		return length;
	}
}
