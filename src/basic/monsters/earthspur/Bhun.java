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

public class Bhun extends AbstractEnemy {
	
	public Bhun() {
		setAlive(true);
		setArmorClass(15);
		setHitpointsOnCreation(DiceService.throwD8(9) + 27);
		setSpeed("30 feet, 6 vakjes || adv on poison saves");
		setAbilityScores(new AbilityScores(18, 16, 16, 10, 12, 15));
		addToSpecialAbilities(SpecialAbility.Brave);
		setAttacks();
		setAttacksOnAttackAction(2);
		addToSaveModifiers(new SaveModifier(STR, 5), new SaveModifier(DEX, 5));
		addToSkills(new SkillModifier(6, Athletics, STR), new SkillModifier(4, Intimidation, CHA));
	}
	
	@Override
	protected void setAttacks() {
		MeleeAttackBuilder meleeBuilder = new MeleeAttackBuilder();
		MeleeAttack handAxe = meleeBuilder.setWeaponName("Flint Hand Axe") //
					.setToHit(6)//
					.addDamageComponent(new DamageComponent(1, 6, 4, DamageType.SLASHING))//
					.build();
		addToAvailableAttacks(handAxe);
	}
}
