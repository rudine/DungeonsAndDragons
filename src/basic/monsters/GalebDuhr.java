package basic.monsters;

import static basic.ruleobjects.DamageType.BLUDGEONING;

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

public class GalebDuhr extends AbstractEnemy {

	public GalebDuhr() {
		setSize(Size.Medium);
		setAC(16);
		setHitpointsOnCreation(DiceService.throwD8(9)+45);
		setSpeed("15 ft. walking, 30 ft. rolling (60 ft. downhill)");
		setAbilityScores(new AbilityScores(20, 14, 20, 11, 12, 11));
		addToSpecialAbilities(SpecialAbility.FalseAppearance, SpecialAbility.RollingCharge);
		setAttacks();
		setAttacksOnAttackAction(1);
		setActions();
	}
	
	@Override
	protected void setAttacks() {
		MeleeAttack slam = new MeleeAttackBuilder()//
				.setWeaponName("slam")//
				.setToHit(8)//
				.addDamageComponent(new DamageComponent(2, 6, 5, BLUDGEONING))
				.build();
		addToAvailableAttacks(slam);
	}
	
	private void setActions() {
		ActionBuilder builder = new ActionBuilder();
		Action animateBoulders = builder.setName("Animate boulders")//
				.setDescription(getMagicBoulderDescription())//
				.setArea("Up to 2 boulders within 60 ft.")//
				.build();
		addToActions(animateBoulders);
	}

	protected String getMagicBoulderDescription() {
		return "The galeb duhr magically animates boulders. A boulder has\r\n" + 
				"statistics like those of a galeb duhr, except it has Intelligence 1\r\n" + 
				"and Charisma 1, it can't be charmed or frightened, and it lacks\r\n" + 
				"this action option. A boulder remains animated as long as\r\n" + 
				"the galeb duhr maintains concentration, up to l minute (as if\r\n" + 
				"concentrating on a spell) .";
	}
	
	@Override
	public void doDamage(int damage, DamageType type) {
		if (type == DamageType.BLUDGEONING || type == DamageType.PIERCING || type == DamageType.SLASHING) {
			damage = damage / 2;
		}
		else if (type == DamageType.POISON) {
			return;
		}
		super.doDamage(damage, type);
	}
}
