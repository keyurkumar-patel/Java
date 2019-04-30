import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

public class Addressbook {
	//Addressbook ab = new Addressbook();
	public long location =0;
	protected int count = 0;
	private JFrame frmAddressbook;
	private JTextField txtName;
	private JTextField textStreet;
	private JTextField textCity;
	private JTextField textstate;
	private JTextField textzipcode;
	private JLabel  lblerror;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addressbook window = new Addressbook();
					window.frmAddressbook.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Addressbook() {
				
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frmAddressbook = new JFrame();
		frmAddressbook.setTitle("AddressBook");
		frmAddressbook.setBounds(100, 100, 788, 449);
		frmAddressbook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddressbook.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name:-");
		lblName.setBounds(34, 32, 46, 14);
		frmAddressbook.getContentPane().add(lblName);
		
		JLabel lblStreet = new JLabel("Street:-");
		lblStreet.setBounds(34, 73, 46, 14);
		frmAddressbook.getContentPane().add(lblStreet);
		
		JLabel lblCity = new JLabel("City:-");
		lblCity.setBounds(34, 143, 46, 14);
		frmAddressbook.getContentPane().add(lblCity);
		
		txtName = new JTextField();
		/*txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c=evt.getKeyChar();
				//Pattern letterPattern = Pattern.compile("^[a-zA-Z]+$");

				if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ))
			        evt.consume();
			}
		});*/
		txtName.setBounds(90, 23, 331, 33);
		frmAddressbook.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		textStreet = new JTextField();
		textStreet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		textStreet.setBounds(90, 67, 331, 33);
		frmAddressbook.getContentPane().add(textStreet);
		textStreet.setColumns(10);
		
		textCity = new JTextField();
		/*textCity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
					char c=evt.getKeyChar();

				    if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ))
				        evt.consume();
				}
			}
		);*/
		textCity.setBounds(90, 134, 158, 33);
		frmAddressbook.getContentPane().add(textCity);
		textCity.setColumns(10);
		
		JLabel lblState = new JLabel("State:-");
		lblState.setBounds(267, 143, 46, 14);
		frmAddressbook.getContentPane().add(lblState);
		
		JLabel lblZipcode = new JLabel("ZipCode:-");
		lblZipcode.setBounds(482, 143, 64, 14);
		frmAddressbook.getContentPane().add(lblZipcode);
		
		textstate = new JTextField();
		/*textstate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
			}
			@Override
			public void keyTyped(KeyEvent evt) {
				char c=evt.getKeyChar();

			    if(!(Character.isAlphabetic(c) ||  (c==KeyEvent.VK_BACK_SPACE)||  c==KeyEvent.VK_DELETE ))
			        evt.consume();

			}
		});*/
		textstate.setBounds(323, 134, 98, 33);
		frmAddressbook.getContentPane().add(textstate);
		textstate.setColumns(10);
		
		textzipcode = new JTextField();
		textzipcode.setBounds(556, 134, 86, 33);
		frmAddressbook.getContentPane().add(textzipcode);
		textzipcode.setColumns(10);
		
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pattern letterPattern = Pattern.compile("^([a-zA-Z]+\\s)*[a-zA-Z]+$");
				Pattern StreetPattern = Pattern.compile("^([a-zA-Z0-9]+\\s)*[a-zA-Z0-9]+$");
				Pattern CityPattern = Pattern.compile("^[a-zA-Z]+$");
				Pattern StatePattern = Pattern.compile("^[a-zA-Z]+$");
				Pattern ZipPattern = Pattern.compile("^([A-Za-z]\\d[A-Za-z][-]?\\d[A-Za-z]\\d)");
								
				if(txtName.getText().equals("") || textStreet.getText().equals("")
						|| textCity.getText().equals("") || textstate.getText().equals("")
						|| textzipcode.getText().equals("") || (!(letterPattern.matcher(txtName.getText()).matches()))
						||(!(StreetPattern.matcher(textStreet.getText()).matches()))
						||(!(CityPattern.matcher(textCity.getText()).matches()))
						||(!(StatePattern.matcher(textstate.getText()).matches()))
						||(!(ZipPattern.matcher(textzipcode.getText()).matches())))
						//||(zip.matches(regex)))
						//(name.matches(namePattern)) 
						//||  || (street.matches(regexstreet)) ||(city.matches(regexcity)) || (state.matches(regstate)) )
					{
						JOptionPane.showMessageDialog(null, "Please enter all Field with valid DATA Entry");
					}				
					else{
										File fs = new File("Address.dat");
										try 
										{
											RandomAccessFile data = new RandomAccessFile(fs, "rw");
											long position = data.length();
											data.seek(position);
											String tmp, tmp2, tmp3;
											/*if(txtName.getText().isEmpty() 
													|| textStreet.getText().isEmpty()
													|| textCity.getText().isEmpty() 
													|| textstate.getText().isEmpty() || textzipcode.getText().isEmpty()){
												JOptionPane.showMessageDialog(null, "Please enter all Field");
							
											}
											else
											{
												JOptionPane.showMessageDialog(null, "Record added succesfully");	
											}*/
											tmp3 = txtName.getText();
											if (txtName.getText().length() <= 32) 
											{
												tmp = tmp3;
												for (int i = tmp.length(); i < 32; i++) 
												{
													tmp = tmp + ' ';
												}
											}
											else 
											{
												tmp = tmp3.substring(0, 32);
							
											}

											tmp2 = tmp + ',';
											data.writeBytes(tmp2);
											tmp3 = textStreet.getText();
											if (textStreet.getText().length() > 32) {
												tmp = tmp3.substring(0, 32);
											} 
											else 
											{
												tmp = tmp3;
												for (int i = tmp.length(); i < 32; i++) {
													tmp = tmp + ' ';
												}
											}
											tmp2 = tmp + ',';
											data.writeBytes(tmp2);

											tmp3 = textCity.getText();
											if (textCity.getText().length() > 20) {
												tmp = tmp3.substring(0, 20);
											} 
											else 
											{
												tmp = tmp3;
												for (int i = tmp.length(); i < 20; i++) 
												{
													tmp = tmp + ' ';
												}
											}
											tmp2 = tmp + ',';
											data.writeBytes(tmp2);
											tmp3 = textstate.getText();
											if (textstate.getText().length() <=  2) 
											{
												tmp = tmp3;
												for (int i = tmp.length(); i < 2; i++) 
												{
													tmp = tmp + ' ';
												}
											}
											else 
											{
												tmp = tmp3.substring(0, 2);
											}
											tmp2 = tmp + ',';
											data.writeBytes(tmp2);
											tmp3 = textzipcode.getText();
											if (textzipcode.getText().length() <= 7) 
											{
												tmp = tmp3;
												for (int i = tmp.length(); i < 7; i++) 
												{
													tmp = tmp + ' ';
												}
											}
											else 
											{
												tmp = tmp3.substring(0, 7);
											}
											tmp2 = tmp + '\n';
											data.writeBytes(tmp2);
											location = data.getFilePointer();
											data.close();
										}
										catch (IOException ex)
										{
											ex.printStackTrace();
										}
										JOptionPane.showMessageDialog(null, "Record added succesfully");
						}
				
					}
			});
		btnAdd.setBounds(34, 224, 89, 23);
		frmAddressbook.getContentPane().add(btnAdd);
		
		JButton btnFirst = new JButton("First");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Addressbook adbook = new Addressbook();
				File fs = new File("Address.dat");
				try 
				{
					RandomAccessFile data = new RandomAccessFile(fs, "rw");
					data.seek(0);
					String tmp = data.readLine();
					String[] list = tmp.split(",");
					txtName.setText(list[0].trim());
					textStreet.setText(list[1].trim());
					textCity.setText(list[2].trim());
					textstate.setText(list[3].trim());
					textzipcode.setText(list[4].trim());
					adbook.location = data.getFilePointer() - 96;
					data.close();
				} catch (IOException ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		btnFirst.setBounds(135, 224, 89, 23);
		frmAddressbook.getContentPane().add(btnFirst);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File fs = new File("Address.dat");
				try {	
					RandomAccessFile data = new RandomAccessFile(fs, "rw");
					if (count * 91 < data.length())
						{
							data.seek(count * 91);
							int position;
							byte[] name = new byte[32];	
							position = data.read(name);
							txtName.setText(new String(name).trim());
							byte[] street = new byte[32];	
							position += data.read(street);
							textStreet.setText(new String(street).trim());
							byte[] city = new byte[20];	
							position += data.read(city);
							textCity.setText(new String(city).trim());
							byte[] state = new byte[2];	
							position += data.read(state);
							textstate.setText(new String(state).trim());
							byte[] zip = new byte[6];	
							position += data.read(zip);
							textzipcode.setText(new String(zip).trim());
							count++;
						}
						else
						{
							JOptionPane.showMessageDialog(null, "End of File...");
						}
					}
			catch (IOException ex) {}
				
			}
		});
		btnNext.setBounds(234, 224, 89, 23);
		frmAddressbook.getContentPane().add(btnNext);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Addressbook Previous = new Addressbook();
				File f1 = new File("Address.dat");
				try {
					RandomAccessFile data = new RandomAccessFile(f1, "rw");
					if (count > 1) 
							count--;
						else 
							count = 1;
						data.seek((count * 91) - 91);
						int position;
						byte[] name = new byte[32];	
						position = data.read(name);
						txtName.setText(new String(name).trim());
						byte[] street = new byte[32];	
						position += data.read(street);
						textStreet.setText(new String(street).trim());
						byte[] city = new byte[20];	
						position += data.read(city);
						textCity.setText(new String(city).trim());
						byte[] state = new byte[2];	
						position += data.read(state);
						textstate.setText(new String(state).trim());
						byte[] zip = new byte[6];	
						position += data.read(zip);
						textzipcode.setText(new String(zip).trim());
				}
				catch (IOException ex) {
				}
			}
		});
		btnPrevious.setBounds(333, 224, 89, 23);
		frmAddressbook.getContentPane().add(btnPrevious);
		
		JButton btnLast = new JButton("Last");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Addressbook last = new Addressbook();
				File fs = new File("Address.dat");
				try 
				{	RandomAccessFile data = new RandomAccessFile(fs, "rw");
					data.seek((data.length() - 98));
					String str = data.readLine();
					String[] list = str.split(",");
					txtName.setText(list[0].trim());
					textStreet.setText(list[1].trim());
					textCity.setText(list[2].trim());
					textstate.setText(list[3].trim());
					textzipcode.setText(list[4].trim());
					last.location = data.getFilePointer() - 98;
					data.close();
				} 
				catch (IOException ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		btnLast.setBounds(439, 224, 89, 23);
		frmAddressbook.getContentPane().add(btnLast);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pattern letterPattern = Pattern.compile("^([a-zA-Z]+\\s)*[a-zA-Z]+$");
				Pattern StreetPattern = Pattern.compile("^([a-zA-Z0-9]+\\s)*[a-zA-Z0-9]+$");
				Pattern CityPattern = Pattern.compile("^[a-zA-Z]+$");
				Pattern StatePattern = Pattern.compile("^[a-zA-Z]+$");
				Pattern ZipPattern = Pattern.compile("^([A-Za-z]\\d[A-Za-z][-]?\\d[A-Za-z]\\d)");
				
				if(txtName.getText().equals("") || textStreet.getText().equals("")
						|| textCity.getText().equals("") || textstate.getText().equals("")
						|| textzipcode.getText().equals("") || (!(letterPattern.matcher(txtName.getText()).matches()))
						||(!(StreetPattern.matcher(textStreet.getText()).matches()))
						||(!(CityPattern.matcher(textCity.getText()).matches()))
						||(!(StatePattern.matcher(textstate.getText()).matches()))
						||(!(ZipPattern.matcher(textzipcode.getText()).matches())))
						//||(zip.matches(regex)))
						//(name.matches(namePattern)) 
						//||  || (street.matches(regexstreet)) ||(city.matches(regexcity)) || (state.matches(regstate)) )
				{
					JOptionPane.showMessageDialog(null, "Please enter all Field with valid DATA Entry");
				}				
				
				else
				{
						Addressbook update = new Addressbook();
						File fs = new File("Address.dat");
						try 
						{
							RandomAccessFile data = new RandomAccessFile(fs, "rw");
							int length = (int) data.length() / 98;
							String[] s = new String[length];
							for (int i = 0; i < length; i++) 
							{
								s[i] = "";
							}
							for (int i = 0; i < length; i++) 
							{
								s[i] = data.readLine();
						
								String[] tmp7 = s[i].split(",");
								tmp7[0] = tmp7[0].trim();
								String tmp10 = txtName.getText();
								if (tmp7[0].equals(tmp10)) 
								{
									data.seek(98 * i);
									String tmp, tmp2, tmp3;

									tmp3 = txtName.getText();
									if (txtName.getText().length() > 32) 
									{
										tmp = tmp3.substring(0, 32);
									} 
									else 
									{
										tmp = tmp3;
										for (int j = tmp.length(); j < 32; j++) 
										{
										tmp = tmp + ' ';
										}
									}

									tmp2 = tmp + ',';
									data.writeBytes(tmp2);
									tmp3 = textStreet.getText();
									if (textStreet.getText().length() > 32) 
									{
										tmp = tmp3.substring(0, 32);
									}
									else 
									{
										tmp = tmp3;
										for (int j = tmp.length(); j < 32; j++) 
										{
											tmp = tmp + ' ';
										}
									}
									tmp2 = tmp + ',';
									data.writeBytes(tmp2);

									tmp3 = textCity.getText();
									if (textCity.getText().length() > 20) 
									{
										tmp = tmp3.substring(0, 20);
									}
									else 
									{
										tmp = tmp3;
										for (int j = tmp.length(); j < 20; j++) 
										{
											tmp = tmp + ' ';
										}
									}
									tmp2 = tmp + ',';
									data.writeBytes(tmp2);

									tmp3 = textstate.getText();
									if (textstate.getText().length() > 2) 
									{
										tmp = tmp3.substring(0, 2);
									} 
									else 
									{
										tmp = tmp3;
										for (int j = tmp.length(); j < 2; j++) 
										{
											tmp = tmp + ' ';
										}
									}
									tmp2 = tmp + ',';
									data.writeBytes(tmp2);

									tmp3 = textzipcode.getText();
									if (textzipcode.getText().length() > 7)
									{
										tmp = tmp3.substring(0, 7);
									} 
									else 
									{
										tmp = tmp3;
										for (int j = tmp.length(); j < 7; j++) 
										{
											tmp = tmp + ' ';
										}
									}
									tmp2 = tmp + '\n';
									data.writeBytes(tmp2);

									update.location = data.getFilePointer() - 96;
									break;
								}

							}
							data.close();
					} 
					catch (IOException ex){
						ex.printStackTrace();
					}
						JOptionPane.showMessageDialog(null, "Record added succesfully");
				}
			}
		});
		btnUpdate.setBounds(539, 224, 89, 23);
		frmAddressbook.getContentPane().add(btnUpdate);
		
		JLabel lblerror = new JLabel("*Enter Only Character");
		lblerror.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblerror.setForeground(new Color(255, 0, 0));
		lblerror.setBounds(431, 23, 268, 23);
		frmAddressbook.getContentPane().add(lblerror);
		
		JButton btnclear = new JButton("Clear");
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						
				txtName.setText("");
				txtName.setEditable(true);
				textStreet.setText("");
				textCity.setText("");
				textstate.setText("");
				textzipcode.setText("");
				
			}
		});
		btnclear.setBounds(34, 270, 89, 23);
		frmAddressbook.getContentPane().add(btnclear);
		
		JLabel lblshowerror = new JLabel("*Enter Only Valid Code(ex. M2J 1K2)");
		lblshowerror.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblshowerror.setForeground(Color.RED);
		lblshowerror.setBounds(507, 168, 215, 17);
		frmAddressbook.getContentPane().add(lblshowerror);
		
		JLabel lblvalidcity = new JLabel("*Enter Only Character");
		lblvalidcity.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblvalidcity.setForeground(new Color(255, 0, 0));
		lblvalidcity.setBounds(90, 171, 158, 14);
		frmAddressbook.getContentPane().add(lblvalidcity);
		
		JLabel lblvalidstate = new JLabel("*Enter only Character");
		lblvalidstate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblvalidstate.setForeground(Color.RED);
		lblvalidstate.setBounds(323, 171, 158, 14);
		frmAddressbook.getContentPane().add(lblvalidstate);
		
		JLabel lblstreeterror = new JLabel("*Enter Only Number or Character");
		lblstreeterror.setForeground(Color.RED);
		lblstreeterror.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblstreeterror.setBounds(435, 73, 242, 14);
		frmAddressbook.getContentPane().add(lblstreeterror);
	}
	
	
}
