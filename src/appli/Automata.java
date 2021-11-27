package appli;

import java.util.ArrayList;

/** Automata Class
 *
 *  @author Erwan CHAUVEL
 *
 *  @version 1.0
 *
 */
public class Automata {
    private ArrayList<State> S;
    private ArrayList<Character> A;
    private State S0;
    private ArrayList<State> Sf;

    /**
     * Constructor of an Automata
     */
    public Automata() {
        S = new ArrayList<>();
        A = new ArrayList<>();
        S0 = null;
        Sf = new ArrayList<>();
    }

    /**
     * Method which verify if a String is recognized by Automata
     * @see java.lang.String
     * @param string The String to test
     * @return True if automata recongnized string, else False
     */
    public boolean recognized(String string) {
        State actualState = S0;
        for(int i=0; i<string.length(); i++) {
            try {
                if (!A.contains(string.charAt(i))) {
                    throw new NoFollowingStateException();
                }
                actualState = actualState.getFollowingState(string.charAt(i));
            } catch (NoFollowingStateException e) {
                return false;
            }
        }
        return Sf.contains(actualState);
    }

    /**
     * Method which add a State to Automata's list of State and verify if the given state is an initial or final State
     * @param state The State to add
     */
    public void addState(State state) {
        S.add(state);
        if (state.getName().equals("I")) {
            S0 = state;
        } else if (state.getName().charAt(0) == 'F') {
            Sf.add(state);
        }
    }

    /**
     * Method which add a Charachter to Automata's alphabet
     * @param element The Character to add
     */
    public void addAlphabetElemement(char element) {
        A.add(element);
    }

    /**
     * Method which add a transition to Automata's list of transition
     * @param name The name of stating State
     * @param character The Character of the transition
     * @param followingStateName The name of ending State
     */
    public void addTransition(String name, char character, String followingStateName) {
        State stateInstance = S.get(S.indexOf(new State(name)));
        State followingStateInstance = S.get(S.indexOf(new State(followingStateName)));
        stateInstance.addFollowingState(character, followingStateInstance);
    }
}
