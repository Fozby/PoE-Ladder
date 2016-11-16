package fozrao.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ResponseFoo {
	private int total;
	private Object[] entries;
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Object[] getEntries() {
		return entries;
	}

	public void setEntries(Object[] entries) {
		this.entries = entries;
	}

	public String toString()
	{
		return "Total: " + total + ", numEntries: " + entries.length;
	}
}
