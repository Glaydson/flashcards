package flashcards;

import java.io.*;
import java.util.*;

public class Main {

    static Map<String, String> flashCards = new LinkedHashMap<>();
    static Map<String, Integer> mistakes = new LinkedHashMap<>();
    static List<String> log = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        String cardFileName = null;
        boolean exportOnExit = false;

        if (args.length != 0) {
            if (args.length == 2) {
                if (args[0].equals("-import")) {
                    String fileName = args[1];
                    importFile(fileName);
                } else {  // -export
                    cardFileName = args[1];
                    exportOnExit = true;
                }
            } else { // args.length = 4
                if (args[0].equals("-import")) {
                    String fileName = args[1];
                    importFile(fileName);
                    cardFileName = args[3];
                    exportOnExit = true;
                } else { //-export
                    cardFileName = args[1];
                    exportOnExit = true;
                    String fileName = args[3];
                    importFile(fileName);
                }
            }
        }


        String action = "";
        while (!action.equals("exit")) {
            // Show menu options
            String input = "Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats): ";
            System.out.println(input);
            log.add(input);
            action = scanner.nextLine();
            log.add(action);
            // Process action
            switch (action) {
                case "add": {
                    // Read a card and add it in the Map
                    System.out.println("The card:");
                    log.add("The card:");
                    String term = scanner.nextLine();
                    log.add(term);
                    if (termIsDuplicated(term)) {
                        String output = "The card " + "\"" + term + "\"" + " already exists.";
                        System.out.println(output);
                        log.add(output);
                        break;
                    }
                    System.out.println("The definition: ");
                    log.add("The definition: ");
                    String definition = scanner.nextLine();
                    log.add(definition);
                    if (definitionIsDuplicated(definition)) {
                        String output = "The definition " + "\"" + definition + "\"" + " already exists.";
                        System.out.println(output);
                        log.add(output);
                        break;
                    }
                    flashCards.put(term, definition);
                    mistakes.put(term, 0);
                    String added = "The pair " + "\"" + term + "\":" + "\"" +
                            definition + "\"" + " has been added.";
                    System.out.println(added);
                    log.add(added);
                    break;
                }
                case "remove": {
                    // Read a card and remove it from the Map
                    System.out.println("The card:");
                    log.add("The card:");
                    String term = scanner.nextLine();
                    log.add(term);
                    if (flashCards.containsKey(term)) {
                        flashCards.remove(term);
                        String removed = "The card has been removed.";
                        System.out.println(removed);
                        log.add(removed);
                        mistakes.remove(term);
                    } else {
                        String cantRemove = "Can't remove " + "\"" +
                                term + "\": " + "there is no such card.";
                        System.out.println(cantRemove);
                        log.add(cantRemove);
                    }
                    break;
                }
                case "import": {
                    System.out.println("File name:");
                    log.add("File name:");
                    String fileName = scanner.next();
                    log.add(fileName);
                    File file = new File("./" + fileName);
                    int qtyLoaded = 0;
                    try (Scanner fileScanner = new Scanner(file).useDelimiter("-")) {
                        while (fileScanner.hasNext()){
                            String term = fileScanner.next();
                            if (term.equals("")) break;
                            String definition = fileScanner.next().replace("-", "");
                            Integer numMistakes = Integer.valueOf(fileScanner.nextLine().replace("-", ""));

                            if (flashCards.containsKey(term)) {
                                flashCards.replace(term, definition);
                                mistakes.replace(term, numMistakes);
                            } else {
                                flashCards.put(term, definition);
                                mistakes.put(term, numMistakes);
                            }
                            qtyLoaded++;
                        }
                        String loaded = qtyLoaded + " cards have been loaded.";
                        System.out.println(loaded);
                        log.add(loaded);
                    } catch (FileNotFoundException fnfe) {
                        String fileNotFound = "File not found.";
                        System.out.println(fileNotFound);
                        log.add(fileNotFound);
                    }
                    scanner.nextLine();
                    break;
                }
                case "export": {
                    System.out.println("File name:");
                    log.add("File name:");
                    String fileName = scanner.nextLine();
                    log.add(fileName);
                    File file = new File("./" + fileName);
                    try (PrintWriter writer = new PrintWriter(file)){
                        flashCards.forEach((term, definition) -> {
                                writer.print(term + "-");
                                writer.print(definition + "-");
                                writer.println(mistakes.get(term));
                        });
                        String saved = flashCards.size() + " cards have been saved.";
                        System.out.println(saved);
                        log.add(saved);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "ask": {
                    String ask = "How many times to ask?";
                    System.out.println(ask);
                    log.add(ask);
                    int numberTimes = scanner.nextInt();
                    log.add(String.valueOf(numberTimes));
                    scanner.nextLine();
                    List<String> keysAsArray = new ArrayList<String>(flashCards.keySet());

                    Random r = new Random();
                    for (int i = 0; i < numberTimes; i++) {
                        String term = keysAsArray.get(r.nextInt(keysAsArray.size()));
                        String askDefinition = "Print the definition of " + "\"" + term + "\":";
                        System.out.println(askDefinition);
                        log.add(askDefinition);
                        String answer = scanner.nextLine();
                        log.add(answer);
                        String definition = flashCards.get(term).trim();
                        if (answer.equals(definition)) {
                            System.out.println("Correct!");
                            log.add("Correct!");

                        } else {
                            if (flashCards.containsValue(answer)) {
                                String wrongAnswer = "Wrong answer. The right answer is \"" + definition + "\"," +
                                        " but your definition is correct for " + "\"" + findKeyForValue(answer) +
                                        "\"";
                              System.out.println(wrongAnswer);
                              log.add(wrongAnswer);
                            } else {
                                String wrong = "Wrong. The right answer is " + "\"" + definition + "\"" + ".";
                                System.out.println(wrong);
                                log.add(wrong);
                            }
                            int numMistakes = mistakes.get(term) + 1;
                            mistakes.replace(term,numMistakes);
                        }
                    }
                    //scanner.nextLine();
                    break;
                }
                case "log": {
                    System.out.println("File name:");
                    log.add("File name:");
                    String fileName = scanner.nextLine();
                    log.add(fileName);
                    File file = new File("./" + fileName);
                    try (PrintWriter writer = new PrintWriter(file)){
                        log.forEach(phrase -> {
                            writer.println(phrase);
                        });
                        String saved = "The log has been saved.";
                        System.out.println(saved);
                        log.add(saved);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "hardest card" : {
                    // find max mistakes
                    int maxMistakes;
                    Optional<Map.Entry<String, Integer>> optMaxMistakes = mistakes.entrySet()
                            .stream()
                            .max(Comparator.comparing(Map.Entry::getValue));
                    if (optMaxMistakes.isPresent()) {
                        maxMistakes = optMaxMistakes.get().getValue();
                    } else {
                        maxMistakes = 0;
                    }
                    List<String> termsWithMaxMistakes = new ArrayList<>();

                    // if no mistakes, print message
                    if (maxMistakes == 0) {
                        String noMistakes = "There are no cards with errors.";
                        System.out.println(noMistakes);
                        log.add(noMistakes);
                    } else {  // loops the map to find the terms with maxMistakes
                        for (Map.Entry<String,Integer> entry : mistakes.entrySet()) {
                            if (entry.getValue() == maxMistakes) {
                                termsWithMaxMistakes.add(entry.getKey());
                            }
                        }
                        // Print message with max mistakes
                        String mistakesMessage = "The hardest cards are xx. You have "
                                + maxMistakes + " errors answering them.";
                        if (termsWithMaxMistakes.size() == 1) {
                            mistakesMessage = mistakesMessage.replace("are", "is")
                                    .replace("xx", "\"" + termsWithMaxMistakes.get(0) + "\"")
                                    .replace("them", "it")
                                    .replace("cards", "card");
                        } else {
                            String terms = "";
                            for (String t: termsWithMaxMistakes) {
                                terms = terms + "\"" + t + "\",";
                            }
                            terms = terms.substring(0, terms.length() - 1);
                            mistakesMessage = mistakesMessage.replace("xx", terms);
                        }
                        System.out.println(mistakesMessage);
                        log.add(mistakesMessage);
                    }
                    break;
                }
                case "reset stats" : {
                    for (String t: mistakes.keySet()) {
                        mistakes.replace(t, 0);
                    }
                    String reset = "Card statistics has been reset";
                    System.out.println(reset);
                    log.add(reset);
                    break;
                }
                default:{
                    //System.out.println("Invalid option.");
                }
            }
        }
        System.out.println("Bye bye!");
        log.add("Bye bye!");
        if (exportOnExit) {
            exportToFile(cardFileName);
        }
    } // End main




    /** PRIVATE METHODS **/

    // Find a term for a given answer
    private static String findKeyForValue(String answer) {
        String key = "";
        for (String term: flashCards.keySet()) {
            if (flashCards.get(term).equals(answer)) {
                key = term;
                break;
            }
        }
        return key;
    }

    // Verify if a definition is duplicated and receive it again
    private static String verifyDefinitionDuplicate(String definition) {
        while(flashCards.containsValue(definition)) {
            String definitionExists = "The definition " + "\"" + definition + "\"" + " already exists. Try again:";
            System.out.println(definitionExists);
            log.add(definitionExists);
            definition = scanner.nextLine();
            log.add(definition);
        }
        return definition;
    }

    // Verify if a definition is duplicated
    private static boolean definitionIsDuplicated(String definition) {
        if (flashCards.containsValue(definition)) {
            return true;
        } else {
            return false;
        }
    }

    // Verify if a term is duplicated and receive it again
    private static String verifyTermDuplicate(String term) {
        while (flashCards.containsKey(term)) {
            String termExists = "The card " + "\"" + term + "\"" + " already exists. Try again:";
            System.out.println(termExists);
            log.add(termExists);
            term = scanner.nextLine();
            log.add(term);
        }
        return term;
    }

    // Verify if a term is duplicated
    private static boolean termIsDuplicated(String term) {
        if (flashCards.containsKey(term)) {
            return true;
        } else {
            return false;
        }
    }

    private static void importFile(String fileName) {
        File file = new File("./" + fileName);
        int qtyLoaded = 0;
        try (Scanner fileScanner = new Scanner(file).useDelimiter("-")) {
            while (fileScanner.hasNext()){
                String term = fileScanner.next();
                if (term.equals("")) break;
                String definition = fileScanner.next().replace("-", "");
                Integer numMistakes = Integer.valueOf(fileScanner.nextLine().replace("-", ""));
                if (flashCards.containsKey(term)) {
                    flashCards.replace(term, definition);
                    mistakes.replace(term, numMistakes);
                } else {
                    flashCards.put(term, definition);
                    mistakes.put(term, numMistakes);
                }
                qtyLoaded++;
            }
            String loaded = qtyLoaded + " cards have been loaded.";
            System.out.println(loaded);
            log.add(loaded);
        } catch (FileNotFoundException fnfe) {
            String fileNotFound = "File not found.";
            System.out.println(fileNotFound);
            log.add(fileNotFound);
        }
        //scanner.nextLine();
    }

    private static void exportToFile(String cardFileName) {
        File file = new File("./" + cardFileName);
        try (PrintWriter writer = new PrintWriter(file)){
            flashCards.forEach((term, definition) -> {
                writer.print(term + "-");
                writer.print(definition + "-");
                writer.println(mistakes.get(term));
            });
            String saved = flashCards.size() + " cards have been saved.";
            System.out.println(saved);
            log.add(saved);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
