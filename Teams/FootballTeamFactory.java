package Teams;

public class FootballTeamFactory implements TeamFactory {
  public FootballTeam createTeam(String id, String name) {
    FootballTeam team = new FootballTeam(id);
    team.setName(name);
    System.out.println("Football team is created");
    return team;
  }
}
