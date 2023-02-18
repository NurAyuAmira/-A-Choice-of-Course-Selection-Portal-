//Authors: Daniel, Haziq & Naufal
package view;
import model.Course;


import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CourseGenerateGUI extends JFrame
{
    CourseGenerate courseGenerate = new CourseGenerate();
    JFrame mainFrame = new JFrame("Course Generator");
    JLabel title;
    BufferedImage img;
    Image dummyImage;
    ImageIcon logo;
    JLabel mainLogo;
    JLabel courseNameLabel;
    JLabel courseFacultyLabel;
    JLabel courseLevelStudyLabel;
    JLabel courseSubjectLabel;
    JLabel courseDurationLabel;
    JLabel courseEmployeeLabel;
    JLabel courseScopeLabel;
    JLabel courseScholarLabel;
    JLabel courseFeeLabel;

    JLabel courseSeatsLabel;

    JLabel courseRequirementsLabel;

    JTextField courseRequirementsField;
    JTextField courseNameField;

    JTextField courseFacultyField;
    JTextField courseLevelStudyField;
    JTextField courseSubjectField;
    JTextField courseDurationField;
    JTextField courseEmployeeField;
    JTextField courseScopeField;
    JTextField courseScholarField;
    JTextField  courseFeeField;

    JTextField courseSeatsField;

    List<String> courseList;
    JList<String> courseJList;
    DefaultListModel<String> courseListModel;

    JButton createCourse;
    JButton create;
    JButton removeCourse;
    JButton viewCourses;
    JButton delCourse;
    JButton signOut;
    JButton goBack;
    int index;


    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    //Default constructor for CourseGeneratorGUI class
    public CourseGenerateGUI()
    {
        this.setSize(screen.width,screen.height);
        mainFrame.setSize(1920, 1080);
        mainFrame.setBackground(Color.BLACK);
        try
        {
            img = ImageIO.read(new File("./data/courselogo.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        dummyImage = img.getScaledInstance(300, 205, Image.SCALE_SMOOTH);
        logo = new ImageIcon(dummyImage);

        initializeCourseGenerate();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

    }

    //initializes CourseGenerator GUI screen
    private void initializeCourseGenerate() {
        JPanel courseGenerateScreen = new JPanel(new GridBagLayout());
        courseGenerateScreen.setBackground(SystemColor.WHITE);
        GridBagConstraints courseGSConstraints = new GridBagConstraints();
        courseGSConstraints.insets = new Insets(10, 10, 10, 10);
        title = new JLabel("Course Portal");

        createCourse = new JButton("Create a Course");
        removeCourse = new JButton("Remove a Course");
        viewCourses = new JButton("View all Courses");
        signOut = new JButton("Sign Out");
        mainLogo = new JLabel(logo);
        courseGenerateScreenElements(courseGenerateScreen, courseGSConstraints);
        mainFrame.add(courseGenerateScreen);
    }

    // extension to the method above. Displays the CourseGeneratorScreen elements.
    private void courseGenerateScreenElements(JPanel courseGenerateScreen, GridBagConstraints courseGSConstraints)
    {

        courseGSConstraints.anchor = GridBagConstraints.CENTER;
        courseGSConstraints.fill = GridBagConstraints.HORIZONTAL;

        courseGSConstraints.gridx = 0;
        courseGSConstraints.gridy = 0;
        courseGenerateScreen.add(mainLogo,courseGSConstraints);

        courseGSConstraints.gridx = 0;
        courseGSConstraints.gridy = 1;
        courseGenerateScreen.add(createCourse, courseGSConstraints);
        ActionListener createCourseButton = createCourseButton(courseGenerateScreen);
        createCourse.addActionListener(createCourseButton);

        courseGSConstraints.gridx = 0;
        courseGSConstraints.gridy = 2;
        courseGenerateScreen.add(removeCourse, courseGSConstraints);
        ActionListener removeCourseButton = removeCourseButton(courseGenerateScreen);
        removeCourse.addActionListener(removeCourseButton);

        courseGSConstraints.gridx = 0;
        courseGSConstraints.gridy = 3;
        courseGenerateScreen.add(viewCourses, courseGSConstraints);
        ActionListener viewCoursesButton = viewCoursesButton(courseGenerateScreen);
        viewCourses.addActionListener(viewCoursesButton);

        courseGenerateScreenElements2(courseGenerateScreen, courseGSConstraints, signOut, signOutCall());

    }

    //Displays the courseGeneratorScreenElements elements
    private void courseGenerateScreenElements2(JPanel cgs, GridBagConstraints c, JButton e, ActionListener al)
    {
        c.gridx = 0;
        c.gridy = 4;
        cgs.add(e, c);
        e.addActionListener(al);
    }


    //To display elements for createCourse
    private void createCourse()
    {

        JPanel createCourseScreen = new JPanel(new GridBagLayout());
        createCourseScreen.setBackground(SystemColor.WHITE);
        GridBagConstraints createCSConstraints = new GridBagConstraints();
        createCSConstraints.insets = new Insets(10, 10, 10, 10);

        title = new JLabel("Create a Course");
        courseFacultyLabel = new JLabel("Faculty of : ");
        courseLevelStudyLabel = new JLabel("Level Of Study : ");
        courseNameLabel = new JLabel("Course Name : ");
        courseSubjectLabel = new JLabel("Subject in this course : ");
        courseDurationLabel = new JLabel("Duration (Year) in this course : ");
        courseEmployeeLabel = new JLabel("Employment Opportunities : ");
        courseScopeLabel = new JLabel("Scope studies : ");
        courseScholarLabel = new JLabel("Scholarship availabilities : ");
        courseFeeLabel = new JLabel("Course Fee : ");
        courseRequirementsLabel = new JLabel("Minimum Entry Requirements :");
        courseSeatsLabel = new JLabel("Total Seats : ");
        courseFacultyField = new JTextField(30);
        courseLevelStudyField = new JTextField(30);
        courseNameField = new JTextField(30);
        courseSubjectField = new JTextField(30);
        courseDurationField = new JTextField(30);
        courseEmployeeField = new JTextField(30);
        courseScopeField = new JTextField(30);
        courseScholarField = new JTextField(30);
        courseFeeField = new JTextField(30);
        courseRequirementsField = new JTextField(30);
        courseSeatsField = new JTextField(10);
        create = new JButton("Create Course");
        goBack = new JButton("Go Back to Account");
        createCourseScreenElements(createCourseScreen, createCSConstraints);
        mainFrame.add(createCourseScreen);
    }


    //Displays createCourseScreen elements.
    private void createCourseScreenElements(JPanel createCourseScreen, GridBagConstraints createCSConstraints)
    {
        createCSConstraints.fill = GridBagConstraints.HORIZONTAL;
        createCSConstraints.gridx = 0;
        createCSConstraints.gridy = 0;
        createCourseScreen.add(title, createCSConstraints);

        createCSConstraints.gridx = 0;
        createCSConstraints.gridy = 1;
        createCourseScreen.add(courseFacultyLabel, createCSConstraints);
        createCSConstraints.gridx = 1;
        createCSConstraints.gridy = 1;
        createCourseScreen.add(courseFacultyField, createCSConstraints);

        createCSConstraints.gridx = 0;
        createCSConstraints.gridy = 2;
        createCourseScreen.add(courseLevelStudyLabel, createCSConstraints);
        createCSConstraints.gridx = 1;
        createCSConstraints.gridy = 2;
        createCourseScreen.add(courseLevelStudyField, createCSConstraints);

        createCSConstraints.gridx = 0;
        createCSConstraints.gridy = 3;
        createCourseScreen.add(courseNameLabel, createCSConstraints);
        createCSConstraints.gridx = 1;
        createCSConstraints.gridy = 3;
        createCourseScreen.add(courseNameField, createCSConstraints);

        createCSConstraints.gridx = 0;
        createCSConstraints.gridy = 4;
        createCourseScreen.add(courseSubjectLabel, createCSConstraints);
        createCSConstraints.gridx = 1;
        createCSConstraints.gridy = 4;
        createCourseScreen.add(courseSubjectField, createCSConstraints);

        createCSConstraints.gridx = 0;
        createCSConstraints.gridy = 5;
        createCourseScreen.add(courseDurationLabel, createCSConstraints);
        createCSConstraints.gridx = 1;
        createCSConstraints.gridy = 5;
        createCourseScreen.add(courseDurationField, createCSConstraints);

        createCSConstraints.gridx = 0;
        createCSConstraints.gridy = 6;
        createCourseScreen.add(courseEmployeeLabel, createCSConstraints);
        createCSConstraints.gridx = 1;
        createCSConstraints.gridy = 6;
        createCourseScreen.add(courseEmployeeField, createCSConstraints);

        createCSConstraints.gridx = 0;
        createCSConstraints.gridy = 7;
        createCourseScreen.add(courseScopeLabel, createCSConstraints);
        createCSConstraints.gridx = 1;
        createCSConstraints.gridy = 7;
        createCourseScreen.add(courseScopeField, createCSConstraints);

        createCSConstraints.gridx = 0;
        createCSConstraints.gridy = 8;
        createCourseScreen.add(courseScholarLabel, createCSConstraints);
        createCSConstraints.gridx = 1;
        createCSConstraints.gridy = 8;
        createCourseScreen.add(courseScholarField, createCSConstraints);

        createCSConstraints.gridx = 0;
        createCSConstraints.gridy = 9;
        createCourseScreen.add(courseFeeLabel, createCSConstraints);
        createCSConstraints.gridx = 1;
        createCSConstraints.gridy = 9;
        createCourseScreen.add(courseFeeField, createCSConstraints);

        createCSConstraints.gridx = 0;
        createCSConstraints.gridy = 10;
        createCourseScreen.add(courseRequirementsLabel, createCSConstraints);
        createCSConstraints.gridx = 1;
        createCSConstraints.gridy = 10;
        createCourseScreen.add(courseRequirementsField, createCSConstraints);

        createCSConstraints.gridx = 0;
        createCSConstraints.gridy = 11;
        createCourseScreen.add(courseSeatsLabel, createCSConstraints);
        createCSConstraints.gridx = 1;
        createCSConstraints.gridy = 11;
        createCourseScreen.add(courseSeatsField, createCSConstraints);

        createCourseScreenElements2(createCourseScreen, createCSConstraints);

    }


    //Extension to the method above. Displays createCourseScreen elements.
    private void createCourseScreenElements2(JPanel createCourseScreen, GridBagConstraints createCSConstraints)
    {
        createCSConstraints.gridx = 0;
        createCSConstraints.gridy = 12;
        createCourseScreen.add(create, createCSConstraints);
        ActionListener createCall = createCall(createCourseScreen);
        create.addActionListener(createCall);

        createCSConstraints.gridx = 0;
        createCSConstraints.gridy = 13;
        createCourseScreen.add(goBack, createCSConstraints);
        ActionListener goBackCall = goBackCall(createCourseScreen);
        goBack.addActionListener(goBackCall);
    }

    //Displays elements for removeCourse tab.
    private void removeCourse()
    {
        JPanel removeCourseScreen = new JPanel(new GridBagLayout());
        removeCourseScreen.setBackground(SystemColor.WHITE);
        GridBagConstraints removeCSConstraints = new GridBagConstraints();
        removeCSConstraints.insets = new Insets(10, 10, 10, 10);

        title = new JLabel("Remove a Course");
        delCourse = new JButton("Delete");
        goBack = new JButton("Go Back to Account");

        courseList = courseGenerate.viewCourseGUI();
        courseListModel = new DefaultListModel<>();
        for (String s : courseList)
        {
            courseListModel.addElement(s);
        }

        courseJList = new JList<>();
        courseJList.setModel(courseListModel);
        courseJList.setSize(new Dimension(1000, 800));
        courseJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        courseJList.setVisibleRowCount(4);

        removeCourseScreenElements(removeCourseScreen, removeCSConstraints);
        mainFrame.add(removeCourseScreen);
    }

    //Displays removeCourseScreen elements.
    private void removeCourseScreenElements(JPanel removeCourseScreen, GridBagConstraints removeCSConstraints)
    {
        JScrollPane remScrollPane;
        remScrollPane = new JScrollPane(courseJList, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
        remScrollPane.setSize(new Dimension(1920, 1080));

        removeCSConstraints.fill = GridBagConstraints.HORIZONTAL;
        removeCSConstraints.gridx = 0;
        removeCSConstraints.gridy = 0;
        removeCourseScreen.add(title, removeCSConstraints);

        removeCSConstraints.gridx = 0;
        removeCSConstraints.gridy = 1;
        removeCourseScreen.add(remScrollPane, removeCSConstraints);

        ListSelectionListener courseSelectionFromList = courseSelectionFromList(removeCourseScreen);
        courseJList.addListSelectionListener(courseSelectionFromList);

        removeCSConstraints.gridx = 0;
        removeCSConstraints.gridy = 2;
        removeCourseScreen.add(goBack, removeCSConstraints);

        ActionListener goBackCall = goBackCall(removeCourseScreen);
        goBack.addActionListener(goBackCall);
    }

    //Constructs the GUI Elements for the View Course Scroll Panel Page
    private void viewCourses()
    {
        JPanel viewCourseScreen = new JPanel(new GridBagLayout());
        viewCourseScreen.setBackground(SystemColor.WHITE);
        GridBagConstraints viewCSConstraints = new GridBagConstraints();
        viewCSConstraints.insets = new Insets(10, 10, 10, 10);

        title = new JLabel("View all Courses");
        goBack = new JButton("Go Back to Account");
        courseList = courseGenerate.viewCourseGUI();

        courseListModel = new DefaultListModel<>();
        for (String s : courseList) {
            courseListModel.addElement(s);
        }

        courseJList = new JList<>();
        courseJList.setModel(courseListModel);
        courseJList.setSize(new Dimension(1920, 1080));
        courseJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        courseJList.setVisibleRowCount(4);

        viewCoursesScreenElements(viewCourseScreen, viewCSConstraints);
        mainFrame.add(viewCourseScreen);

    }

    //Extension of the method above, it constructs the GUI Elements for the View Course Scroll Panel Page
    private void viewCoursesScreenElements(JPanel viewCourseScreen, GridBagConstraints viewCSConstraints)
    {
        JScrollPane viewScrollPane;
        viewScrollPane = new JScrollPane(courseJList, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
        viewScrollPane.setSize(new Dimension(1920, 1080));
        viewCSConstraints.fill = GridBagConstraints.HORIZONTAL;

        viewCSConstraints.gridx = 0;
        viewCSConstraints.gridy = 0;
        viewCourseScreen.add(title, viewCSConstraints);

        viewCSConstraints.gridx = 0;
        viewCSConstraints.gridy = 1;
        viewCourseScreen.add(viewScrollPane, viewCSConstraints);

        viewCSConstraints.gridx = 0;
        viewCSConstraints.gridy = 2;
        viewCourseScreen.add(goBack, viewCSConstraints);

        ActionListener goBackCall = goBackCall(viewCourseScreen);
        goBack.addActionListener(goBackCall);
    }

    //Adds an ActionListener for goBackButton
    private ActionListener goBackCall(JPanel panel)
    {
        return e ->
        {
            panel.setVisible(false);
            initializeCourseGenerate();
        };
    }

    //adds an ActionListener for viewCoursesButton and initializes the viewCourses method.
    private ActionListener viewCoursesButton(JPanel panel)
    {
        return e ->
        {
            panel.setVisible(false);
            viewCourses();
        };
    }

    //adds an ActionListener for removeCourseButton and initializes the removeCourse method.
    private ActionListener removeCourseButton(JPanel panel)
    {
        return e ->
        {
            panel.setVisible(false);
            removeCourse();
        };
    }


    //Adds an ActionListener for createCourseButton and initializes the createCourse method.
    private ActionListener createCourseButton(JPanel panel)
    {
        return e ->
        {
            panel.setVisible(false);
            createCourse();
        };
    }

    //adds a new course to the list of courses by getting the required values from the user.
    private ActionListener createCall(JPanel panel)
    {
        return e ->
        {
            panel.setVisible(false);
            String fac =  courseFacultyField.getText();
            String level = courseLevelStudyField.getText();
            String name = courseNameField.getText();
            String subject = courseSubjectField.getText();
            String duration = courseDurationField.getText();
            String employee = courseEmployeeField.getText();
            String scope = courseScopeField.getText();
            String scholar = courseScholarField.getText();
            String fee = courseFeeField.getText();
            int seats = Integer.parseInt(courseSeatsField.getText());
            String req = courseRequirementsField.getText();



            Course course = new Course(fac,level,name,subject,duration,employee,scope,scholar,fee,seats,req,0);

            if (courseGenerate.newCourse(course))
            {
                JOptionPane.showMessageDialog(mainFrame, "Course Added Successfully !!!! ");
            }
            else
            {
                JOptionPane.showMessageDialog(mainFrame, "Course Already Added in the list. Try Again !!!");
            }

            panel.setVisible(false);
            mainFrame.dispose();
            new CourseGenerateGUI();
        };
    }

    //adds an ActionListener for the signOut button.
    private ActionListener signOutCall()
    {
        return e ->
        {
            mainFrame.dispose();
            new FacultyScreenGUI();
        };
    }

    //adds a list selection listener that removes the selected course.
    private ListSelectionListener courseSelectionFromList(JPanel panel)
    {
        return e ->
        {
            index = courseJList.getSelectedIndex();
            int input = JOptionPane.showConfirmDialog(null, "Click Yes to delete the Course: " + (index + 1), "Delete Course Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
            panel.setVisible(false);
            if (input == 0 && courseGenerate.removeCourse(index)) {
                JOptionPane.showMessageDialog(mainFrame,"Course number " + (index + 1) + " deleted!");
            }
            else
            {
                JOptionPane.showMessageDialog(mainFrame,"Unable to delete Course!");
            }

            mainFrame.dispose();
            new CourseGenerateGUI();
        };
    }


}
