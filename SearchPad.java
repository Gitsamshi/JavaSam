package frames;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SearchPad {
	JFrame frame = new JFrame("File Searcher");
	JPanel panel = new JPanel();
	
	JTextArea area = new JTextArea(15,15);
	JTextField field = new JTextField("Enter dir name",20);
	JButton button = new JButton("Search");
	
	ScrollPane bar = new ScrollPane(); 
	
	public static void main(String[] args) {
		new SearchPad().init();
	}
	
	public void init(){
		bar.add(area);
		panel.add(field);
		panel.add(button);
		
		field.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				String text = ((JTextField)(e.getSource())).getText();
				if(text.equals("Enter dir name")) {
					((JTextField)(e.getSource())).setText("");
				}
			}
			
		});
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("");
				String path = field.getText();
				File file = new File(path);
				File[] files = file.listFiles();
				if(files != null){
					for(File fl:files){
						area.setText(area.getText()+fl.getName()+"\r\n");
					}	
				}
				else {
					area.setText("Wrong name\r\n");
				}
				
			}
		});
		
		frame.add(panel,BorderLayout.NORTH);
		frame.add(bar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(200,300,400,400);
		frame.setVisible(true);
	}
}
