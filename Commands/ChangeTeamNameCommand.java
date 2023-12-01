package Commands;

import Teams.*;
import Memento.*;

import java.util.*;

public class ChangeTeamNameCommand implements Command {
    private Caretaker com;
    private Team team;
    private String oldName;
    private String newName;

    public ChangeTeamNameCommand(Caretaker com) {
        this.com = com;
        this.team = com.currentTeam;
        this.oldName = team.getName();
    }

    public boolean execute() {
        // Scanner from com for user input
        Scanner inputScanner = com.sc;
        System.out.print("Please input new name of the current team:- ");
        newName = inputScanner.nextLine().trim();

        // Check if the new name is not empty
        if (newName.isEmpty()) {
            System.out.println("Invalid team name. The name must not be empty.");
            return false;
        }

        // Set the new name to the current team
        team.setName(newName);
        System.out.println("Team's name is updated.");
        return true;
    }

    public void undo() {
        // Check if the current team com is correct
        if (com.currentTeam != team) {
            com.lastTeam = com.currentTeam;
            com.currentTeam = team;
        }
        // Revert to the old name
        team.setName(oldName);
    }

    public void redo() {
        // Check if the current team com is correct
        if (com.currentTeam != team) {
            com.lastTeam = com.currentTeam;
            com.currentTeam = team;
        }
        // Redo the name change
        team.setName(newName);
    }

    public String getInfo() {
        // Return information about the executed com
        return "Change team's name, " + team.getTeamID() + ", " + newName;
    }
}
