package appli;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/** ReadAutomata Class
 *
 *  @author Erwan CHAUVEL
 *
 *  @version 1.0
 *
 */
public class ReadAutomata {

    /**
     * Static method which verify if a String is recognized by Automata
     * @param fileName The file name to open
     * @return Automata contained in the given file
     */
    public static Automata readAutomata(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("../data/" + fileName));
        Automata automata = new Automata();


        // Read first line which contains all States
        String line = reader.readLine();
        String[] states = line.split(" ");
        for (int i=0; i<states.length; i++) {
            automata.addState(new State(states[i]));
        }

        // Read second line which contains all elements of the alphabet
        line = reader.readLine();
        String[] alphabet = line.split(" ");
        for (int i=0; i<alphabet.length; i++) {
            if (alphabet[i].equals("space")) automata.addAlphabetElemement(' ');
            else {
                automata.addAlphabetElemement(alphabet[i].charAt(0));
            }
        }

        // Read all transitions of Automata
        line = reader.readLine();
        while (line != null) {
            String[] transition = line.split(" ");
            char transitionChar;
            if (transition[1].equals("space")) transitionChar = ' ';
            else transitionChar = transition[1].charAt(0);
            automata.addTransition(transition[0], transitionChar, transition[2]);
            line = reader.readLine();
        }
        reader.close();
        return automata;
    }
}
