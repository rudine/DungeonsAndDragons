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
import basic.ruleobjects.Skill;
import basic.ruleobjects.modifiers.SkillModifier;
import basic.services.DiceService;

public class Behir extends AbstractEnemy implements PreparesForNextTurn {

	public Behir() {
		setArmorClass(17);
		setHitpointsOnCreation(DiceService.throwD12(16) + 64);
		setSpeed("50 ft, 10 vakjes. Climb 40ft. 8 vakjes");
		setAbilityScores(new AbilityScores(23, 16, 18, 7, 14, 12));
		setAttacks();
		setAttacksOnAttackAction(2);
		setSpecialAttacks();
		setSpecialAttacksOnAction(1);
		addToSkills(new SkillModifier(6, Skill.Perception), new SkillModifier(7, Skill.Stealth));
	}

	@Override
	protected void setAttacks() {
		MeleeAttackBuilder biteBuilder = new MeleeAttackBuilder();
		MeleeAttack bite = biteBuilder.setWeaponName("Bite")//
				.setToHit(10)//
				.addDamageComponent(new DamageComponent(3, 10, 6, DamageType.PIERCING))//
				.setReach(10)//
				.build();
		addToAvailableAttacks(bite);
		MeleeAttackBuilder constrictBuilder = new MeleeAttackBuilder();
		MeleeAttack constrict = constrictBuilder.setWeaponName("Constrict")//
				.setToHit(10)//
				.setReach(5)//
				.setDescription("One large or smaller creature. Half bludgeoning, half slashing. Target is grappled DC16, and restrained on hit")//
				.addDamageComponent(new DamageComponent(4, 10, 12, DamageType.BLUDGEONING))//
				.build();
		addToAvailableAttacks(constrict);
	}
	
	private void setSpecialAttacks() {
		SpecialAttackBuilder lightningBuilder = new SpecialAttackBuilder();
		SpecialAttack lightning = lightningBuilder.setAreaOfEffect("Line, 20ft long, 5ft wide")//
				.setSavingThrow(new SavingThrow(16, AbilityTypes.DEX))//
				.addDamageComponent(new DamageComponent(12, 10, 0, DamageType.LIGHTNING))//
				.setWeaponName("Lightning Breath")//
				.setHalfDamageWhenSaved(true)//
				.setDescription(getLightningBreathDescription())//
				.setRecharge(true)//
				.setAvailable(true)//
				.setAvailabilityDie(6)//
				.setSuccesRange(new Range(5,6))//
				.build();
		addToSpecialAttacks(lightning);
		SpecialAttackBuilder swallowBuilder = new SpecialAttackBuilder();
		SpecialAttack swallow = swallowBuilder.setAreaOfEffect("grappled creature")//
				.setWeaponName("Swallow")//
				.addDamageComponent(new DamageComponent(6, 6, 0, DamageType.ACID))//
				.setRecharge(false)//
				.setAvailable(true)//
				.setDescription(getSwallowDescription())//
				.setSavingThrow(new SavingThrow(14, AbilityTypes.CON))//
				.build();
		addToSpecialAttacks(swallow);
	}
	
	private String getLightningBreathDescription() {
		return "The behir exhales a line of " + 
				"lightning that is 20 feet long and 5 feet wide. Each creature " + 
				"in that line must make a DC 16 Dexterity saving throw, taking " + 
				"66 (12d10) lightning damage on a failed save, or half as much " + 
				"damage on a successful one.";
	}
	
	private String getSwallowDescription() {
		return "The behir makes one bite attack against a Medium or " + 
				"smaller target it is grappling. If the attack hits, the target is also " + 
				"swallowed, and the grapple ends. While swallowed, the target " + 
				"is blinded and restrained, it has total cover against attacks " + 
				"and other effects outside the behir, and it takes 21 (6d6) acid " + 
				"damage at the start of each of the behir's turns. A behir can " + 
				"have only one creature swallowed at a time.\r\n\r\n" + 
				"If the behir takes 30 damage or more on a single turn from " + 
				"the swallowed creature, the behir must succeed on a DC 14 " + 
				"Constitution saving throw at the end of that turn or regurgitate " + 
				"the creature, which falls prone in a space within 10 feet of " + 
				"the behir. If the behir dies, a swallowed creature is no longer " + 
				"restrained by it and can escape from the corpse by using 15 feet " + 
				"of movement, exiting prone.";
	}

	@Override
	public void prepareForNextTurn() {
		specialAttacks.stream().filter(SpecialAttack::hasRecharge).forEach(SpecialAttack::recharge);
	}
}
