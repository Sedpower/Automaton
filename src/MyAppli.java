import appli.Automata;
import appli.ReadAutomata;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/** Application Class
 *
 *  @author Erwan CHAUVEL
 *
 *  @version 1.0
 *
 */
public class MyAppli {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) throws IOException {
        while (true) {
            displayMenu();
            String input = getInput("Entrez votre choix : ");
            switch (input) {
                case "1":
                    exprProcess(ReadAutomata.readAutomata("smiley.txt"));
                    break;
                case "2":
                    exprProcess(ReadAutomata.readAutomata("hhmm.txt"));
                    break;
                case "3":
                    exprProcess(ReadAutomata.readAutomata("jjmmaaa.txt"));
                    break;
                case "4":
                    exprProcess(ReadAutomata.readAutomata("hhmmss.txt"));
                    break;
                case "5":
                    exprProcess(ReadAutomata.readAutomata("email.txt"));
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "8":
                    exprProcess(ReadAutomata.readAutomata("polynome.txt"));
                    break;
                case "9":
                    System.exit(0);
            }
        }
    }

    /**
     * Static method which permit to clear the terminal
     */
    public static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Static method which permit to ask and get input from user
     * @param text The String which will be displayed to ask user input
     * @return Input String from the user
     */
    private static String getInput(String text) {
        System.out.print(text);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /**
     * Static method which process the choosen automata
     * @param automata The appli.Automata choosen by user
     */
    private static void exprProcess(Automata automata) {
        boolean exit = false;
        while (!exit) {
            clear();
            System.out.println("Pour retourner au menu, tapez \"exit\"\n");
            String input = getInput("Entrez l'expression : ");
            if (input.equalsIgnoreCase("exit") ) {
                exit = true;
            } else {
                boolean isRecognized = automata.recognized(input);
                if (isRecognized) {
                    System.out.println(ANSI_GREEN + "'"+ input +"' est reconnu par l'automate" + ANSI_RESET);
                } else {
                    System.out.println(ANSI_RED + "'"+ input +"' n'est pas reconnu par l'automate" + ANSI_RESET);
                }
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Static method which display the main menu
     */
    private static void displayMenu() {
        clear();
        System.out.println("--------------- Menu de mon TP -------------------------");
        System.out.println("1. Smiley (pour reconnaitre un des smileys)");
        System.out.println("2. HH:MM (pour reconnaitre une heure bien formée)");
        System.out.println("3. JJ/MM/AAAA");
        System.out.println("4. HH :MM :SS");
        System.out.println("5. Adresses electroniques");
        System.out.println("6. <automata>");
        System.out.println("7. <automata>");
        System.out.println("8. Polynôme");
        System.out.println("9. Arrêt");
        System.out.println("Votre choix (1-9) ?");
        System.out.println("Je vous demanderez ensuite la chaine à analyser, Merci");
        System.out.println("-------------------------------------------------------");
    }
}
