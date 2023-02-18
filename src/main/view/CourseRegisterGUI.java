//Authors: Ayu,Naufal & Faiz
package view;

import model.CourseStore;
import model.Student;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
import javax.swing.JFrame;
import java.io.IOException;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.net.URI;
import java.net.URISyntaxException;
public class CourseRegisterGUI extends JFrame {
    private CourseStore courseStore = new CourseStore();
    CourseRegister courseRegistration;
    JFrame mainFrame = new JFrame("Course Worklist Registration");
    JLabel title;
    JLabel caption;
    List<String> courseList;
    JList<String> courseJList;
    DefaultListModel<String> courseListModel;
    JButton viewAllCourses;
    JButton addCourse;
    JButton removeCourse;
    JButton viewYourCourses;
    JButton logOut;
    JButton goBackToPortal;
    JButton websiteButton ;
    int idx;
    Student student;
    boolean flag;


    // Default constructor for CourseRegistrationGUI class
    public CourseRegisterGUI(Student student) {
        mainFrame.setSize(1920, 1080);
        mainFrame.setBackground(Color.BLACK);
        initializeCourseRegister();

        this.student = student;
        courseRegistration = new CourseRegister(student);

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    //initializes CourseRegistrationGUI Screen
    private void initializeCourseRegister()
    {
        JPanel courseRegScreen = new JPanel(new GridBagLayout());
        courseRegScreen.setBackground(SystemColor.WHITE);
        GridBagConstraints courseRegConstraints = new GridBagConstraints();
        courseRegConstraints.insets = new Insets(10, 10, 10, 10);

        title = new JLabel("Manage Worklist");
        websiteButton = new JButton("Video About Course Information");
        viewAllCourses = new JButton("View All Courses");
        addCourse = new JButton("Add Courses");
        removeCourse = new JButton("Remove Courses");
        viewYourCourses = new JButton("View Your Courses Status");
        logOut = new JButton("Log Out");

        courseRegisterScreenElements(courseRegScreen, courseRegConstraints);
        mainFrame.add(courseRegScreen);
    }

    // extension to the method above. Displays the CourseRegistrationScreen elements.
    private void courseRegisterScreenElements(JPanel courseRegScreen, GridBagConstraints courseRegConstraints)
    {
        courseRegConstraints.anchor = GridBagConstraints.CENTER;
        courseRegConstraints.fill = GridBagConstraints.HORIZONTAL;

        courseRegConstraints.gridx = 0;
        courseRegConstraints.gridy = 0;
        courseRegScreen.add(title);

        courseRegConstraints.gridx = 0;
        courseRegConstraints.gridy = 1;
        courseRegScreen.add(websiteButton,courseRegConstraints);
        ActionListener websiteButtonAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=Wm-gU6FKzHM"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
        };
        websiteButton.addActionListener(websiteButtonAction);

        courseRegConstraints.gridx = 0;
        courseRegConstraints.gridy = 2;
        courseRegScreen.add(viewAllCourses, courseRegConstraints);

        ActionListener viewAllCoursesButton = viewAllCoursesButton(courseRegScreen);
        viewAllCourses.addActionListener(viewAllCoursesButton);

        courseRegConstraints.gridx = 0;
        courseRegConstraints.gridy = 3;
        courseRegScreen.add(addCourse, courseRegConstraints);
        ActionListener addCourseButton = addCourseButton(courseRegScreen);
        addCourse.addActionListener(addCourseButton);

        courseRegConstraints.gridx = 0;
        courseRegConstraints.gridy = 4;
        courseRegScreen.add(removeCourse, courseRegConstraints);
        ActionListener removeCourseButton = removeCourseButton(courseRegScreen);
        removeCourse.addActionListener(removeCourseButton);

        courseRegisterScreenElements2(courseRegScreen, courseRegConstraints);
    }

    //  extension to the method above. Displays the CourseRegistrationScreen elements.
    private void courseRegisterScreenElements2(JPanel courseRegScreen, GridBagConstraints courseRegConstraints)
    {
        courseRegConstraints.gridx = 0;
        courseRegConstraints.gridy = 5;
        courseRegScreen.add(viewYourCourses, courseRegConstraints);
        ActionListener viewYourCoursesButton = viewYourCoursesButton(courseRegScreen);
        viewYourCourses.addActionListener(viewYourCoursesButton);

        courseRegConstraints.gridx = 0;
        courseRegConstraints.gridy = 6;
        courseRegScreen.add(logOut, courseRegConstraints);
        ActionListener goBackCall = logOut();
        logOut.addActionListener(goBackCall);
    }


    //Displays elements for viewAllCourses tab.
    private void viewAllCourses()
    {
        JPanel viewCourseScreen = new JPanel(new GridBagLayout());
        viewCourseScreen.setBackground(SystemColor.WHITE);
        GridBagConstraints viewCSConstraints = new GridBagConstraints();
        viewCSConstraints.insets = new Insets(10, 10, 10, 10);

        title = new JLabel("View all Courses");
        goBackToPortal = new JButton("Go Back to Account");

        courseList = courseRegistration.viewAllCoursesGUI();
        courseListModel = new DefaultListModel<>();
        flag = false;

        for (String s : courseList)
        {
            courseListModel.addElement(s);
            if (!s.equals("No Courses have been created yet!"))
            {
                flag = true;
            }
        }
        courseJList = new JList<>();
        courseJList.setModel(courseListModel);
        courseJList.setSize(new Dimension(1920, 1080));
        courseJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        courseJList.setVisibleRowCount(4);
        viewAllCoursesScreenElements(viewCourseScreen, viewCSConstraints);
        mainFrame.add(viewCourseScreen);

    }

    // EFFECTS: Extension to the method above. Displays viewAllCoursesScreen elements.
    private void viewAllCoursesScreenElements(JPanel viewCourseScreen, GridBagConstraints viewCSConstraints)
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
        viewCourseScreen.add(goBackToPortal, viewCSConstraints);

        ActionListener goBackToPortalCall = goBackToPortal();
        goBackToPortal.addActionListener(goBackToPortalCall);
    }

    //Displays elements for addCourse tab.
    private void addCourse()
    {
        JPanel addCourseScreen = new JPanel(new GridBagLayout());
        addCourseScreen.setBackground(SystemColor.WHITE);
        GridBagConstraints addCourseConstraints = new GridBagConstraints();
        addCourseConstraints.insets = new Insets(10, 10, 10, 10);

        title = new JLabel("Add Courses");
        caption = new JLabel("Click on a course to add to worklist.");
        goBackToPortal = new JButton("Go Back to Account");

        courseList = courseRegistration.viewAllCoursesGUI();
        courseListModel = new DefaultListModel<>();
        flag = false;

        for (String s : courseList)
        {
            courseListModel.addElement(s);
            if (!s.equals("No Courses have been created yet!"))
            {
                flag = true;
            }
        }

        courseJList = new JList<>();
        courseJList.setModel(courseListModel);
        courseJList.setSize(new Dimension(1920, 1080));
        courseJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        courseJList.setVisibleRowCount(4);

        mainFrame.add(addCourseScreen);
        addCourseScreenElements(addCourseScreen, addCourseConstraints);
    }

    // Extension to the method above. Displays addCourseScreen elements.
    private void addCourseScreenElements(JPanel addCourseScreen, GridBagConstraints addCourseConstraints)
    {
        JScrollPane addScrollPane;
        addScrollPane = new JScrollPane(courseJList, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
        addCourseConstraints.anchor = GridBagConstraints.CENTER;
        addCourseConstraints.fill = GridBagConstraints.HORIZONTAL;

        addCourseConstraints.gridx = 0;
        addCourseConstraints.gridy = 0;
        addCourseScreen.add(title, addCourseConstraints);

        addCourseConstraints.gridx = 0;
        addCourseConstraints.gridy = 1;
        addCourseScreen.add(caption, addCourseConstraints);

        addCourseConstraints.gridx = 0;
        addCourseConstraints.gridy = 2;
        addCourseScreen.add(addScrollPane, addCourseConstraints);

        ListSelectionListener courseSelectionFromList = courseSelectionFromList();
        courseJList.addListSelectionListener(courseSelectionFromList);

        addCourseConstraints.gridx = 0;
        addCourseConstraints.gridy = 3;
        addCourseScreen.add(goBackToPortal, addCourseConstraints);

        ActionListener goBackToPortalCall = goBackToPortal();
        goBackToPortal.addActionListener(goBackToPortalCall);
    }

    //  Displays elements for removeCourse tab.
    private void removeCourse()
    {
        JPanel removeCourseScreen = new JPanel(new GridBagLayout());
        removeCourseScreen.setBackground(SystemColor.WHITE);
        GridBagConstraints removeCourseConstraints = new GridBagConstraints();
        removeCourseConstraints.insets = new Insets(10, 10, 10, 10);

        title = new JLabel("Remove Courses");
        caption = new JLabel("Click on a course to remove from worklist.");
        goBackToPortal = new JButton("Go Back to Account");
        courseList = courseRegistration.viewYourCoursesGUI();
        courseListModel = new DefaultListModel<>();
        flag = false;

        for (String s : courseList)
        {
            courseListModel.addElement(s);
            if (!s.equals("No Courses have been added to your Course list yet!"))
            {
                flag = true;
            }
        }

        courseJList = new JList<>();
        courseJList.setModel(courseListModel);
        courseJList.setSize(new Dimension(1920, 1080));
        courseJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        courseJList.setVisibleRowCount(4);

        mainFrame.add(removeCourseScreen);
        removeCourseScreenElements(removeCourseScreen, removeCourseConstraints);

    }

    // Extension to the method above. Displays removeCourseScreen elements.
    private void removeCourseScreenElements(JPanel removeCourseScreen, GridBagConstraints removeCourseConstraints)
    {
        JScrollPane removeScrollPane;
        removeScrollPane = new JScrollPane(courseJList, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);

        removeCourseConstraints.anchor = GridBagConstraints.CENTER;
        removeCourseConstraints.fill = GridBagConstraints.HORIZONTAL;

        removeCourseConstraints.gridx = 0;
        removeCourseConstraints.gridy = 0;
        removeCourseScreen.add(title, removeCourseConstraints);

        removeCourseConstraints.gridx = 0;
        removeCourseConstraints.gridy = 1;
        removeCourseScreen.add(caption, removeCourseConstraints);

        removeCourseConstraints.gridx = 0;
        removeCourseConstraints.gridy = 2;
        removeCourseScreen.add(removeScrollPane, removeCourseConstraints);

        ListSelectionListener removeCourseSelection = removeCourseSelection(removeCourseScreen);
        courseJList.addListSelectionListener(removeCourseSelection);

        removeCourseConstraints.gridx = 0;
        removeCourseConstraints.gridy = 3;
        removeCourseScreen.add(goBackToPortal, removeCourseConstraints);

        ActionListener goBackToPortalCall = goBackToPortal();
        goBackToPortal.addActionListener(goBackToPortalCall);

    }

    // Displays elements for viewYourCourses tab.
    private void viewYourCourses()
    {
        JPanel viewYourCourses = new JPanel(new GridBagLayout());
        viewYourCourses.setBackground(SystemColor.WHITE);
        GridBagConstraints viewYourCoursesConstraints = new GridBagConstraints();
        viewYourCoursesConstraints.insets = new Insets(10, 10, 10, 10);

        title = new JLabel("View Your Registered Courses");
        caption = new JLabel("Click on a course to view your status.");
        goBackToPortal = new JButton("Go Back to Account");
        courseList = courseRegistration.viewYourCoursesGUI();
        courseListModel = new DefaultListModel<>();
        flag = false;

        for (String s : courseList)
        {
            courseListModel.addElement(s);
            if (!s.equals("No Courses have been added to your Course list yet!"))
            {
                flag = true;
            }

        }

        courseJList = new JList<>();
        courseJList.setModel(courseListModel);
        courseJList.setSize(new Dimension(1920, 1080));
        courseJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        courseJList.setVisibleRowCount(4);
        viewYourCoursesScreenElements(viewYourCourses, viewYourCoursesConstraints);
        mainFrame.add(viewYourCourses);

    }

    // Extension to the method above. Displays viewYourCoursesScreen elements.
    private void viewYourCoursesScreenElements(JPanel viewYourCourses, GridBagConstraints viewYourCoursesConstraints)
    {
        JScrollPane viewScrollPane;
        viewScrollPane = new JScrollPane(courseJList, VERTICAL_SCROLLBAR_AS_NEEDED, HORIZONTAL_SCROLLBAR_AS_NEEDED);
        viewYourCoursesConstraints.anchor = GridBagConstraints.CENTER;
        viewYourCoursesConstraints.fill = GridBagConstraints.HORIZONTAL;

        viewYourCoursesConstraints.gridx = 0;
        viewYourCoursesConstraints.gridy = 0;
        viewYourCourses.add(title, viewYourCoursesConstraints);

        viewYourCoursesConstraints.gridx = 0;
        viewYourCoursesConstraints.gridy = 1;
        viewYourCourses.add(caption, viewYourCoursesConstraints);

        viewYourCoursesConstraints.gridx = 0;
        viewYourCoursesConstraints.gridy = 2;
        viewYourCourses.add(viewScrollPane, viewYourCoursesConstraints);
        ListSelectionListener statusSelection = statusSelectionList();
        courseJList.addListSelectionListener(statusSelection);

        viewYourCoursesConstraints.gridx = 0;
        viewYourCoursesConstraints.gridy = 3;
        viewYourCourses.add(goBackToPortal, viewYourCoursesConstraints);
        ActionListener goBackToPortalCall = goBackToPortal();
        goBackToPortal.addActionListener(goBackToPortalCall);
    }

    //adds an ActionListener for viewYourCoursesButton and initializes the viewYourCourses method
    private ActionListener viewYourCoursesButton(JPanel panel)
    {
        return e ->
        {
            panel.setVisible(false);
            viewYourCourses();
        };
    }

    //adds an ActionListener for removeCourseButton and initializes the removeCourse method
    private ActionListener removeCourseButton(JPanel panel)
    {
        return e ->
        {
            panel.setVisible(false);
            removeCourse();
        };
    }

    // adds an ActionListener for addCourseButton and initializes the addCourse method
    private ActionListener addCourseButton(JPanel panel)
    {
        return e ->
        {
            panel.setVisible(false);
            addCourse();
        };
    }

    //  adds an ActionListener for viewAllCoursesButton and initializes the viewAllCourses method
    private ActionListener viewAllCoursesButton(JPanel panel)
    {
        return e ->
        {
            panel.setVisible(false);
            viewAllCourses();
        };
    }

    // adds an ActionListener for logOutButton and initializes StudentScreenGUI
    private ActionListener logOut()
    {
        return e ->
        {
            mainFrame.dispose();
            new StudentScreenGUI();
        };
    }

    //adds an ActionListener for goBackButton and initializes StudentScreenGUI
    private ActionListener goBackToPortal()
    {
        return e ->
        {
            mainFrame.dispose();
            new CourseRegisterGUI(student);
        };
    }

    //  adds a list selection listener and adds course to the worklist.
    private ListSelectionListener courseSelectionFromList()
    {
        return e ->
        {
            int i = 1;
            try
            {
                idx = courseJList.getSelectedIndex();
                i = JOptionPane.showConfirmDialog(null,
                        "Click Yes to add Course: " + courseStore.getCourseList().get(idx).getCourseName()
                                + " to " + "Course list!", "Course Addition Confirmation",
                        JOptionPane.YES_NO_CANCEL_OPTION);
            }
            catch (Exception f)
            {
                //leave
            }

            courseSelectionFromList2(i);
        };
    }


    // extension to the method above.
    private void courseSelectionFromList2(int i)
    {
        if (i == 0 && courseStore.registerCourse(courseStore.getCourseList().get(idx).getCourseName(), student) == 0)
        {
            JOptionPane.showMessageDialog(mainFrame, "Course: " + courseStore.getCourseList().get(idx).getCourseName() + " added to your Course list!");
        }
        else if (i == 0 && courseStore.registerCourse(courseStore.getCourseList().get(idx).getCourseName(), student) == 1)
        {
            JOptionPane.showMessageDialog(mainFrame, "Course: " + courseStore.getCourseList().get(idx).getCourseName() + " is already added to your Course list!");
        }
        else
        {
            JOptionPane.showMessageDialog(mainFrame, "Invalid!");
        }
    }

    //  adds a list selection listener and removes course from the worklist.
    private ListSelectionListener removeCourseSelection(JPanel panel)
    {
        return e ->
        {
            int i = 1;
            try
            {
                idx = courseJList.getSelectedIndex();
                i = JOptionPane.showConfirmDialog(null,
                        "Click Yes to remove Course: " + student.getCourseRegistered().get(idx).getCourseName() + " from " + "Course list!", "Course Removal Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
            }
            catch (Exception f)
            {
                //leave
            }
            removeCourseSelection2(panel, i);
        };
    }

    //extension to the method above.
    private void removeCourseSelection2(JPanel panel, int i)
    {
        if (i == 0 && courseStore.unregisterCourse(student.getCourseRegistered().get(idx).getCourseName(), student))
        {
            JOptionPane.showMessageDialog(mainFrame, "Course: " + student.getCourseRegistered().get(idx).getCourseName() + " removed from your Course list!");
            panel.setVisible(false);
            removeCourse();
        }
        else if (i == 0 && !courseStore.unregisterCourse(student.getCourseRegistered().get(idx).getCourseName(), student))
        {
            JOptionPane.showMessageDialog(mainFrame, "Course: " + student.getCourseRegistered().get(idx).getCourseName() + " is not in your Course list!");
        }
        else
        {
            JOptionPane.showMessageDialog(mainFrame, "Invalid!");
        }
    }

    //  adds a list selection listener and shows the course status.
    private ListSelectionListener statusSelectionList()
    {
        return e ->
        {
            try
            {
                idx = courseJList.getSelectedIndex();
            }
            catch (Exception f)
            {
                //leave
            }
            JOptionPane.showMessageDialog(mainFrame, courseRegistration.courseStudentChance(student.getCourseRegistered().get(idx)));
        };
    }

}

