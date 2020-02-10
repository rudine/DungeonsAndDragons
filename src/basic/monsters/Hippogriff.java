package basic.monsters;

import basic.attack.DamageComponent;
import basic.attack.types.MeleeAttack;
import basic.attack.types.builders.MeleeAttackBuilder;
import basic.monsters.specialabilities.SpecialAbility;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.AbilityTypes;
import basic.ruleobjects.DamageType;
import basic.ruleobjects.Size;
import basic.ruleobjects.Skill;
import basic.ruleobjects.modifiers.SkillModifier;
import basic.services.DiceService;

public class Hippogriff extends AbstractEnemy {

	public Hippogriff() {
		setSize(Size.Large);
		setArmorClass(11);
		setHitpointsOnCreation(DiceService.throwD10(3) + 3);
		setSpeed("40ft. 8v, fly 60ft. 12v");
		setAbilityScores(new AbilityScores(17, 13, 13, 2, 12, 8));
		addToSkills(new SkillModifier(5, Skill.Perception, AbilityTypes.WIS));
		addToSpecialAbilities(SpecialAbility.KeenSight);
		setAttacks();
		setAttacksOnAttackAction(2);
	}
	
	@Override
	protected void setAttacks() {
		MeleeAttack beak = new MeleeAttackBuilder()//
				.setWeaponName("beak")//
				.setToHit(5)//
				.setUsesOnMultiAttack(1)//
				.addDamageComponent(new DamageComponent(1, 10, 3, DamageType.PIERCING))
				.build();
		addToAvailableAttacks(beak);
		MeleeAttack claw = new MeleeAttackBuilder()//
				.setWeaponName("claws")//
				.setToHit(5)//
				.setUsesOnMultiAttack(1)//
				.addDamageComponent(new DamageComponent(2, 6, 3, DamageType.SLASHING))
				.build();
		addToAvailableAttacks(claw);
	}
}
