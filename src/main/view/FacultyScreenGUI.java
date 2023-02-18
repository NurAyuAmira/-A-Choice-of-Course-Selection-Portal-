//Authors: Daniel
package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


//FacultyScreenGUI is the landing screen for faculty user.
public class FacultyScreenGUI extends JFrame
{
    JFrame mainFrame = new JFrame("Faculty Portal");
    JLabel title;
    JLabel idLabel;
    JLabel passwordLabel;
    JTextField idField;
    JTextField passwordField;
    JButton loginButton;
    JButton goBack;
    BufferedImage img;
    Image dummyImage;
    ImageIcon logo;
    JLabel mainLogo;

    //default constructor of faculty screen
    public FacultyScreenGUI()
    {
        mainFrame.setSize(1920, 1080);
        mainFrame.setBackground(Color.BLACK);
        try
        {
            img = ImageIO.read(new File("./data/faclogo.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        dummyImage = img.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        logo = new ImageIcon(dummyImage);

        initializeFacultyScreen();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    //initializes faculty screen elements
    public void initializeFacultyScreen() {
        JPanel facultyScreen = new JPanel(new GridBagLayout());
        facultyScreen.setBackground(SystemColor.WHITE);
        GridBagConstraints facultyScreenConstraints = new GridBagConstraints();
        facultyScreenConstraints.insets = new Insets(10, 10, 10, 10);

        title = new JLabel("Faculty Portal");
        idLabel = new JLabel("Enter Faculty ID :");
        passwordLabel = new JLabel("Enter Password :");
        idField = new JTextField(20);
        passwordField = new JTextField(20);
        loginButton = new JButton("Log In");
        goBack = new JButton("Go Back to Home Screen");
        mainLogo = new JLabel(logo);
        facultyScreenElements(facultyScreen, facultyScreenConstraints);
        mainFrame.add(facultyScreen);
    }


    //extension to the method above. Displays faculty screen elements.
    private void facultyScreenElements(JPanel facultyScreen, GridBagConstraints facultyScreenConstraints)
    {

        facultyScreenConstraints.anchor = GridBagConstraints.CENTER;
        facultyScreenConstraints.fill = GridBagConstraints.HORIZONTAL;
        facultyScreenConstraints.gridx = 0;
        facultyScreenConstraints.gridy = 0;
        facultyScreen.add(mainLogo,facultyScreenConstraints);

        facultyScreenConstraints.gridx = 0;
        facultyScreenConstraints.gridy = 1;
        facultyScreen.add(idLabel, facultyScreenConstraints);

         facultyScreenConstraints.gridx = 1;
         facultyScreenConstraints.gridy = 1;
         facultyScreen.add(idField, facultyScreenConstraints);

         facultyScreenConstraints.gridx = 0;
         facultyScreenConstraints.gridy = 2;
         facultyScreen.add(passwordLabel, facultyScreenConstraints);

        facultyScreenConstraints.gridx = 1;
        facultyScreenConstraints.gridy = 2;
        facultyScreen.add(passwordField,facultyScreenConstraints);

        facultyScreenElements2(facultyScreen, facultyScreenConstraints);
    }

    // extension to the method above. Displays admin screen elements.
    private void facultyScreenElements2(JPanel facultyScreen, GridBagConstraints facultyScreenConstraints)
    {
        facultyScreenConstraints.gridx = 0;
        facultyScreenConstraints.gridy = 3;
        facultyScreen.add(loginButton, facultyScreenConstraints);

        ActionListener loginCall = loginButton(facultyScreen);
        loginButton.addActionListener(loginCall);

        facultyScreenConstraints.gridx = 0;
        facultyScreenConstraints.gridy = 4;
        facultyScreen.add(goBack, facultyScreenConstraints);

        ActionListener goBackCall = goBackButton(facultyScreen);
        goBack.addActionListener(goBackCall);
    }


    // EFFECTS: ActionListener for goBackButton
    private ActionListener goBackButton(JPanel panel)
    {
        return e ->
        {
            panel.setVisible(false);
            mainFrame.dispose();
            new FirstScreenGUI();
        };
    }

    // EFFECTS: ActionListener for login button
    private ActionListener loginButton(JPanel panel)
    {
        return e ->
        {
            String id = idField.getText();
            String password = passwordField.getText();
            if (id.equals("Faculty") && password.equals("fc"))
            {
                JOptionPane.showMessageDialog(mainFrame, "Login Successful!");
                panel.setVisible(false);
                mainFrame.dispose();
                new CourseGenerateGUI();
            }
            else
            {
                JOptionPane.showMessageDialog(mainFrame, "Wrong Id/Password. Please try again!");
            }
        };
    }

}
