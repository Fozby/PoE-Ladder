package fozrao.entities.ladder;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Response {

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
	
	@Override
	public String toString() {
		return "ResponseLadder [total=" + total + ", entries=" + Arrays.toString(entries) + "\n]";
	}
	
}

