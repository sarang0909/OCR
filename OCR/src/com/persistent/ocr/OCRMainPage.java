package com.persistent.ocr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

import com.persistent.ocr.Listeners.InputButtonListener;

public class OCRMainPage {

	private JFrame frame;
	JLabel l; 
	private static JTextField outputFileText;
	private static JTextField pythonFileText;
	private static JLabel processingTime;
	private static String primaryLanguage;
	private static String secondaryLanguage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 
	
		JFrame frame = new JFrame("OCR");
		frame.setSize(700, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		placeComponents(panel);
		
		processingTime = new JLabel("");
		processingTime.setBounds(216, 285, 185, 25);
		panel.add(processingTime);
		
		
		frame.setVisible(true);
		
		/*JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

		int returnValue = jfc.showOpenDialog(null);
        String inputFilePath = "";
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			System.out.println(selectedFile.getAbsolutePath());
			inputFilePath = selectedFile.getAbsolutePath();
		}
		
			
		Process p1;
		Process p2;
		try {
			p1 = Runtime.getRuntime().exec("python C:\\Users\\Vani\\Desktop\\Sample\\python_scripts\\ocr_input.py --image "+inputFilePath);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(p1.getInputStream()));
		String processedImagePath = in.readLine();
		System.out.println("processedImagePath is : "+processedImagePath);
		
		String outputTextFilePath = "";
		outputTextFilePath = processedImagePath.replace(".TIF", "");
		
		String[] command =
		    {
		        "cmd",
		    };
		    Process p = Runtime.getRuntime().exec(command);
		    new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
		    new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
		    PrintWriter stdin = new PrintWriter(p.getOutputStream());
		    stdin.println("tesseract "+processedImagePath+" "+outputTextFilePath+" -l eng+asm");
		    stdin.close();
		    int returnCode = p.waitFor();
		    System.out.println("Return code = " + returnCode);
		
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	/**
	 * Create the application.
	 */
	public OCRMainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private static void placeComponents(JPanel panel) {

		panel.setLayout(null);

		JTextField inputFileText = new JTextField(2000);
		inputFileText.setBounds(216, 11, 381, 25);
		panel.add(inputFileText);
		
		JButton inputButton = new JButton("Choose Input image");
		inputButton.setBounds(10, 11, 160, 25);
		panel.add(inputButton);
		
		pythonFileText = new JTextField(2000);
		pythonFileText.setBounds(216, 116, 381, 25);
		panel.add(pythonFileText);

		JButton pythonButton = new JButton("Choose Python Script");
		pythonButton.setBounds(10, 116, 160, 25);
		panel.add(pythonButton);
		
		
		JButton processButton = new JButton("Convert");
		processButton.setBounds(154, 165, 80, 25);
		panel.add(processButton);
		
		JLabel outputLabel = new JLabel("Output File Path:");
		outputLabel.setBounds(29, 238, 119, 25);
		panel.add(outputLabel);
		
		outputFileText = new JTextField(2000);
		outputFileText.setBounds(216, 238, 375, 25);
		panel.add(outputFileText);
		
		
		 JLabel primaryLabel = new JLabel("Select Primary Language:");
		 primaryLabel.setBounds(10, 56, 160, 17);
		 panel.add(primaryLabel);
		       
		      JComboBox comboBox = new JComboBox();
		      comboBox.addItem("Select");
		      comboBox.addItem("Assamese");
		      comboBox.addItem("Bengali");
		      comboBox.addItem("English");
		      comboBox.addItem("Hindi");
		      comboBox.addItem("Marathi");
		      
		      comboBox.setBounds(216, 54, 101, 20);
		      panel.add(comboBox);
		      comboBox.addActionListener(new ActionListener() {
		          public void actionPerformed(ActionEvent arg0) {
		        	  String s = (String) comboBox.getSelectedItem();
		        	  switch (s) {//check for a match
	                    case "Assamese":
	                    	primaryLanguage = "asm";
	                        break;
	                        
	                    case "Bengali":
	                    	primaryLanguage = "ben";
	                        break;
    
	                    case "English":
	                    	primaryLanguage = "eng";
	                        break;
	                    default:
	                    	primaryLanguage = "eng";
	                        break;

		          }
		        	  }
		      });
		      
		      JLabel secondaryLabel = new JLabel("Select Secondary Language:");
		      secondaryLabel.setBounds(10, 84, 170, 17);
				 panel.add(secondaryLabel);
				       
				      JComboBox comboBox2 = new JComboBox();
				      comboBox2.addItem("Select");
				      comboBox2.addItem("Assamese");
				      comboBox2.addItem("Bengali");
				      comboBox2.addItem("English");
				      comboBox2.addItem("Hindi");
				      comboBox2.addItem("Marathi");
				      
				      comboBox2.setBounds(216, 85, 101, 20);
				      panel.add(comboBox2);
				      comboBox2.addActionListener(new ActionListener() {
				          public void actionPerformed(ActionEvent arg0) {
				        	  String s = (String) comboBox2.getSelectedItem();
				        	  switch (s) {//check for a match
			                    case "Assamese":
			                    	secondaryLanguage = "asm";
			                        break;
			                        
			                    case "Bengali":
			                    	secondaryLanguage = "ben";
			                        break;
		    
			                    case "English":
			                    	secondaryLanguage = "eng";
			                        break;
			                    default:
			                    	secondaryLanguage = "eng";
			                        break;

				          }
				        	  }
				      });     
		     
		
		
		ActionListener inputButtonListener = new InputButtonListener();
		//inputButton.addActionListener(inputButtonListener);
		
		inputButton.addActionListener(new ActionListener() {
			
			            public void actionPerformed(ActionEvent arg0) {
			        		
			        		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

			        		int returnValue = jfc.showOpenDialog(null);
			                String inputFilePath = "";
			        		if (returnValue == JFileChooser.APPROVE_OPTION) {
			        			File selectedFile = jfc.getSelectedFile();
			        			System.out.println(selectedFile.getAbsolutePath());
			        			inputFilePath = selectedFile.getAbsolutePath();
			        			inputFileText.setText(inputFilePath);
			        		}
			        	}
			        });

		
		pythonButton.addActionListener(new ActionListener() {
			
            public void actionPerformed(ActionEvent arg0) {
        		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        		int returnValue = jfc.showOpenDialog(null);
                String pythonFilePath = "";
        		if (returnValue == JFileChooser.APPROVE_OPTION) {
        			File selectedFile = jfc.getSelectedFile();
        			System.out.println(selectedFile.getAbsolutePath());
        			pythonFilePath = selectedFile.getAbsolutePath();
        			pythonFileText.setText(pythonFilePath);
        		}
        	}
        });
		
		
		processButton.addActionListener(new ActionListener() {
			
            public void actionPerformed(ActionEvent arg0) {
            	Process p1;
        		try {
        			long startTime = System.currentTimeMillis();
        			
        			p1 = Runtime.getRuntime().exec("python "+pythonFileText.getText()+" --image "+inputFileText.getText());
        		
        		BufferedReader in = new BufferedReader(new InputStreamReader(p1.getInputStream()));
        		String processedImagePath = in.readLine();
        		System.out.println("processedImagePath is : "+processedImagePath);
        		
        		String outputTextFilePath = "";
        		outputTextFilePath = processedImagePath.replace("_processed.TIF", "");
        		
        		String[] command =
        		    {
        		        "cmd",
        		    };
        		    Process p = Runtime.getRuntime().exec(command);
        		    String configFilePath = pythonFileText.getText().replace(".py", ".txt");
        		    new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
        		    new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
        		    PrintWriter stdin = new PrintWriter(p.getOutputStream());
        		    stdin.println("tesseract "+processedImagePath+" "+outputTextFilePath+" -l "+primaryLanguage+"+"+secondaryLanguage
        		    		+" -configfile "+configFilePath);
        		    stdin.close();
        		    int returnCode = p.waitFor();
        		    System.out.println("Return code = " + returnCode);
        		    outputFileText.setText(outputTextFilePath+".txt");
        		            		    long endTime   = System.currentTimeMillis();
        			Long totalTime = (endTime - startTime)/1000;
        			String timeTaken = "Processing time: "+totalTime.toString()+"seconds";
        			processingTime.setText(timeTaken);

        			
        		} catch (Exception e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
        			
        	}
        });
		
	}
}
