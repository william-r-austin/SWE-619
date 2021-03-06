package edu.gmu.cs.swe619.assignments.assignment13;

import javax.swing.JOptionPane;

/**
 * Enum to replace the JOptionPane int constants
 * for message type. 
 */
public enum MessageType {
	ERROR(JOptionPane.ERROR_MESSAGE),
	INFORMATION(JOptionPane.INFORMATION_MESSAGE),
	WARNING(JOptionPane.WARNING_MESSAGE),
	QUESTION(JOptionPane.QUESTION_MESSAGE),
	PLAIN(JOptionPane.PLAIN_MESSAGE);
	
	/**
	 * Original JOptionPane int value
	 */
	private int value;
	
	/**
	 * Private constructor to initialize the object
	 * @param value JOptionPane int value
	 */
	private MessageType(int value) {
		this.value = value;
	}
	
	/**
	 * Get the original JOptionPane int value
	 * @return value
	 */
	public int getValue() {
		return this.value;
	}
	
	/**
	 * Get the record associated with a given value
	 * @param inputValue  int value from JOptionPane
	 * @return  a message type with a value that matches the input
	 */
	public static MessageType fromValue(int inputValue) {
		for(MessageType messageType : MessageType.values()) {
			if(messageType.getValue() == inputValue) {
				return messageType;
			}
		}
		
		return null;
	}
}
