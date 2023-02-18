//Authors:Haziq & Daniel
package view;
import model.Student;
import model.StudentVerification;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StudentScreenGUI extends JFrame
{
    JFrame mainFrame = new JFrame("Student Portal");
    StudentVerification studentVerification = new StudentVerification();

    BufferedImage img;
    Image dummyImage;
    ImageIcon logo;
    JLabel mainLogo;

    JLabel title;
    JLabel idLabel;
    JLabel passwordLabel;

    JTextField idField;
    JTextField passwordField;
    JButton loginButton;

    JButton goBack;

    JButton signUpButton;
    JButton signUpButton2;
    JLabel signUpTitleLabel;
    JLabel signUpLevelLabel;
    JLabel signUpNameLabel;
    JLabel signUpIdLabel;
    JLabel signUpPasswordLabel;
    JTextField signUpNameField;
    JTextField signUpLevelField;
    JTextField signUpIdField;
    JTextField signUpPasswordField;



    // Default constructor of studentScreenGUI
    public StudentScreenGUI()
    {
        mainFrame.setSize(1920, 1080);
        mainFrame.setBackground(Color.BLACK);
        try
        {
            img = ImageIO.read(new File("./data/studlogo.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        dummyImage = img.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        logo = new ImageIcon(dummyImage);

        initializeStudentScreen();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    // EFFECTS: initializes elements of StudentScreen.
    private void initializeStudentScreen()
    {
        JPanel studentScreen = new JPanel(new GridBagLayout());
        studentScreen.setBackground(SystemColor.WHITE);
        GridBagConstraints studentScreenConstraints = new GridBagConstraints();
        studentScreenConstraints.insets = new Insets(10, 10, 10, 10);

        title = new JLabel("Student Portal");
        idLabel = new JLabel("Enter Your Id : ");
        passwordLabel = new JLabel("Enter Password : ");
        idField = new JTextField(20);
        passwordField = new JTextField(20);

        loginButton = new JButton("Log In");
        signUpButton = new JButton("Sign Up");
        goBack = new JButton("Go back to Home Screen");
        mainLogo = new JLabel(logo);
        studentScreenElements(studentScreen, studentScreenConstraints);
        mainFrame.add(studentScreen);
    }


    //Extension to the method above and displays elements of StudentScreen
    private void studentScreenElements(JPanel studentScreen, GridBagConstraints studentScreenConstraints)
    {

        studentScreenConstraints.gridx = 0;
        studentScreenConstraints.gridy =0;
        studentScreen.add(mainLogo,studentScreenConstraints);
        studentScreenConstraints.anchor = GridBagConstraints.CENTER;
        studentScreenConstraints.fill = GridBagConstraints.HORIZONTAL;

        studentScreenConstraints.gridx = 0;
        studentScreenConstraints.gridy = 1;
        studentScreen.add(idLabel, studentScreenConstraints);
        studentScreenConstraints.gridx = 1;
        studentScreenConstraints.gridy = 1;
        studentScreen.add(idField, studentScreenConstraints);

        studentScreenConstraints.gridx = 0;
        studentScreenConstraints.gridy = 2;
        studentScreen.add(passwordLabel, studentScreenConstraints);
        studentScreenConstraints.gridx = 1;
        studentScreenConstraints.gridy = 2;
        studentScreen.add(passwordField, studentScreenConstraints);


        studentScreenElements2(studentScreen, studentScreenConstraints);

    }


    //Extension to the method above and displays elements of StudentScreen
    private void studentScreenElements2(JPanel studentScreen, GridBagConstraints studentScreenConstraints)
    {
        studentScreenConstraints.gridx = 0;
        studentScreenConstraints.gridy = 3;
        studentScreen.add(loginButton, studentScreenConstraints);
        ActionListener loginCall = loginButton(studentScreen);
        loginButton.addActionListener(loginCall);

        studentScreenConstraints.gridx = 0;
        studentScreenConstraints.gridy = 4;
        studentScreen.add(signUpButton, studentScreenConstraints);
        ActionListener signUpCall = signUpButton(studentScreen);
        signUpButton.addActionListener(signUpCall);

        studentScreenConstraints.gridx = 0;
        studentScreenConstraints.gridy = 5;
        studentScreen.add(goBack, studentScreenConstraints);
        ActionListener goBackCall = goBackButton(studentScreen);
        goBack.addActionListener(goBackCall);
    }



    //initializes the studentSignUpScreen elements
    private void studentSignUp()
    {
        JPanel studentSignUpScreen = new JPanel(new GridBagLayout());
        studentSignUpScreen.setBackground(Color.WHITE);
        GridBagConstraints studentSignUpConstraints = new GridBagConstraints();
        studentSignUpConstraints.insets = new Insets(10, 10, 10, 10);
        signUpTitleLabel = new JLabel("Sign Up");

        signUpLevelLabel = new JLabel("Your Level of Study : ");
        signUpNameLabel = new JLabel("Your Name : ");
        signUpIdLabel = new JLabel("Your ID Last 6 Digit : ");
        signUpPasswordLabel = new JLabel("Password : ");

        signUpLevelField = new JTextField(20);
        signUpNameField = new JTextField(20);
        signUpIdField = new JTextField(20);
        signUpPasswordField = new JTextField(20);

        signUpButton2 = new JButton("Sign Up");
        goBack = new JButton("Go Back to Student Screen");

        studentSignUpElements(studentSignUpScreen, studentSignUpConstraints);
        mainFrame.add(studentSignUpScreen);
    }


    //Extension to the method above. initializes the studentSignUpScreen elements.
    private void studentSignUpElements(JPanel studentSignUpScreen, GridBagConstraints studentSignUpConstraints)
    {

        studentSignUpConstraints.gridx = 0;
        studentSignUpConstraints.gridy = 0;
        studentSignUpScreen.add(signUpLevelLabel, studentSignUpConstraints);
        studentSignUpConstraints.gridx = 1;
        studentSignUpConstraints.gridy = 0;
        studentSignUpScreen.add(signUpLevelField, studentSignUpConstraints);

        studentSignUpConstraints.gridx = 0;
        studentSignUpConstraints.gridy = 2;
        studentSignUpScreen.add(signUpNameLabel, studentSignUpConstraints);
        studentSignUpConstraints.gridx = 1;
        studentSignUpConstraints.gridy = 2;
        studentSignUpScreen.add(signUpNameField, studentSignUpConstraints);

        studentSignUpConstraints.gridx = 0;
        studentSignUpConstraints.gridy = 3;
        studentSignUpScreen.add(signUpIdLabel, studentSignUpConstraints);
        studentSignUpConstraints.gridx = 1;
        studentSignUpConstraints.gridy = 3;
        studentSignUpScreen.add(signUpIdField, studentSignUpConstraints);

        studentSignUpConstraints.gridx = 0;
        studentSignUpConstraints.gridy = 4;
        studentSignUpScreen.add(signUpPasswordLabel, studentSignUpConstraints);
        studentSignUpConstraints.gridx = 1;
        studentSignUpConstraints.gridy = 4;
        studentSignUpScreen.add(signUpPasswordField, studentSignUpConstraints);

        studentSignUpElements2(studentSignUpScreen, studentSignUpConstraints);
    }

    //Extension to the method above. initializes the studentSignUpScreen elements.
    private void studentSignUpElements2(JPanel studentSignUpScreen, GridBagConstraints studentSignUpConstraints)
    {
        studentSignUpConstraints.gridx = 0;
        studentSignUpConstraints.gridy = 5;
        studentSignUpScreen.add(signUpButton2, studentSignUpConstraints);
        ActionListener signUpCall = signUpButton2();
        signUpButton2.addActionListener(signUpCall);

        studentSignUpConstraints.gridx = 0;
        studentSignUpConstraints.gridy = 6;
        studentSignUpScreen.add(goBack, studentSignUpConstraints);
        ActionListener goBackCall = backToStudentScreen(studentSignUpScreen);
        goBack.addActionListener(goBackCall);
    }

    //adds ActionListener for goBackButton
    private ActionListener goBackButton(JPanel panel)
    {
        return e -> {
            panel.setVisible(false);
            mainFrame.dispose();
            new FirstScreenGUI();
        };
    }

    //  adds ActionListener to backToStudentScreenButton
    private ActionListener backToStudentScreen(JPanel panel)
    {
        return e -> {
            panel.setVisible(false);
            mainFrame.dispose();
            new StudentScreenGUI();
        };
    }

    // adds ActionListener to loginButton
    private ActionListener loginButton(JPanel panel)
    {
        return e ->
        {
            String email = idField.getText();
            String password = passwordField.getText();
            Student student = studentVerification.verifyStudent(email, password);
            if (student != null) {
                JOptionPane.showMessageDialog(mainFrame, "Login Successful!");
                panel.setVisible(false);
                mainFrame.dispose();
                new CourseRegisterGUI(student);
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Wrong Id/Password. Please try again!");
            }
        };
    }


    //adds ActionListener to signUpButton
    private ActionListener signUpButton(JPanel panel)
    {
        return e ->
        {
            panel.setVisible(false);
            studentSignUp();
        };
    }

    //Extension to the method above.
    private ActionListener signUpButton2()
    {
        return e ->
        {
            String level = signUpLevelField.getText();
            String name = signUpNameField.getText();
            String id = signUpIdField.getText();
            String password = signUpPasswordField.getText();

            if (studentVerification.newStudent(new Student(level,name, id, password)))
            {
                JOptionPane.showMessageDialog(mainFrame, "Sign Up Successful!");
                mainFrame.dispose();
                new StudentScreenGUI();
            }
            else
            {
                JOptionPane.showMessageDialog(mainFrame, "This ID is already registered! Try again.");
            }
        };
    }

}
