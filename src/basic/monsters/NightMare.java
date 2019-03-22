package basic.monsters;

import basic.action.Action;
import basic.action.ActionBuilder;
import basic.attack.DamageComponent;
import basic.attack.types.MeleeAttack;
import basic.attack.types.builders.MeleeAttackBuilder;
import basic.monsters.specialabilities.SpecialAbility;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.DamageType;
import basic.services.DiceService;

public class NightMare extends AbstractEnemy {
	
	public NightMare() {
		setAC(13);
		setHitpoints(DiceService.throwD10(8) + 24);
		setSpeed("60 ft. 12v, fly 90ft. 18v");
		setAbilityScores(new AbilityScores(18, 15, 16, 10, 13, 15));
		setAttacksOnAttackAction(1);
		setAttacks();
		addToSpecialAbilities(SpecialAbility.ConferFireResistance, SpecialAbility.Illumination);
		setActions();
	}

	@Override
	protected void setAttacks() {
		MeleeAttackBuilder builder = new MeleeAttackBuilder();
		MeleeAttack hooves = builder.setWeaponName("Hooves")//
				.setToHit(6)//
				.addDamageComponent(new DamageComponent(2, 8, 4, DamageType.BLUDGEONING))//
				.addDamageComponent(new DamageComponent(2, 6, 0, DamageType.FIRE))//
				.build();
		addToAvailableAttacks(hooves);
	}
	
	private void setActions() {
		ActionBuilder builder = new ActionBuilder();
		Action etherealStride = builder.setName("Etherial stride")//
				.setArea("max 3 willing creatures within 5ft.")//
				.setDescription(getEtherialStrideDescription())//
				.build();
		addToActions(etherealStride);
	}
	
	private String getEtherialStrideDescription() {
		return "The nightmare and up to three willing creatures within 5 feet"
				+ " of it magically enter the Ethereal Plane from the Material"
				+ " Plane, or vice versa.";
	}
	
	@Override
	public void doDamage(int damage, DamageType type) {
		if(type == DamageType.FIRE)
			damage = 0;
		super.doDamage(damage, type);
	}
}
