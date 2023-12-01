package Commands;

import Teams.*;
import Memento.*;


import java.util.*;

public class CreateTeamCommandFactory implements CommandFactory {
    private Caretaker com;
    private HashMap<String, TeamFactory> teamFactoryHashMap = new HashMap<String, TeamFactory>();

    public CreateTeamCommandFactory(Caretaker com) {
        this.com = com;
        teamFactoryHashMap.put("v", new VolleyballTeamFactory());
        teamFactoryHashMap.put("f", new FootballTeamFactory());
    }

    public Command createCommand() {
        return new CreateTeamCommand(com, teamFactoryHashMap);
    }

}
