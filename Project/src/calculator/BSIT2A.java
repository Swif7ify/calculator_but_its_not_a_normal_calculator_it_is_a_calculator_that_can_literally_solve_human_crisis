package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class BSIT2A extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	@SuppressWarnings("unused")
	private JTextField numwrapper;

	/**
	  Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BSIT2A frame = new BSIT2A();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	String firstValue, secondValue, operator, copiedText;
    double firstDoubleValue, secondDoubleValue, Answer;
    int decimalCount = 0, zeroCount = 0;
	/**
	 * Create the frame.
	 */
	public BSIT2A() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 747);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 17, 775, 689);
		panel.setBackground(new Color(28, 28, 28));
		contentPane.add(panel);
		panel.setLayout(null);
		
		RoundedPanel panel_1 = new RoundedPanel(100);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(28, 27, 718, 125);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		RoundJTextField numwrapper = new RoundJTextField(500);
		numwrapper.setHorizontalAlignment(SwingConstants.TRAILING);
		numwrapper.setEditable(false);
		numwrapper.setFont(new Font("Arial", Font.PLAIN, 24));
		numwrapper.setBackground(new Color(255, 255, 255));
		numwrapper.setBounds(10, 27, 698, 75);
		panel_1.add(numwrapper);
		numwrapper.setColumns(10);
		
		RoundedButton DEL_button = new RoundedButton("DEL", 50);
		DEL_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		DEL_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentText = numwrapper.getText();
				if(currentText.isEmpty()) {
					numwrapper.setText(numwrapper.getText() + "");
				} else {
					numwrapper.setText(currentText.substring(0, currentText.length() - 1));
				}
			}
		});
		DEL_button.setForeground(new Color(0, 0, 0));
		DEL_button.setBackground(new Color(212, 212, 210));
		DEL_button.setBounds(28, 162, 94, 54);
		panel.add(DEL_button);
		
		RoundedButton AC_button = new RoundedButton("AC", 50);
		AC_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		AC_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(" 0");
				firstValue = null;
				secondValue = null;
				firstDoubleValue = 0;
				secondDoubleValue = 0;
				Answer = 0;
				decimalCount = 0;
				zeroCount = 0;
			}
		});
		AC_button.setForeground(new Color(0, 0, 0));
		AC_button.setBackground(new Color(212, 212, 210));
		AC_button.setBounds(132, 162, 94, 54);
		panel.add(AC_button);
		
		RoundedButton plus_minusbutton = new RoundedButton("+/-", 50);
		plus_minusbutton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		plus_minusbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (zeroCount != 0 & Double.parseDouble(numwrapper.getText()) > 0) {
					 firstDoubleValue = Double.parseDouble(numwrapper.getText());
					 numwrapper.setText(" -" + firstDoubleValue);
				 }
			}
		});
		plus_minusbutton.setForeground(new Color(0, 0, 0));
		plus_minusbutton.setBackground(new Color(212, 212, 210));
		plus_minusbutton.setBounds(236, 162, 94, 54);
		panel.add(plus_minusbutton);
		
		RoundedButton plus_button = new RoundedButton("+", 50);
		plus_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		plus_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (firstValue == null) {
	                firstValue = numwrapper.getText();
	                
	            } else {                
	                secondValue = numwrapper.getText();                
	                
	                firstDoubleValue = Double.parseDouble(firstValue);
	                secondDoubleValue = Double.parseDouble(secondValue);
	                
	                Answer = firstDoubleValue + secondDoubleValue;
	                firstValue = "" + Answer;
	                
	            }
				numwrapper.setText(" ");
	            operator = plus_button.getText();
	            decimalCount = 0;
			}
		});
		plus_button.setForeground(new Color(255, 255, 255));
		plus_button.setBackground(new Color(254, 143, 0));
		plus_button.setBounds(340, 162, 94, 54);
		panel.add(plus_button);
		
		RoundedButton FLR_button = new RoundedButton("FLR", 50);
		FLR_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		FLR_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "FLR");
			}
		});
		FLR_button.setForeground(new Color(0, 0, 0));
		FLR_button.setBackground(new Color(212, 212, 210));
		FLR_button.setBounds(444, 162, 94, 54);
		panel.add(FLR_button);
		
		RoundedButton CEIL_button = new RoundedButton("CEIL", 50);
		CEIL_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		CEIL_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "CEIL");
			}
		});
		CEIL_button.setForeground(new Color(0, 0, 0));
		CEIL_button.setBackground(new Color(212, 212, 210));
		CEIL_button.setBounds(548, 162, 94, 54);
		panel.add(CEIL_button);
		
		RoundedButton INT_button = new RoundedButton("INT", 50);
		INT_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		INT_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "INT");
			}
		});
		INT_button.setForeground(new Color(0, 0, 0));
		INT_button.setBackground(new Color(212, 212, 210));
		INT_button.setBounds(652, 162, 94, 54);
		panel.add(INT_button);
		
		RoundedButton seven_button = new RoundedButton("7", 50);
		seven_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		seven_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(zeroCount == 0 ? (" " + seven_button.getText()) : numwrapper.getText() + seven_button.getText());
		        zeroCount++;
			}
		});
		seven_button.setForeground(new Color(255, 255, 255));
		seven_button.setBackground(new Color(80, 80, 80));
		seven_button.setBounds(28, 226, 94, 54);
		panel.add(seven_button);
		
		RoundedButton eight_button = new RoundedButton("8", 50);
		eight_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		eight_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(zeroCount == 0 ? (" " + eight_button.getText()) : numwrapper.getText() + eight_button.getText());
		        zeroCount++;
			}
		});
		eight_button.setForeground(new Color(255, 255, 255));
		eight_button.setBackground(new Color(80, 80, 80));
		eight_button.setBounds(132, 226, 94, 54);
		panel.add(eight_button);
		
		RoundedButton nine_button = new RoundedButton("9", 50);
		nine_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nine_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(zeroCount == 0 ? (" " + nine_button.getText()) : numwrapper.getText() + nine_button.getText());
		        zeroCount++;
			}
		});
		nine_button.setForeground(new Color(255, 255, 255));
		nine_button.setBackground(new Color(80, 80, 80));
		nine_button.setBounds(236, 226, 94, 54);
		panel.add(nine_button);
		
		RoundedButton minus_button = new RoundedButton("-", 50);
		minus_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		minus_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (firstValue == null) {
	                firstValue = numwrapper.getText();
	            } else {
	                secondValue = numwrapper.getText();                
	                
	                firstDoubleValue = Double.parseDouble(firstValue);
	                secondDoubleValue = Double.parseDouble(secondValue);
	                Answer = firstDoubleValue - secondDoubleValue;
	                firstValue = "" + Answer;
	            }
				numwrapper.setText(" ");
	            operator = minus_button.getText();
	            decimalCount = 0;
			}
		});
		minus_button.setForeground(new Color(255, 255, 255));
		minus_button.setBackground(new Color(254, 143, 0));
		minus_button.setBounds(340, 226, 94, 54);
		panel.add(minus_button);
		
		RoundedButton integerdivision_button = new RoundedButton("//", 50);
		integerdivision_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		integerdivision_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "//");
			}
		});
		integerdivision_button.setForeground(new Color(0, 0, 0));
		integerdivision_button.setBackground(new Color(212, 212, 210));
		integerdivision_button.setBounds(444, 226, 94, 54);
		panel.add(integerdivision_button);
		
		RoundedButton modulus = new RoundedButton("%", 50);
		modulus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		modulus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secondValue = numwrapper.getText();            
		            
				firstDoubleValue = Double.parseDouble(firstValue);
				secondDoubleValue = Double.parseDouble(secondValue);
		            
				if (operator == "÷") {
					Answer = (firstDoubleValue / secondDoubleValue) * 100;
					numwrapper.setText(" " + Answer);                
				}
				firstValue = null;
				decimalCount = 0;
			}
		});
		modulus.setForeground(new Color(0, 0, 0));
		modulus.setBackground(new Color(212, 212, 210));
		modulus.setBounds(548, 226, 94, 54);
		panel.add(modulus);
		
		RoundedButton factorial_button = new RoundedButton("N!", 50);
		factorial_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		factorial_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (firstValue == null) {
	                firstValue = numwrapper.getText();
	            } else {
	                secondValue = numwrapper.getText();                
	                
	                firstDoubleValue = Double.parseDouble(firstValue);
	                secondDoubleValue = Double.parseDouble(secondValue);
	                Answer = firstDoubleValue - secondDoubleValue;
	                firstValue = "" + Answer;
	            }
				numwrapper.setText(" ");
	            operator = factorial_button.getText();
	            decimalCount = 0;
			}
		});
		factorial_button.setForeground(new Color(0, 0, 0));
		factorial_button.setBackground(new Color(212, 212, 210));
		factorial_button.setBounds(652, 226, 94, 54);
		panel.add(factorial_button);
		
		RoundedButton four_button = new RoundedButton("4", 50);
		four_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		four_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(zeroCount == 0 ? (" " + four_button.getText()) : numwrapper.getText() + four_button.getText());
		        zeroCount++;
			}
		});
		four_button.setForeground(new Color(255, 255, 255));
		four_button.setBackground(new Color(80, 80, 80));
		four_button.setBounds(28, 290, 94, 54);
		panel.add(four_button);
		
		RoundedButton five_button = new RoundedButton("5", 50);
		five_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		five_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(zeroCount == 0 ? (" " + five_button.getText()) : numwrapper.getText() + five_button.getText());
		        zeroCount++;
			}
		});
		five_button.setForeground(new Color(255, 255, 255));
		five_button.setBackground(new Color(80, 80, 80));
		five_button.setBounds(132, 290, 94, 54);
		panel.add(five_button);
		
		RoundedButton six_button = new RoundedButton("6", 50);
		six_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		six_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(zeroCount == 0 ? (" " + six_button.getText()) : numwrapper.getText() + six_button.getText());
		        zeroCount++;
			}
		});
		six_button.setForeground(new Color(255, 255, 255));
		six_button.setBackground(new Color(80, 80, 80));
		six_button.setBounds(236, 290, 94, 54);
		panel.add(six_button);
		
		RoundedButton multiplication_button = new RoundedButton("*", 50);
		multiplication_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		multiplication_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (firstValue == null) {
		                firstValue = numwrapper.getText();
		            } else {
		                secondValue = numwrapper.getText();                
		                
		                firstDoubleValue = Double.parseDouble(firstValue);
		                secondDoubleValue = Double.parseDouble(secondValue);
		                Answer = firstDoubleValue * secondDoubleValue;
		                firstValue = "" + Answer;
		            }
				 numwrapper.setText(" ");
				 operator = multiplication_button.getText();
				 decimalCount = 0;
			}
		});
		multiplication_button.setForeground(new Color(255, 255, 255));
		multiplication_button.setBackground(new Color(254, 143, 0));
		multiplication_button.setBounds(340, 290, 94, 54);
		panel.add(multiplication_button);
		
		RoundedButton squareroot_button = new RoundedButton("√", 50);
		squareroot_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		squareroot_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  firstValue = numwrapper.getText();
				  firstDoubleValue = Double.parseDouble(firstValue);
				  Answer = Math.sqrt(firstDoubleValue);
				  numwrapper.setText(" " + Answer);     
			}
		});
		squareroot_button.setForeground(new Color(0, 0, 0));
		squareroot_button.setBackground(new Color(212, 212, 210));
		squareroot_button.setBounds(444, 290, 94, 54);
		panel.add(squareroot_button);
		
		RoundedButton cuberoot_button = new RoundedButton("∛", 50);
		cuberoot_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cuberoot_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "∛");
			}
		});
		cuberoot_button.setForeground(new Color(0, 0, 0));
		cuberoot_button.setBackground(new Color(212, 212, 210));
		cuberoot_button.setBounds(548, 290, 94, 54);
		panel.add(cuberoot_button);
		
		RoundedButton summation_button = new RoundedButton("∑", 50);
		summation_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		summation_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "∑");
			}
		});
		summation_button.setForeground(new Color(0, 0, 0));
		summation_button.setBackground(new Color(212, 212, 210));
		summation_button.setBounds(652, 290, 94, 54);
		panel.add(summation_button);
		
		RoundedButton one_button = new RoundedButton("1", 50);
		one_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		one_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(zeroCount == 0 ? (" " + one_button.getText()) : numwrapper.getText() + one_button.getText());
		        zeroCount++;
			}
		});
		one_button.setForeground(new Color(255, 255, 255));
		one_button.setBackground(new Color(80, 80, 80));
		one_button.setBounds(28, 354, 94, 54);
		panel.add(one_button);
		
		RoundedButton two_button = new RoundedButton("2", 50);
		two_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		two_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(zeroCount == 0 ? (" " + two_button.getText()) : numwrapper.getText() + two_button.getText());
		        zeroCount++;
			}
		});
		two_button.setForeground(new Color(255, 255, 255));
		two_button.setBackground(new Color(80, 80, 80));
		two_button.setBounds(132, 354, 94, 54);
		panel.add(two_button);
		
		RoundedButton three_button = new RoundedButton("3", 50);
		three_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		three_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(zeroCount == 0 ? (" " + three_button.getText()) : numwrapper.getText() + three_button.getText());
		        zeroCount++;
			}
		});
		three_button.setForeground(new Color(255, 255, 255));
		three_button.setBackground(new Color(80, 80, 80));
		three_button.setBounds(236, 354, 94, 54);
		panel.add(three_button);
		
		RoundedButton division_button = new RoundedButton("÷", 50);
		division_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		division_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (firstValue == null) {
		                firstValue = numwrapper.getText();
		            } else {
		                secondValue = numwrapper.getText();                
		                
		                firstDoubleValue = Double.parseDouble(firstValue);
		                secondDoubleValue = Double.parseDouble(secondValue);
		                Answer = firstDoubleValue / secondDoubleValue;
		                firstValue = "" + Answer;
		            }
				 numwrapper.setText(" ");
		            operator = division_button.getText();
		            decimalCount = 0;
			}
		});
		division_button.setForeground(new Color(255, 255, 255));
		division_button.setBackground(new Color(254, 143, 0));
		division_button.setBounds(340, 354, 94, 54);
		panel.add(division_button);
		
		RoundedButton XpowerY_button = new RoundedButton("x^y", 50);
		XpowerY_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		XpowerY_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "x^y");
			}
		});
		XpowerY_button.setForeground(new Color(0, 0, 0));
		XpowerY_button.setBackground(new Color(212, 212, 210));
		XpowerY_button.setBounds(444, 354, 94, 54);
		panel.add(XpowerY_button);
		
		RoundedButton XpowerYpowerofZ_button = new RoundedButton("x^y^z", 50);
		XpowerYpowerofZ_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		XpowerYpowerofZ_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "x^y^z");
			}
		});
		XpowerYpowerofZ_button.setForeground(new Color(0, 0, 0));
		XpowerYpowerofZ_button.setBackground(new Color(212, 212, 210));
		XpowerYpowerofZ_button.setBounds(548, 354, 94, 54);
		panel.add(XpowerYpowerofZ_button);
		
		RoundedButton productnotation_button = new RoundedButton("Π", 50);
		productnotation_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		productnotation_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "Π");
			}
		});
		productnotation_button.setForeground(new Color(0, 0, 0));
		productnotation_button.setBackground(new Color(212, 212, 210));
		productnotation_button.setBounds(652, 354, 94, 54);
		panel.add(productnotation_button);
		
		RoundedButton zero_button = new RoundedButton("0", 50);
		zero_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		zero_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(zeroCount !=0) {
					  numwrapper.setText(numwrapper.getText() + zero_button.getText());
				}
			}
		});
		zero_button.setForeground(new Color(0, 0, 0));
		zero_button.setBackground(new Color(212, 212, 210));
		zero_button.setBounds(28, 418, 94, 54);
		panel.add(zero_button);
		
		RoundedButton period_button = new RoundedButton(".", 50);
		period_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		period_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 decimalCount++;
				 zeroCount++;
				 numwrapper.setText(numwrapper.getText() + period_button.getText());      
			}
		});
		period_button.setForeground(new Color(0, 0, 0));
		period_button.setBackground(new Color(212, 212, 210));
		period_button.setBounds(132, 418, 94, 54);
		panel.add(period_button);
		
		RoundedButton equals_button = new RoundedButton("=", 50);
		equals_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		equals_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (operator == "N!") {
					 firstDoubleValue = Double.parseDouble(firstValue);
	                if(firstDoubleValue == 0 || firstDoubleValue == 1) {
	                	Answer = 1;
	                } else {
	                	Answer = 1;
	                    for (int i = 2; i <= firstDoubleValue; i++) {
	                        Answer *= i; 
	                    }
	                }
	                numwrapper.setText(" " + Answer);
	            } else {
	            	secondValue = numwrapper.getText();            
		            
		            firstDoubleValue = Double.parseDouble(firstValue);
		            secondDoubleValue = Double.parseDouble(secondValue);
		            
		            if (operator == "+") {
		                Answer = firstDoubleValue + secondDoubleValue;
		                numwrapper.setText(" " + Answer);                
		            } else if (operator == "-") {
		                Answer = firstDoubleValue - secondDoubleValue;
		                numwrapper.setText(" " + Answer);                
		            } else if (operator == "*") {
		                Answer = firstDoubleValue * secondDoubleValue;
		                numwrapper.setText(" " + Answer);                
		            } else if (operator == "÷") {
		                Answer = firstDoubleValue / secondDoubleValue;
		                numwrapper.setText(" " + Answer);
		            } 

		            firstValue = null;
		            decimalCount = 0;
	            }
			}
		});
		equals_button.setForeground(new Color(255, 255, 255));
		equals_button.setBackground(new Color(254, 143, 0));
		equals_button.setBounds(236, 418, 198, 54);
		panel.add(equals_button);
		
		RoundedButton doublesummation_button = new RoundedButton("∑ ∑", 50);
		doublesummation_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		doublesummation_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "∑ ∑");
			}
		});
		doublesummation_button.setForeground(new Color(0, 0, 0));
		doublesummation_button.setBackground(new Color(212, 212, 210));
		doublesummation_button.setBounds(444, 418, 147, 54);
		panel.add(doublesummation_button);
		
		RoundedButton doubleproductnotation_button = new RoundedButton("Π Π", 50);
		doubleproductnotation_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		doubleproductnotation_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "Π Π");
			}
		});
		doubleproductnotation_button.setForeground(new Color(0, 0, 0));
		doubleproductnotation_button.setBackground(new Color(212, 212, 210));
		doubleproductnotation_button.setBounds(601, 418, 145, 54);
		panel.add(doubleproductnotation_button);
		
		RoundedButton set_button = new RoundedButton("SET", 50);
		set_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		set_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "SET");
			}
		});
		set_button.setForeground(new Color(255, 255, 255));
		set_button.setBackground(new Color(80, 80, 80));
		set_button.setBounds(28, 480, 406, 54);
		panel.add(set_button);
		
		RoundedButton logsubtwoX_button = new RoundedButton("log∨(2) X", 50);
		logsubtwoX_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		logsubtwoX_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "log∨(2) X");
			}
		});
		logsubtwoX_button.setForeground(new Color(255, 255, 255));
		logsubtwoX_button.setBackground(new Color(80, 80, 80));
		logsubtwoX_button.setBounds(444, 480, 147, 54);
		panel.add(logsubtwoX_button);
		
		RoundedButton logX_button = new RoundedButton("log∨(x)", 50);
		logX_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		logX_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "log∨(x)");
			}
		});
		logX_button.setForeground(new Color(255, 255, 255));
		logX_button.setBackground(new Color(80, 80, 80));
		logX_button.setBounds(601, 482, 145, 54);
		panel.add(logX_button);
		
		RoundedButton A_button = new RoundedButton("A", 50);
		A_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		A_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "A");
			}
		});
		A_button.setForeground(new Color(255, 255, 255));
		A_button.setBackground(new Color(80, 80, 80));
		A_button.setBounds(28, 544, 94, 54);
		panel.add(A_button);
		
		RoundedButton B_button = new RoundedButton("B", 50);
		B_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		B_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "B");
			}
		});
		B_button.setForeground(new Color(255, 255, 255));
		B_button.setBackground(new Color(80, 80, 80));
		B_button.setBounds(132, 544, 94, 54);
		panel.add(B_button);
		
		RoundedButton C_button = new RoundedButton("C", 50);
		C_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		C_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "C");
			}
		});
		C_button.setForeground(new Color(255, 255, 255));
		C_button.setBackground(new Color(80, 80, 80));
		C_button.setBounds(236, 544, 94, 54);
		panel.add(C_button);
		
		RoundedButton D_button = new RoundedButton("D", 50);
		D_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		D_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "D");
			}
		});
		D_button.setForeground(new Color(255, 255, 255));
		D_button.setBackground(new Color(80, 80, 80));
		D_button.setBounds(340, 544, 94, 54);
		panel.add(D_button);
		
		RoundedButton aFACTplusbFACT_button = new RoundedButton("a! + b!", 50);
		aFACTplusbFACT_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		aFACTplusbFACT_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "a! + b!");
			}
		});
		aFACTplusbFACT_button.setForeground(new Color(255, 255, 255));
		aFACTplusbFACT_button.setBackground(new Color(80, 80, 80));
		aFACTplusbFACT_button.setBounds(444, 544, 147, 54);
		panel.add(aFACTplusbFACT_button);
		
		RoundedButton aFACTdividebFACT_button = new RoundedButton("a! / b!", 50);
		aFACTdividebFACT_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		aFACTdividebFACT_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "a! / b!");
			}
		});
		aFACTdividebFACT_button.setForeground(new Color(255, 255, 255));
		aFACTdividebFACT_button.setBackground(new Color(80, 80, 80));
		aFACTdividebFACT_button.setBounds(601, 546, 145, 54);
		panel.add(aFACTdividebFACT_button);
		
		RoundedButton XY_button = new RoundedButton("xy", 50);
		XY_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		XY_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "xy");
			}
		});
		XY_button.setForeground(new Color(255, 255, 255));
		XY_button.setBackground(new Color(80, 80, 80));
		XY_button.setBounds(28, 608, 94, 54);
		panel.add(XY_button);
		
		RoundedButton XplusY_button = new RoundedButton("x+y", 50);
		XplusY_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		XplusY_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "x+y");
			}
		});
		XplusY_button.setForeground(new Color(255, 255, 255));
		XplusY_button.setBackground(new Color(80, 80, 80));
		XplusY_button.setBounds(132, 608, 94, 54);
		panel.add(XplusY_button);
		
		RoundedButton XpowerY = new RoundedButton("x^y", 50);
		XpowerY.setFont(new Font("Tahoma", Font.PLAIN, 15));
		XpowerY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "x^y");
			}
		});
		XpowerY.setForeground(new Color(255, 255, 255));
		XpowerY.setBackground(new Color(80, 80, 80));
		XpowerY.setBounds(236, 608, 94, 54);
		panel.add(XpowerY);
		
		RoundedButton Cx_button = new RoundedButton("Cx", 50);
		Cx_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Cx_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "Cx");
			}
		});
		Cx_button.setForeground(new Color(255, 255, 255));
		Cx_button.setBackground(new Color(80, 80, 80));
		Cx_button.setBounds(340, 608, 94, 54);
		panel.add(Cx_button);
		
		RoundedButton xplusC_button = new RoundedButton("x + C", 50);
		xplusC_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		xplusC_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "x + C");
			}
		});
		xplusC_button.setForeground(new Color(255, 255, 255));
		xplusC_button.setBackground(new Color(80, 80, 80));
		xplusC_button.setBounds(444, 608, 94, 54);
		panel.add(xplusC_button);
		
		RoundedButton XpowerC = new RoundedButton("x^C", 50);
		XpowerC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		XpowerC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "x^C");
			}
		});
		XpowerC.setForeground(new Color(255, 255, 255));
		XpowerC.setBackground(new Color(80, 80, 80));
		XpowerC.setBounds(548, 608, 94, 54);
		panel.add(XpowerC);
		
		RoundedButton answer_button = new RoundedButton("ANS", 50);
		answer_button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		answer_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numwrapper.setText(numwrapper.getText() + "ANS");
			}
		});

		answer_button.setForeground(new Color(255, 255, 255));
		answer_button.setBackground(new Color(80, 80, 80));
		answer_button.setBounds(652, 610, 94, 54);
		panel.add(answer_button);
	}
}
