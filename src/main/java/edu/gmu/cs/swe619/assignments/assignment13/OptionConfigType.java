package edu.gmu.cs.swe619.assignments.assignment13;

import javax.swing.JOptionPane;

/**
 * Enum to replace the JOptionPane int constants
 * for the different option configurations on dialogs. 
 */
public enum OptionConfigType {
	DEFAULT(JOptionPane.DEFAULT_OPTION),
	YES_NO(JOptionPane.YES_NO_OPTION),
	YES_NO_CANCEL(JOptionPane.YES_NO_CANCEL_OPTION),
	OK_CANCEL(JOptionPane.OK_CANCEL_OPTION);
	
	/**
	 * Original JOptionPane int value
	 */
	private int value;
	
	/**
	 * Private constructor to initialize the object
	 * @param value JOptionPane int value
	 */
	private OptionConfigType(int value) {
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
	public static OptionConfigType fromValue(int inputValue) {
		for(OptionConfigType optionConfigType : OptionConfigType.values()) {
			if(optionConfigType.getValue() == inputValue) {
				return optionConfigType;
			}
		}
		
		return null;
	}
}
