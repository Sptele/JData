import DataSets.GenericDataSet;
import DataSets.NumericalDataSet;

import java.util.TreeMap;

public class GraphingEngine {

	public static final int Y_LENGTH = 20;
	public static final int X_LENGTH = 20;

	// █
	public static final String CHARACTER_TO_PRINT = "█";
	public static int PRECISION = 1;

	public static int BOX_PLOT_HEIGHT = 5;

	public static <T> void histogram(GenericDataSet<T> set, ChartData data) {
		boolean numeric = set instanceof NumericalDataSet;

		TreeMap<T, Integer> freqs = new TreeMap<>(set.frequency());

		T[] keys = (T[]) freqs.keySet().toArray(Object[]::new);
		Integer[] values = freqs.values().toArray(Integer[]::new);

		System.out.println("\t\t" + data.getChartName());

		int maxFreq = freqs.values().stream().max(Integer::compareTo).get();
		int maxFreqLength = (maxFreq+"").length();

		System.out.println(" \t" + " ".repeat(maxFreqLength-1) + "  _");
		for (int i = maxFreq; i > 0; i--) {
			System.out.print(
					maxFreq-i >= data.getVerticalAxisName().length()
							? " \t"
							: data.getVerticalAxisName().charAt(maxFreq-i) + "\t"
			);

			System.out.printf(
					maxFreqLength != (i+"").length()
							? "0".repeat(maxFreqLength-1) + "%d |"
							: "%d |"
					, i);

			for (int j = 0; j < keys.length; j++) {
				T value = keys[j];
				int freq = values[j];

				int valueDigits = numeric
						? String.format("%." + PRECISION + "f", value).length()
						: value.toString().length();

				System.out.print(
						freq >= i
								? " " + CHARACTER_TO_PRINT.repeat(valueDigits) + " "
								: "  " + " ".repeat(valueDigits)
				);
			}

			System.out.println();
		}


		System.out.print(" \t" + "0".repeat(maxFreqLength-1) + "0 +");

		for (T value : keys) {
			int valueDigits = numeric
					? String.format("%." + PRECISION + "f", value).length()
					: value.toString().length();

			System.out.print("--" + "-".repeat(valueDigits));
		}


		System.out.print("|\n \t" + " ".repeat(maxFreqLength-1) + "   ");
		if (numeric) {
			for (T value : keys) {
				System.out.printf(" %." + PRECISION + "f ", value);
			}
		} else {
			for (T value : keys) {
				System.out.print(" " + value + " ");
			}
		}

		System.out.println("\n\n\t\t" + data.getHorizontalAxisName());
	}

	public static void boxplot(NumericalDataSet set, ChartData data) {
		System.out.println("\t\t" + data.getChartName());

		for (int i = 0; i < BOX_PLOT_HEIGHT; i++) {
			for (int j = 0; j < (set.data().getRange() + 2) / X_LENGTH; j++) {
				// TODO complete me
			}
		}
	}
}
