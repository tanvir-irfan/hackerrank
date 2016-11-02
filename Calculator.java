package edu.tanvir.irfan;

public class Calculator {

	interface IntegerMath {
		int operation(int a, int b);
	}

	interface Negation {
		int negate(int num);
	}

	public int operateBinary(int a, int b, IntegerMath op) {
		return op.operation(a, b);
	}

	public int operateNegation(int a, Negation op) {
		return op.negate(a);
	}

	public static void main(String... args) {

		Calculator myApp = new Calculator();
		IntegerMath addition = (int a, int b) -> a + b; // data type can be
														// omitted.
		IntegerMath subtraction = (a, b) -> a - b;
		Negation negation = a -> {
			return -a;
		};
		System.out.println("40 + 2 = " + myApp.operateBinary(40, 2, addition));
		System.out.println("40 + 2 = " + myApp.operateBinary(40, 2, (a, b) -> a + b));
		System.out.println("20 - 10 = " + myApp.operateBinary(20, 10, subtraction));
		System.out.println("Negation of -20 = " + myApp.operateNegation(-20, negation));
	}
}