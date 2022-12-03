public class ChartData {
	private String chartName;
	private String verticalAxisName;
	private String horizontalAxisName;

	private String notes;

	public String getChartName() {
		return chartName;
	}

	public void setChartName(String chartName) {
		this.chartName = chartName;
	}

	public String getVerticalAxisName() {
		return verticalAxisName;
	}

	public void setVerticalAxisName(String verticalAxisName) {
		this.verticalAxisName = verticalAxisName;
	}

	public String getHorizontalAxisName() {
		return horizontalAxisName;
	}

	public void setHorizontalAxisName(String horizontalAxisName) {
		this.horizontalAxisName = horizontalAxisName;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public ChartData(String chartName, String verticalAxisName, String horizontalAxisName, String notes) {
		this.chartName = chartName;
		this.verticalAxisName = verticalAxisName;
		this.horizontalAxisName = horizontalAxisName;
		this.notes = notes;
	}
}
