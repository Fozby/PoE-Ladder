package fozrao.entities;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ResponseLadder {

	private int total;
	private Entry[] entries;
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Entry[] getEntries() {
		return entries;
	}

	public void setEntries(Entry[] entries) {
		this.entries = entries;
	}
	
	public static class Entry {
		
		private int rank;
		private boolean dead;
		private boolean online;
		private Character character;
		private Account account;
		
		public int getRank() {
			return rank;
		}

		public void setRank(int rank) {
			this.rank = rank;
		}

		public boolean isDead() {
			return dead;
		}

		public void setDead(boolean dead) {
			this.dead = dead;
		}

		public boolean isOnline() {
			return online;
		}

		public void setOnline(boolean online) {
			this.online = online;
		}

		public Character getCharacter() {
			return character;
		}

		public void setCharacter(Character character) {
			this.character = character;
		}

		public Account getAccount() {
			return account;
		}

		public void setAccount(Account account) {
			this.account = account;
		}
		
		public static class Character {
			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public int getLevel() {
				return level;
			}

			public void setLevel(int level) {
				this.level = level;
			}

			public String getCharacterClass() {
				return characterClass;
			}

			public void setCharacterClass(String characterClass) {
				this.characterClass = characterClass;
			}

			public long getExperience() {
				return experience;
			}

			public void setExperience(long experience) {
				this.experience = experience;
			}

			private String name;
			private int level;
			@JsonProperty("class")
			private String characterClass;
			private long experience;
			
			@Override
			public String toString() {
				return name;
			}
		}
		
		public static class Account {
			
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
			
			public static class Challenges {
				private int total;

				public int getTotal() {
					return total;
				}

				public void setTotal(int total) {
					this.total = total;
				}
			}
			
			public static class Twitch {
				private String name;

				public String getName() {
					return name;
				}

				public void setName(String name) {
					this.name = name;
				}
			}
			
			@Override
			public String toString() {
				return name;
			}
		}
		
		@Override
		public String toString() {
			return "\n\tEntry [character=" + character
					+ ", account=" + account + "]";
		}
	}

	@Override
	public String toString() {
		return "ResponseLadder [total=" + total + ", entries=" + Arrays.toString(entries) + "\n]";
	}
	
}

