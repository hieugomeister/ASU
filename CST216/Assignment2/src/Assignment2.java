

/**
 * Implement a method parseBinary(String binaryString), which converts a binary 
 * string into a decimal number. Implement parseBinary method to throw a NumberFormatException
 * if the string is not a binary string. NumberFormatException is predefined in the Java. 
 * Create a program called Assignment2.java with UI as shown in figure 1 and 2 with two TextField's 
 * to receive the user's input binary string and display the decimal string or a error message in 
 * case an exception occurs. This program should use the parseBinary method to perform the conversion 
 * and display the results.
 * 
 * hqpham
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Assignment2 extends JFrame implements ActionListener {
	private JLabel decimalLabel = new JLabel("Decimal String");
	private JTextField decimalTextField = new JTextField(30);	
	private JLabel binaryLabel = new JLabel("Binary String");
	private JTextField binaryTextField = new JTextField(30);
	
	private JButton convertButton = new JButton("Convert To Decimal");

	private JPanel panel = new JPanel();

	public Assignment2() {  //Constructor
		
  		setTitle("Assignment 2: Convert Binary to Decimal");
  		setLayout(new BorderLayout());
  		setSize(650, 150);
  
  		panel.setLayout(new GridLayout(3, 3, 4, 4));
  
  		panel.add(binaryLabel);
  		panel.add(binaryTextField);
  		panel.add(decimalLabel);
  		panel.add(decimalTextField);
  
  		add(panel, BorderLayout.CENTER);		//Place panel at center
  		add(convertButton, BorderLayout.SOUTH);	//Place the button on the bottom of the panel
  
  		convertButton.addActionListener(this);	//Add ActionListener to this frame
  
  		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Handles the exit procedure
  		setLocationRelativeTo(null);		//Set the frame at the middle of the screen
  		setVisible(true);  
	}//Constructor
	/**
	 * Method actionPerformed
	 */
	public void actionPerformed(ActionEvent theEvent) { //ActionListener interface
		int theNumber = 0;
		String bString = binaryTextField.getText();		//Get the binary string from binaryTextField  
		try
		{
			theNumber = parseBinary(bString);			//Call the parseBinary(String) method
			decimalTextField.setText(theNumber + ""); 	//Update the text field
		}
		catch(NumberFormatException E) {
		   	decimalTextField.setText("Invalid Format for a Binary String - Illegal character: " + E.getMessage());
		}		
	}//actionPerformed

	public int parseBinary(String bString) {//Recursive parser
		  if(bString.length() == 0)	//Base case
		  {
		   	return(0);
		  }
		  
		  if(bString.charAt(0) == '0') //Handles value 0
		  {    
		   	return((int) ((Math.pow(2, bString.length() - 1) * 0) + parseBinary(bString.substring(1))));
		  }
		  else
		  if(bString.charAt(0) == '1') //Handles value 1
		  {
		   	return((int) ((Math.pow(2, bString.length() - 1) * 1) + parseBinary(bString.substring(1))));
		  }
		  else  //Binary value should be either 1 or 0
		  {
		   	throw new NumberFormatException("" + bString.charAt(0));
		  }
	}//parseBinary
	
	public static void main(String[] args) {
	  	new Assignment2();
	}
}