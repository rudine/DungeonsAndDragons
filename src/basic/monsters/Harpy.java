package basic.monsters;

import basic.attack.DamageComponent;
import basic.attack.types.MeleeAttack;
import basic.attack.types.SpecialAttack;
import basic.attack.types.builders.MeleeAttackBuilder;
import basic.attack.types.builders.SpecialAttackBuilder;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.AbilityTypes;
import basic.ruleobjects.DamageType;
import basic.ruleobjects.SavingThrow;
import basic.services.DiceService;

public class Harpy extends AbstractEnemy {

	public Harpy() {
		setAlive(true);
		setAC(11);
		setHitpoints(DiceService.throwD8(7) + 7);
		setSpeed("20ft, fly 40ft");
		setAbilityScores(new AbilityScores(12, 13, 12, 7, 10, 13));
		setAttacksOnAttackAction(2);
		setAttacks();
		setSpecialAttacksOnAction(1);
		setSpecialAttacks();
	}
	
	private void setAttacks() {
		MeleeAttackBuilder clawBuilder = new MeleeAttackBuilder();
		MeleeAttack claw = clawBuilder.setWeaponName("Claw")//
				.setToHit(3)//
				.addDamageComponent(new DamageComponent(2, 4, 1, DamageType.SLASHING))//
				.build();
		addToAvailableAttacks(claw);
		MeleeAttackBuilder clubBuilder = new MeleeAttackBuilder();
		MeleeAttack club = clubBuilder.setWeaponName("Club")//
				.setToHit(3)//
				.addDamageComponent(new DamageComponent(1, 4, 1, DamageType.BLUDGEONING))//
				.build();
		addToAvailableAttacks(club);
	}
	
	private void setSpecialAttacks() {
		// TODO also not a good fit for a special attack, see if it fits in the same category 
		// as the special actions
		SpecialAttackBuilder luresongBuilder = new SpecialAttackBuilder();
		SpecialAttack luringSong = luresongBuilder.setWeaponName("Luring song")//
				.setAreaOfEffect("300 feet")//
				.setSavingThrow(new SavingThrow(11, AbilityTypes.WIS))
				.setRecharge(false)
				.setAvailable(true)//
				.setDescription(lookupLuringSongDescription())//
				.addDamageComponent(new DamageComponent(0, 4, 0, DamageType.MAGIC))//
				.build();
		addToSpecialAttacks(luringSong);
	}
	
	private String lookupLuringSongDescription() {
		return "MM p.181";
	}
	
	@SuppressWarnings("unused")
	private String getLuringSongDescription() {
		return "succeed on a DC 11 Wisdom saving throw or " + 
				"be charmed until the song ends. The harpy must take a bonus " + 
				"action on its subsequent turns to continue singing. It can stop " + 
				"singing at any time. The song ends if the harpy is incapacitated. " + 
				"While charmed by the harpy, a target is incapacitated and " + 
				"ignores the songs of other harpies. If the charmed target is " + 
				"more than 5 feet away from the harpy, the target can take " + 
				"the Dash action on its turn to move toward the harpy by the " + 
				"most direct route. It doesn't avoid opportunity attacks, but " + 
				"before moving into damaging terrain, such as lava or a pit, and " + 
				"whenever it takes damage from a source other than the harpy, " + 
				"a target can repeat the saving throw. A creature can also repeat " + 
				"the saving throw at the end of each of its turns. If a creature's " + 
				"saving throw is successful, the effect ends on it. " + 
				"A target that successfully saves is immune to this harpy's " + 
				"song for the next 24 hours"; 
	}
	
}
