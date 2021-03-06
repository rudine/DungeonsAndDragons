package basic.monsters;

import static basic.monsters.specialabilities.SpecialAbility.Amorphous;
import static basic.monsters.specialabilities.SpecialAbility.CorrosiveForm;
import static basic.monsters.specialabilities.SpecialAbility.SpiderClimb;

import java.util.List;

import basic.attack.DamageComponent;
import basic.attack.types.MeleeAttack;
import basic.attack.types.builders.MeleeAttackBuilder;
import basic.monsters.interfaces.PreparesForNextTurn;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.DamageType;
import basic.services.DiceService;

public class BlackPudding extends AbstractEnemy implements PreparesForNextTurn {

	private boolean isSplitThisRound;
	
	private List<BlackPudding> splittedPuddings;
	
	public BlackPudding() {
		setArmorClass(7);
		setHitpointsOnCreation(DiceService.throwD10(10) + 30);
		setSpeed("20ft. 4 vakjes, Climb 20ft. 4 vakjes");
		setAbilityScores(new AbilityScores(16, 5, 16, 1, 6, 1));
		setAttacksOnAttackAction(1);
		setAttacks();
		addToSpecialAbilities(Amorphous, CorrosiveForm, SpiderClimb);
	}

	public BlackPudding(int hitpoints) {
		this();
		setHitpoints(hitpoints);
	}

	@Override
	protected void setAttacks() {
		MeleeAttackBuilder podBuilder = new MeleeAttackBuilder();
		MeleeAttack pseudoPod = podBuilder.setWeaponName("Pseudopod")//
				.setToHit(5)//
				.addDamageComponent(new DamageComponent(1, 6, 3, DamageType.BLUDGEONING))//
				.addDamageComponent(new DamageComponent(4, 8, 0, DamageType.ACID))//
				.setDescription(
						"Nonmagical armor worn by the target gets permanent and cumulative -1 dmg to AC and is destroyed when it reaches 10AC")//
				.build();
		addToAvailableAttacks(pseudoPod);
	}

	/**
	 * REACTION Split. When a pudding that is Medium or larger is subjected to lightning or slashing damage, it splits in two new puddings if it has 
	 * at least 10 hit points. Each new pudding has hit points equal to half the original pudding's, rounded down. New puddings are one size smaller
	 * than the original pudding. 
	 */
	public void split() {
		if (getHitpoints() >= 10 && !isSplitThisRound) {
			for (int i = 0; i < 2; i++) {
				splittedPuddings.add(new BlackPudding((int)(getHitpoints() / 2)));
			}
			isSplitThisRound = true;
		}
	}

	@Override
	public void doDamage(int damage, DamageType type) {
		switch (type) {
		case ACID:
			setHitpoints(getHitpoints());
			break;
		case COLD:
			setHitpoints(getHitpoints());
			break;
		case LIGHTNING:
			split();
			break;
		case SLASHING:
			split();
			break;
		default:
			super.doDamage(damage, type);
		}
	}

	@Override
	public void prepareForNextTurn() {
		isSplitThisRound = false;
	}

	public boolean isSplitThisRound() {
		return isSplitThisRound;
	}

	public void setSplitThisRound(boolean isSplitThisRound) {
		this.isSplitThisRound = isSplitThisRound;
	}
}
