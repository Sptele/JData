import java.util.Arrays;

public class Statistics {
	private double average;
	private double range;
	private double min;
	private double max;

	public double getAverage() {
		return average;
	}

	public double getRange() {
		return range;
	}

	public double getMin() {
		return min;
	}

	public double getMax() {
		return max;
	}

	public Statistics(double[] data) {
		this.max = Arrays.stream(data).max().getAsDouble();
		this.min = Arrays.stream(data).min().getAsDouble();
		this.range = max - min;
		this.average = Arrays.stream(data).average().getAsDouble();

	}
}
