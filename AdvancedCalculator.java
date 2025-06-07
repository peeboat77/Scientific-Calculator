
/*
author: Persis Boateng
date: December 12, 2024
*/


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AdvancedCalculator implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JTextArea historyArea;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[18];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JButton sinButton, cosButton, tanButton, logButton, sqrtButton;
    JButton mAddButton, mSubButton, mRecallButton, mClearButton;
    JPanel panel;
    JScrollPane historyScrollPane;

    Font displayFont = new Font("Arial", Font.BOLD, 30);
    Font buttonFont = new Font("Arial", Font.PLAIN, 20);

    double num1 = 0, num2 = 0, result = 0, memory = 0;
    char operator;
    ArrayList<String> history = new ArrayList<>();
    boolean isScientificMode = false;

    AdvancedCalculator() {
        frame = new JFrame("Advanced Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 750);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(50, 50, 50));

        textfield = new JTextField();
        textfield.setBounds(50, 25, 450, 50);
        textfield.setFont(displayFont);
        textfield.setEditable(false);
        textfield.setBackground(new Color(220, 220, 220));
        textfield.setForeground(Color.BLACK);

        historyArea = new JTextArea();
        historyArea.setEditable(false);
        historyArea.setFont(new Font("Arial", Font.PLAIN, 14));
        historyScrollPane = new JScrollPane(historyArea);
        historyScrollPane.setBounds(50, 85, 450, 100);

        // Initialize buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("×");
        divButton = new JButton("÷");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("C");
        negButton = new JButton("±");
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");
        logButton = new JButton("log");
        sqrtButton = new JButton("√");
        mAddButton = new JButton("M+");
        mSubButton = new JButton("M-");
        mRecallButton = new JButton("MR");
        mClearButton = new JButton("MC");

        JButton themeToggle = new JButton("Theme");
        themeToggle.setBounds(370, 650, 130, 50);
        themeToggle.setFont(buttonFont);
        themeToggle.setFocusable(false);
        themeToggle.setBackground(new Color(60, 60, 60));
        themeToggle.setForeground(Color.BLACK);
        themeToggle.addActionListener(e -> toggleTheme());

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = sinButton;
        functionButtons[10] = cosButton;
        functionButtons[11] = tanButton;
        functionButtons[12] = logButton;
        functionButtons[13] = sqrtButton;
        functionButtons[14] = mAddButton;
        functionButtons[15] = mSubButton;
        functionButtons[16] = mRecallButton;
        functionButtons[17] = mClearButton;

        for (JButton btn : functionButtons) {
            btn.addActionListener(this);
            btn.setFont(buttonFont);
            btn.setFocusable(false);
            btn.setBackground(new Color(100, 100, 100));
            btn.setForeground(Color.BLUE);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(buttonFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(new Color(80, 80, 80));
            numberButtons[i].setForeground(Color.BLUE);
        }

        negButton.setBounds(50, 650, 95, 50);
        delButton.setBounds(150, 650, 95, 50);
        clrButton.setBounds(250, 650, 95, 50);

        panel = new JPanel();
        panel.setBounds(50, 200, 450, 400);
        panel.setLayout(new GridLayout(6, 4, 10, 10));
        panel.setBackground(new Color(50, 50, 50));

        // Add buttons to the panel
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(mulButton);

        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        panel.add(sinButton);
        panel.add(cosButton);
        panel.add(tanButton);
        panel.add(logButton);

        panel.add(sqrtButton);
        panel.add(mAddButton);
        panel.add(mSubButton);
        panel.add(mRecallButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(themeToggle);
        frame.add(textfield);
        frame.add(historyScrollPane);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new AdvancedCalculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource()==addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='+';
			textfield.setText("");
		}
		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='-';
			textfield.setText("");
		}
		if(e.getSource()==mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='*';
			textfield.setText("");
		}
		if(e.getSource()==divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='/';
			textfield.setText("");
		}
		if(e.getSource()==equButton) {
			num2=Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clrButton) {
			textfield.setText("");
		}
		if(e.getSource()==delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		if(e.getSource()==negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}

        if (e.getSource() == sinButton) {
            calculateScientific("sin");
        }
        if (e.getSource() == cosButton) {
            calculateScientific("cos");
        }
        if (e.getSource() == tanButton) {
            calculateScientific("tan");
        }
        if (e.getSource() == logButton) {
            calculateScientific("log");
        }
        if (e.getSource() == sqrtButton) {
            calculateScientific("sqrt");
        }
    }

    private void calculateScientific(String function) {
        double num = Double.parseDouble(textfield.getText());
        switch (function) {
            case "sin":
                result = Math.sin(Math.toRadians(num));
                break;
            case "cos":
                result = Math.cos(Math.toRadians(num));
                break;
            case "tan":
                result = Math.tan(Math.toRadians(num));
                break;
            case "log":
                result = Math.log10(num);
                break;
            case "sqrt":
                result = Math.sqrt(num);
                break;
        }
        textfield.setText(String.valueOf(result));
        addToHistory(function + "(" + num + ") = " + result);
    }

    private void addToHistory(String operation) {
        history.add(operation);
        historyArea.setText(String.join("\n", history));
    }

    private void toggleTheme() {
        Color lightBackground = Color.WHITE;
        Color lightText = Color.BLUE;
        Color darkBackground = Color.BLACK;
        Color darkText = Color.PINK;
    
        if (frame.getContentPane().getBackground().equals(darkBackground)) {
            // Switch to Light Theme
            frame.getContentPane().setBackground(lightBackground);
            textfield.setBackground(lightBackground);
            textfield.setForeground(lightText);
            historyArea.setBackground(lightBackground);
            historyArea.setForeground(lightText);
    
            for (JButton btn : functionButtons) {
                btn.setBackground(lightBackground);
                btn.setForeground(lightText);
            }
    
            for (JButton btn : numberButtons) {
                btn.setBackground(lightBackground);
                btn.setForeground(lightText);
            }
        } else {
            // Switch to Dark Theme
            frame.getContentPane().setBackground(darkBackground);
            textfield.setBackground(darkBackground);
            textfield.setForeground(darkText);
            historyArea.setBackground(darkBackground);
            historyArea.setForeground(darkText);
    
            for (JButton btn : functionButtons) {
                btn.setBackground(new Color(80, 80, 80));
                btn.setForeground(darkText);
            }
    
            for (JButton btn : numberButtons) {
                btn.setBackground(new Color(60, 60, 60));
                btn.setForeground(darkText);
            }
        }
    }
    
}

