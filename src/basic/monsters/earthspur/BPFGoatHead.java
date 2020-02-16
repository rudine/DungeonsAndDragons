package basic.monsters.earthspur;

import static basic.ruleobjects.AbilityTypes.CHA;
import static basic.ruleobjects.AbilityTypes.DEX;
import static basic.ruleobjects.AbilityTypes.STR;
import static basic.ruleobjects.Skill.Athletics;
import static basic.ruleobjects.Skill.Intimidation;

import basic.attack.DamageComponent;
import basic.attack.types.MeleeAttack;
import basic.attack.types.builders.MeleeAttackBuilder;
import basic.monsters.AbstractEnemy;
import basic.monsters.specialabilities.SpecialAbility;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.DamageType;
import basic.ruleobjects.modifiers.SaveModifier;
import basic.ruleobjects.modifiers.SkillModifier;
import basic.services.DiceService;

public class BPFGoatHead extends AbstractEnemy{

	public BPFGoatHead() {
		setAlive(true);
		setArmorClass(15);
		setHitpointsOnCreation(DiceService.throwD8(9) + 18);
		setSpeed("30 feet, 6 vakjes");
		setAbilityScores(new AbilityScores(16, 16, 14, 10, 12, 15));
		addToSpecialAbilities(SpecialAbility.Brave);
		setAttacks();
		setAttacksOnAttackAction(2);
		addToSaveModifiers(new SaveModifier(STR, 5), new SaveModifier(DEX, 5));
		addToSkills(new SkillModifier(5, Athletics), new SkillModifier(4, Intimidation));
	}
	
	@Override
	protected void setAttacks() {
		MeleeAttackBuilder meleeBuilder = new MeleeAttackBuilder();
		MeleeAttack pike = meleeBuilder.setWeaponName("Pike") //
					.setToHit(5)//
					.setReach(10)//
					.addDamageComponent(new DamageComponent(1, 10, 3, DamageType.PIERCING))//
					.setDescription("If the gladiator hits when charging the target, they also fall prone")//
					.build();
		addToAvailableAttacks(pike);
	}
}
