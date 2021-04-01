package com.lilithsthrone.LolificationProject;

@SuppressWarnings("all")
public class Library {
    public static final String NAME = "Lolilith's Throne";
    public static final String VERSION = "_54";

    /* MODIFICATION LOG
    Action  |   Description                                                 | Class                              | Location (Post modifcation)
    ADD         WetSlots Variable                                           CharacterInventory.java                 ln[72]
    ADD         WetSlot  Functions                                          CharacterInventory.java                 ln[2535]
    ADD         SlotFunctions                                               GameCharacter.java                      ln[22475]
    ADD         Fetishes                                                    Fetish.java                             ln[1751]
    ADD         WetFunction                                                 AbstractClothing.java                   ln[2690]
    ADD         ModOption getters                                           Game.java                               ln[4637]
    ADD         NumericalVariables                                          Properties.java                         ln[1513]
    ADD         Option Toggles                                              MainControllerInitMethod.java           ln[7367]
    ADD         Option Saving                                               Properties.java                         ln[335]
    ADD         Option Loading                                              Properties.java                         ln[883]
    ADD         Age Categories                                              AgeCategory.java                        ln[18]
    ADD         Age Color Presets                                           PresetColour.java                       ln[1304]
    CHANGE      getContentPreferenceDiv Private->Public                     OptionsDialogue.java                    ln[2620]
    CHANGE      getContentPreferenceVariableDiv Private->Public             OptionsDialogue.java                    ln[2713]
    ADD         ModOptions button                                           OptionsDialogue.java                    ln[255]
    ADD         ModOption Booleans                                          PropertyValue.java                      ln[85]
    REPLACE     Age Description Code                                        Body.java                               ln[2127]
    REPLACE     Offspring Age Setting                                       GameCharacter.java                      ln[19130]
    ADD         Modded Flag                                                 NPC.java                                ln[118]
    ADD         Modded Flag Saving                                          NPC.java                                ln[321]
    ADD         Modded Flag Loading                                         NPC.java                                ln[367]
    ADD         Offspring Moddifications                                    Game.java                               ln[3977]
    ADD         NPC Age Modifications                                       Game.java                               ln[4084]
    REPLACE     Offspring Age Supercall's                                   NPCOffspring.java                       ln[52,63]
    REPLACE     Minimum Age Static Final                                    GameCharacter.java                      ln[310]
    ADD         Testing Cheats                                              PhoneDialogue.java                      ln[142]
    CHANGE      private->public and String[] to List                        Name.java                               ALL
    CHANGE      ^ appropriate length->size() calls and getters              ^                                       ^
    ADD         Extra Combat Effects                                        Combat.java                             ln[1166]
    ADD         Loot Bonus Config                                           Combat.java                             ln[344,390]
    CHANGE      Max Character Level                                         GameCharacter.java                      ln[305]
    CHANGE      getLootItem now does multiple rolls                         NPC.java                                ln[930]
    ADD         URINE                                                       FluidType.java                          ln[25]
    ADD         NECTAR                                                      FluidFlavour.java                       ln[17]
    ADD         URINE TYPE                                                  FluidTypeBase.java                      ln[17]
    ADD         URINE COVERING TYPE                                         BodyCoveringType.java                   ln[26]
    ADD         Watersports                                                 SexActionPresets.java                   ln[520]
    ADD         Assets                                                      res/inventoryIcons|fetishes             <---
    REPLACE     Main Window Title                                           Main.java                               ln[900]
    ADD         Wet Icon                                                    SVGImages.java                          ln[27,137,1644]
    ADD         Wet Rendering                                               RenderingEngine.java                    ln[315,489,510,518,549,946,1018]
    ADD         Fetish Parity                                               SexType.java                            ln[501]
    ADD         Fetish TF Mod                                               TFModifier.java                         ln[1356]
    ADD         Fetish Pairing Urine/Ageplay                                NPC.java                                ln[2050]
    ADD         Fetish in journal                                           PhoneDialogue.java                      ln[3423]
    REPLACE     return with TranslationUtils.clean()                        UtilText.java                           ln[1247]
    ADD         WetSlot Intializers                                         CharacterInventory.java                 ln[104]
    REPLACE     Age < 18 with GameCharacter.MINIMUM_AGE                     CharacterModificationUtils.java         ln[434,435]
    REPLACE     Character Minimum Age with GameCharacter.MINIMUM_AGE        CharacterModificationUtils.java         ln[469,513,931]
    CHANGE      Minimum Heights down 2 tiers                                GameCharacter.java                      ln[24147-14154]
    REPLACE     All Calls to setHeight to ignore height restrictions        GameCharacter.java                      ln[24169]
    REPLACE     Minimum Height                                              Height.java                             ln[81]
    REPLACE     Preg Duration                                               GameCharacter.java                      ln[19218]
    ^           ^                                                           StatusEffect.java                       ln[3630,3825]

     */
}
