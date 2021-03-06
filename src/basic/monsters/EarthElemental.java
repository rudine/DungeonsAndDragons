package basic.monsters;

import static basic.ruleobjects.DamageType.BLUDGEONING;

import basic.attack.DamageComponent;
import basic.attack.types.MeleeAttack;
import basic.attack.types.builders.MeleeAttackBuilder;
import basic.monsters.specialabilities.SpecialAbility;
import basic.ruleobjects.AbilityScores;
import basic.ruleobjects.DamageType;
import basic.ruleobjects.Size;
import basic.services.DiceService;

public class EarthElemental extends AbstractEnemy {

	public EarthElemental() {
		setSize(Size.Large);
		setArmorClass(17);
		setHitpointsOnCreation(DiceService.throwD10(12)+60);
		setSpeed("30 ft. 6v, burrow 30 ft.");
		setAbilityScores(new AbilityScores(20, 8, 20, 5, 10, 5));
		addToSpecialAbilities(SpecialAbility.EarthGlide, SpecialAbility.SiegeMonster);
		setAttacks();
		setAttacksOnAttackAction(2);
	}
	
	@Override
	protected void setAttacks() {
		MeleeAttack slam = new MeleeAttackBuilder()//
				.setWeaponName("slam")//
				.setToHit(8)//
				.setUsesOnMultiAttack(2)//
				.addDamageComponent(new DamageComponent(2, 8, 5, BLUDGEONING))
				.build();
		addToAvailableAttacks(slam);
	}
	
	@Override
	public void doDamage(int damage, DamageType type) {
		if(type == DamageType.THUNDER) {
			damage = damage * 2;
		}
		else if (type == DamageType.BLUDGEONING || type == DamageType.PIERCING || type == DamageType.SLASHING) {
			damage = damage / 2;
		}
		else if (type == DamageType.POISON) {
			return;
		}
		super.doDamage(damage, type);
	}
}
