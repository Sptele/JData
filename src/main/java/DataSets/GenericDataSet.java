package DataSets;

import Exceptions.EmptyDataSetException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class GenericDataSet<T> {
	private T[] data;
	private final int length;

	private HashMap<T, Integer> frequency;

	public T get(int index) { return data[index]; }

	public int indexOf(T element) {
		int index = 0;
		for (T datum : data) {
			if (datum.equals(element)) return index;
			index++;
		}

		return -1;
	}

	public boolean contains(T element) {
		for (T datum : data) {
			if (element.equals(datum)) return true;
		}

		return false;
	}

	public int size() { return length; }

	public GenericDataSet<T> sorted(Comparator<T> comparator) {
		return new GenericDataSet<>((T[]) Arrays.stream(data).sorted(comparator).toArray());
	}

	public T[] toArray() { return data; }

	public GenericDataSet(T[] data) {
		if (data.length == 0) throw new EmptyDataSetException();

		this.data = data;
		this.length = data.length;

		frequency();
	}

	public HashMap<T, Integer> frequency() {
		if (frequency != null) return frequency;

		HashMap<T, Integer> freqs = new HashMap<>();

		for (T t : data) {
			freqs.put(t, freqs.getOrDefault(t, 0) + 1);
		}

		this.frequency = freqs;
		return freqs;
	}
}
