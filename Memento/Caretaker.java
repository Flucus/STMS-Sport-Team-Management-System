package Memento;

import Teams.*;
import java.util.*;

import Commands.Command;

public class Caretaker {
    public Scanner sc = new Scanner(System.in);
    public Stack<Command> historyStack = new Stack<>();
    public Stack<Command> redoStack = new Stack<>();
    public HashMap<String, Team> teamID = new HashMap<>();
    public HashMap<String, String> teamTypeID = new HashMap<>();
    public HashMap<String, String> teamTypeInfo = new HashMap<>();
    public HashMap<String, HashMap<Integer, String>> teamPositionInfo = new HashMap<>();
    public Team currentTeam = null;
    public Team lastTeam = null;

    public Caretaker() {
        // Initialize volleyball team information
        teamTypeInfo.put("v", "volleyball");
        HashMap<Integer, String> volleyballPositionInfo = new HashMap<>();
        volleyballPositionInfo.put(1, "attacker");
        volleyballPositionInfo.put(2, "defender");
        teamPositionInfo.put("v", volleyballPositionInfo);

        // Initialize football team information
        teamTypeInfo.put("f", "football");
        HashMap<Integer, String> footballPositionInfo = new HashMap<>();
        footballPositionInfo.put(1, "goalkeeper");
        footballPositionInfo.put(2, "defender");
        footballPositionInfo.put(3, "midfielder");
        footballPositionInfo.put(4, "forward");
        teamPositionInfo.put("f", footballPositionInfo);
    }
}
