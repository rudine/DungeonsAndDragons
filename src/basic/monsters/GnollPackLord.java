package basic.monsters;

import basic.attack.DamageComponent;
import basic.attack.types.MeleeAttack;
import basic.attack.types.SpecialAttack;
import basic.attack.types.builders.MeleeAttackBuilder;
import basic.attack.types.builders.SpecialAttackBuilder;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.AbilityTypes;
import basic.ruleobjects.DamageType;
import basic.ruleobjects.Range;
import basic.ruleobjects.SavingThrow;
import basic.services.DiceService;

public class GnollPackLord extends Gnoll implements PreparesForNextTurn {

	public GnollPackLord() {
		setHitpoints(DiceService.throwD8(9) + 9);
		setAbilityScores(new AbilityScores(16, 14, 13, 8, 11, 9));
		getAvailableAttacks().clear();
		setAttacks();
		setAttacksOnAttackAction(2);
		setSpecialAttacks();
		setSpecialAttacksOnAction(1);
	}
	
	@Override
	protected void setAttacks() {
		addLongbowAttack(this.getAbilityScores().getDexterityModifier());
		addGlaiveAttack();
	}
	
	protected void addGlaiveAttack() {
		MeleeAttackBuilder glaiveBuilder = new MeleeAttackBuilder();
		MeleeAttack glaive = glaiveBuilder.setWeaponName("Glaive")//
				.setToHit(5)//
				.addDamageComponent(new DamageComponent(1, 10, 3, DamageType.SLASHING))//
				.build();
		addToAvailableAttacks(glaive);
	}
	
	private void setSpecialAttacks() {
		SpecialAttackBuilder InciteBuilder = new SpecialAttackBuilder();
		SpecialAttack inciteRampage = InciteBuilder.setAreaOfEffect("1 cr. with rampage within 30ft.")//
				.addDamageComponent(new DamageComponent(0, 8, 0, DamageType.MAGIC))// FIXME this is a special action, not an attack
				.setSavingThrow(new SavingThrow(0, AbilityTypes.DEX))//
				.setHalfDamageWhenSaved(false)//
				.setWeaponName("Incite Rampage")//
				.setDescription(inciteRampageDescription())//
				.setRecharge(true)//
				.setAvailable(true)//
				.setAvailabilityDie(6)//
				.setSuccesRange(new Range(5, 6))//
				.build();
		addToSpecialAttacks(inciteRampage);
	}
	
	private String inciteRampageDescription() {
		return "The gnoll can use this next to its 2 attacks. 1 creature that the gnoll can see"
				+ " within 30ft. of it can use its reaction to make a melee attack if it can hear"
				+ " the gnoll and has the rampage feat.";
	}

	@Override
	public void prepareForNextTurn() {
		specialAttacks.stream().filter(a -> a.hasRecharge()).forEach(a -> a.recharge());
	}
}

