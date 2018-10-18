package basic.attack.types;

import basic.attack.Attack;
import basic.ruleobjects.Range;
import basic.ruleobjects.SavingThrow;
import basic.services.DiceService;

public class SpecialAttack extends Attack {
	
	private String areaOfEffect;
	private SavingThrow save;
	private boolean halfDamageWhenSaveMade;
	private boolean recharge = false;
	private boolean available = false;
	private int availabilityDie;
	private Range succesRange = new Range(0,0);	
	
	public SpecialAttack() {
	}

	public String getAreaOfEffect() {
		return areaOfEffect;
	}

	public void setAreaOfEffect(String areaOfEffect) {
		this.areaOfEffect = areaOfEffect;
	}

	public SavingThrow getSave() {
		return save;
	}

	public void setSave(SavingThrow save) {
		this.save = save;
	}

	public boolean isHalfDamageWhenSaveMade() {
		return halfDamageWhenSaveMade;
	}

	public void setHalfDamageWhenSaveMade(boolean halfDamageWhenSaveMade) {
		this.halfDamageWhenSaveMade = halfDamageWhenSaveMade;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public void useAttack() {
		this.available = false;
	}
	
	public int getAvailabilityDie() {
		return availabilityDie;
	}

	public void setAvailabilityDie(int availabilityDie) {
		this.availabilityDie = availabilityDie;
	}

	public Range getSuccesRange() {
		return succesRange;
	}

	public void setSuccesRange(Range succesRange) {
		this.succesRange = succesRange;
	}
	
	public boolean hasRecharge() {
		return recharge;
	}

	public void setRecharge(boolean recharge) {
		this.recharge = recharge;
	}

	public void recharge() {
		if(recharge && !available) {
			int throwDie = DiceService.throwDice(1, availabilityDie);
			System.out.println("Thrown for recharge: " + throwDie);
			if(succesRange.contains(throwDie)) {
				available = true;
			}
		}
	}
}
