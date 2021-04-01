package com.lilithsthrone.LolificationProject.ModCommon;

import com.lilithsthrone.game.character.attributes.Attribute;
import com.lilithsthrone.game.character.fetishes.Fetish;
import com.lilithsthrone.game.character.fetishes.FetishDesire;
import com.lilithsthrone.game.character.quests.Quest;
import com.lilithsthrone.game.character.quests.QuestLine;
import com.lilithsthrone.game.combat.spells.Spell;
import com.lilithsthrone.main.Main;

public class MiscStuff {

    public static void checkCheats() {
        if (Main.game.getPlayer().getName(false).startsWith("Keldon") || Main.game.getPlayer().getName(false).startsWith("Test")) {
            MiscStuff.addMyCheats();
        } else if (Main.game.getPlayer().getName(false).equalsIgnoreCase("Airi") && (Main.game.getPlayer().getSurname().equalsIgnoreCase("Melona") || Main.game.getPlayer().getSurname().equalsIgnoreCase("Merona"))) {
            MiscStuff.addAiriCheats();
        }
    }

    public static void addMyCheats() {
        Main.game.getPlayer().setEssenceCount(5000000);
        Main.game.getPlayer().setMoney(5000000);
//        AbstractClothing cloth = AbstractClothingType.generateClothing(ClothingType.WRIST_WRISTBANDS);
//        Main.game.getPlayer().addClothing(cloth, 10, false, false);
        Main.game.getPlayer().setQuestProgress(QuestLine.SIDE_SLAVERY, Quest.SIDE_UTIL_COMPLETE);
        Main.game.getPlayer().setLevel(15);
//        Main.game.getPlayer().addWeapon(AbstractWeaponType.generateWeapon(WeaponType.getWeaponTypeFromId("innoxia_scythe_scythe"), DamageType.PHYSICAL, Colour.COVERING_RED_DARK, Colour.BASE_AQUA), 1, false, false);
        Main.game.getPlayer().setAttribute(Attribute.MAJOR_CORRUPTION, 75);
        for (int i = 0; i < Spell.values().length; i++) {
            if (!Spell.values()[i].isForbiddenSpell()) {
                Main.game.getPlayer().addSpell(Spell.values()[i]);
            }
        }
    }

    public static void addAiriCheats() {
        addMyCheats();
        Main.game.getPlayer().setAttribute(Attribute.MAJOR_CORRUPTION, 10);
        Main.game.getPlayer().addFetish(Fetish.FETISH_ANAL_RECEIVING);
        Main.game.getPlayer().addFetish(Fetish.FETISH_PURE_VIRGIN);
        Main.game.getPlayer().addFetish(Fetish.FETISH_ORAL_GIVING);
        Main.game.getPlayer().addFetish(Fetish.FETISH_BREASTS_SELF);
        Main.game.getPlayer().addFetish(Fetish.FETISH_EXHIBITIONIST);
        Main.game.getPlayer().addFetish(Fetish.FETISH_VAGINAL_RECEIVING);
        Main.game.getPlayer().addFetish(Fetish.FETISH_DOMINANT);
        Main.game.getPlayer().addFetish(Fetish.FETISH_SUBMISSIVE);
        Main.game.getPlayer().addFetish(Fetish.FETISH_LACTATION_SELF);
        Main.game.getPlayer().setFetishDesire(Fetish.FETISH_ANAL_RECEIVING, FetishDesire.FOUR_LOVE);
        Main.game.getPlayer().setFetishDesire(Fetish.FETISH_PURE_VIRGIN, FetishDesire.FOUR_LOVE);
        Main.game.getPlayer().setFetishDesire(Fetish.FETISH_ORAL_GIVING, FetishDesire.FOUR_LOVE);
        Main.game.getPlayer().setFetishDesire(Fetish.FETISH_BREASTS_SELF, FetishDesire.FOUR_LOVE);
        Main.game.getPlayer().setFetishDesire(Fetish.FETISH_EXHIBITIONIST, FetishDesire.FOUR_LOVE);
        Main.game.getPlayer().setFetishDesire(Fetish.FETISH_VAGINAL_RECEIVING, FetishDesire.FOUR_LOVE);
        Main.game.getPlayer().setFetishDesire(Fetish.FETISH_DOMINANT, FetishDesire.FOUR_LOVE);
        Main.game.getPlayer().setFetishDesire(Fetish.FETISH_SUBMISSIVE, FetishDesire.FOUR_LOVE);
        Main.game.getPlayer().setFetishDesire(Fetish.FETISH_LACTATION_SELF, FetishDesire.FOUR_LOVE);
//        Main.game.getPlayer().addItem(AbstractItemType.generateItem(ItemType.RACE_INGREDIENT_SLIME), 1, false, false);
//        Main.game.getPlayer().addClothing(AbstractClothingType.generateClothing(ClothingType.GROIN_CROTCHLESS_THONG, Colour.CLOTHING_PINK, false), 1, false, false);
//        Main.game.getPlayer().addClothing(AbstractClothingType.generateClothing(ClothingType.CHEST_LACY_PLUNGE_BRA, Colour.CLOTHING_PINK, false), 1, false, false);
//        Main.game.getPlayer().addClothing(AbstractClothingType.generateClothing(ClothingType.MAID_DRESS, Colour.CLOTHING_BLACK, false), 1, false, false);
//        Main.game.getPlayer().addClothing(AbstractClothingType.generateClothing(ClothingType.MAID_HEADPIECE, Colour.CLOTHING_BLACK, false), 1, false, false);
//        Main.game.getPlayer().addClothing(AbstractClothingType.generateClothing(ClothingType.MAID_STOCKINGS, Colour.CLOTHING_BLACK, false), 1, false, false);
//        Main.game.getPlayer().addClothing(AbstractClothingType.generateClothing(ClothingType.MAID_SLEEVES, Colour.CLOTHING_BLACK, false), 1, false, false);
//        Main.game.getPlayer().addClothing(AbstractClothingType.generateClothing(ClothingType.MAID_HEELS, Colour.CLOTHING_BLACK, false), 1, false, false);
    }
}
