package edu.gmu.cs.swe619.assignments.assignment13;

import javax.swing.JOptionPane;

/**
 * Enum to replace the JOptionPane int constants
 * for option type. 
 */
public enum OptionType {
	YES(JOptionPane.YES_OPTION),
	NO(JOptionPane.NO_OPTION),
	CANCEL(JOptionPane.CANCEL_OPTION),
	OK(JOptionPane.OK_OPTION),
	CLOSED(JOptionPane.CLOSED_OPTION);
		
	/**
	 * Original JOptionPane int value
	 */
	private int value;
	
	/**
	 * Private constructor to initialize the object
	 * @param value JOptionPane int value
	 */
	private OptionType(int value) {
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
	public static OptionType fromValue(int inputValue) {
		for(OptionType optionType : OptionType.values()) {
			if(optionType.getValue() == inputValue) {
				return optionType;
			}
		}
		
		return null;
	}
}
