package cConverter;

//conversion to Rupee
abstract class Rupee implements CC {
	protected static int convert(Double value) {
			return (int)(value*74.733891);
	}
}