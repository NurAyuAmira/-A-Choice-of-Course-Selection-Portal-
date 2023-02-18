//Authors: Ayu & Faiz
package view;
import model.Course;
import model.CourseStore;
import model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//CourseRegistration is the part of Student Portal which implements all the functionalities of portal.
public class CourseRegister
{
    Scanner sc = new Scanner(System.in);
    private CourseStore courseStore = new CourseStore();
    private Student student;

    //Opens functions of courseActions
    public CourseRegister(Student student)
    {

        this.student = student;
    }

    //allows student to add addition, removal, view operations.
    public void courseStudentAction()
    {

        System.out.println("Hello, " + student.getName() + ". Press: \n(1) to view list of all available courses");
        System.out.println("(2) to add course to your worklist\n(3) to remove course to your worklist.");
        System.out.println("(4) to view your status of the courses in the worklist.");
        System.out.println("(5) to Log Out");
        int a = sc.nextInt();

        if (a == 1) {
            viewCourses();
        }
        if (a == 2) {
            registerCourse();
        }
        if (a == 3) {
            removeregisterCourse();
        }

        if (a == 4) {
            viewCourseStatus();
        }

        if (a == 5) {
            new FirstScreen();
        } else {
            System.out.println("Invalid input. Try again!");
            courseStudentAction();
        }
    }

    //Creates a new course and puts in the list of courses offered.
    public void registerCourse()
    {

        System.out.println("What is the course name you would like to register in your worklist?");

        Scanner sc1 = new Scanner(System.in);
        String name = sc1.nextLine();

        if (courseStore.registerCourse(name, student) == 0)
        {
            System.out.println("Course added successfully!");
        }
        else if (courseStore.registerCourse(name, student) == 1)
        {
            System.out.println("You already added this course to your worklist!");
        }
        else
        {
            System.out.println("Course does not exist!");
        }

        courseStudentAction();
    }

    //Deletes a course from the list of courses offered.
    public void removeregisterCourse()
    {

        System.out.println("Enter the name of course which has to be deleted?");

        Scanner sc1 = new Scanner(System.in);
        String name = sc1.nextLine();

        if (courseStore.unregisterCourse(name, student))
        {
            System.out.println("Course has been deleted successfully.");
        }
        else
        {
            System.out.println("Course not found.");
        }
        courseStudentAction();
    }

    //Displays the list of courses offered.
    public void viewCourses()
    {
        if (courseStore.getCourseList().size() != 0)
        {
            for (Course c : courseStore.getCourseList())
            {
                System.out.println("Level of Study: " + c.getCourseLevelStudy());
                System.out.println("Course Name: " + c.getCourseName());
                System.out.println("Subject: " + c.getCourseSubject());
                System.out.println("Duration: " + c.getCourseDuration());
                System.out.println("Employee Opportunities: " + c.getCourseEmployee());
                System.out.println("Scope: " + c.getCourseScope());
                System.out.println("Scholar: " + c.getCourseScholar());
                System.out.println("Fee: " + c.getCourseFee());
                System.out.println("Total number of available seats: " + c.getCourseSeats());

                System.out.println();
            }
        }
        else
        {
            System.out.println("No courses found!");
        }
        courseStudentAction();
    }

    // Displays the status of all the courses registered.
    public void viewCourseStatus()
    {
        if (student.getCourseRegistered().size() != 0)
        {
            for (Course courses : student.getCourseRegistered()) {
                System.out.println("Course Name: " + courses.getCourseName());
                courseStudentChance(courses);
            }
        }
        else
        {
            System.out.println("No courses found!");
        }
        courseStudentAction();
    }

    // Displays the student's status in registered courses.
    public String courseStudentChance(Course course)
    {
        double counter = course.getCounter();
        double seats = course.getCourseSeats();
        double ratio = counter / seats;

        if (ratio <= 1)
        {
            return "You're superb! \nWhat this means: Total no. of seats available for this course "
                    + "is " + "sufficient for no. of students who have added this course to their worklist.";
        }
        else if (ratio > 1 && ratio < 1.2)
        {
            return "There's a solid chance you'll get this one! \n What this means: No. of students who"
                    + " added this course to their worklist is up to 20% more than total no. of seats available for"
                    + " this course";
        }
        else if (ratio >= 1.2 && ratio <= 1.5)
        {
            return "Eh. Just pray your registration time is sooner than others!\n"
                    + "What this means: No. of students who added this course to their worklist is about 20% -"
                    + " 50% more than total no. of seats available for this course.";
        }
        else
        {
            return "Sorry student, there's a heavy chance you won't get this course. Consider other options as "
                    + "well.\n" + "What this means: No. of students who added this course to their worklist is 50% "
                    + "more " + "than the total no. of seats available for this course.";
        }
    }

    //  Returns a course list to the CourseGeneratorGUI
    public List<String> viewAllCoursesGUI()
    {
        List<String> list = new ArrayList<>();

        if (courseStore.getCourseList().size() == 0)
        {
            list.add("No Courses have been created yet!");
        }
        else
        {
            for (int i = 0; i < courseStore.getCourseList().size(); i++) {
                String entry = (i + 1) + "." + courseStore.getCourseList().get(i).toString();
                list.add(entry);
            }
        }
        return list;
    }

    // Returns a course list to the CourseGeneratorGUI
    public List<String> viewYourCoursesGUI()
    {
        List<String> list = new ArrayList<>();

        if (student.getCourseRegistered().size() == 0)
        {
            list.add("No Courses have been added to your Worklist yet!");
        }
        else
        {
            for (int i = 0; i < student.getCourseRegistered().size(); i++)
            {
                String entry = (i + 1) + "." + student.getCourseRegistered().get(i).toString();
                list.add(entry);
            }
        }
        return list;
    }

}
