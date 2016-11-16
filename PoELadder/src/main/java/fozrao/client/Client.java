package fozrao.client;

import fozrao.entities.*;
import fozrao.entities.ResponseLadder.Entry;

import org.springframework.web.client.RestTemplate;

public class Client {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseLadder ladder = restTemplate.getForObject("http://api.pathofexile.com/ladders/Hardcore Essence?offset=0&limit=10", ResponseLadder.class);
		
		System.out.println(ladder.toString());
		
		Entry[] entries = ladder.getEntries();
		for (int i = 0; i < entries.length; i++) {
			String characterName = entries[i].getCharacter().getName();
			String accountName = entries[i].getAccount().getName();
			System.out.println(String.format("getBuild(%s, %s)", characterName, accountName));
		}
	}
}
