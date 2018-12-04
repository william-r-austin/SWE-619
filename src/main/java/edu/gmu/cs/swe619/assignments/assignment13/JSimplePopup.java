package edu.gmu.cs.swe619.assignments.assignment13;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JOptionPane;

/**
 * Wrapper class for the Swing JOptionPane class that allows configuration
 * through a builder pattern and replaces the integer constants associated
 * with the JOptionPane class with strongly typed enums.
 */
public class JSimplePopup {
	
	/**
	 * Private constructor. Only the static member classes are accessible.
	 */
	private JSimplePopup() { }
	
	/**
	 * Replacement class for the JOptionPane.showConfirmDialog( ... ) methods.
	 * Uses a builder pattern to collect the configuration and replaces int constants
	 * with enums that are exposed to the user.
	 */
	public static class ConfirmDialogBuilder {
		/**
		 * Parent component for the dialog
		 */
		private Component parentComponent;
		
		/**
		 * Message to be shown in the dialog
		 */
		private Object message;
		
		/**
		 * Title for the dialog
		 */
		private String title;
		
		/**
		 * OptionConfigType specifies the set of buttons that the user
		 * will see in the popup
		 */
		private OptionConfigType optionConfigType;
		
		/**
		 * Type of message to show, which corresponds to a default icon
		 */
		private MessageType messageType;
		
		/**
		 * Icon to show in the popup
		 */
		private Icon icon;
				
		/**
		 * Create a new builder and set some default values
		 */
		public ConfirmDialogBuilder() {
			this.message = "Confirm Dialog Placeholder Message";
			this.title = "Select an Option";
			this.optionConfigType = OptionConfigType.YES_NO_CANCEL;
			this.messageType = MessageType.PLAIN;
		}
		
		/**
		 * Set the parent component for the dialog
		 * @param parentComponent
		 * @return this
		 */
		public ConfirmDialogBuilder withParentComponent(Component parentComponent) {
			this.parentComponent = parentComponent;
			return this;
		}
		
		/**
		 * Set the message to show in the dialog
		 * @param message
		 * @return this
		 */
		public ConfirmDialogBuilder withMessage(Object message) {
			this.message = message;
			return this;
		}
		
		/**
		 * Set the text to show in the title bar of the popup
		 * @param title
		 * @return this
		 */
		public ConfirmDialogBuilder withTitle(String title) {
			this.title = title;
			return this;
		}
		
		/**
		 * Set the OptionConfigType. This corresponds to the set of buttons that the
		 * user is allowed to choose, such as "Yes", "No", and "Cancel".
		 * @param optionConfigType
		 * @return this
		 */
		public ConfirmDialogBuilder withOptionConfigType(OptionConfigType optionConfigType) {
			this.optionConfigType = optionConfigType;
			return this;
		}
		
		/**
		 * Set the MessageType. This value dictates the default icon for the popup.
		 * @param messageType
		 * @return this
		 */
		public ConfirmDialogBuilder withMessageType(MessageType messageType) {
			this.messageType = messageType;
			return this;
		}
		
		/**
		 * Set a custom icon for the popup
		 * @param icon
		 * @return this
		 */
		public ConfirmDialogBuilder withIcon(Icon icon) {
			this.icon = icon;
			return this;
		}
		
		/**
		 * Show the dialog, using the previously defined values. If necessary, validation can be performed at this point to
		 * make sure that the specified configuration options are valid. 
		 * 
		 * @return the option that the user chose
		 */
		public OptionType show() {
			int result = JOptionPane.showConfirmDialog(parentComponent, message, title, optionConfigType.getValue(), messageType.getValue(), icon);
			return OptionType.fromValue(result);
		}
	}
	
	/**
	 * Replacement class for the JOptionPane.showInputDialog( ... ) methods.
	 * Uses a builder pattern to collect the configuration and replaces int constants
	 * with enums that are exposed to the user.
	 */
	public static class InputDialogBuilder {
		/**
		 * Parent component for the dialog
		 */
		private Component parentComponent;
		
		/**
		 * Message to be shown in the dialog
		 */
		private Object message;
		
		/**
		 * Title for the dialog
		 */
		private String title;
		
		/**
		 * Type of message to show, which corresponds to a default icon
		 */
		private MessageType messageType;
		
		/**
		 * Create a new builder and set some default values
		 */
		public InputDialogBuilder() {
			this.message = "Input Dialog Placeholder Message";
			this.title = "Select an Option";
			this.messageType = MessageType.PLAIN;
		}
		
		/**
		 * Set the parent component for the dialog
		 * @param parentComponent
		 * @return this
		 */
		public InputDialogBuilder withParentComponent(Component parentComponent) {
			this.parentComponent = parentComponent;
			return this;
		}
		
		/**
		 * Set the message to show in the dialog
		 * @param message
		 * @return this
		 */
		public InputDialogBuilder withMessage(Object message) {
			this.message = message;
			return this;
		}
		
		/**
		 * Set the text to show in the title bar of the popup
		 * @param title
		 * @return this
		 */
		public InputDialogBuilder withTitle(String title) {
			this.title = title;
			return this;
		}
		
		/**
		 * Set the MessageType. This value dictates the default icon for the popup.
		 * @param messageType
		 * @return this
		 */
		public InputDialogBuilder withMessageType(MessageType messageType) {
			this.messageType = messageType;
			return this;
		}
		
		/**
		 * Show the dialog, using the previously defined values. If necessary, validation can be performed at this point to
		 * make sure that the specified configuration options are valid. 
		 * 
		 * @return the text that the user typed in the input box
		 */
		public String show() {
			return JOptionPane.showInputDialog(parentComponent, message, title, messageType.getValue());
		}
	}
	
	// Message Dialog
	/**
	 * Replacement class for the JOptionPane.showMessageDialog( ... ) methods.
	 * Uses a builder pattern to collect the configuration and replaces int constants
	 * with enums that are exposed to the user.
	 */
	public static class MessageDialogBuilder {
		/**
		 * Parent component for the dialog
		 */
		private Component parentComponent;
		
		/**
		 * Message to be shown in the dialog
		 */
		private Object message;
		
		/**
		 * Title for the dialog
		 */
		private String title;
		
		/**
		 * Type of message to show, which corresponds to a default icon
		 */
		private MessageType messageType;
		
		/**
		 * Icon to show in the popup
		 */
		private Icon icon;
		
		/**
		 * Create a new builder and set some default values
		 */
		public MessageDialogBuilder() {
			this.message = "Input Dialog Placeholder Message";
			this.title = "Select an Option";
			this.messageType = MessageType.PLAIN;
		}
		
		/**
		 * Set the parent component for the dialog
		 * @param parentComponent
		 * @return this
		 */
		public MessageDialogBuilder withParentComponent(Component parentComponent) {
			this.parentComponent = parentComponent;
			return this;
		}
		
		/**
		 * Set the message to show in the dialog
		 * @param message
		 * @return this
		 */
		public MessageDialogBuilder withMessage(Object message) {
			this.message = message;
			return this;
		}
		
		/**
		 * Set the text to show in the title bar of the popup
		 * @param title
		 * @return this
		 */
		public MessageDialogBuilder withTitle(String title) {
			this.title = title;
			return this;
		}
		
		/**
		 * Set the MessageType. This value dictates the default icon for the popup.
		 * @param messageType
		 * @return this
		 */
		public MessageDialogBuilder withMessageType(MessageType messageType) {
			this.messageType = messageType;
			return this;
		}

		/**
		 * Set a custom icon for the popup
		 * @param icon
		 * @return this
		 */
		public MessageDialogBuilder withIcon(Icon icon) {
			this.icon = icon;
			return this;
		}
		
		/**
		 * Show the dialog, using the previously defined values. If necessary, validation can be performed at this point to
		 * make sure that the specified configuration options are valid. 
		 */
		public void show() {
			JOptionPane.showMessageDialog(parentComponent, message, title, messageType.getValue(), icon);
		}
	}
}