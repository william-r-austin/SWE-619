package edu.gmu.cs.swe619.assignments.assignment13;

public class TestPopups {
	
	public static void main(String[] args) {
		// Sample Confirm Dialog
		OptionType myOptionType = 
			new JSimplePopup.ConfirmDialogBuilder()
					.withTitle("Popup #1: Confirm Dialog")
					.withMessage("Do you like this popup?")
					.withMessageType(MessageType.PLAIN)
					.withOptionConfigType(OptionConfigType.YES_NO)
					.show();
		
		System.out.println("Popup #1 Result: " + myOptionType.name());
		
		// Sample Input Dialog
		String typedResult = 
			new JSimplePopup.InputDialogBuilder()
					.withTitle("Popup #2: Input Dialog")
					.withMessage("Uh oh! The final is coming! How many hours have you spent studying?")
					.withMessageType(MessageType.QUESTION)
					.show();
		System.out.println("Popup #2 Result: " + typedResult);
		
		// Sample Message Dialog
		new JSimplePopup.MessageDialogBuilder()
				.withTitle("Popup #3: Message Dialog")
				.withMessage("That's not enough! Study more!")
				.withMessageType(MessageType.WARNING)
				.show();
		System.out.println("Popup #3 has been closed.");
	}
}


