package Exceptions;

public class EmptyDataSetException extends RuntimeException {
	public EmptyDataSetException() {
		super("Dataset supplied is empty!");
	}
}
