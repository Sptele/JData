import DataSets.GenericDataSet;
import DataSets.NumericalDataSet;

public class Main {
	public static void main(String[] args) {
		NumericalDataSet set = new NumericalDataSet(new double[] {0, 2.1, 3, 4, 2, 4, 2, 3, 2, 1, 4, 5, 3, 2.1, 3, 10,10,10,10,10,10,10,10,10, 10, 1000});
		GraphingEngine.histogram(set, new ChartData("Random DataSet lmao", "Frequency", "Minutes", "Cool!"));

		GenericDataSet<String> strData = new GenericDataSet<>(new String[]{"John", "John", "Jack", "Jill", "Jill"});
		GraphingEngine.histogram(strData, new ChartData("Random DataSet lmao", "", "Minutes", "Cool!"));
	}
}
