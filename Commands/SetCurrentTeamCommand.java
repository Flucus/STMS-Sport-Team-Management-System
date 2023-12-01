package Commands;

import Teams.*;

import java.util.*;

import Memento.*;

public class SetCurrentTeamCommand implements Command {
  private Caretaker com;

  public SetCurrentTeamCommand(Caretaker com) {
    this.com = com;
  }

  public boolean execute() {
    com.historyStack.pop();

    Scanner scanner = com.sc;
    String teamID = null;
    Team targetTeam = null;

    System.out.print("Please input team ID:- ");
    teamID = scanner.nextLine();
    targetTeam = com.teamID.get(teamID);
    if (targetTeam == null) {
      System.out.println("Team " + teamID + " is not found!!");
      return true;
    }

    com.lastTeam = com.currentTeam;
    com.currentTeam = targetTeam;
    System.out.println("Changed current team to " + targetTeam.getTeamID() + ".");
    return true;
  }

  public void undo() {
  }

  public void redo() {
  }

  public String getInfo() {
    return "SetCurrentTeamCommand.getInfo()";
  }
}
