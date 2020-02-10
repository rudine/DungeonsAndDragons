package basic.monsters;


import static basic.monsters.specialabilities.SpecialAbility.Beserk;
import static basic.monsters.specialabilities.SpecialAbility.FearOfFire;
import static basic.monsters.specialabilities.SpecialAbility.ImmutableForm;
import static basic.monsters.specialabilities.SpecialAbility.LightningAbsorption;
import static basic.monsters.specialabilities.SpecialAbility.MagicResistance;
import static basic.monsters.specialabilities.SpecialAbility.MagicWeapons;
import static basic.ruleobjects.DamageType.BLUDGEONING;
import static basic.ruleobjects.DamageType.FIRE;
import static basic.ruleobjects.DamageType.LIGHTNING;
import static basic.ruleobjects.DamageType.PIERCING;
import static basic.ruleobjects.DamageType.POISON;
import static basic.ruleobjects.DamageType.SLASHING;

import basic.attack.DamageComponent;
import basic.attack.types.MeleeAttack;
import basic.attack.types.builders.MeleeAttackBuilder;
import basic.monsters.interfaces.DamageTypeCausesDisadvantage;
import basic.monsters.interfaces.PreparesForNextTurn;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.DamageType;
import basic.ruleobjects.Size;
import basic.services.DiceService;

public class FleshGolem extends AbstractEnemy implements DamageTypeCausesDisadvantage, PreparesForNextTurn{
	
	private int roundsAffected;
	
	private boolean beserk;
	
	public FleshGolem() {
		setSize(Size.Large);
		setArmorClass(11);
		setHitpointsOnCreation(DiceService.throwD8(11) + 44);
		setSpeed("30ft. 6v");
		setAbilityScores(new AbilityScores(19, 9, 18, 6, 10, 5));
		addToSpecialAbilities(Beserk, FearOfFire, ImmutableForm, LightningAbsorption, MagicResistance, MagicWeapons);
		setAttacks();
		setAttacksOnAttackAction(2);
	}
	
	@Override
	protected void setAttacks() {
		MeleeAttack slam = new MeleeAttackBuilder()//
				.setWeaponName("slam")//
				.setToHit(7)//
				.setUsesOnMultiAttack(2)//
				.addDamageComponent(new DamageComponent(2, 8, 4, BLUDGEONING))
				.build();
		addToAvailableAttacks(slam);
	}
	
	@Override
	public void doDamage(int damage, DamageType type) {
		if(type == FIRE) {
			setRoundsAffected(2); //this turn and next turn
			setDisadvantageOnAttacks(true);
		}
		
		if (type == LIGHTNING) {
			setHitpoints(getHitpoints() + damage);
			return;
		}
		
		if(type != POISON && type != BLUDGEONING && type != PIERCING && type != SLASHING) {
			super.doDamage(damage, type);
		}
	}
	
	@Override
	public void prepareForNextTurn() {
		if(getHitpoints() < 40) {
			if(DiceService.throwD6(1) == 6) 
				setBeserk(true);
		}
		else if(getHitpoints() == getHitpointsAtCreation() && beserk == true) {
			setBeserk(false);
		}
		
		if(getRoundsAffected() > 0)
			roundsAffected--;
		
		if(getRoundsAffected() == 0)
			setDisadvantageOnAttacks(false);
	}

	@Override
	public void setRoundsAffected(int roundsAffected) {
		this.roundsAffected = roundsAffected;
	}

	@Override
	public int getRoundsAffected() {
		return roundsAffected;
	}

	public boolean isBeserk() {
		return beserk;
	}

	public void setBeserk(boolean beserk) {
		this.beserk = beserk;
	}
}
