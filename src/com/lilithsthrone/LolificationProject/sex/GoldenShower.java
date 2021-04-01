package com.lilithsthrone.LolificationProject.sex;

import com.lilithsthrone.LolificationProject.ModCommon.TranslationUtils;
import com.lilithsthrone.game.PropertyValue;
import com.lilithsthrone.game.character.GameCharacter;
import com.lilithsthrone.game.character.attributes.CorruptionLevel;
import com.lilithsthrone.game.dialogue.utils.UtilText;
import com.lilithsthrone.game.inventory.InventorySlot;
import com.lilithsthrone.game.sex.ArousalIncrease;
import com.lilithsthrone.game.sex.SexAreaOrifice;
import com.lilithsthrone.game.sex.SexParticipantType;
import com.lilithsthrone.game.sex.sexActions.SexAction;
import com.lilithsthrone.game.sex.sexActions.SexActionType;
import com.lilithsthrone.main.Main;

import java.util.HashMap;

public class GoldenShower {
    public static final SexAction GOLDEN_SHOWER_START = new SexAction(
            SexActionType.REQUIRES_NO_PENETRATION_AND_EXPOSED,
            ArousalIncrease.TWO_LOW,
            ArousalIncrease.TWO_LOW,
            CorruptionLevel.THREE_DIRTY,
            new HashMap<>()/*Util.newHashMapOfValues(new Util.Value<>(SexAreaOrifice.URETHRA_VAGINA, SexAreaOrifice.MOUTH))*/,
            SexParticipantType.NORMAL) {

        @Override
        public boolean isBaseRequirementsMet() {
            return Main.game.isPeeingEnabled() && (Main.sex.isOrificeFree(Main.sex.getCharacterPerformingAction(), SexAreaOrifice.URETHRA_PENIS) || Main.sex.isOrificeFree(Main.sex.getCharacterPerformingAction(), SexAreaOrifice.URETHRA_VAGINA));
        }

        @Override
        public String getActionTitle() {
            return "Golden Shower";
        }

        @Override
        public String getActionDescription() {
            return Main.getProperties().hasValue(PropertyValue.sillyMode) ? "Make it rain!" : "Cover them in your stream.";
        }

        @Override
        public String getDescription() {
            UtilText.nodeContentSB.setLength(0);
//            boolean reverse = Sex.getCharacterTargetedForSexAction(this) == Main.game.getPlayer();
            switch (Main.sex.getSexPace(Main.sex.getCharacterPerformingAction())) {
                case DOM_GENTLE:
                    UtilText.nodeContentSB.append(TranslationUtils.getStringFor("sex.dom.gentle.peeOnOther", true));
                    break;
                case DOM_NORMAL:
                case SUB_EAGER:
                    UtilText.nodeContentSB.append(TranslationUtils.getStringFor("sex.sub.eager.peeOnOther", true));
                    break;
                case DOM_ROUGH:
                    UtilText.nodeContentSB.append(TranslationUtils.getStringFor("sex.dom.rough.peeOnOther", true));
                    break;
                case SUB_NORMAL:
                    UtilText.nodeContentSB.append(TranslationUtils.getStringFor("sex.sub.normal.peeOnOther", true));
                    break;
                case SUB_RESISTING:
                    UtilText.nodeContentSB.append(TranslationUtils.getStringFor("sex.sub.resist.peeOnOther", true));
                    break;
                default:
                    break;
            }

            return UtilText.nodeContentSB.toString();
        }

        @Override
        public void applyEffects() {
            Shower(Main.sex.getCharacterTargetedForSexAction(this));
        }
    };

    public static final SexAction REQUEST_GOLDEN_SHOWER_START = new SexAction(
            SexActionType.REQUIRES_NO_PENETRATION_AND_EXPOSED,
            ArousalIncrease.TWO_LOW,
            ArousalIncrease.TWO_LOW,
            CorruptionLevel.THREE_DIRTY,
            new HashMap<>()/*Util.newHashMapOfValues(new Util.Value<>(SexAreaOrifice.URETHRA_VAGINA, SexAreaOrifice.MOUTH))*/,
            SexParticipantType.NORMAL) {

        @Override
        public boolean isBaseRequirementsMet() {
            return Main.game.isPeeingEnabled() && (Main.sex.isOrificeFree(Main.sex.getTargetedPartner(Main.sex.getCharacterPerformingAction()), SexAreaOrifice.URETHRA_PENIS) || Main.sex.isOrificeFree(Main.sex.getTargetedPartner(Main.sex.getCharacterPerformingAction()), SexAreaOrifice.URETHRA_VAGINA));
        }
        
        @Override
        public String getActionTitle() {
            return "Get a Shower";
        }

        @Override
        public String getActionDescription() {
            return Main.getProperties().hasValue(PropertyValue.sillyMode) ? "Request a warm stream of golden glory." : "Request them to cover you in urine.";
        }

        @Override
        public String getDescription() {
            UtilText.nodeContentSB.setLength(0);
            switch (Main.sex.getSexPace(Main.sex.getCharacterPerformingAction())) {
                case DOM_GENTLE:
                    UtilText.nodeContentSB.append(TranslationUtils.getStringFor("sex.dom.gentle.peeOnOther"));
                    break;
                case DOM_NORMAL:
                case SUB_EAGER:
                    UtilText.nodeContentSB.append(TranslationUtils.getStringFor("sex.sub.eager.peeOnOther"));
                    break;
                case DOM_ROUGH:
                    UtilText.nodeContentSB.append(TranslationUtils.getStringFor("sex.dom.rough.peeOnOther"));
                    break;
                case SUB_NORMAL:
                    UtilText.nodeContentSB.append(TranslationUtils.getStringFor("sex.sub.normal.peeOnOther"));
                    break;
                case SUB_RESISTING:
                    UtilText.nodeContentSB.append(TranslationUtils.getStringFor("sex.sub.resist.peeOnOther"));
                    break;
                default:
                    break;
            }
            return UtilText.nodeContentSB.toString();
        }
        @Override
        public void applyEffects() {
            Shower(Main.sex.getTargetedPartner(Main.sex.getCharacterTargetedForSexAction(this)));
        }
    };

    public static void Shower(GameCharacter c) {
        c.addWetSlot(InventorySlot.CHEST);
        c.addWetSlot(InventorySlot.HEAD);
        c.addWetSlot(InventorySlot.LEG);
        c.addWetSlot(InventorySlot.GROIN);
        c.addWetSlot(InventorySlot.FOOT);
        if (!c.getInventorySlotsConcealed(c).containsKey(InventorySlot.CHEST) && c.getClothingInSlot(InventorySlot.CHEST) != null)
            c.getClothingInSlot(InventorySlot.CHEST).setWet(c, true);
        if (!c.getInventorySlotsConcealed(c).containsKey(InventorySlot.HEAD) && c.getClothingInSlot(InventorySlot.HEAD) != null)
            c.getClothingInSlot(InventorySlot.HEAD).setWet(c, true);
        if (!c.getInventorySlotsConcealed(c).containsKey(InventorySlot.LEG) && c.getClothingInSlot(InventorySlot.LEG) != null)
            c.getClothingInSlot(InventorySlot.LEG).setWet(c, true);
        if (!c.getInventorySlotsConcealed(c).containsKey(InventorySlot.GROIN) && c.getClothingInSlot(InventorySlot.GROIN) != null)
            c.getClothingInSlot(InventorySlot.GROIN).setWet(c, true);
        if (!c.getInventorySlotsConcealed(c).containsKey(InventorySlot.FOOT) && c.getClothingInSlot(InventorySlot.FOOT) != null)
            c.getClothingInSlot(InventorySlot.FOOT).setWet(c, true);
    }
}
