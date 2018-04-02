package SudokuSolver;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SudokuView extends JPanel implements FocusListener {
	JButton confirm;
	JButton reset;
	JFrame mainFrame = new JFrame();
	JPanel frame = new JPanel();
	int t = 9;
	ArrayList<JTextField> list = new ArrayList<>();

	public SudokuView() { // constructor
		confirm = new JButton("confirm");
		confirm.addActionListener(e -> {
			confirmEntry();
		});
		reset = new JButton("reset");
		reset.addActionListener(e -> {
			reset();
		});
		mainFrame.setLayout(new BorderLayout());
		frame.setLayout(new GridLayout(t, t, 3, 3));
		addFields(frame, t);
		frame.setPreferredSize(new Dimension(500, 500));
		mainFrame.add(confirm, BorderLayout.SOUTH);
		mainFrame.add(reset, BorderLayout.CENTER);
		mainFrame.add(frame, BorderLayout.NORTH);
		mainFrame.pack();
		mainFrame.setVisible(true);

	}

	private void addFields(JPanel frame2, int t) {
		JTextField grid;
		for (int y = 0; y < t; y++) {

			for (int x = 0; x < t; x++) {

				grid = new JTextField(); // creates new button
				grid.setText("0");
				grid.setPreferredSize(new Dimension(55, 55));
				grid.setHorizontalAlignment(JTextField.CENTER);
				grid.addFocusListener(this);
				frame2.add(grid); // adds button to grid
				list.add(grid);

			}
		}
	}

	private void confirmEntry() {
		int[] input = new int[81];
		int i = 0;
		for (JTextField field : list) {

			input[i] = Integer.parseInt(field.getText());
			i++;
			field.setEditable(false);
			field.setBackground(Color.WHITE);

		}

		new SudokuMain(input, this);

	}

	@Override
	public void focusGained(FocusEvent e) {

		JTextField field = (JTextField) e.getSource();
		field.setText(null);

		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField field = (JTextField) e.getSource();
		{
			if (field.getText().equals("")) {
				field.setText("0");
			}
		}

	}

	public void reset() {
		new SudokuView();
		mainFrame.dispose();

	}

	public void update(String numbers) {
		int i = 0;
		numbers = numbers.replaceAll("\\s+", "");
		for (JTextField field : list) {

			field.setText(String.valueOf(numbers.charAt(i)));
			i++;
		}

	}

	public void wrongInputMessage() {
		for (JTextField field : list) {

			field.setEditable(true);

		}

		JOptionPane.showMessageDialog(null, "Wrong input pleas type in numbers again", "Wrong input",
				JOptionPane.PLAIN_MESSAGE);
		;
		// TODO Auto-generated method stub

	}
}