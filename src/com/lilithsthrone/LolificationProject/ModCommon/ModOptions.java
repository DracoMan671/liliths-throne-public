package com.lilithsthrone.LolificationProject.ModCommon;

import com.lilithsthrone.game.PropertyValue;
import com.lilithsthrone.game.dialogue.DialogueNode;
import com.lilithsthrone.game.dialogue.DialogueNodeType;
import com.lilithsthrone.game.dialogue.responses.Response;
import com.lilithsthrone.game.dialogue.utils.OptionsDialogue;
import com.lilithsthrone.game.dialogue.utils.UtilText;
import com.lilithsthrone.main.Main;
import com.lilithsthrone.utils.colours.PresetColour;

public class ModOptions {

    public static final DialogueNode MOD_CONTENT_PREFERENCE = new DialogueNode("Mod Options", "", true) {

        @Override
        public String getHeaderContent() {
            UtilText.nodeContentSB.setLength(0);

            UtilText.nodeContentSB.append(OptionsDialogue.getContentPreferenceDiv(
                    OptionsDialogue.ContentOptionsPage.MISC,
                    "PEE",
                    PresetColour.BASE_GOLD,
                    "Pee content",
                    "</br>When disabled, all pee content will be disabled.",
                    Main.getProperties().hasValue(PropertyValue.peeContent)));

            UtilText.nodeContentSB.append(OptionsDialogue.getContentPreferenceDiv(
                    OptionsDialogue.ContentOptionsPage.MISC,
                    "HUG",
                    PresetColour.BASE_PINK,
                    "Hug your enemies",
                    "</br>When disabled, you cannot hug your enemies to defeat.",
                    Main.getProperties().hasValue(PropertyValue.enableHug)));

            UtilText.nodeContentSB.append(OptionsDialogue.getContentPreferenceDiv(
                    OptionsDialogue.ContentOptionsPage.MISC,
                    "ALWAYSMODDED",
                    PresetColour.BASE_PINK,
                    "Flag imported characters as already modified",
                    "</br>When enabled, any characters imported as slave will be flagged as already modified by us and not get tweaked.",
                    Main.getProperties().hasValue(PropertyValue.importedFlagAsModded)));

            UtilText.nodeContentSB.append(OptionsDialogue.getContentPreferenceDiv(
                    OptionsDialogue.ContentOptionsPage.MISC,
                    "EXTREME_AGE",
                    PresetColour.BASE_BLUE_STEEL,
                    "Age gap fetish content.",
                    "</br>When disabled, Age Difference Fetishes are disabled. @Atrum needs to expand upon",
                    Main.getProperties().hasValue(PropertyValue.extremeAgeContent)));

            UtilText.nodeContentSB.append(OptionsDialogue.getContentPreferenceDiv(
                    OptionsDialogue.ContentOptionsPage.MISC,
                    "SHOW_AGE",
                    PresetColour.BASE_GREEN_LIME,
                    "Show age",
                    "</br>When enabled, NPCs upon inspection will show the exact age they appear to be.",
                    Main.getProperties().hasValue(PropertyValue.showAge)));

            UtilText.nodeContentSB.append(OptionsDialogue.getContentPreferenceDiv(
                    OptionsDialogue.ContentOptionsPage.MISC,
                    "SHOW_TRUE_AGE",
                    PresetColour.BASE_GREEN_LIME,
                    "Show true age",
                    "</br>When enabled, NPCs upon inspection will show their true age.",
                    Main.getProperties().hasValue(PropertyValue.showTrueAge)));

            UtilText.nodeContentSB.append(OptionsDialogue.getContentPreferenceDiv(
                    OptionsDialogue.ContentOptionsPage.MISC,
                    "SHOW_HEIGHT_APP_REAL",
                    PresetColour.BASE_GREEN_LIME,
                    "Decide Height off Appearance Age or Real Age",
                    "</br>True = Calculate Height off of Age Appearance, </br>False = Calculate Height off of Real Age",
                    Main.getProperties().hasValue(PropertyValue.scaleHeightBasedOnAgeAppearance)));

            UtilText.nodeContentSB.append(OptionsDialogue.getContentPreferenceDiv(
                    OptionsDialogue.ContentOptionsPage.MISC,
                    "SHOW_HEIGHT_GENDERED",
                    PresetColour.BASE_GREEN_LIME,
                    "Decide Height off Real Gender or Apparent Gender",
                    "</br>True = Calculate Height off of Real Gender, </br>False = Calculate Height off of Apparent Gender",
                    Main.getProperties().hasValue(PropertyValue.scaleHeightBasedOnGenderOrAppearance)));

            UtilText.nodeContentSB.append(OptionsDialogue.getContentPreferenceDiv(
                    OptionsDialogue.ContentOptionsPage.MISC,
                    "HEAVY_CPU_HEIGHT_CALC",
                    PresetColour.BASE_GREEN_LIME,
                    "Explicit or Implicit height calculations",
                    "</br>True = Calculate Height per month of life, </br>False = Approximate Height off of 'random' growth seed !! CPU INTENSIVE !!",
                    Main.getProperties().hasValue(PropertyValue.extremeCaseCalculations)));

            UtilText.nodeContentSB.append(OptionsDialogue.getContentPreferenceVariableDiv(
                    "HEIGHT_DEVIATION",
                    PresetColour.BASE_BLUE_LIGHT,
                    "Height Deviation",
                    "</br>This changes the base heights in cm",
                    Main.getProperties().heightDeviations+"cm",
                    Main.getProperties().heightDeviations,
                    -50,
                    50));

            UtilText.nodeContentSB.append(OptionsDialogue.getContentPreferenceVariableDiv(
                    "HEIGHT_AGE_CAP",
                    PresetColour.BASE_BLUE_STEEL,
                    "Height Calculated Age Cap",
                    "</br>This changes what age npcs are considered to be as tall as they can get",
                    String.valueOf(Main.getProperties().heightAgeCap),
                    Main.getProperties().heightAgeCap,
                    12,
                    50));

            UtilText.nodeContentSB.append(OptionsDialogue.getContentPreferenceVariableDiv(
                    "XP_MULT",
                    PresetColour.BASE_GREEN,
                    "XP Multiplier",
                    "</br>This increases the amount of xp you gain from victories in combat",
                    Main.getProperties().xpMultiplier+"%",
                    Main.getProperties().xpMultiplier,
                    100,
                    1000));

            UtilText.nodeContentSB.append(OptionsDialogue.getContentPreferenceVariableDiv(
                    "IMP_HMULT",
                    PresetColour.BASE_BROWN,
                    "Imp Height Multiplier",
                    "</br>This is multiplied by the usual height calculations for imps",
                    Main.getProperties().impHMult+"%",
                    Main.getProperties().impHMult,
                    10,
                    100));

            UtilText.nodeContentSB.append(OptionsDialogue.getContentPreferenceVariableDiv(
                    "A_IMP_HMULT",
                    PresetColour.BASE_ORANGE,
                    "Alpha Imp Height Multiplier",
                    "</br>This is multiplied by the usual height calculations for alpha imps",
                    Main.getProperties().aimpHMult+"%",
                    Main.getProperties().aimpHMult,
                    10,
                    100));

            UtilText.nodeContentSB.append(OptionsDialogue.getContentPreferenceVariableDiv(
                    "ESS_MULT",
                    PresetColour.BASE_PURPLE,
                    "Essences Mulitplier",
                    "</br>This increases the amount of Essences you get from sexual interactions",
                    Main.getProperties().essenceMultiplier+"%",
                    Main.getProperties().essenceMultiplier,
                    100,
                    10000));

            UtilText.nodeContentSB.append(OptionsDialogue.getContentPreferenceVariableDiv(
                    "MONEY_MULT",
                    PresetColour.BASE_GOLD,
                    "Money Mulitplier",
                    "</br>This increases the amount of Money you get from victories in combat",
                    Main.getProperties().moneyMultiplier+"%",
                    Main.getProperties().moneyMultiplier,
                    100,
                    100000));

            UtilText.nodeContentSB.append(OptionsDialogue.getContentPreferenceVariableDiv(
                    "DROPS_MULT",
                    PresetColour.BASE_GOLD,
                    "Drops Mulitplier",
                    "</br>This increases the amount of Items you get from victories in combat",
                    String.valueOf(Main.getProperties().itemDropsIncrease),
                    Main.getProperties().itemDropsIncrease,
                    0,
                    100));

            UtilText.nodeContentSB.append(OptionsDialogue.getContentPreferenceVariableDiv(
                    "MAX_LEVEL",
                    PresetColour.BASE_BLUE,
                    "Character Max Level",
                    "</br>This changes the max level of characters",
                    String.valueOf(Main.getProperties().maxLevel),
                    Main.getProperties().maxLevel,
                    25,
                    100));

            UtilText.nodeContentSB.append(OptionsDialogue.getContentPreferenceVariableDiv(
                    "OFFSPRING_AGE",
                    PresetColour.BASE_BLUE_LIGHT,
                    "Minimum Age offspring spawn at",
                    "</br>This is the lowest age an offspring can spawn at",
                    String.valueOf(Main.getProperties().offspringAge),
                    Main.getProperties().offspringAge,
                    5,
                    20));

            UtilText.nodeContentSB.append(OptionsDialogue.getContentPreferenceVariableDiv(
                    "OFFSPRING_AGE_DEVIATION",
                    PresetColour.BASE_BLUE_LIGHT,
                    "Chance of deviating from minimum",
                    "</br>This is the chance of up to 3 years being added to the offsprings age",
                    String.valueOf(Main.getProperties().offspringAgeDeviation),
                    Main.getProperties().offspringAgeDeviation,
                    0,
                    100));

            UtilText.nodeContentSB.append(OptionsDialogue.getContentPreferenceVariableDiv(
                    "AGE_CONVERT",
                    PresetColour.BASE_BLUE_LIGHT,
                    "Percent of people that get Age Shifted",
                    "</br>This percent is the percent of people who's age will be lowered below 18",
                    Main.getProperties().ageConversionPercent+"%",
                    Main.getProperties().ageConversionPercent,
                    0,
                    100));

            UtilText.nodeContentSB.append(OptionsDialogue.getContentPreferenceVariableDiv(
                    "HUNG_SHOTA",
                    PresetColour.BASE_BLUE,
                    "Percent of shotas that are well-endowed",
                    "</br>This percent is the percent of shotas who spawn with larger schlongs and higher virility",
                    Main.getProperties().hungShotasPercent+"%",
                    Main.getProperties().hungShotasPercent,
                    0,
                    100));

            UtilText.nodeContentSB.append(OptionsDialogue.getContentPreferenceVariableDiv(
                    "OPPAI_LOLI",
                    PresetColour.BASE_PINK_DEEP,
                    "Percent of lolis that get larger tits",
                    "</br>This percent is the percent of people who's age will be lowered below 18",
                    Main.getProperties().oppaiLolisPercent+"%",
                    Main.getProperties().oppaiLolisPercent,
                    0,
                    100));

            UtilText.nodeContentSB.append(OptionsDialogue.getContentPreferenceVariableDiv(
                    "PREG_LOLI",
                    PresetColour.BASE_PINK,
                    "Percent of lolis that are fertile",
                    "</br>This percent is the percent of lolis that will spawn with normal fertility",
                    Main.getProperties().pregLolisPercent+"%",
                    Main.getProperties().pregLolisPercent,
                    0,
                    100));

            UtilText.nodeContentSB.append(OptionsDialogue.getContentPreferenceVariableDiv(
                    "VIRGIN_LOVER",
                    PresetColour.BASE_PINK_LIGHT,
                    "Percent with vaginal/penile virginity",
                    "</br>This percent is the percent of people who's spawned as a virgin",
                    Main.getProperties().virginsPercent+"%",
                    Main.getProperties().virginsPercent,
                    0,
                    100));


            UtilText.nodeContentSB.append(OptionsDialogue.getContentPreferenceVariableDiv(
                    "MINIMUM_AGE",
                    PresetColour.BASE_ORANGE,
                    "Lowest Age anyone can be",
                    "</br>This is the Lowest Age anyone can be (player included)",
                    Main.getProperties().minAge+"",
                    Main.getProperties().minAge,
                    5,
                    500));


            UtilText.nodeContentSB.append(OptionsDialogue.getContentPreferenceVariableDiv(
                    "PLAYER_PREG_DUR",
                    PresetColour.BASE_PINK_LIGHT,
                    "Percent increase/decrease in player pregnancy duration",
                    "</br>This is a Percent increase/decrease in player pregnancy duration.",
                    Main.getProperties().playerPregDuration+"%",
                    Main.getProperties().playerPregDuration,
                    5,
                    100000));


            UtilText.nodeContentSB.append(OptionsDialogue.getContentPreferenceVariableDiv(
                    "NPC_PREG_DUR",
                    PresetColour.BASE_PINK_LIGHT,
                    "Percent increase/decrease in NPC pregnancy duration",
                    "</br>This is a Percent increase/decrease in NPC pregnancy duration.",
                    Main.getProperties().NPCPregDuration+"%",
                    Main.getProperties().NPCPregDuration,
                    5,
                    100000));

            return UtilText.nodeContentSB.toString();
        }

        @Override
        public String getContent(){
            return "";
        }

        @Override
        public Response getResponse(int responseTab, int index) {
            if (index == 0) {
                return new Response("Back", "Go back to the options menu.", OptionsDialogue.MENU);

            } else {
                return null;
            }
        }

        @Override
        public DialogueNodeType getDialogueNodeType() {
            return DialogueNodeType.OPTIONS;
        }
    };
}
