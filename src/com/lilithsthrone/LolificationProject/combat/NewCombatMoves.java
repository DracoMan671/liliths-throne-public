package com.lilithsthrone.LolificationProject.combat;

import com.lilithsthrone.game.character.GameCharacter;
import com.lilithsthrone.game.character.effects.StatusEffect;
import com.lilithsthrone.game.combat.*;
import com.lilithsthrone.game.combat.moves.CombatMove;
import com.lilithsthrone.game.combat.moves.CombatMoveType;
import com.lilithsthrone.game.combat.spells.Spell;
import com.lilithsthrone.game.dialogue.utils.UtilText;
import com.lilithsthrone.utils.Util;

import java.util.List;

@Deprecated
public class NewCombatMoves {
    /*public static CombatMove hugAttack = new CombatMove("hug-tease",
            "hug",
            0,
            1,
            CombatMoveType.TEASE,
            DamageType.LUST,
            "moves/tease",
            false,
            true,
            false,
            null){

        private int getBaseDamage(GameCharacter source) {
            return 10;
        }

        private int getDamage(GameCharacter source, GameCharacter target, boolean critical) {
            return Attack.calculateSeductionDamage(source, target, getBaseDamage(source), critical);
        }

        @Override
        public Util.Value<Boolean, String> isAvailableFromSpecialCase(GameCharacter source) {
            return new Util.Value<>(true, "Available to everyone as a basic move.");
        }

        @Override
        public String getPrediction(int turnIndex, GameCharacter source, GameCharacter target, List<GameCharacter> enemies, List<GameCharacter> allies) {
            boolean isCrit = canCrit(turnIndex, source, target, enemies, allies);
            return UtilText.parse(source, target,
                    (isCrit?"[style.colourExcellent(Critical)]: ":"")
                            + "<span style='color:"+this.getColour().toWebHexString()+";'>Hug</span> "
                            +" [npc2.name] for " + getFormattedDamage(getDamageType(source), getDamage(source, target, isCrit), target, false, target.getLust() == 1f) + " damage.");
        }

        @Override
        public String getDescription(GameCharacter source) {
            return "Hug your enemy, dealing base "
                    + getFormattedDamage(getDamageType(source), getBaseDamage(source), null, false, false)
                    + " damage to them.";
        }

        @Override
        public String perform(int turnIndex, GameCharacter source, GameCharacter target, List<GameCharacter> enemies, List<GameCharacter> allies) {
            StringBuilder sb = new StringBuilder();

            DamageType finalDt = getDamageType(source);
//            	if(target.getLust()>=100) {
//					finalDt = DamageType.HEALTH;
//				}

            boolean isCrit = canCrit(turnIndex, source, target, enemies, allies);
            Util.Value<String, Integer> damageValue = getDamageType(source).damageTarget(source, target, getDamage(source, target, isCrit));
            int lustDamage = damageValue.getValue();

            sb.append(formatAttackOutcome(source, target,
                    source.getSeductionDescription(target),
                    "[npc2.Name] took " + getFormattedDamage(finalDt, lustDamage, target, true, target.getLust() == 1f) + " damage!",
                    isCrit?"":null,
                    isCrit?"[npc2.Name] [npc2.verb(feel)] incredibly turned-on!":""));

            if(source.hasStatusEffect(StatusEffect.TELEPATHIC_COMMUNICATION_POWER_OF_SUGGESTION)) {
//                Combat.addStatusEffectToApply(target, StatusEffect.TELEPATHIC_COMMUNICATION_POWER_OF_SUGGESTION_TARGETED, 3);
                sb.append(Spell.getBasicStatusEffectApplication(target, false, Util.newHashMapOfValues(new Util.Value<>(StatusEffect.TELEPATHIC_COMMUNICATION_POWER_OF_SUGGESTION_TARGETED, 2))));
            }

            return sb.toString();
        }
    };*/
}
