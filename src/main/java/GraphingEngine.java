import java.util.TreeMap;

public class GraphingEngine {

	public static final int Y_LENGTH = 20;
	public static final int X_LENGTH = 20;

	// █
	public static final String CHARACTER_TO_PRINT = "█";
	public static int PRECISION = 1;

	public static void histogram(DataSet set, ChartData data) {
		set = set.getSorted();

		TreeMap<Double, Integer> freqs = new TreeMap<>(set.frequency());

		Double[] keys = freqs.keySet().toArray(Double[]::new);
		Integer[] values = freqs.values().toArray(Integer[]::new);

		System.out.println("\t\t" + data.getChartName());

		int maxFreq = freqs.values().stream().max(Integer::compareTo).get();
		int maxFreqLength = (maxFreq+"").length();

		System.out.println(" ".repeat(maxFreqLength-1) + "  _");
		for (int i = maxFreq; i > 0; i--) {
			System.out.printf(
					maxFreqLength != (i+"").length()
							? "0".repeat(maxFreqLength-1) + "%d |"
							: "%d |"
					, i);

			for (int j = 0; j < keys.length; j++) {
				double value = keys[j];
				int freq = values[j];

				int valueDigits = String.format("%." + PRECISION + "f", value).length();

				System.out.print(
						freq >= i
								? " " + CHARACTER_TO_PRINT.repeat(valueDigits) + " "
								: "  " + " ".repeat(valueDigits)
				);
			}

			System.out.println();
		}


		System.out.printf("0".repeat(maxFreqLength-1) + "0 +");

		for (double value : keys) {
			int valueDigits = String.format("%." + PRECISION + "f", value).length();

			System.out.print("--" + "-".repeat(valueDigits));
		}


		System.out.print("|\n   " + " ".repeat(maxFreqLength-1));
		for (double value : keys) {
			System.out.printf(" %." + PRECISION + "f ", value);
		}

		System.out.println("\n\n\t\t" + data.getHorizontalAxisName());




	}
}
