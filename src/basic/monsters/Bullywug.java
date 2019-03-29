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

public class Bullywug extends AbstractEnemy {

	public Bullywug() {
		setSize(Size.Medium);
		setAC(15);
		setHitpoints(DiceService.throwD8(2) + 2);
		setSpeed("Swim 40ft (8v), Walk 20ft (4v)");
		setAbilityScores(new AbilityScores(12, 12, 13, 7, 10, 7));
		addToSkills(new SkillModifier(3, Skill.Stealth, AbilityTypes.DEX));
		addToSpecialAbilities(SpecialAbility.Amphibious, SpecialAbility.SpeakFrogToad, SpecialAbility.SwampCamouflage, SpecialAbility.StandingLeapLong20High10);
		setAttacks();
		setAttacksOnAttackAction(1); // TODO klopt niet helemaal, er zijn wel 2 attacks, maar die met de spear is met 2 handen of met 1 hand
	}

	@Override
	protected void setAttacks() {
		MeleeAttack bite = new MeleeAttackBuilder()//
				.setWeaponName("Bite")//
				.setToHit(3)//
				.addDamageComponent(new DamageComponent(1, 4, 1, DamageType.BLUDGEONING))
				.build();
		addToAvailableAttacks(bite);
		MeleeAttack spear = new MeleeAttackBuilder()//
				.setWeaponName("Spear (one hand)")//
				.setToHit(3)//
				.addDamageComponent(new DamageComponent(1, 6, 1, DamageType.PIERCING))//
				.setDescription("in addition to the bite")//
				.build();
		addToAvailableAttacks(spear);
		MeleeAttack spearTwoHands = new MeleeAttackBuilder()//
				.setWeaponName("Spear (two hands)")//
				.setToHit(3)//
				.addDamageComponent(new DamageComponent(1, 8, 1, DamageType.PIERCING))//
				.setDescription("replaces the attack 1 one hand") //
				.build();
		addToAvailableAttacks(spearTwoHands);
	}
}