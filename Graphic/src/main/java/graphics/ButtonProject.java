package graphics;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Program that uses action listener to accomplish different tasks
 * William Meathrel
 * October 13 2020
 */
public class ButtonProject implements ActionListener {

	// Sets variables
	public static JFrame window;
	public static JPanel mainJPanel;
	public int counter;
	public static JTextField textField;
	public JSlider slider;
	public static JPanel secondaryPanel;

	public static void main(String[] args) {
		new ButtonProject();
	}

	public ButtonProject() {

		// Initalizes jframe and its contents
		window = new JFrame("Button Project");
		mainJPanel = new JPanel();
		secondaryPanel = new JPanel();

		// Window and jpanel config
		window.setSize(800, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainJPanel.setBackground(Color.red);
		secondaryPanel.setBackground(Color.red);

		// Creates a button group
		ButtonGroup radioGroup = new ButtonGroup();

		// Adds the buttons to the button group and gives them the multiButton action
		// listener
		for (int i = 0; i < 3; i++) {
			JRadioButton tempButton = new JRadioButton(Integer.toString(i));
			tempButton.addActionListener(new multiButton());
			secondaryPanel.add(tempButton);
			radioGroup.add(tempButton);

		}

		// Initalizes the slider and gives it a changelistener
		slider = new JSlider(100, 700);
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent event) {
				secondaryPanel.setLocation(secondaryPanel.getX(), slider.getValue());

			}

		});

		// adds the slider to the panel
		secondaryPanel.add(slider);

		// Creates a button that changes that increases the value of the title
		counter = 0;

		JButton counterButton = new JButton("Counter Button");
		counterButton.addActionListener(this);
		mainJPanel.add(counterButton);

		// Creates and adds a buttin with 2 action listeners one that moves and one that
		// changes the background color
		JButton duelListenerButton = new JButton("Duel Listener");
		duelListenerButton.addActionListener(this);
		duelListenerButton.addActionListener(new moveAL());
		mainJPanel.add(duelListenerButton);

		// Create and add the movement button
		JButton moveButton = new JButton("Move Button");
		moveButton.addActionListener(new moveAL());
		mainJPanel.add(moveButton);

		// Creates and adds a text field with length 30
		textField = new JTextField(30);
		mainJPanel.add(textField);

		// Adds the duplication button
		JButton duplicateButton = new JButton("duplicate");
		duplicateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				if (secondaryPanel.getComponents().length >= 5) {
					return;
				}

				String name = textField.getText();

				secondaryPanel.add(new JButton(name));

				window.validate();

			}

		});

		mainJPanel.add(duplicateButton);

		// Adds panels to the window and sets visibilaty true
		mainJPanel.add(secondaryPanel);
		window.add(mainJPanel);

		window.setVisible(true);

	}

	
	// Handles mulitple buttons
	@Override
	public void actionPerformed(ActionEvent event) {
		// Increases title counter if counter button is pressed
		if (event.getActionCommand().equals("Counter Button")) {
			counter++;
			window.setTitle(Integer.toString(counter));
			System.out.println(textField.getText());
		} 
		// Changes background if duel listener button is pressed
		else if (event.getActionCommand().equals("Duel Listener")) {
			if (mainJPanel.getBackground() == Color.red) {
				mainJPanel.setBackground(Color.ORANGE);
			} else {
				mainJPanel.setBackground(Color.red);
			}

			secondaryPanel.setBackground(mainJPanel.getBackground());
		}

	}

	// Moves buttons towards the buttom of the screen
	public static class moveAL implements ActionListener {

		public static int muliplier = 1;
		public int x = 0;
		public static int y = 20;

		// Sets the new location
		@Override
		public void actionPerformed(ActionEvent event) {
			// Switches the direction if an edge is hit
			if (y == 760 || y == 0) {
				muliplier *= -1;
			}

			// Moves the panel
			ButtonProject.mainJPanel.setLocation(x, y += 20 * muliplier);
		}

	}

	// This handles the event listeners for the JButtonGroup radio button
	public static class multiButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// Checks to see if the required amount of buttons exist
			if (secondaryPanel.getComponents().length <= 4) {
				System.out.println("No button");
				return;
			}

			// Creates new button with old text
			JButton newJButton = new JButton(((JButton) (secondaryPanel.getComponent(4))).getText());

			// Removes old component
			secondaryPanel.remove(secondaryPanel.getComponent(4));

			// Switch for which button was pressed
			switch (Integer.parseInt(event.getActionCommand())) {
				case 0:
					// Adds the new button
					newJButton.addActionListener(new moveAL());
					break;
				case 1:
					// Adds new action listner
					newJButton.addActionListener(new ActionListener() {

						// Adds action listener that changes bg color
						@Override
						public void actionPerformed(ActionEvent event) {
							if (mainJPanel.getBackground() == Color.red) {
								mainJPanel.setBackground(Color.ORANGE);
							} else {
								mainJPanel.setBackground(Color.red);
							}
							secondaryPanel.setBackground(mainJPanel.getBackground());

						}

					});

					break;
				case 2:

					// Adds text from JOptionpanel to screen
					newJButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent event) {
							String text = JOptionPane.showInputDialog(window, "What would you like to write",
									"Add Text", JOptionPane.DEFAULT_OPTION);
							mainJPanel.add(new JLabel(text));
							window.validate();
						}
					});

					break;
				default:
					break;
			}

			// Adds new button to screen and validates
			secondaryPanel.add(newJButton);
			window.validate();
		}

	}
}
