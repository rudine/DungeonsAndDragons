package basic.monsters;

import static basic.ruleobjects.AbilityTypes.CHA;
import static basic.ruleobjects.Skill.Intimidation;

import basic.attacktypes.MeleeAttack;
import basic.attacktypes.MeleeAttackBuilder;
import basic.attacktypes.RangedAttack;
import basic.attacktypes.RangedAttackBuilder;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.Alignment;
import basic.ruleobjects.DamageType;
import basic.ruleobjects.modifiers.SkillModifier;
import basic.services.DiceService;

public class Thug extends AbstractEnemy {
	
	public Thug() {
		setAlive(true);
		setAC(11);
		setHitpoints(DiceService.throwD8(5) + 10);
		setSpeed("30 feet, 6 vakjes");
		setAbilityScores(new AbilityScores(15, 11, 14, 10, 10, 11));
		setAttacks();
		setAttacksOnAttackAction(2);
		addToSkills(new SkillModifier(2, Intimidation, CHA));
		setAlignment(Alignment.AnyNonGood);
	}
	
	protected void setAttacks() {
		addMaceAttack();
		addHeavyCrossbowAttack();
	}

	protected void addHeavyCrossbowAttack() {
		RangedAttackBuilder rangedBuilder = new RangedAttackBuilder();
		RangedAttack heavyCrossbow = rangedBuilder.setWeaponName("Heavy Crossbow")//
				.setBaseDamage(0)//
				.setRange("100/400 ft.")//
				.setToHit(2)
				.setDamageDie(10)//
				.setTimesToThrowDamageDie(1)//
				.setDamageType(DamageType.PIERCING)//
				.build();
		addToAvailableAttacks(heavyCrossbow);
	}

	protected void addMaceAttack() {
		MeleeAttackBuilder meleeBuilder = new MeleeAttackBuilder();
		MeleeAttack mace = meleeBuilder.setWeaponName("Mace") //
					.setBaseDamage(2)
					.setToHit(4)//
					.setDamageDie(6)//
					.setTimesToThrowDamageDie(1)//
					.setDamageType(DamageType.BLUDGEONING)//
					.build();
		addToAvailableAttacks(mace);
	}
}
