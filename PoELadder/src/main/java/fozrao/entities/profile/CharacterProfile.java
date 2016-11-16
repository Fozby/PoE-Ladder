package fozrao.entities.profile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CharacterProfile {
	public int[] hashes;
	public Object[] items; // TODO create item class

	public int[] getHashes() {
		return hashes;
	}

	public void setHashes(int[] hashes) {
		this.hashes = hashes;
	}

	public Object[] getItems() {
		return items;
	}

	public void setItems(Object[] items) {
		this.items = items;
	}
}
