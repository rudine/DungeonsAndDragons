package basic.services;

import java.util.List;
import java.util.OptionalDouble;

public class StandardRulesService {
	
	public static int determineDMInitiative(List<Integer> dexterities) {
		OptionalDouble avg = dexterities.stream().mapToDouble(a ->a).average();
		Double average = avg.isPresent() ? avg.getAsDouble() : 0;
		return average.intValue() + DiceService.throwD20(1);
	}
	
	public static int getAbilityModifier(int score) {
		if(score >= 1 && score <= 30) {
			return (int)(Math.ceil((score - 10)/2));
		}
		else {
			throw new IllegalArgumentException("Score moet tussen 1 en 30 liggen");
		}
	}
}
