package fozrao.client;

import org.springframework.web.client.RestTemplate;

import fozrao.builds.BuildDeterminer;
import fozrao.entities.ladder.Entry;
import fozrao.entities.ladder.Response;
import fozrao.entities.profile.CharacterProfile;


//items api = https://www.pathofexile.com/character-window/get-items?character=feraobv&accountName=firao
//passives api = https://www.pathofexile.com/character-window/get-passive-skills?reqData=0&character=feraobv&accountName=firao


public class Client {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		Response ladder = restTemplate.getForObject("http://api.pathofexile.com/ladders/Hardcore Essence?offset=0&limit=10", Response.class);
		
		System.out.println(ladder.toString());
		
		BuildDeterminer bd = new BuildDeterminer();
		
		Entry[] entries = ladder.getEntries();
		for (int i = 0; i < entries.length; i++) {
			String characterName = entries[i].getCharacter().getName();
			String accountName = entries[i].getAccount().getName();
			String passivesUrl = String.format("https://www.pathofexile.com/character-window/get-passive-skills?reqData=0&character=%s&accountName=%s", characterName, accountName);
			CharacterProfile profile = restTemplate.getForObject(passivesUrl, CharacterProfile.class);

			String build = bd.getBuild(profile);
			System.out.println(String.format("Build for %s, %s is %s", characterName, accountName, build));
		}
	}
}
