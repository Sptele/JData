import Data.NumericalData;
import DataSets.NumericalDataSet;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumericalDataTest {
	NumericalData createExpected(double[] set) {
		return new NumericalData(new NumericalDataSet(set));
	}

	@Test
	void quartilesLargeOdd() {
		NumericalData data = createExpected(new double[] { 1, 2, 3, 4, 5, 6, 7});

		assertEquals(data.getMedian(), 4);
		assertEquals(data.getFirstQuartile(), 2);
		assertEquals(data.getThirdQuartile(), 6);
	}

	@Test
	void quartilesSmallOdd() {
		NumericalData data = createExpected(new double[] { 1, 2, 3 });

		assertEquals(data.getMedian(), 2);
		assertEquals(data.getFirstQuartile(), 1);
		assertEquals(data.getThirdQuartile(), 3);
	}

	@Test
	void quartilesLargeEven() {
		NumericalData data = createExpected(new double[] {1, 2, 3, 4, 5, 6, 7, 8});

		assertEquals(data.getMedian(), 4.5);
		assertEquals(data.getFirstQuartile(), 2.5);
		assertEquals(data.getThirdQuartile(), 6.5);
	}

	@Test
	void quartilesSmallEven() {
		NumericalData data = createExpected(new double[] {1, 2, 3, 4});

		assertEquals(data.getMedian(), 2.5);
		assertEquals(data.getFirstQuartile(), 1.5);
		assertEquals(data.getThirdQuartile(), 3.5);
	}

	@Test
	void quartilesUnordered() {
		NumericalData data = createExpected(new double[] {4, 2, 5, 3, 1, 7, 6, 8});

		assertEquals(data.getMedian(), 4.5);
		assertEquals(data.getFirstQuartile(), 2.5);
		assertEquals(data.getThirdQuartile(), 6.5);
	}

	@Test
	void quartilesRandom() {
		// 1, 2, 3, 7, 8, 11, 14
		NumericalData data = createExpected(new double[] {3, 7, 8, 1, 2, 11, 14});

		assertEquals(data.getMedian(), 7);
		assertEquals(data.getFirstQuartile(), 2);
		assertEquals(data.getThirdQuartile(), 11);
	}

	@Test
	void quartilesDuplicate() {
		// 1, 2, 2, 4, 6, 7, 7
		NumericalData data = createExpected(new double[] {4, 6, 2, 2, 1, 7, 7});

		assertEquals(data.getMedian(), 4);
		assertEquals(data.getFirstQuartile(), 2);
		assertEquals(data.getThirdQuartile(), 7);
	}
}
