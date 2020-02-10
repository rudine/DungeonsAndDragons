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

public class BloodHawk extends AbstractEnemy{
	
	public BloodHawk() {
		setSize(Size.Small);
		setArmorClass(12);
		setHitpointsOnCreation(DiceService.throwD6(2));
		setSpeed("10ft 2v, 60ft 12v");
		setAbilityScores(new AbilityScores(6, 14, 10, 3, 14, 5));
		addToSkills(new SkillModifier(4, Skill.Perception, AbilityTypes.WIS));
		addToSpecialAbilities(SpecialAbility.PackTactics, SpecialAbility.KeenSight);
		setAttacks();
		setAttacksOnAttackAction(1);
	}
	
	@Override
	protected void setAttacks() {
		MeleeAttack beak = new MeleeAttackBuilder()//
				.setWeaponName("Beak")//
				.setToHit(4)//
				.addDamageComponent(new DamageComponent(1, 4, 2, DamageType.PIERCING))
				.build();
		addToAvailableAttacks(beak);
	}
}
