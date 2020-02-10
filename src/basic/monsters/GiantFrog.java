package basic.monsters;

import basic.action.Action;
import basic.action.ActionBuilder;
import basic.attack.DamageComponent;
import basic.attack.types.MeleeAttack;
import basic.attack.types.builders.MeleeAttackBuilder;
import basic.monsters.specialabilities.SpecialAbility;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.DamageType;
import basic.ruleobjects.Size;
import basic.services.DiceService;

public class GiantFrog extends AbstractEnemy {

	public GiantFrog() {
		setSize(Size.Medium);
		setArmorClass(11);
		setHitpointsOnCreation(DiceService.throwD8(4));
		setSpeed("Swim 30ft (6v), Walk 30ft (6v)");
		setAbilityScores(new AbilityScores(12, 13, 11, 2, 10, 3));
		addToSpecialAbilities(SpecialAbility.Amphibious, SpecialAbility.StandingLeapLong20High10);
		setAttacks();
		setAttacksOnAttackAction(1);
		setActions();
	}

	@Override
	protected void setAttacks() {
		MeleeAttack bite = new MeleeAttackBuilder()//
				.setWeaponName("Bite")//
				.setToHit(3)//
				.addDamageComponent(new DamageComponent(1, 6, 1, DamageType.BLUDGEONING))
				.setDescription(
						"On a succesful bite the target is grappled and restrained, DC11 strength save to escape.")
				.build();
		addToAvailableAttacks(bite);

	}

	private void setActions() {
		Action swallow = new ActionBuilder()//
				.setName("Swallow")//
				.setArea("One creature that can see the medusa and starts its turn within 30ft of it\r\n\r\n")//
				.setDescription(getSwallowText())//
				.build();
		addToActions(swallow);
	}

	private String getSwallowText() {
		return "The frog makes one bite attack against a small or smaller target it is grappling. If the attack hits, "
				+ "the target is swallowed, and the grapple ends. The swallowed target is blinded and restrained, it "
				+ "has total cover against attacks and other effects outside the frog, and it takes 5 (2d4) acid damage "
				+ "at the start of each of the frog�s turns. The frog can have only one target swallowed at a time. If "
				+ "the frog dies, a swallowed creature is no longer restrained by it and can escape from the corpse "
				+ "using 5 feet of movement, exiting prone.";
	}
	
	public int getSwallowDamage() {
		return DiceService.throwD4(2);
	}
}
