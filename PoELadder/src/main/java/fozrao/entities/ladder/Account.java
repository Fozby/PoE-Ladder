package fozrao.entities.ladder;

public class Account {
	
	private String name;
	private Challenges challenges;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Challenges getChallenges() {
		return challenges;
	}

	public void setChallenges(Challenges challenges) {
		this.challenges = challenges;
	}
	
	@Override
	public String toString() {
		return name;
	}
}