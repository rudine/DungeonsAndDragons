package basic.monsters;

import basic.attack.DamageComponent;
import basic.attack.types.MeleeAttack;
import basic.attack.types.SpecialAttack;
import basic.attack.types.builders.MeleeAttackBuilder;
import basic.attack.types.builders.SpecialAttackBuilder;
import basic.monsters.interfaces.PreparesForNextTurn;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.AbilityTypes;
import basic.ruleobjects.DamageType;
import basic.ruleobjects.Range;
import basic.ruleobjects.SavingThrow;
import basic.services.DiceService;

public class Ankheg extends AbstractEnemy implements PreparesForNextTurn{

	public Ankheg() {
		setAC(14);
		setHitpoints(DiceService.throwD10(6) + 6);
		setSpeed("30 ft. burrow 10 ft.");
		setAbilityScores(new AbilityScores(17, 11, 13, 1, 13, 6));
		setAttacksOnAttackAction(1);
		setAttacks();
		setSpecialAttacksOnAction(1);
		setSpecialAttacks();
	}
	
	private void setAttacks() {
		MeleeAttackBuilder biteBuilder = new MeleeAttackBuilder();
		MeleeAttack bite = biteBuilder.setWeaponName("Bite") //
					.setToHit(5)//
					.addDamageComponent(new DamageComponent(2, 6, 3, DamageType.SLASHING))//
					.addDamageComponent(new DamageComponent(1, 6, 0, DamageType.ACID))//
					.setDescription("If the target is a Large or smaller cr., it is grappled (escape DC13) until grapple ends ankheg can bite only the grappled creature and has adv on attack rolls to do so")//
					.build();
		addToAvailableAttacks(bite);
	}
	
	private void setSpecialAttacks() {
		SpecialAttackBuilder AOEBuilder = new SpecialAttackBuilder();
		SpecialAttack acidSpray = AOEBuilder.setAreaOfEffect("30 ft long line, 5ft. wide")//
				.addDamageComponent(new DamageComponent(3, 6, 0, DamageType.ACID))//
				.setSavingThrow(new SavingThrow(13, AbilityTypes.DEX))//
				.setHalfDamageWhenSaved(true)//
				.setWeaponName("Acid spray")//
				.setDescription(getAcidSprayText())//
				.setRecharge(true)//
				.setAvailable(true)//
				.setAvailabilityDie(6)//
				.setSuccesRange(new Range(6, 6))//
				.build();
		addToSpecialAttacks(acidSpray);
	}
	
	private String getAcidSprayText() {
		return "It spits acid provided that it has no creature grappled."
				+ " Each creature in the line must make a DC13 dex save"
				+ " taking the full dmg on a failed save and 1/2 on a success.";
	}

	@Override
	public void prepareForNextTurn() {
		specialAttacks.stream().filter(a -> a.hasRecharge()).forEach(a -> a.recharge());
	}
}
