package Teams;

public class VolleyballTeamFactory implements TeamFactory {
  public VolleyballTeam createTeam(String id, String name) {
    VolleyballTeam team = new VolleyballTeam(id);
    team.setName(name);
    System.out.println("Volleyball team is created");
    return team;
  }
}
