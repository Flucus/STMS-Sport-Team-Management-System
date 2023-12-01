package Commands;

import Teams.*;
import Memento.*;

import java.util.*;

public class CreateTeamCommand implements Command {
    private Caretaker com;
    private String teamName;
    private Team team;
    private Team lastTeam;
    private String teamType;
    private HashMap<String, TeamFactory> teamFactoryMap;

    public CreateTeamCommand(Caretaker com, HashMap<String, TeamFactory> teamFactoryMap) {
        this.com = com;
        this.teamFactoryMap = teamFactoryMap;
    }

    public boolean execute() {
        // Request user input for the type of sport
        System.out.print("Enter sport type (v = volleyball | f = football) :- ");
        teamType = com.sc.nextLine().trim();

        // Validate sport type and get corresponding factory
        TeamFactory factory = teamFactoryMap.get(teamType);
        if (factory == null) {
            System.out.println("Invalid sport type.");
            return false;
        }

        // Request and validate user input for team ID
        System.out.print("Team ID:- ");
        String teamID = com.sc.nextLine().trim();
        if (com.teamID.containsKey(teamID)) {
            System.out.println("Team ID already exists.");
            return false;
        }

        // Request and validate user input for team name
        System.out.print("Team Name:- ");
        teamName = com.sc.nextLine().trim();
        if (teamName.isEmpty()) {
            System.out.println("Invalid team name, must not be empty.");
            return false;
        }

        // Create the team using the factory and update the com with the new team
        team = factory.createTeam(teamID, teamName);
        lastTeam = com.lastTeam;
        com.teamID.put(teamID, team);
        com.teamTypeID.put(teamID, teamType);
        com.lastTeam = com.currentTeam;
        com.currentTeam = team;

        // Output confirmation of team creation
        System.out.println("Current team is changed to " + teamID + ".");
        return true;
    }

    public void undo() {
        // Undo team creation by removing it from the com and reverting to the
        // previous team
        com.teamID.remove(team.getTeamID());
        com.teamTypeID.remove(team.getTeamID());
        com.currentTeam = com.lastTeam;
        com.lastTeam = lastTeam;
    }

    public void redo() {
        // Redo team creation by re-adding it to the com and updating current and
        // last team references
        com.teamID.put(team.getTeamID(), team);
        com.teamTypeID.put(team.getTeamID(), teamType);
        com.lastTeam = com.currentTeam;
        com.currentTeam = team;
    }

    public String getInfo() {
        // Return information about the create team action performed
        return "Create " + com.teamTypeInfo.get(teamType) + " team, " + team.getTeamID() + ", "
                + teamName;
    }
}
