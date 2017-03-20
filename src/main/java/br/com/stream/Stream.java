package br.com.stream;

public interface Stream {
	public char getNext();
	public boolean hasNext();
	public void setInput(String input);
	public char getPrevious();
	public char getPreviousPrevious();
}
