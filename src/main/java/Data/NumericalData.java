package Data;

import DataSets.NumericalDataSet;
import Exceptions.EmptyDataSetException;

import java.util.Arrays;
import java.util.Comparator;

public class NumericalData {

	/* Normal data */
	private double max;
	private double min;
	private double average;
	private double sum;
	private double range;

	/* Quartile Data */
	private double median;
	private double firstQuartile;
	private double thirdQuartile;
	private double interQuartileRange;

	public NumericalData(Double[] set) {
		if (set.length == 0) throw new EmptyDataSetException();

		this.max = Arrays.stream(set).max(Comparator.naturalOrder()).get();
		this.min = Arrays.stream(set).min(Comparator.naturalOrder()).get();
		this.sum = Arrays.stream(set).reduce(Double::sum).get();
		this.average = sum / set.length;
		this.range = max - min;

		set = Arrays.stream(set).sorted().toArray(Double[]::new);

		if (set.length % 2 == 0) { // even
			this.median = (set[set.length/2] + set[set.length/2 - 1])/2.0;
			int boundaryOne = set.length/2;
			int boundaryTwo = set.length/2;

			Double[] firstHalf = Arrays.copyOfRange(set, 0, boundaryOne);
			Double[] secondHalf = Arrays.copyOfRange(set, boundaryTwo, set.length);

			this.firstQuartile = findMedian(firstHalf);
			this.thirdQuartile = findMedian(secondHalf);


		} else { // odd
			this.median = set[set.length/2];
			int boundary = set.length/2;

			Double[] firstHalf = Arrays.copyOfRange(set, 0, boundary);
			Double[] secondHalf = Arrays.copyOfRange(set, boundary+1, set.length);

			this.firstQuartile = findMedian(firstHalf);
			this.thirdQuartile = findMedian(secondHalf);
		}

		this.interQuartileRange = thirdQuartile - firstQuartile;
	}

	private double findMedian(Double[] set) {
		return set.length % 2 == 0
				? (set[set.length/2] + set[set.length/2 - 1])/2.0
				: set[set.length/2];
	}

	public NumericalData(NumericalDataSet set) {
		this(set.toArray());
	}

	public double getMax() {
		return max;
	}

	public double getMin() {
		return min;
	}

	public double getAverage() {
		return average;
	}

	public double getSum() {
		return sum;
	}

	public double getRange() {
		return range;
	}

	public double getMedian() {
		return median;
	}

	public double getFirstQuartile() {
		return firstQuartile;
	}

	public double getThirdQuartile() {
		return thirdQuartile;
	}

	public double getInterQuartileRange() {
		return interQuartileRange;
	}
}
