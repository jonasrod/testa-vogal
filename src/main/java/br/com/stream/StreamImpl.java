package br.com.stream;

/**
 * @author jrodrigueso
 *
 */
public class StreamImpl implements Stream {
	
	private static String input;
	
	private int streamIndex;
	
	private int nextIndex;
	
	private int streamLength;
	
	public StreamImpl() {
		super();
		streamIndex = 0;
		nextIndex = 0;
		streamLength = 0;
	}
	
	/**
	 * Lê o próximo caractere da stream
	 */
	public char getNext() {
		char next = input.charAt(nextIndex);
		streamIndex = nextIndex;
		nextIndex++;
		return next;
	}
	
	/**
	 * Verifica se a stream chegou ao fim.
	 */
	public boolean hasNext() {
		if (streamLength == nextIndex)
			return false;
		else
			return true;
	}
	
	/**
	 * Atribuí o valor de entrada
	 */
	public void setInput(String in) {
		input = in;
		streamLength = in.length();
		streamIndex = 0;
	}

	@Override
	public char getPrevious() {
		if (streamIndex > 0) {
			return input.charAt(streamIndex - 1);
		} else {
			return 0;
		}
	}

	@Override
	public char getPreviousPrevious() {
		if (streamIndex > 1) {
			return input.charAt(streamIndex - 2);
		} else {
			return 0;
		}
	}
}