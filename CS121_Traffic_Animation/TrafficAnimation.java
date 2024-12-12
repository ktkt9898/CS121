import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import java.awt.Font;

/**
 * CS 121 Project 0: Traffic Animation
 *
 * Animates a moving train/locomotive from left to right. Also includes background scenery of a moving
 * tumbleweed, a cactus, a desert rock, and a bandit all which scale according to screen size.
 *
 * @author BSU CS 121 Instructors
 * @author kyletruschel
 */
@SuppressWarnings("serial")
public class TrafficAnimation extends JPanel
{
	// This is where you declare constants and variables that need to keep their
	// values between calls	to paintComponent(). Any other variables should be
	// declared locally, in the method where they are used.

	/**
	 * A constant to regulate the frequency of Timer events.
	 * Note: 100ms is 10 frames per second - you should not need
	 * a faster refresh rate than this
	 */
	private final int DELAY = 100; //milliseconds

	/**
	 * The anchor coordinate for drawing / animating. All of your vehicle's
	 * coordinates should be relative to this offset value.
	 */

	private int xOffset = 0;
	private int xOffsetTumbleWeed = getWidth();

	/**
	 * The number of pixels added to xOffset each time paintComponent() is called.
	 */
	private int stepSize = 10;
	private int stepSizeTumbleWeed = -25;

	private final Color BACKGROUND_COLOR = Color.black;

	/* This method draws on the panel's Graphics context.
	 * This is where the majority of your work will be.
	 *
	 * (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g)
	{
		// Get the current width and height of the window.
		int width = getWidth(); // panel width
		int height = getHeight(); // panel height

		// Fill the graphics page with the background color.
		g.setColor(BACKGROUND_COLOR);
		g.fillRect(0, 0, width, height);

		// Calculate the new xOffset position of the moving object.
		xOffset  = (xOffset + stepSize) % width;
		xOffsetTumbleWeed = (xOffsetTumbleWeed > 0) ? (xOffsetTumbleWeed + stepSizeTumbleWeed) : width;
 
		// This draws a green square. Replace it with your own object.
		// int squareW = height/5;
		// int squareH = squareW; 
		// int squareX = xOffset;
		// int squareY = height/2 - squareW/2;

		// g.setColor(Color.green);
		// g.fillRect(squareX, squareY, squareW, squareH);

		// TODO: Use width, height, and xOffset to draw your scalable objects
		// at their new positions on the screen

		// Colors
		// @keyterm color
		Color colorBlueSky = new Color(135, 206, 235);
		Color colorDesert = new Color(237, 201, 175);
		Color colorRailRoad = new Color(192, 192, 192);
		Color colorBrownSteel = new Color(74, 49, 24);
		Color colorGlass = new Color(168, 204, 215);
		Color colorDarkRed = new Color (139, 0, 0);
		Color colorWheels = new Color(21, 22, 27);
		Color colorSun = new Color(253, 184, 19);
		Color colorSkinTone = new Color(255, 219, 172);
		Color colorBlackBody = new Color(0, 0, 0);

		// Background

		// Draw Top Desert Background
		int topDesertHX = 0;
		int topDesertHY = 0; 
		int topDesertW = width;
		int topDesertH = (int)(height / 2.1);
		g.setColor(colorDesert);
		// @keyterm fillRect method 1
		g.fillRect(topDesertHX, topDesertHY, topDesertW, topDesertH);

		// Draw Sky Background
		int topSkyHX = 0;
		int topSkyHY = 0;
		int topSkyW = width;
		int topSkyH = (int)(height / 4);
		g.setColor(colorBlueSky);
		g.fillRect(topSkyHX, topSkyHY, topSkyW, topSkyH);

		// Draw Top Rail Road
		int upperRailRoadX = 0;
		int upperRailRoadY = (int)(height * 0.67);	
		int upperRailRoadW = width;
		int upperRailRoadH = (int)(height / 100);	
		g.setColor(colorRailRoad);
		g.fillRect(upperRailRoadX, upperRailRoadY, upperRailRoadW, upperRailRoadH);

		// Draw Bottom Rail Road		
		int bottomRailRoadX = 0;
		int bottomRailRoadY = (int)(height * 0.55);	
		int bottomRailRoadW = width;
		int bottomRailRoadH = (int)(height / 100);	
		g.setColor(colorRailRoad);
		g.fillRect(bottomRailRoadX, bottomRailRoadY, bottomRailRoadW, bottomRailRoadH);

		// Draw Bottom Desert Background
		int bottomDesertHX = 0;
		int bottomDesertHY = (int)(height * 0.75); 
		int bottomDesertW = width;
		int bottomDesertH = (int)(height / 4);
		g.setColor(colorDesert);
		g.fillRect(bottomDesertHX, bottomDesertHY, bottomDesertW, bottomDesertH);

		// Background Scenery

		// Cacti
		int unitCactusX = (int)(width / 4);
		int unitCactusY = (int)(height / 4);
		ImageIcon iconCactusOne = new ImageIcon("../images/cactusOne.png");
		// @keyterm drawImage() method 2
		g.drawImage(iconCactusOne.getImage(), unitCactusX, unitCactusY / 4, unitCactusY, unitCactusY, null);

		// Sun
		int sunX = (int)(width / 600);
		int sunY = (int)(width/  400);
		int unitSun = (int)(height * 0.1);
		g.setColor(colorSun);
		// @keyterm fillOval() method 3
		g.fillOval(sunX, sunY, unitSun, unitSun);

		// Bandit/Traffic Observer
		// @keyterm avatar observer

		// Base Draw Bandit Dimensions
		int unitBandit = (int)(height * 0.2);
		
		// Draw Bandit Head
		int banditHeadX = (int)(width / 2);
		int banditHeadY = (int)(height / 4.5);
		int banditHeadW = (int)(unitBandit * 0.5);
		int banditHeadH = (int)(unitBandit * 0.5);
		g.setColor(colorSkinTone);
		g.fillOval(banditHeadX, banditHeadY, banditHeadW, banditHeadH);

		// Draw Bandit Right Eye
		int banditRightEyeX = (int)(banditHeadX + unitBandit / 3.2);
		int banditRightEyeY = (int)(banditHeadY * 1.15);
		int banditRightEyeW = (int)(banditHeadW / 5);
		int banditRightEyeH = (int)(banditHeadH / 5);
		g.setColor(colorDarkRed);
		g.fillOval(banditRightEyeX, banditRightEyeY, banditRightEyeW, banditRightEyeH);

		// Draw Bandit Left Eye
		int banditLeftEyeX = (int)(banditHeadX + unitBandit / 10);
		int banditLeftEyeY = (int)(banditHeadY * 1.15);
		int banditLeftEyeW = (int)(banditHeadW / 5);
		int banditLeftEyeH = (int)(banditHeadH / 5);
		g.setColor(colorDarkRed);
		g.fillOval(banditLeftEyeX, banditLeftEyeY, banditLeftEyeW, banditLeftEyeH);

		// Draw Bandit Bandana
		int [] XPoints = {(int)(banditHeadX + banditHeadW * 0.01), (int)(banditHeadX + banditHeadW / 2), (int)(banditHeadX + banditHeadW * 1.01)};
		int [] YPoints = {(int)(banditHeadY + banditHeadH / 1.45), (int)(banditHeadY + banditHeadH * 1.3), (int)(banditHeadY + banditHeadH / 1.45)};
		int nPoints = 3;
		g.setColor(colorDarkRed);
		// @keyterm fillPolygon() method 4
		g.fillPolygon(XPoints, YPoints, nPoints);
		
		// Draw Cowboy Hat
		int banditHatX = (int)(banditHeadX - unitBandit / 10);
		int banditHatY = (int)(banditHeadY / 1.5);
		int banditHatW = (int)(banditHeadW * 1.5);
		int banditHatH = (int)(banditHeadH * 1.5);
		ImageIcon iconCowboyHat = new ImageIcon("../images/cowboyhat.png");
		g.drawImage(iconCowboyHat.getImage(), banditHatX, banditHatY, banditHatW, banditHatH, null);

		// Draw Bandit Body
		int banditBodyX = (int)(banditHeadX + unitBandit / 4);
		int banditBodyY = (int)(banditHeadY * 1.57);
		int banditBodyW = (int)(banditHeadW * 0);
		int banditBodyH = (int)(banditHeadH / 1.1);
		g.setColor(colorBlackBody);
		// @keyterm drawRect() method 5
		g.drawRect(banditBodyX, banditBodyY, banditBodyW, banditBodyH);

		// Draw Bandit Right Arm
		int banditRightArmX = (int)(banditHeadX + unitBandit * 0.0001);
		int banditRightArmY = (int)(banditHeadY * 1.6);
		int banditRightArmW = (int)(banditHeadW * 1);
		int banditRightArmH = (int)(banditHeadH / 1.1);
		g.setColor(colorBlackBody);
		// @keyterm drawArc() method 6
		g.drawArc(banditRightArmX, banditRightArmY, banditRightArmW, banditRightArmH, 0, 90);

		// Draw Bandit Left Arm
		int banditLeftArmX = (int)(banditHeadX + unitBandit * 0.0001);
		int banditLeftArmY = (int)(banditHeadY * 1.6);
		int banditLeftArmW = (int)(banditHeadW * 1);
		int banditLeftArmH = (int)(banditHeadH / 1.1);
		g.setColor(colorBlackBody);
		g.drawArc(banditLeftArmX, banditLeftArmY, banditLeftArmW, banditLeftArmH, 90, 90);

		// Draw Bandit Right Leg
		int banditRightLegX = (int)(banditHeadX + unitBandit * 0.0001);
		int banditRightLegY = (int)(banditHeadY * 1.97);
		int banditRightLegW = (int)(banditHeadW * 1);
		int banditRightLegH = (int)(banditHeadH / 1.1);
		g.setColor(colorBlackBody);
		g.drawArc(banditRightLegX, banditRightLegY, banditRightLegW, banditRightLegH, 0, 90);

		// Draw Bandit Left Leg
		int banditLeftLegX = (int)(banditHeadX + unitBandit * 0.0001);
		int banditLeftLegY = (int)(banditHeadY * 1.97);
		int banditLeftLegW = (int)(banditHeadW * 1);
		int banditLeftLegH = (int)(banditHeadH / 1.1);
		g.setColor(colorBlackBody);
		g.drawArc(banditLeftLegX, banditLeftLegY, banditLeftLegW, banditLeftLegH, 90, 90);

		// Scenery cont.

		// Tumbleweed	
		int unitTumbleWeed = (int)(height * 0.2);
		int unitTumbleWeedY = (int)(height / 3 - unitTumbleWeed * 0.5);
		int tumbleWeedX = (int)(xOffsetTumbleWeed);
		ImageIcon iconTumbleWeed = new ImageIcon("../images/tumbleweed.png");
		g.drawImage(iconTumbleWeed.getImage(), tumbleWeedX, unitTumbleWeedY, unitTumbleWeed, unitTumbleWeed, null);

		// Vehicle/Train

		// Base Train Dimensions
		// This makes the base train unit 1/4 of the height of the screen
		int unitTrain = (int)(height * 0.25);

		// This centers the train height in the center and the unitTrain ensures the body scales
		int unitTrainY = (int)(height * 0.5 - unitTrain * 0.5);

		// This moves the train engine from left to right
		int trainEngineX = (int)((xOffset) + (unitTrain * 0.2));

		// Train Body Dimensions
		int trainBodyY = unitTrainY;
		int trainBodyW = (int)(unitTrain * 2.75);
		int trainBodyH = unitTrain;

		// Draw Train Engine
		g.setColor(colorBrownSteel);
		g.fillRect(trainEngineX, trainBodyY, trainBodyW, trainBodyH);

		// Draw Front Train
		int [] trainFrontXPoints = {(int)(trainEngineX + trainBodyW), (int)(trainEngineX + trainBodyW * 1.15), (int)(trainEngineX + trainBodyW)};
		int [] trainFrontYPoints = {(int)(trainBodyY + trainBodyH / 2), (int)(trainBodyY + trainBodyH), (int)(trainBodyY + trainBodyH)};
		int trainFrontPoints = 3;
		g.setColor(colorBrownSteel);
		g.fillPolygon(trainFrontXPoints, trainFrontYPoints, trainFrontPoints);

		// Draw Train Smoke Stack
		int trainSmokeStackX = (int)((xOffset) + (unitTrain * 2));
		int trainSmokeStackY = (int)(unitTrainY / 1.5);
		int trainSmokeStackW = (int)(unitTrain * 0.5);
		g.setColor(colorBrownSteel);
		g.fillRect(trainSmokeStackX, trainSmokeStackY, trainSmokeStackW, unitTrain);

		// Draw Train Smoke Stack Border
		int trainSmokeStackBorderX = (int)((xOffset) + (unitTrain * 1.93));
		int trainSmokeStackBorderW = (int)(trainSmokeStackW * 1.3);
		int trainSmokeStackBorderH = (int)(unitTrain * 0.25);
		g.setColor(colorBrownSteel);
		g.fillRect(trainSmokeStackBorderX, trainSmokeStackY, trainSmokeStackBorderW, trainSmokeStackBorderH);

		// Draw Train Cabin
		int trainCabinY = (int)(unitTrainY / 1.8);
		int trainCabinW = (int)(unitTrain * 1.25);
		g.setColor(colorBrownSteel);
		g.fillRect(trainEngineX, trainCabinY, trainCabinW, unitTrain);

		// Draw Train Cabin Border
		int trainCabinBorderX = (int)((xOffset) + (unitTrain * 0.1));
		int trainCabinTopW = (int)(trainCabinW * 1.15);
		int trainCabinTopH = (int)(unitTrain * 0.25);
		g.setColor(colorBrownSteel);
		g.fillRect(trainCabinBorderX, trainCabinY, trainCabinTopW, trainCabinTopH);

		// Draw Train Cabin Window
		int trainCabinWindowX = (int)((xOffset) + (unitTrain * 0.35));
		int trainCabinWindowY = (int)(unitTrainY / 1.35);
		int trainCabinWindowW = (int)(unitTrain * 0.95);
		int trainCabinWindowH = (int)(unitTrain * 0.5);
		g.setColor(colorGlass);
		g.fillRect(trainCabinWindowX, trainCabinWindowY, trainCabinWindowW, trainCabinWindowH);		

		// Draw Train Front Light
		int trainFrontLightX = (int)((xOffset) + (unitTrain * 2.85));
		int trainFrontLightY = (int)(unitTrainY * 1.05);
		int trainFrontLightW = (int)(unitTrain * 0.25);
		int trainFrontLightH = (int)(unitTrain * 0.5);
		g.setColor(colorBrownSteel);
		g.fillOval(trainFrontLightX, trainFrontLightY, trainFrontLightW, trainFrontLightH);	

		// Train Wheels Dimensions
		int trainWheelY = (int)(unitTrainY * 1.5);
		int trainWheelW = (int)(unitTrain * 0.5);
		int trainWheelH = (int)(unitTrain * 0.5);

		// Draw Left Wheel Border
		int trainLeftWheelBorderX = (int)((xOffset) + (unitTrain * 0.4));
		int trainLeftWheelBorderY = (int)(trainWheelY / 1.0999);
		int trainLeftWheelBorderW = (int)(unitTrain * 0.7);
		int trainLeftWheelBorderH = (int)(unitTrain * 0.7);
		g.setColor(colorWheels);
		g.fillOval(trainLeftWheelBorderX, trainLeftWheelBorderY, trainLeftWheelBorderW, trainLeftWheelBorderH);

		// Draw Left Wheel
		int trainLeftWheelX = (int)((xOffset) + (unitTrain * 0.466));
		int trainLeftWheelY = (int)(unitTrainY * 1.4);
		int trainLeftWheelW = (int)(trainWheelW / 0.85);
		int trainLeftWheelH = (int)(trainWheelH / 0.85);
		g.setColor(colorDarkRed);
		g.fillOval(trainLeftWheelX, trainLeftWheelY, trainLeftWheelW, trainLeftWheelH);	

		// Draw Middle Wheel Border
		int trainMiddleWheelBorderX = (int)((xOffset) + (unitTrain * 1.5));
		g.setColor(colorWheels);
		g.fillOval(trainMiddleWheelBorderX, trainWheelY, trainWheelW, trainWheelH);

		// Draw Middle Wheel
		int trainMiddleWheelX = (int)((xOffset) + (unitTrain * 1.555));
		int trainMiddleWheelY = (int)(unitTrainY * 1.5355);
		int trainMiddleWheelW = (int)(trainWheelW / 1.25);
		int trainMiddleWheelH = (int)(trainWheelH / 1.25);
		g.setColor(colorDarkRed);
		g.fillOval(trainMiddleWheelX, trainMiddleWheelY, trainMiddleWheelW, trainMiddleWheelH);		

		// Draw Right Wheel Border
		int trainRightWheelBorderX = (int)((xOffset) + (unitTrain * 2.3));
		g.setColor(colorWheels);
		g.fillOval(trainRightWheelBorderX, trainWheelY, trainWheelW, trainWheelH);

		// Draw Right Wheel
		int trainRightWheelX = (int)((xOffset) + (unitTrain * 2.355));
		int trainRightWheelY = (int)(unitTrainY * 1.5355);
		int trainRightWheelW = (int)(trainWheelW / 1.25);
		int trainRightWheelH = (int)(trainWheelH / 1.25);
		g.setColor(colorDarkRed);
		g.fillOval(trainRightWheelX, trainRightWheelY, trainRightWheelW, trainRightWheelH);	

		// Draw front scenery

		// Base Rock Dimensions
		int unitRockX = (int)(width / 2);
		int unitRockY = (int)(height / 0.5);

		// Desert Rock One
		int rockOneX = (int)(unitRockX * 1);
		int rockOneY = (int)(unitRockY * 0.25);
		int rockOneW = (int)(unitRockY * 0.25);
		int rockOneH = (int)(unitRockY * 0.25);
		ImageIcon iconDesertRock = new ImageIcon("../images/desertRock.png");
		g.drawImage(iconDesertRock.getImage(), rockOneX, rockOneY, rockOneW, rockOneH, null);

		// Draw Text
		// @keyterm text
		Font textFont = new Font("Serif", Font.BOLD, 30);
		g.setFont(textFont);
		g.setColor(colorDarkRed);

		g.drawString("Choo Choo!", (int)(width/2.1), (int)(height/10));

		// Put your code above this line. This makes the drawing smoother.
		Toolkit.getDefaultToolkit().sync();
	}


	//==============================================================
	// You don't need to modify anything beyond this point.
	//==============================================================


	/**
	 * Starting point for this program. Your code will not go in the
	 * main method for this program. It will go in the paintComponent
	 * method above.
	 *
	 * DO NOT MODIFY this method!
	 *
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		// DO NOT MODIFY THIS CODE.
		JFrame frame = new JFrame ("Traffic Animation");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new TrafficAnimation());
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Constructor for the display panel initializes necessary variables.
	 * Only called once, when the program first begins. This method also
	 * sets up a Timer that will call paint() with frequency specified by
	 * the DELAY constant.
	 */
	public TrafficAnimation()
	{
		// Do not initialize larger than 800x600. I won't be able to
		// grade your project if you do.
		int initWidth = 600;
		int initHeight = 400;
		setPreferredSize(new Dimension(initWidth, initHeight));
		this.setDoubleBuffered(true);

		//Start the animation - DO NOT REMOVE
		startAnimation();
	}

	/**
	 * Create an animation thread that runs periodically.
	 * DO NOT MODIFY this method!
	 */
	private void startAnimation()
	{
		ActionListener timerListener = new TimerListener();
		Timer timer = new Timer(DELAY, timerListener);
		timer.start();
	}

	/**
	 * Repaints the graphics panel every time the timer fires.
	 * DO NOT MODIFY this class!
	 */
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}
}