package basic.monsters;

import static basic.monsters.specialabilities.SpecialAbility.KeenSmell;
import static basic.monsters.specialabilities.SpecialAbility.PackTactics;
import static basic.monsters.specialabilities.SpecialAbility.Pounce;
import static basic.monsters.specialabilities.SpecialAbility.RunningLeap;
import static basic.ruleobjects.AbilityTypes.DEX;
import static basic.ruleobjects.AbilityTypes.WIS;
import static basic.ruleobjects.Skill.Perception;
import static basic.ruleobjects.Skill.Stealth;

import basic.attack.DamageComponent;
import basic.attack.types.MeleeAttack;
import basic.attack.types.builders.MeleeAttackBuilder;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.DamageType;
import basic.ruleobjects.modifiers.SkillModifier;
import basic.services.DiceService;

public class Lion extends AbstractEnemy {
	
	public Lion() {
		setAlive(true);
		setAC(12);
		setHitpoints(DiceService.throwD10(4) + 4);
		setSpeed("50 feet, 10 vakjes");
		setAbilityScores(new AbilityScores(17, 15, 13, 3, 12, 8));
		addToSpecialAbilities(KeenSmell, Pounce, RunningLeap, PackTactics);
		setAttacks();
		setAttacksOnAttackAction(1);
		addToSkills(new SkillModifier(5, Perception, WIS), new SkillModifier(4, Stealth, DEX));
	}

	@Override
	protected void setAttacks() {
		MeleeAttackBuilder biteBuilder = new MeleeAttackBuilder();
		MeleeAttack bite = biteBuilder.setWeaponName("Bite") //
					.setToHit(5)//
					.addDamageComponent(new DamageComponent(1, 8, 3, DamageType.PIERCING))//
					.build();
		addToAvailableAttacks(bite);
		MeleeAttackBuilder clawBuilder = new MeleeAttackBuilder();
		MeleeAttack claw = clawBuilder.setWeaponName("Claw") //
					.setToHit(5)//
					.addDamageComponent(new DamageComponent(1, 6, 3, DamageType.SLASHING))//
					.build();
		addToAvailableAttacks(claw);
	}
}
