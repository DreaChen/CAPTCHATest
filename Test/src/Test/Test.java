package Test;

import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.util.Random;

public class Test {
	static int rImage;
	static ImageIcon[] captchas;
	static String[] answers;
	static JLabel correct = new JLabel("Correct");
	static JLabel incorrect = new JLabel("Incorrect");
	
    public static void addComponentsToPane(Container pane) {
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Type in the next below and press enter. (Case Sensitive)", JLabel.CENTER);
        JLabel captcha = new JLabel(captchas[rImage]);
        JTextField answer = new JTextField();
        answer.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
            	if (answer.getText().equalsIgnoreCase(answers[rImage])) {
            		 JFrame frame = new JFrame();
            	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	     frame.add(correct);
            	     frame.pack();
            	     frame.setVisible(true);
            	}
            	else {
            		 JFrame frame = new JFrame();
            	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	     frame.add(incorrect);
            	     frame.pack();
            	     frame.setVisible(true);
            	}
            }
        });

        pane.add(label);
        pane.add(captcha);
        pane.add(answer);
    }
    

	private static void addAButton(String text, Container container) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }
 
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("CAPTCHA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponentsToPane(frame.getContentPane());
 
        frame.pack();
        frame.setVisible(true);
    }

 
    public static void main(String[] args) {
    	ImageIcon i1 = new ImageIcon("1.jpg");
        ImageIcon i2 = new ImageIcon("2.jpg");
        ImageIcon i3 = new ImageIcon("3.jpg");
        ImageIcon i4 = new ImageIcon("4.jpg");
        ImageIcon i5 = new ImageIcon("5.jpg");
        ImageIcon i6 = new ImageIcon("6.jpg");
        captchas = new ImageIcon[6];
        captchas[0] = i1;
        captchas[1] = i2;
        captchas[2] = i3;
        captchas[3] = i4;
        captchas[4] = i5;
        captchas[5] = i6;
        
        String answer1 = new String("W93BX");
    	String answer2 = new String("JA3V8");
    	String answer3 = new String("RBSKW");
    	String answer4 = new String("HJ9PV");
    	String answer5 = new String("TSMS9");
    	String answer6 = new String("459CT");
    	answers = new String[6];
        answers[0] = answer1;
        answers[1] = answer2;
        answers[2] = answer3;
        answers[3] = answer4;
        answers[4] = answer5;
        answers[5] = answer6;
        
        Random rand = new Random();
        rImage = rand.nextInt(6);
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}