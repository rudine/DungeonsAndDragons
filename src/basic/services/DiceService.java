package basic.services;

import java.util.Random;

public class DiceService {

	private static Random die = new Random();
	
	public static int throwD20WithAdvantage() {
		int throwD20 = throwD20(1);
		int throwD20Again = throwD20(1);
		return throwD20 >= throwD20Again ? throwD20 : throwD20Again;
	}

	public static int throwD20WithDisAdvantage() {
		int throwD20 = throwD20(1);
		int throwD20Again = throwD20(1);
		return throwD20 <= throwD20Again ? throwD20 : throwD20Again;
	}
	
	public static int throwDice(int times, int sides) {
		int result = 0;
		for (int i = 0; i < times; i++) {
			result += (1 + die.nextInt(sides));
		}
		return result;
	}

	public static int throwD4(int times) {
		return throwDice(times, 4);
	}
	
	public static int throwD6(int times) {
		return throwDice(times, 6);
	}

	public static int throwD8(int times) {
		return throwDice(times, 8);
	}
	
	public static int throwD10(int times) {
		return throwDice(times, 10);
	}
	
	public static int throwD12(int times) {
		return throwDice(times, 12);
	}

	public static int throwD20(int times) {
		return throwDice(times, 20);
	}
	
	public static int throwD100(int times) {
		return throwDice(times, 100);
	}
}
