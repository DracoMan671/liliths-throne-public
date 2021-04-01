package com.lilithsthrone.LolificationProject.ModCommon;

import com.lilithsthrone.game.character.GameCharacter;
import com.lilithsthrone.game.character.persona.Name;
import com.lilithsthrone.game.character.persona.NameTriplet;
import com.lilithsthrone.game.dialogue.utils.ParserCommand;
import com.lilithsthrone.main.Main;
import com.lilithsthrone.utils.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

import static com.lilithsthrone.game.dialogue.utils.UtilText.commandsList;

@SuppressWarnings({"unused", "WeakerAccess"})
public class TranslationUtils {
    public static String language = "en_US";
    public static final File translationFolder = new File("./res/Translation/");
    public static HashMap<String, String> swaps = new HashMap<>();
    public static void init() {
        File[] shouldOnlyBeOne = translationFolder.listFiles(a -> a.getName().endsWith(".enabled"));
        language = (shouldOnlyBeOne != null && shouldOnlyBeOne.length == 1) ?
                shouldOnlyBeOne[0].getName().replace(".enabled", "") : "en_US";
// This was to test if the names were being added and used properly... TL;DR they do first try wow.
//        Name.human = new ArrayList<>();
//        Name.surnames = new ArrayList<>();


        File names = new File("./res/names.txt");
        if (names.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(names));
                reader.lines().forEach(line -> {
                    if (!line.startsWith("#")) {
                        if (line.contains("=")) {
                            String[] arr = line.split("=");
                            String[] nms = arr[1].split(",");
                            List<String> tnames = Arrays.asList(nms);
                            if (!tnames.isEmpty() && tnames.size() != 3 && !arr[0].equalsIgnoreCase("lilin")) {
                                tnames.add(tnames.get(0));
                                if (tnames.size() != 3)
                                    tnames.add(tnames.get(0));
                            }
                            if (tnames.isEmpty()) {
                                tnames.add("Need_1-3_names_seperated_by_,'s_single_names_get_duplicated");
                                tnames.add("Need_1-3_names_seperated_by_,'s_single_names_get_duplicated");
                                tnames.add("Need_1-3_names_seperated_by_,'s_single_names_get_duplicated");
                            }
                            switch (arr[0].toLowerCase()) {
                                case ("equine") :
                                    Name.equine.add(new NameTriplet(tnames.get(0), tnames.get(1), tnames.get(2)));
                                    break;
                                case ("reindeer") :
                                    Name.reindeer.add(new NameTriplet(tnames.get(0), tnames.get(1), tnames.get(2)));
                                    break;
                                case ("prostitute") :
                                    Name.prostitute.add(new NameTriplet(tnames.get(0), tnames.get(1), tnames.get(2)));
                                    break;
                                case ("lilin") :
                                    Name.lilinNames.addAll(tnames);
                                    break;
                                default :
                                case ("human") :
                                    Name.human.add(new NameTriplet(tnames.get(0), tnames.get(1), tnames.get(2)));
                                    break;
                            }
                        }
                    }
                });
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        File surnames = new File("./res/surnames.txt");
        if (surnames.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(surnames));
                reader.lines().forEach(line -> {
                    if (!line.startsWith("#")) {
                        if (line.contains("=")) {
                            String[] arr = line.split("=");
                            String[] nms = arr[1].split(",");
                            List<String> tnames = Arrays.asList(nms);
                            switch (arr[0]) {
                                case ("youkoSurnames") :
                                    Name.youkoSurnames.addAll(tnames);
                                    break;
                                case ("surnames") :
                                default :
                                    Name.surnames.addAll(tnames);
                                    break;
                            }
                        }
                    }
                });
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        File lang = new File(translationFolder, language + "/chatswaps.lang");
        if (lang.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(lang));
                reader.lines().forEach(line -> {
                    if (!line.startsWith("#")) {
                        if (line.contains("=")) {
                            String[] arr = line.split("=");
                            if (arr.length > 2) {
                                swaps.put(arr[0] + "=" + arr[1], arr[2]);
                            } else {
                                swaps.put(arr[0], arr[1]);
                            }
                        }
                    }
                });
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        commandsList.add(new ParserCommand(
                Collections.singletonList("pee"),
                false,
                false,
                "",
                "Returns a renaming of pee.") {
            @Override
            public String parse(List<GameCharacter> specialNPCs, String command, String arguments, String target, GameCharacter character) {
                return getStringFor("pee");
            }
        });

    }

    public static String getStringFor(String unlocalized) {
        String[] arr = getStringsFor(unlocalized);
        return arr[Util.random.nextInt(arr.length - 1)];
    }

    public static String getStringFor(String unlocalized, boolean reversePerspective) {
        return reversePerspective ? reversePerspective(getStringFor(unlocalized)) : getStringFor(unlocalized);
    }

    @SuppressWarnings("ToArrayCallWithZeroLengthArrayArgument")
    public static String[] getStringsFor(String unlocalized) {
        List<String> translations = new ArrayList<>();
        try {
            File lang = new File(translationFolder, unlocalized.contains(".") ? language + "/" + unlocalized.split("\\.")[0] + ".lang" : language + ".lang");
            BufferedReader reader = new BufferedReader(new FileReader(lang));
            reader.lines().forEach(line -> {
                if (!line.startsWith("#") && line.contains("=")) {
                    if (line.split("=")[0].equals(unlocalized.replaceFirst(unlocalized.split("\\.")[0] + "\\.", ""))) {
                        translations.add(line.split("=")[1]);
                    }
                }
            });
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return translations.toArray(new String[translations.size()]);
    }

    public static String[] getStringsFor(String unlocalized, boolean reversePerspective) {
        String[] Outgoing = getStringsFor(unlocalized);
        return reversePerspective ? reversePerspectives(Outgoing) : Outgoing;
    }

    public static String reversePerspective(String localized) {
        return localized.replaceAll("npc2\\.", "to_err_is_man").replaceAll("npc\\.", "npc2\\.").replaceAll("to_err_is_man", "npc\\.");
    }

    public static String[] reversePerspectives(String[] localized) {
        for (int i = 0; i < localized.length; i++)
            localized[i] = reversePerspective(localized[i]);
        return localized;
    }

//TODO: Find where this belongs
    public static AtomicReference<String> str = new AtomicReference<>();
    public static String clean(String dirtyDialogue) {
        if (swaps.isEmpty()) return dirtyDialogue;
        str.set(dirtyDialogue);
        if (Main.game != null && Main.game.getActiveNPC() != null) {
            GameCharacter c = Main.game.getActiveNPC();

            try {
                swaps.forEach((get, replaceWith) -> {
                    String oldStr = str.get();
                    String newStr = oldStr;
                    if (get.startsWith("age(") && get.contains(".")) {
                        String ageCheck = get.split("\\(")[1].split("\\)")[0];
                        int age = Integer.parseInt(ageCheck.replaceAll("=|>|<", ""));
                        String toReplace = get.split("\\.")[1];
                        if (ageCheck.contains("=")) {
                            if (ageCheck.contains(">") && c.getAgeValue() >= age) {
                                newStr = newStr.replaceAll(toReplace, replaceWith.replaceAll("\\[gender_elder_sibling]", genderedCute()));
                            } else if (ageCheck.contains("<") && c.getAgeValue() <= age) {
                                newStr = newStr.replaceAll(toReplace, replaceWith.replaceAll("\\[gender_elder_sibling]", genderedCute()));
                            } else if (c.getAgeValue() == age) {
                                newStr = newStr.replaceAll(toReplace, replaceWith.replaceAll("\\[gender_elder_sibling]", genderedCute()));
                            }
                        } else if (ageCheck.contains(">") && c.getAgeValue() > age) {
                            newStr = newStr.replaceAll(toReplace, replaceWith.replaceAll("\\[gender_elder_sibling]", genderedCute()));
                        } else if (ageCheck.contains("<") && c.getAgeValue() < age) {
                            newStr = newStr.replaceAll(toReplace, replaceWith.replaceAll("\\[gender_elder_sibling]", genderedCute()));
                        } else if (c.getAgeValue() == age) {
                            newStr = newStr.replaceAll(toReplace, replaceWith.replaceAll("\\[gender_elder_sibling]", genderedCute()));
                        }
                    } else {
                        newStr = newStr.replaceAll(get, replaceWith.replaceAll("\\[gender_elder_sibling]", genderedCute()));
                    }

                    str.compareAndSet(oldStr, newStr);
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str.get();
    }

    public static String genderedCute() {
        return Main.game.getPlayer().isFeminine() ? "Onee" : "Onii";
    }
}
