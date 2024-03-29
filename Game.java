 //This was made using a tutorial on YouTube linked here: https://www.youtube.com/watch?v=G5yr4sekAI0. Credit goes to RyiSnow on YouTube.

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;


public class Game {
	JFrame f;
	Container con;
	JPanel startPanel, startButton, message, choiceButton;
	JLabel startLabel;
	Font title = new Font("Tempus Sans ITC", Font.PLAIN, 60);
	Font normalFont = new Font("Tempus Sans ITC", Font.PLAIN, 15);
	JButton start, choice1, choice2, choiceCancel, choiceTitle;
	JTextArea messageText;
	TitleScreenClicks tsClick = new TitleScreenClicks();
	ChoiceHandler cHandler = new ChoiceHandler();
	cancelClick cancelling = new cancelClick();
	returnTitle rTitle = new returnTitle();
	private String position;
	
	public Game() {
		
		//macOS exception handler to fix background color of button
		try {
		    UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
		 } catch (Exception e) {
		            e.printStackTrace();
		 }
		
		f = new JFrame();
		f.setBounds(100, 100, 800, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setBackground(Color.black);
		con = f.getContentPane();
		
		startPanel = new JPanel();
		startPanel.setBackground(Color.black);
		
		startLabel = new JLabel("CURIOUS SAMURAI");
		startLabel.setForeground(Color.white);
		startLabel.setFont(title);
		
		startButton = new JPanel();
		startButton.setBackground(Color.black);
		
		start = new JButton("START");
		start.setBackground(Color.black);
		start.setForeground(Color.white);
		start.setFont(normalFont);
		start.addActionListener(tsClick);
		start.setFocusPainted(false);
		
		Box horizontalBox = Box.createHorizontalBox();
		startPanel.add(horizontalBox);
		
		startPanel.add(startLabel);
		startButton.add(start);
		GroupLayout groupLayout = new GroupLayout(f.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(100)
					.addComponent(startPanel, GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
					.addGap(84))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(300)
					.addComponent(startButton, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
					.addGap(286))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(98)
					.addComponent(startPanel, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
					.addGap(222)
					.addComponent(startButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(127))
		);
		f.getContentPane().setLayout(groupLayout);
		f.setVisible(true);
	}
	
	public void GameScreen() {
		JPanel message = new JPanel();
		message.setBounds(150, 150, 600, 300);
		message.setBackground(Color.BLACK);
		con.add(message);
		startPanel.setVisible(false);
		startButton.setVisible(false);
		
		choiceButton = new JPanel();
		choiceButton.setBounds(150, 350, 100, 50);
		choiceButton.setBackground(Color.black);
		choiceButton.setForeground(Color.black);
		choiceButton.setLayout(new GridLayout(4, 1));
		con.add(choiceButton);
		
		GroupLayout groupLayout = new GroupLayout(f.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addComponent(message, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
					.addGap(50))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(160)
					.addComponent(choiceButton, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
					.addGap(170))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(120)
					.addComponent(message, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(choiceButton, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addGap(50))
		);
		
		choice1 = new JButton();
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.addActionListener(cHandler);
		choice1.setActionCommand("c1");
		choiceButton.add(choice1);
		
		choice2 = new JButton();
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.addActionListener(cHandler);
		choice2.setActionCommand("c2");
		choiceButton.add(choice2);
		
		choiceTitle = new JButton("Play Again");
		choiceTitle.setBackground(Color.black);
		choiceTitle.setForeground(Color.white);
		choiceTitle.setFont(normalFont);
		choiceTitle.addActionListener(rTitle);
		choiceTitle.setActionCommand("return");
		choiceButton.add(choiceTitle);
		
		choiceCancel = new JButton("CANCEL");
		choiceCancel.setBackground(Color.black);
		choiceCancel.setForeground(Color.white);
		choiceCancel.setFont(normalFont);
		choiceCancel.addActionListener(cancelling);
		choiceCancel.setActionCommand("cancel");
		choiceButton.add(choiceCancel);
		
		messageText = new JTextArea();
		messageText.setBounds(150, 150, 600, 300);
		messageText.setBackground(Color.black);
		messageText.setForeground(Color.white);
		messageText.setFont(normalFont);
		messageText.setWrapStyleWord(true);
		messageText.setLineWrap(true);
		message.add(messageText);
		
		f.getContentPane().setLayout(groupLayout);
		f.setVisible(true);
				
		start();

	}
	
	public void start() {
		position = "start";
		
		messageText.setText("You wield the magical samurai sword that has been passed down in your family for generations," 
		+ " but you’re unsure how to use it as it is also a family tradition for the wielder to discover their limits themselves."
		+ " Unfortunately, you are also assigned personal bodyguard for the emperor of Japan before you are able to even discover"
		+ " the slightest magical ability of the sword (so far, it just looks like an old metal sword)."
		+ " Even worse, you hear rumours on the streets that there is an assassination plan schemed against the emperor. Unknowing who, what, where, when, and how,"
		+ " it is up to you to figure out who’s behind this and save the emperor’s life - after all, not being able to protect the emperor leads to your shameful seppuku." 
		+ " With your trusty (or rusty) magical samurai sword, you must dive undercover into the dark, underground society and"
		+ " use your wits to figure out who can be trusted - or is it that simple?");
		
		choice1.setText("Continue");
		choice2.setText("");
		choice2.setVisible(false);
		choiceTitle.setVisible(false);
	}
	
	public void streets() {
		position = "streets";
		messageText.setText("While on the street, you overhear plot of assassinating the emperor, try to find out information, thugs run away");
		
		choice2.setVisible(true);
		choice1.setText("Follow thug");
		choice2.setText("Go back to palace and alert emperor");
	}
	
	public void followThug() {
		position = "followThug";
		messageText.setText("You tail the guard using your super stealthy samurai skills to a compound with several lookouts posted at the entrance. What do you do?");
		
		choice1.setText("Storm the building with your unfledged sword");
		choice2.setText("Take a guard hostage and try to learn information");
	}
	
	public void alertEmperor() {
		position = "alertEmperor";
		messageText.setText("You reach the palace and open the great doors and look to the Emperor's throne. You find that the Emperor is missing.");
		
		choice1.setText("Organize a search party");
		choice2.setText("Look for him yourself");
	}
	
	public void searchParty() {
		position = "searchParty";
		messageText.setText("The search party, although organized, took lots of time to start; emperor’s head found decapitated on stick with thug organization over it, Japan falls into chaos, you commit seppuku.");
		
		choice1.setText("");
		choice2.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choiceTitle.setVisible(true);
	}
	
	public void lookYourself() {
		position = "lookYourself";
		messageText.setText("You decide to go to the Emperor's favourite relaxing spot - the palace's bonsai garden. Streaming water flows around and through the garden. The tree canopy allows beams of light to filter in. You see on the meticulously composed dirt several shifty footprints -- almost as if there was a struggle. \n"
				+ "\n"
				+ "You notice two sets of footprints leading somewhere.  ");
		
		choice1.setText("Go right");
		choice2.setText("Go left");
	}
	
	public void stormBuilding() {
		position = "stormBuilding";
		messageText.setText("You try all kinds of methods to activate your sword, but nothin's happening. You get discovered by a group of guards, what do you do?");
		
		choice1.setText("Run and hide");
		choice2.setText("Stay and fight them yourself");
	}
	
	public void guardHostage() {
		position = "guardHostage";
		messageText.setText("After you waterboard the guard and take him to the brink of death, the guard reveals to you that you will find something at the Emperor's garden");
		
		lookYourself();
	}
	
	public void right() {
		position = "right";
		messageText.setText("As you are walking through the forest, you fall into a pit trap disguised as leaves on the ground. The hole is a perfect cylinder and 12 feet deep. Days go by and no one comes by. You die of hunger.");
		
		choice1.setText("");
		choice2.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choiceTitle.setVisible(true);
	
	}
	
	public void left() {
		position = "left";
		messageText.setText("You find that the footprints lead to a building and specifically a door in the back of the building that is slightly ajar. You pry it open with your sword and find yourself in a hallway. You hear muffled yells coming from a room a couple feet away. Coming from the room across the hallway you hear sweet sounds - the voice of the Emperor commending you for your talents, the voice of your mother as she sang to you as a child.");
	
		choice1.setText("Open the door to the room with the screams");
		choice2.setText("Open the door to the sweet voices");
	
	}
	
	public void screams() {
		position = "screams";
		rightRoom();
	}
	
	public void sweetVoices() {
		position = "sweetVoices";
		messageText.setText("You are impaled with a sword from a samurai. You see a box that the sounds come out of.");
		
		choice1.setText("");
		choice2.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choiceTitle.setVisible(true);

	}
	
	public void runHide() {
		position = "runHide";
		messageText.setText("The emperor is found dead later on. You commit seppuku as a shame of not being able to protect the emperor.");
		
		choice1.setText("");
		choice2.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choiceTitle.setVisible(true);

	}
	
	public void stayFight() {
		position = "stayFight";
		messageText.setText("You valiantly fight off the guards, but end up very wounded. You stumble into one of the building's inner hallways and see two doors, one of which holds the emperor hostage.");
	
		choice1.setText("You choose the left room.");
		choice2.setText("You choose the right room.");
	}
	
	public void leftRoom() {
		position = "leftRoom";
		messageText.setText("You are ambushed by a group of guards. You keel over and die.");
		
		choice1.setText("");
		choice2.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choiceTitle.setVisible(true);

	}
	
	public void rightRoom() {
		position = "rightRoom";
		messageText.setText("You find the emperor tied up in the room.");
		
		choice1.setText("You lock yourself and the emperor in the room.");
		choice2.setText("You go straight to the emperor and untie him.");
	}
	
	public void lockRoom() {
		position = "lockRoom";
		messageText.setText("You force open the window, which has been glued and hammered shut, and send a firecracker into the sky. \n Dread pools in your stomach as you hear guards banging on the door. You feel weak, but it is your duty to protect the emperor nonetheless. You are on your own with nothing but your sword. You know that you are unable to fight them off with just your swordskills.");
		
		choice1.setText("You hesitate.");
		choice2.setText("You and the emperor escape through the window.");
	}
	
	public void untie() {
		position = "untie";
		messageText.setText("As you try to escape with the emperor, you get ambushed by guards. You were too weak to fight, and the emperor too unskilled. You both die and Japan falls into chaos.");
		
		choice1.setText("");
		choice2.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choiceTitle.setVisible(true);

	}
	
	public void hesistate() {
		position = "hesistate";
		messageText.setText("The guards break through the barricade. You are hit in the head and fall unconscious as the emperor tries his best to fend for himself.");
		
		choice1.setText("Continue");
		choice2.setText("");
		choice2.setVisible(false);	
		
	}
	
	public void continue1() {
		position = "continue1";
		messageText.setText("You remember what your father said to you when you were younger: \"space isn't just space - it also has a spirit. That spirit can't be felt by agitation or anger, but by true tranquility in one's mind. You reach out with your mind and grasp that power.");
	
		choice1.setText("Continue");
	}
	
	public void continue2() {
		position = "continue2";
		messageText.setText("You feel death approaching, but you still manage to reach for your sword. It feels warm to the touch, and you feel a slight hum under your skin the moment you felt its grip. You bring back what your father taught you years ago - the silent breathing, the expansion of the conscious and the unconscious. As you do this, you feel your sword's warmth seep into your body. You let the sword guide you. You stand up, feeling the aura around you change completely. The sword is strumming gold and white, with patterns glowing on the metal. The air around you changes strangely as you move forwards and counterattack the soldiers, taking down them all before collapsing on the ground as reinforcements arrive from the palace.");
	
		choice1.setText("Continue");
	}
	
	public void continue3() {
		position = "continue3";
		messageText.setText("You open your eyes and realize you're in the palace infirmary. You learn that you have saved the emperor and subsequently saved Japan from downfall. What's more, you learn the secrets of your sword and smile silently to the night as you think about the countless more battles and adventures you will have to endure with your sword as the emperor's personal bodyguard.");
	
		choice1.setText("");
		choice1.setVisible(false);
	}
	
	public void windowEscape() {
		position = "windowEscape";
		messageText.setText("You jump out of the building but you break your legs. Guards quickly surround you and you both die. Japan falls into chaos.");
		
		choice1.setText("");
		choice2.setText("");
		choice1.setVisible(false);
		choice2.setVisible(false);
		choiceTitle.setVisible(true);

	}
	
	public class TitleScreenClicks implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			GameScreen();
		}
	}
	
	public class cancelClick implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.exit(0);
		}
	}
	
	public class returnTitle implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			close();
			new Game();
		}
	}
	
	public void close() {
		f.dispose();
	}
	
	public class ChoiceHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String yourChoice = event.getActionCommand();
		
			switch(position) {
			case "start":
				switch(yourChoice) {
				case "c1": streets(); break;
				}
				break;
				
			case "streets":	
				switch(yourChoice) {
				case "c1": followThug(); break;
				case "c2": alertEmperor(); break;
				}
				break;
			
			case "followThug":
				switch(yourChoice) {
				case "c1": stormBuilding(); break;
				case "c2": guardHostage(); break;
				}
				break;
			
			case "alertEmperor":
				switch(yourChoice) {
				case "c1": searchParty(); break;
				case "c2": lookYourself(); break;
				}
				break;
				
			case "lookYourself":
				switch(yourChoice) {
				case "c1": right(); break;
				case "c2": left(); break;
				}
				break;
			
			case "left":
				switch(yourChoice) {
				case "c1": screams(); break;
				case "c2": sweetVoices(); break;
				}
				break;
				
			case "stormBuilding":
				switch(yourChoice) {
				case "c1": runHide(); break;
				case "c2": stayFight(); break;
				}
				break;
				
			case "stayFight":
				switch(yourChoice) {
				case "c1": leftRoom(); break;
				case "c2": rightRoom(); break;
				}
				break;
			
			case "rightRoom":
				switch(yourChoice) {
				case "c1": lockRoom(); break;
				case "c2": untie(); break;
				}
				break;
			
			case "lockRoom":
				switch(yourChoice) {
				case "c1": hesistate(); break;
				case "c2": windowEscape(); break;
				}
				break;
			
			case "hesistate":
				switch(yourChoice) {
				case "c1": continue1(); break;
				}
				break;
				
			case "continue1":
				switch(yourChoice) {
				case "c1": continue2(); break;
				}
				break;
			
			case "continue2":
				switch(yourChoice) {
				case "c1": continue3(); break;
				}
				break;		
			
			} 
		
	}
	
}

	public static void main (String[] args) {
		new MainGame();
		try {
			FileInputStream fis = new FileInputStream("BGM.mp3");
			Player player = new Player(fis);
			player.play();
			System.out.println("Song is playing!");
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(JavaLayerException e) {
			e.printStackTrace();
		}
	}
}
