package edu.gmu.cs.swe619.assignments.assignment07;

/**
 * Implementation of the Indexer class for Strings. We can think of a String as a
 * collection of characters.
 */
public class StringIndexer implements Indexer<Character> {

	/**
	 * The source String to be indexed
	 */
	private final String sourceString;
	
	/**
	 * Creates a new StringIndexer
	 * 
	 * @param sourceString  the String to create the Indexer from
	 * @throws NullPointerException  if the source String is null
	 */
	public StringIndexer(String sourceString) {
		if(sourceString == null) {
			throw new NullPointerException("The source string may not be null");
		}
		
		this.sourceString = sourceString;
	}
	
	/**
	 * Gets the character in the String at the given index 
	 * 
	 * @return  the Character object at the given index in the String
	 * @throws  IndexOutOfBoundsException  if the index is not valid
	 */
	@Override
	public Character get(int index) {
		return sourceString.charAt(index);
	}

	/**
	 * Get the number of indexed characters, which is the length of the String
	 * 
	 * @return the length of the string
	 */
	@Override
	public int size() {
		return sourceString.length();
	}
}
