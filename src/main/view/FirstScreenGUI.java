//Authors: Ayu & Naufal
package view;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


// FirstScreenGUI is the landing screen of the application which has different navigation options.
public class FirstScreenGUI extends JFrame
{
    JFrame mainFrame = new JFrame("Self-Financing Multi-Disciplinary University (SFMDU)");
    JButton studentPortal;
    JButton facultyPortal;
    JButton exit;
    JButton load;
    JButton save;

    FirstScreen firstScreen = new FirstScreen();
    BufferedImage img;
    Image dummyImage;
    ImageIcon logo;
    JLabel mainLogo;
    boolean check;

    /*The Singleton pattern: The WelcomeScreen class is implemented as a Singleton, as only
    one instance of it is created throughout the program's execution.*/
    //Default constructor for WelcomeScreenGUI class.
    public FirstScreenGUI()
    {
        mainFrame.setSize(1920, 1080);
        mainFrame.setBackground(Color.BLACK);

        try
        {
            img = ImageIO.read(new File("./data/logo.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        dummyImage = img.getScaledInstance(350, 205, Image.SCALE_SMOOTH);
        logo = new ImageIcon(dummyImage);
        initializeFirstScreen();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    /*The Factory Method pattern: The initializeWelcomeScreen() method creates the necessary objects and adds them to the GUI, while the welcomeScreenElements() and welcomeScreenElements2()
    methods handle the layout of the objects on the GUI.*/
    //initializes FirstScreen elements.
    public void initializeFirstScreen()
    {
        JPanel firstScreen = new JPanel(new GridBagLayout());
        firstScreen.setBackground(SystemColor.WHITE);
        GridBagConstraints firstScreenConstraints = new GridBagConstraints();
        firstScreenConstraints.insets = new Insets(10, 10, 10, 10);
        studentPortal = new JButton("Student Portal");
        facultyPortal = new JButton("Faculty Portal");
        save = new JButton("Save Records");
        load = new JButton("Load Records");
        exit = new JButton("Exit");
        mainLogo = new JLabel(logo);
        FirstScreenElements(firstScreen, firstScreenConstraints);
        mainFrame.add(firstScreen);
    }

    //Extension to the method above. Initializes FirstScreen elements.
    private void FirstScreenElements(JPanel firstScreen, GridBagConstraints firstScreenConstraints)
    {
        firstScreenConstraints.anchor = GridBagConstraints.CENTER;
        firstScreenConstraints.gridx = 0;
        firstScreenConstraints.gridy = 0;
        firstScreen.add(mainLogo, firstScreenConstraints);

        firstScreenConstraints.fill = GridBagConstraints.HORIZONTAL;
        firstScreenConstraints.gridx = 0;
        firstScreenConstraints.gridy = 1;
        firstScreen.add(studentPortal, firstScreenConstraints);
        ActionListener studentPortalButton = studentPortalButton();
        studentPortal.addActionListener(studentPortalButton);

        firstScreenConstraints.gridx = 0;
        firstScreenConstraints.gridy = 2;
        firstScreen.add(facultyPortal, firstScreenConstraints);
        ActionListener facultyPortalButton = facultyPortalButton();
        facultyPortal.addActionListener(facultyPortalButton);

        firstScreenConstraints.gridx = 0;
        firstScreenConstraints.gridy = 3;
        firstScreen.add(save, firstScreenConstraints);
        ActionListener saveCall = saveCall();
        save.addActionListener(saveCall);

        firstScreenElements2(firstScreen, firstScreenConstraints, exit, exitCall());
    }

    //Extension to the method above. Initializes FirstScreen elements.
    private void firstScreenElements2(JPanel firstScreen, GridBagConstraints firstScreenConstraints,
                                      JButton exit, ActionListener actionListener)
    {
        firstScreenConstraints.gridx = 0;
        firstScreenConstraints.gridy = 4;
        firstScreen.add(load, firstScreenConstraints);
        ActionListener loadCall = loadCall();
        load.addActionListener(loadCall);

        firstScreenConstraints.gridx = 0;
        firstScreenConstraints.gridy = 5;
        firstScreen.add(exit, firstScreenConstraints);
        exit.addActionListener(actionListener);
    }

    /*The Command pattern: The button objects (studentPortal, facultyPortal, save, load, exit, websiteButton)
    are used to trigger specific actions in the program (e.g. opening the student portal, saving records) when clicked.
    The corresponding methods for these actions (e.g. studentPortalButton(), saveCall())
    are implemented as ActionListeners and attached to the buttons.
 */

    //adds ActionListener to studentPortalButton
    private ActionListener studentPortalButton() {
        return e ->
        {
            mainFrame.dispose();
            new StudentScreenGUI();
        };
    }


    //adds ActionListener to facultyPortalButton
    private ActionListener facultyPortalButton() {
        return e -> {
            mainFrame.dispose();
            new FacultyScreenGUI();
        };
    }


    //adds ActionListener for exit button.
    private ActionListener exitCall()
    {
        return e -> System.exit(0);
    }

    //adds ActionListener for save button and saveData method is implemented.
    private ActionListener saveCall()
    {
        return e -> firstScreen.saveData();
    }

    //adds ActionListener for load button and loadData method is implemented.
    private ActionListener loadCall()
    {
        return e -> {
            if (firstScreen.loadData()) {
                JOptionPane.showMessageDialog(mainFrame, "Data Loaded Successfully!");
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Data Load Unsuccessful!");
            }
        };

    }


}
