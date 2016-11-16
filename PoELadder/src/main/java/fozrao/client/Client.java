package fozrao.client;

import org.springframework.web.client.RestTemplate;

public class Client {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseFoo foo = restTemplate.getForObject("http://api.pathofexile.com/ladders/Standard?offset=1&limit=2", ResponseFoo.class);
		
		System.out.println(foo.toString());
	}
}
