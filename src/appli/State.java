package appli;

import java.util.HashMap;
import java.util.Objects;

/** State Class
 *
 *  @author Erwan CHAUVEL
 *
 *  @version 1.0
 *
 */
public class State {
    private String name;
    private HashMap<Character, State> followingsState;

    /**
     * Constructor of a State
     */
    public State(String name) {
        this.name = name;
        followingsState = new HashMap<>();
    }

    /**
     * Getter of State name
     * @return State name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Method to get the following State of current one with a Character
     * @throws NoFollowingStateException If State doesn't have following State with given Character
     * @param character The Character to find the following State
     * @return State name
     */
    public State getFollowingState(char character) throws NoFollowingStateException {
        State followingState = followingsState.get(character);
        if (followingState == null) throw new NoFollowingStateException();
        return followingState;
    }

    /**
     * Method to add a following State associated to Character
     * @param character The Character which correspond to following State
     * @param state The following State
     */
    public void addFollowingState(char character, State state) {
        followingsState.put(character, state);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return name.equals(state.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
