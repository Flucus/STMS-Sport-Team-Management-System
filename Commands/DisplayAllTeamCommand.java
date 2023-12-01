package Commands;

import java.util.*;

import Memento.*;
import Teams.Team;

public class DisplayAllTeamCommand implements Command {
    private Caretaker com;

    public DisplayAllTeamCommand(Caretaker com) {
        this.com = com;
    }

    public boolean execute() {
        com.historyStack.pop();
        Iterator<Team> teamIterator = com.teamID.values().iterator();

        while (teamIterator.hasNext()) {
            Team team = teamIterator.next();
            String teamId = team.getTeamID();
            String teamType = com.teamTypeID.get(teamId);
            String teamTypeName = com.teamTypeInfo.get(teamType);
            String capitalize = teamTypeName.substring(0, 1).toUpperCase() + teamTypeName.substring(1);
            System.out.println(capitalize + " Team " + team.getName() + " (" + team.getTeamID() + ")");
        }
        return true;
    }

    public void undo() {
    }

    public void redo() {
    }

    public String getInfo() {
        return "DisplayAllTeamCommand.getInfo()";
    }

}
