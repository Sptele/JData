public class Main {
	public static void main(String[] args) {
		DataSet set = new DataSet(new double[] {0, 2.1, 3, 4, 2, 4, 2, 3, 2, 1, 4, 5, 3, 2.1, 3, 10,10,10,10,10,10,10,10,10, 10, 1000});
		GraphingEngine.histogram(set, new ChartData("Random DataSet lmao", "", "Minutes", "Cool!"));
	}
}
