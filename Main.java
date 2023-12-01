import Teams.*;
import Commands.*;
import Memento.*;

import java.util.*;

public class Main {
    static Caretaker com = new Caretaker();
    static HashMap<String, CommandFactory> cf = new HashMap<String, CommandFactory>();

    public static void main(String[] args) {
        cf.put("c", new CreateTeamCommandFactory(com));
        cf.put("g", new SetCurrentTeamCommandFactory(com));
        cf.put("a", new AddPlayerCommandFactory(com));
        cf.put("m", new ModifyPlayerPositionCommandFactory(com));
        cf.put("d", new DeletePlayerCommandFactory(com));
        cf.put("s", new ShowTeamCommandFactory(com));
        cf.put("p", new DisplayAllTeamCommandFactory(com));
        cf.put("t", new ChangeTeamNameCommandFactory(com));
        cf.put("u", new UndoCommandFactory(com));
        cf.put("r", new RedoCommandFactory(com));
        cf.put("l", new ListHistoryCommandFactory(com));
        cf.put("x", new ExitCommandFactory());

        while (true) {
            String input;
            CommandFactory exec;
            Scanner sc = com.sc;
            Team cTeam = com.currentTeam;
            System.out.println("Sport Teams Management System (STMS)");
            System.out.println(
                    "c = create team, g = set current team, a = add player, m = modify player's position, d = delete player, s = show team, p = display all teams, t = change team's name, u = undo, r = redo, l = list undo/redo, x = exit system");
            if (cTeam != null) {
                System.out.println("The current team is " + cTeam.getTeamID() + " " + cTeam.getName() + ".");
            }
            System.out.print("Please enter command [ c | g | a | m | d | s | p | t | u | r | l | x ] :- ");
            input = sc.nextLine();
            exec = (CommandFactory) cf.get(input);
            if (exec == null) {
                System.out.println("Invalid command");
                continue;
            }
            Command c = exec.createCommand();
            com.historyStack.add(c);
            if (!c.execute()) {
                com.historyStack.pop();
            }
        }

    }
}