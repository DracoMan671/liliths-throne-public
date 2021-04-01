package com.lilithsthrone.LolificationProject.ModCommon;

import com.lilithsthrone.game.character.GameCharacter;
import com.lilithsthrone.game.character.PlayerCharacter;
import com.lilithsthrone.game.character.attributes.Attribute;
import com.lilithsthrone.game.character.body.valueEnums.*;
import com.lilithsthrone.game.character.effects.Perk;
import com.lilithsthrone.game.character.gender.PronounType;
import com.lilithsthrone.game.character.npc.NPC;
import com.lilithsthrone.game.character.race.Race;
import com.lilithsthrone.game.character.race.Subspecies;
import com.lilithsthrone.main.Main;
import com.lilithsthrone.utils.Util;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SuppressWarnings("all")
public class Conversions {
    public static NPC applyAgeEffects(NPC npc) {
        if (npc == null || npc.getBody() == null || npc.haveWeModded || npc.isUnique()) return npc;

        npc.haveWeModded = true;


        //Gets the characters age value, to calculate changes
        int tempRealAge = npc.getAgeValue();
        int tempAge = npc.getAppearsAsAgeValue();//new thought, because true legal lolis exist

        if (Util.random.nextInt(100) < Main.getProperties().virginsPercent) {
            npc.setVaginaVirgin(true);
            npc.setPenisVirgin(true);
        }

        if (npc.getRace() == Race.SLIME || npc.getRace() == Race.DEMON) return npc;

        npc = modifyHeight(npc, tempAge, tempRealAge);

        //If character has breasts, changes the size to match ages
        if (npc.hasBreasts()) {
            if (Util.random.nextInt(100) > Main.getProperties().oppaiLolisPercent) {
                if (tempAge < 16 && tempAge > 12)
                    npc.setBreastSize(CupSize.FLAT.getMeasurement() + Util.random.nextInt(8));
                else if (tempAge < 13 && tempAge > 9)
                    npc.setBreastSize(CupSize.FLAT.getMeasurement() + Util.random.nextInt(5));
                else if (tempAge <= 9)
                    npc.setBreastSize(CupSize.FLAT.getMeasurement() + Util.random.nextInt(3));
            }

            if (npc.getBreastSize().getMeasurement() <= CupSize.C.getMeasurement()) {
                npc.setNippleCapacity(Capacity.ONE_EXTREMELY_TIGHT.getMinimumValue(), false);
                npc.setNippleStretchedCapacity(0);
                npc.setNippleElasticity(OrificeElasticity.ONE_RIGID.getValue());
                npc.setNippleSize(Util.random.nextBoolean() ? NippleSize.ONE_SMALL : NippleSize.ZERO_TINY);
            }

            if (npc.getBreastSize().getMeasurement() <= CupSize.A.getMeasurement()) {
                npc.setNippleCapacity(Capacity.ZERO_IMPENETRABLE.getMinimumValue(), false);
                npc.setNippleStretchedCapacity(0);
                npc.setNippleElasticity(OrificeElasticity.ZERO_UNYIELDING.getValue());
                npc.setNippleSize(NippleSize.ZERO_TINY);
            }
        }

        if (npc.hasVagina()) {
            if (tempRealAge < 16 && tempRealAge > 12) {
                float cap = Capacity.ONE_EXTREMELY_TIGHT.getMinimumValue() + Util.random.nextInt(6);
                npc.setVaginaCapacity(cap, false);
                npc.setVaginaStretchedCapacity(0);
                npc.setVaginaLabiaSize(LabiaSize.ONE_SMALL);
                npc.setVaginaElasticity(Util.random.nextBoolean() ? OrificeElasticity.TWO_FIRM.getValue() : OrificeElasticity.ONE_RIGID.getValue());
                if (Util.random.nextFloat() >= 0.75f) {
                    npc.setVaginaVirgin(true);
                }
            } else if (tempRealAge < 13 && tempRealAge > 9) {
                float cap = Capacity.ONE_EXTREMELY_TIGHT.getMinimumValue() + Util.random.nextInt(4);
                npc.setVaginaCapacity(cap, false);
                npc.setVaginaLabiaSize(LabiaSize.ZERO_TINY);
                npc.setVaginaStretchedCapacity(0);
                npc.setVaginaElasticity(Util.random.nextBoolean() ? OrificeElasticity.ONE_RIGID.getValue() : OrificeElasticity.ZERO_UNYIELDING.getValue());
                if (Util.random.nextFloat() >= 0.6f) {
                    npc.setVaginaVirgin(true);
                }
            } else if (tempRealAge <= 9) {
                float cap = Capacity.ZERO_IMPENETRABLE.getMinimumValue() + Util.random.nextInt(4);
                npc.setVaginaCapacity(cap, false);
                npc.setVaginaStretchedCapacity(0);
                npc.setVaginaLabiaSize(LabiaSize.ZERO_TINY);
                npc.setVaginaElasticity(Util.random.nextBoolean() ? OrificeElasticity.ONE_RIGID.getValue() : OrificeElasticity.ZERO_UNYIELDING.getValue());
                if (Util.random.nextFloat() >= 0.4f) {
                    npc.setVaginaVirgin(true);
                }
            }
        }

        if (tempAge < 16) {
            boolean bornForAnal = Util.random.nextBoolean();
            if (tempAge < 13 && tempAge > 9) {
                npc.setAssCapacity(npc.isAssVirgin() ? bornForAnal ? Capacity.TWO_TIGHT.getMinimumValue() : Capacity.ONE_EXTREMELY_TIGHT.getMinimumValue() : Capacity.TWO_TIGHT.getMinimumValue(), false);
                npc.setAssStretchedCapacity(0);
            } else if (tempAge < 8) {
                npc.setAssCapacity(npc.isAssVirgin() ? bornForAnal ? Capacity.TWO_TIGHT.getMinimumValue() : Capacity.ZERO_IMPENETRABLE.getMinimumValue() : Capacity.TWO_TIGHT.getMinimumValue(), false);
                npc.setAssStretchedCapacity(0);
            } else {
                npc.setAssCapacity(npc.isAssVirgin() ? bornForAnal ? Capacity.TWO_TIGHT.getMinimumValue() : Capacity.ONE_EXTREMELY_TIGHT.getMinimumValue() : Capacity.THREE_SLIGHTLY_LOOSE.getMinimumValue(), false);
                npc.setAssStretchedCapacity(0);
            }
        }

        if (tempAge < 16) {
            boolean bornForDeepThroating = Util.random.nextBoolean();
            if (tempAge < 13 && tempAge > 9)
                npc.setFaceCapacity(npc.isFaceVirgin() ? bornForDeepThroating ? Capacity.TWO_TIGHT.getMinimumValue() : Capacity.ONE_EXTREMELY_TIGHT.getMinimumValue() : Capacity.TWO_TIGHT.getMinimumValue(), false);
            else if (tempAge < 8)
                npc.setFaceCapacity(npc.isFaceVirgin() ? bornForDeepThroating ? Capacity.TWO_TIGHT.getMinimumValue() : Capacity.ZERO_IMPENETRABLE.getMinimumValue() : Capacity.TWO_TIGHT.getMinimumValue(), false);
            else
                npc.setFaceCapacity(npc.isFaceVirgin() ? bornForDeepThroating ? Capacity.TWO_TIGHT.getMinimumValue() : Capacity.ONE_EXTREMELY_TIGHT.getMinimumValue() : Capacity.THREE_SLIGHTLY_LOOSE.getMinimumValue(), false);
        }

        if (npc.hasPenis() && Util.random.nextInt(100) > Main.getProperties().hungShotasPercent) {
            if (tempRealAge < 16 && tempRealAge > 12) {
                npc.setPenisSize(PenisLength.TWO_AVERAGE.getMinimumValue() + Util.random.nextInt(3) + (shouldCockBeLarger(npc) ? Util.random.nextInt(4) : 0));
                npc.setUrethraElasticity(Util.random.nextBoolean() ? OrificeElasticity.TWO_FIRM.getValue() : OrificeElasticity.ONE_RIGID.getValue() + (shouldCockBeLarger(npc) ? Util.random.nextInt(2) : 0));
            } else if (tempRealAge < 13 && tempRealAge > 9) {
                npc.setPenisSize(PenisLength.ONE_TINY.getMinimumValue() + Util.random.nextInt(3) + (shouldCockBeLarger(npc) ? Util.random.nextInt(5) : 0));
                npc.setUrethraElasticity(Util.random.nextBoolean() ? OrificeElasticity.ONE_RIGID.getValue() : OrificeElasticity.ZERO_UNYIELDING.getValue() + (shouldCockBeLarger(npc) ? Util.random.nextInt(2) : 0));
            } else if (tempRealAge <= 9) {
                npc.setPenisSize(Math.max(1, PenisLength.ZERO_MICROSCOPIC.getMinimumValue() + Util.random.nextInt(3) + (shouldCockBeLarger(npc) ? Util.random.nextInt(6) : 0)));
                npc.setUrethraElasticity(OrificeElasticity.ZERO_UNYIELDING.getValue() + (shouldCockBeLarger(npc) ? Util.random.nextInt(2) : 0));
            }
        }

        float v = npc.getAttributeValue(Attribute.VIRILITY);
        float f = npc.getAttributeValue(Attribute.FERTILITY);

        //Removes body hair
        if ((tempAge <= 14 && Util.random.nextInt(5) < 4) || tempAge < 12) {
            npc.setPubicHair(BodyHair.ZERO_NONE);
            npc.setUnderarmHair(BodyHair.ZERO_NONE);
            npc.setAssHair(BodyHair.ZERO_NONE);
            npc.setFacialHair(BodyHair.ZERO_NONE);
        }
        if (tempRealAge <= 12) {
            if (f > 0.15f && Util.random.nextInt(100) > Main.getProperties().pregLolisPercent)
                npc.setAttribute(Attribute.FERTILITY, tempAge > 8 ? tempAge / 100f : 0);
            if (v > 0.15f && Util.random.nextInt(100) > Main.getProperties().hungShotasPercent)
                npc.setAttribute(Attribute.VIRILITY, tempAge > 6 ? tempAge / 100f : 0);
        }

        return npc;
    }

    private static NPC modifyHeight(NPC npc, int tempAge, int tempRealAge) {
        int deviation1 = Main.getProperties().heightDeviations;
        float smallDeviation = deviation1 / 100f;

        int ageForMath = Main.game.isHeightAppearanceBased() ? (tempAge * 12) : ((tempRealAge * 12) + Math.max(0, (npc.getBirthMonth().getValue()) - 11));

        ageForMath = ageForMath - Math.min(ageForMath - Main.getProperties().heightAgeCap, 0); //Capping max height by "age"

        ageForMath -= 60; // Normalizing since calculations assume 5 year old minimum

        float newHeight = 0f;
        byte simpleGenderAssignment = 0; // Fight me SJWs

        float MedianMale = 110.3f + deviation1;//At 5 years old
        float Median = 109.45f + deviation1;//At 5 years old
        float MedianFemale = 109.6f + deviation1;//At 5 years old

        float minorSalting = Util.random.nextBoolean() ? 0.4f + ((float) Util.random.nextInt(20)/100f) : Util.random.nextBoolean() ? 0.423f : 0.583f; //Because WHO has a 0.4-0.6 growth per month calculated

        float StandardDeviation = 4.6822f + smallDeviation;
        float StandardDeviationF = 4.7731f + smallDeviation;
        float StandardDeviationM = 4.5914f + smallDeviation;
        float tinyDeviation = smallDeviation / 85f;
        float StandardDeviationScalar = 0.0315f + tinyDeviation;
        float StandardDeviationScalarF = 0.0324f + tinyDeviation;
        float StandardDeviationScalarM = 0.0306f + tinyDeviation;

        if (Main.game.isHeightGendered()) { // 0 = neutral, 1 = female, -1 = male
            if (npc.hasVagina())
                simpleGenderAssignment++;
            if (npc.hasPenis())
                simpleGenderAssignment--;
            //boobs mean nothing in the scope here
        } else {
            if (npc.getGender().getType() == PronounType.FEMININE)
                simpleGenderAssignment = 1;
            else if (npc.getGender().getType() == PronounType.MASCULINE)
                simpleGenderAssignment = -1;
            else
                simpleGenderAssignment = 0;
        }


        float SD;
        switch (simpleGenderAssignment) {
            case -1:
                SD = (ageForMath * StandardDeviationScalarM) + StandardDeviationM;
                SD = Math.min(6.56f, SD);
                if (Main.game.isHeightExplicitlyCalculated()) {
                    float h = MedianMale;
                    for (int i = 1; i <= (Math.min(ageForMath, 110)); i++) {
                        h += (Util.random.nextBoolean() ? 0.4f + ((float) Util.random.nextInt(20)/100f) : Util.random.nextBoolean() ? 0.423f : 0.613f);
                    }
                    h += (Math.max(0f, ageForMath - 110f) * 0.1f);
                    newHeight = h + ((float) (Util.random.nextBoolean() ? 0 : Util.random.nextBoolean() ? 1 : -1) * SD);
                } else {
                    newHeight = MedianMale + (Math.min(ageForMath, 110) * minorSalting) + ((float) (Util.random.nextBoolean() ? 0 : Util.random.nextBoolean() ? 1 : -1) * SD) + (Math.max(0f, ageForMath - 110f) * 0.1f);
                }
                break;
            case 1 :
                SD = (ageForMath * StandardDeviationScalarF) + StandardDeviationF;
                SD = Math.min(6.56f, SD);

                if (Main.game.isHeightExplicitlyCalculated()) {
                    float h = MedianFemale;
                    for (int i = 1; i <= (Math.min(ageForMath, 110)); i++) {
                        h += (Util.random.nextBoolean() ? 0.4f + ((float) Util.random.nextInt(20)/100f) : Util.random.nextBoolean() ? 0.423f : 0.613f);
                    }
                    h += (Math.max(0f, ageForMath - 110f) * 0.1f);
                    newHeight = h + ((float) (Util.random.nextBoolean() ? 0 : Util.random.nextBoolean() ? 1 : -1) * SD);
                } else {
                    newHeight = MedianFemale + (Math.min(ageForMath, 110) * minorSalting) + ((float) (Util.random.nextBoolean() ? 0 : Util.random.nextBoolean() ? 1 : -1) * SD) + (Math.max(0f, ageForMath - 110f) * 0.1f);
                }
                break;
            default :
                SD = (ageForMath * StandardDeviationScalar) + StandardDeviation;
                SD = Math.min(6.56f, SD);

                if (Main.game.isHeightExplicitlyCalculated()) {
                    float h = Median;
                    for (int i = 1; i <= (Math.min(ageForMath, 110)); i++) {
                        h += (Util.random.nextBoolean() ? 0.4f + ((float) Util.random.nextInt(20)/100f) : Util.random.nextBoolean() ? 0.423f : 0.613f);

                    }
                    h += (Math.max(0f, ageForMath - 110f) * 0.1f);
                    newHeight = h + ((float) (Util.random.nextBoolean() ? 0 : Util.random.nextBoolean() ? 1 : -1) * SD);
                } else {
                    newHeight = Median + (Math.min(ageForMath, 110) * minorSalting) + ((float) (Util.random.nextBoolean() ? 0 : Util.random.nextBoolean() ? 1 : -1) * SD) + (Math.max(0f, ageForMath - 110f) * 0.1f);
                }
                break;
        }

        if (newHeight != 0) {
            if (npc.getSubspecies() == Subspecies.IMP_ALPHA) {
                npc.getBody().setHeight(Math.round(newHeight * ((float) Main.getProperties().aimpHMult / 100f)));
            } else if (npc.getSubspecies() == Subspecies.IMP) {
                npc.getBody().setHeight(Math.round(newHeight * ((float) Main.getProperties().impHMult / 100f)));
            } else {
                npc.getBody().setHeight(Math.round(newHeight));
            }
        }
        return npc;
    }

    public static NPC changeAge(NPC npc) {
        if (npc.getAgeValue() > 18 && npc.getAppearsAsAgeValue() > 18 && Util.random.nextFloat() < (Main.getProperties().ageConversionPercent/100f) && !npc.haveWeModded) {
            if (Util.random.nextFloat() > 0.6f) {
                npc.setAgeAppearanceDifferenceToAppearAsAge(npc.getAppearsAsAgeValue() - Util.random.nextInt(npc.getAppearsAsAgeValue() >>> 1));
            } else {
                int age = LocalDate.now().getYear() - npc.getBirthday().getYear();
                age -= age >>> 1;
                LocalDateTime bday = LocalDateTime.of(LocalDate.of(LocalDateTime.now().getYear() - age, npc.getBirthMonth(), npc.getDayOfBirth()), npc.getBirthday().toLocalTime());
                npc.setBirthday(bday);
            }
        }
        npc = applyAgeEffects(npc);
//        npc.haveWeModded = true;
        return npc;
    }

    public static String getAgeDescriptor(GameCharacter owner) {
        return " [npc.She] [npc.verb(appear)] to be <span style='color:" + owner.getAppearsAsAge().getColour().toWebHexString() + ";'>" //Color from age appearance
                + (!Main.game.isShowAgeEnabled() ? owner.getAppearsAsAge().getName() + "</span>." : owner.getAppearsAsAgeValue() + "</span>" //Show age category if show age disabled
                + (!Main.game.getPlayer().hasTrait(Perk.OBSERVANT, true) && Main.game.isShowTrueAgeEnabled() ? "." : owner.getAgeValue() == owner.getAppearsAsAgeValue() //If show true age and observant with will pass the check to is equal
                ? " and, thanks to your observant perk, you can confirm that [npc.she] looks true to [npc.her] age."
                : " but, thanks to your observant perk, you can tell that [npc.sheIs] really <span style='color:" + owner.getAge().getColour().toWebHexString()+";'>" + owner.getAgeValue() + "</span>."));
    }

    public static int getOffspringAge() {
        int newAge = Main.getProperties().offspringAge;
        int randomDeviation = Util.random.nextInt(3);
        return Util.random.nextInt(100) <= Main.getProperties().offspringAgeDeviation ? newAge + randomDeviation : newAge;
    }

    private static boolean shouldCockBeLarger(GameCharacter character) {
        return (character.getPenisRace() != Race.HORSE_MORPH || character.getPenisRace() != Race.DEMON || character.getPenisRace() != Race.REINDEER_MORPH || character.getPenisRace() != Race.COW_MORPH);
    }
}
