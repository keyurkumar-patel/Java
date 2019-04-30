import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class GUI {

	private JFrame frame;
	private JTextField textyear;
	private JTextField textgender;
	private JTextField textname;
	String fileName = "";
	Pattern YearPattern = Pattern.compile("^[0-9]+$");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 374, 279);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Year:-");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(27, 41, 70, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Gender:-");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_1.setBounds(27, 87, 79, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Name:-");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_2.setBounds(27, 135, 79, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		textyear = new JTextField();
		textyear.setBounds(123, 41, 174, 23);
		frame.getContentPane().add(textyear);
		textyear.setColumns(10);
		
		textgender = new JTextField();
		textgender.setBounds(123, 87, 174, 23);
		frame.getContentPane().add(textgender);
		textgender.setColumns(10);
		
		textname = new JTextField();
		textname.setBounds(123, 135, 174, 23);
		frame.getContentPane().add(textname);
		textname.setColumns(10);
		
		JButton btnsubmit = new JButton("Submit");
		btnsubmit.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String genderm ="m";
				String genderM ="M";
				String genderf ="f";
				String genderF ="F";
				if(textyear.getText().equals("")||textgender.getText().equals("")||textname.getText().equals("")
						||Integer.parseInt(textyear.getText()) < 2001 || Integer.parseInt(textyear.getText()) > 2010)
						
				{																	
					JOptionPane.showMessageDialog(null,"***************Please enter all the filed***************\n");
					
				}
				/*else if(Integer.parseInt(textyear.getText()) < 2001 || Integer.parseInt(textyear.getText()) > 2010) { 
						
					JOptionPane.showMessageDialog(null,"***************Year must range from 2001 - 2010 and must be interger only***************\n");
				}*/
				else if (!textgender.getText().equals(genderm)  && !textgender.getText().equals(genderM) 
						&& !textgender.getText().equals(genderf) && !textgender.getText().equals(genderF)){
					
					JOptionPane.showMessageDialog(null,"Enter Correct Gender Only F(f) or M(m)");
				}
				else 
				{
					try {
						
						fileName = "babynamesranking" + textyear.getText() + ".txt";
						RandomAccessFile data = new RandomAccessFile(fileName, "rw");
						String getstring = "";
						boolean found = false;

						for (int i = 0; i < 1000; i++) 
						{
							getstring = data.readLine();
							String[] word = getstring.split(" ");
							String[] male_word = word[1].split("\\t");
							male_word[1] = male_word[1].trim();
							word[2] = word[2].trim();
							
							
							String S = textgender.getText();
							if (  S.equals("m") | S.equals("M") ) 
							{
								
								if (male_word[1].equalsIgnoreCase(textname.getText())) 
								{
									JOptionPane.showMessageDialog(null,"Boy name " + male_word[1] + " is ranked #" + word[0] + " in year " + textyear.getText());
									found = true;
									
								}
//								else {
//									JOptionPane.showMessageDialog(null,"Boy Name not found\n");
//									
//								}
							}
							
							if (  S.equals("f") | S.equals("F") )
							{
								
								if (word[2].equalsIgnoreCase(textname.getText())) 
								{
									JOptionPane.showMessageDialog(null,"Girl name " + word[2] + " is ranked #" + word[0] + " in year " + textyear.getText());
									found = true;
									
								}
								/*else {
								System.out.print("Girl Name not found\n");
								
							}*/
							}
							
						}
						if (!found) {
							JOptionPane.showMessageDialog(null,"OOPS! Sorry...BoyName or GirlName not found in the File...");
						}
						data.close();
					} 
					catch (IOException ex) 
					{
						ex.printStackTrace();
						
					
					}

				}			}
		});
		btnsubmit.setBounds(135, 192, 118, 27);
		frame.getContentPane().add(btnsubmit);
	}
}
