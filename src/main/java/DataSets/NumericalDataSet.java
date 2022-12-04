package DataSets;

import Data.NumericalData;

import java.util.Arrays;
import java.util.Comparator;

public class NumericalDataSet extends GenericDataSet<Double> {

	private NumericalData data;

	@Override
	public GenericDataSet<Double> sorted(Comparator<Double> comparator) {
		return super.sorted(Comparator.naturalOrder());
	}

	public NumericalDataSet(double[] data) {
		super(Arrays.stream(data).boxed().toArray(Double[]::new));

		this.data = new NumericalData(Arrays.stream(data).boxed().toArray(Double[]::new));
	}

	public NumericalDataSet(Double[] data) {
		super(data);

		this.data = new NumericalData(data);
	}

	public NumericalData data() {
		return data;
	}
}
