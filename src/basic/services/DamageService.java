package basic.services;

import basic.attacktypes.Attack;
import basic.attacktypes.MeleeAttack;
import basic.attacktypes.RangedAttack;
import basic.attacktypes.SpecialAttack;
import gui.components.AttackText;

public class DamageService {

	public static int subtractDoubleDamageFromHitpoints(int hitpoints, int damage) {
		damage = damage * 2;
		return hitpoints -= damage;
	}

	public static int subtractHalfDamageFromHitpoints(int hitpoints, int damage) {
		damage = (int) Math.floor(damage / 2.0);
		return hitpoints -= damage;
	}

	public static int getAttackDamage(int sidesOfDie, int timesDieThrown, int baseDamage, boolean critical) {
		int throwDie = DiceService.throwDice(timesDieThrown, sidesOfDie);
		if (critical)
			throwDie *= 2;
		return baseDamage + throwDie;
	}

	public static AttackText getAttackText(Attack attack, boolean advantage, boolean disadvantage) {
		ThrownD20 rollForHit = rollD20WithToHit(attack.getToHit(), advantage, disadvantage);
		StringBuilder textBuilder = new StringBuilder();
		textBuilder.append(attack.getWeaponName() + " -- ");
		textBuilder.append("To hit: " + rollForHit.getResult());
		textBuilder.append(".  ");
		textBuilder.append("Damage: " + getAttackDamage(attack.getDamageDie(), attack.getTimesToThrowDamageDie(),
				attack.getBaseDamage(), rollForHit.isCritical()));
		textBuilder.append("  ");
		textBuilder.append(attack.getType().toString());
		textBuilder.append(".  ");
		textBuilder.append("Targets: " + attack.getNumberOfTargets());
		textBuilder.append(".  ");
		if(attack instanceof MeleeAttack)
			textBuilder.append("Reach: " + ((MeleeAttack)attack).getReach());
		if(attack instanceof RangedAttack)
			textBuilder.append("Range: " + ((RangedAttack)attack).getRange());
		if(!attack.getDescription().isEmpty())
			textBuilder.append(". " + attack.getDescription());

		return new AttackText(textBuilder.toString(), rollForHit.isCritical());
	}
	
	public static String getSpecialAttackText(SpecialAttack attack) {
		StringBuilder textBuilder = new StringBuilder();
		textBuilder.append(attack.getWeaponName() + " -- ");
		textBuilder.append(attack.getSave().toString());
		textBuilder.append(". ");
		textBuilder.append("Damage: " + getAttackDamage(attack.getDamageDie(), attack.getTimesToThrowDamageDie(),
				attack.getBaseDamage(), false));
		textBuilder.append("  ");
		textBuilder.append(attack.getType().toString());
		textBuilder.append(". Area of Effect: " + attack.getAreaOfEffect());
		textBuilder.append(". ");
		String halfOrNoDamage = attack.isHalfDamageWhenSaveMade() ? "Half damage on save." : "No damage on save.";
		textBuilder.append(halfOrNoDamage);
		return textBuilder.toString();
	}

	private static ThrownD20 rollD20WithToHit(int toHit, boolean advantage, boolean disadvantage) {
		if (advantage) {
			int result = DiceService.throwD20WithAdvantage();
			return new ThrownD20(result + toHit, result == 20);
		} else if (disadvantage) {
			int result = DiceService.throwD20WithDisAdvantage();
			return new ThrownD20(result + toHit, result == 20);
		}
		int result = DiceService.throwD20(1);
		return new ThrownD20(result + toHit, result == 20);
	}
}
