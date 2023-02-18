//Authors: Daniel,Ayu & Haziq
package model;
import org.json.JSONObject;
import controller.Writable;

//  Course class stores the information about the course available
public class Course implements Writable
{

    // Stores the level of study of the course
    protected String courseLevelStudy;
    // Stores the faculty  of the course
    protected String courseFaculty;

    // Stores the name of the course
    protected String courseName;

    // Stores the subject of the course
    protected String courseSubject;

    // Stores the duration of the course
    protected String courseDuration;

    // Stores the employment of the course
    protected String courseEmployee;

    // Stores the scope of the course
    protected String courseScope;

    // Stores the scholar of the course
    protected String courseScholar;

    // Stores the fee of the course
    protected String courseFee;

    // Stores the number of seats available for a course
    protected int courseSeats;

    // Stores the requirement by the course
    protected String courseRequirements;

    //Stores the number of students who registered the particular course in their worklist.
    protected int counter;


    //Parametrized Constructor
    public Course(String courseFaculty,String courseLevelStudy, String courseName, String courseSubject, String courseDuration,
                  String courseEmployee, String courseScope, String courseScholar, String courseFee,  int courseSeats, String courseRequirements,int counter)
    {
        this.courseFaculty = courseFaculty;
        this.courseLevelStudy = courseLevelStudy;
        this.courseName = courseName;
        this.courseSubject = courseSubject;
        this.courseDuration = courseDuration;
        this.courseEmployee = courseEmployee;
        this.courseScope = courseScope;
        this.courseScholar = courseScholar;
        this.courseFee = courseFee;
        this.courseSeats = courseSeats;

        this.courseRequirements = courseRequirements;
        this.counter = counter;
    }



    public Course(String name)
    {
        this.courseName = name;
    }

    //Accessor Method
    public String getCourseLevelStudy()
    {
        return this.courseLevelStudy;
    }

    public String getCourseFaculty()
    {
        return this.courseFaculty ;
    }

    public String getCourseName()
    {
        return this.courseName;
    }

    public String getCourseSubject()
    {
        return this.courseSubject;
    }

    public String getCourseDuration()
    {
        return this.courseDuration;
    }

    public String getCourseEmployee()
    {
        return this.courseEmployee;
    }

    public String getCourseScope()
    {
        return this.courseScope;
    }

    public String getCourseScholar()
    {
        return this.courseScholar;
    }

    public String getCourseFee()
    {
        return this.courseFee;
    }

    public int getCourseSeats()
    {
        return this.courseSeats;
    }


    public String getCourseRequirements()
    {
        return this.courseRequirements;
    }

    public int getCounter()
    {
        return this.counter;
    }


    //counter (increments counter by 1)
    public void incCounter()
    {
        counter++;
    }

    //counter (decrements counter by 1)
    public void decCounter()
    {
        counter--;
    }

    @Override
    public String toString()
    {
        return " Faculty: " + courseFaculty + ", Level of Study : " + courseLevelStudy + ", Course Name : " + courseName + ", Course Subject : " + courseSubject + ", Course Duration (Year) : " + courseDuration + ", Career Prospects : " + courseEmployee +
                ", Scope :   " + courseScope + ", Scholarship Available : " + courseScholar + ", Course Fee(RM) : "
                + courseFee + ", Course Seats : " + courseSeats + ", Minimum Entry Requirements : " + courseRequirements ;
    }

    //Returns this class as a JSON Object
    @Override
    public JSONObject toJson()
    {
        JSONObject json = new JSONObject();
        json.put("courseFaculty", courseFaculty);
        json.put("courseLevelStudy", courseLevelStudy);
        json.put("courseName", courseName);
        json.put("courseSubject", courseSubject);
        json.put("courseDuration", courseDuration);
        json.put("courseEmployee", courseEmployee);
        json.put("courseScope", courseScope);
        json.put("courseScholar", courseScholar);
        json.put("courseFee", courseFee);
        json.put("courseRequirements", courseRequirements);
        json.put("courseSeats", courseSeats);
        json.put("counter", counter);

        return json;
    }
}
