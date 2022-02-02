package cConverter;

//conversion to USD
abstract class usD implements CC{
	protected static Double convert(Double value) {
			return (value*0.01333801);
	}
}