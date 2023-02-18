//Authors: Nur Ayu Amira & Muhammad Dhiyaul Naufal
package controller;
import model.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.json.*;

//Represents a reader that reads Student data from JSON data stored in file.
public class StudentRead
{
    private String source;

    //Constructs reader to read from source file.
    public StudentRead(String source)
    {
        this.source = source;
    }

    //Reads students from file and returns it & throws an IOException if an error occurs when reading data from the file
    public StudentVerification read() throws IOException
    {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray studentArray = jsonObject.getJSONArray("studentList");
        ArrayList<Student> students = new ArrayList<>();

        for (Object s : studentArray)
        {
            JSONObject courseObject = (JSONObject) s;
            String level = courseObject.getString("level");
            String name = courseObject.getString("name");
            String id = courseObject.getString("id");
            String password = courseObject.getString("password");

            Student student = new Student(level,name, id, password);
            student.copyCourseList(parseCourseList(courseObject));
            students.add(student);
        }

        StudentVerification studentVerification = new StudentVerification();
        studentVerification.copyStudentList(students);
        return studentVerification;
    }

    //Parses the registered courses from JSONObject and returns the list.
    public List<Course> parseCourseList(JSONObject jsonObject) {
        JSONArray courseArray = jsonObject.getJSONArray("courseRegistered");
        ArrayList<Course> courses = new ArrayList<>();

        for (Object e : courseArray)
        {
            JSONObject courseObject = (JSONObject) e;
            String courseFaculty = courseObject.getString("courseFaculty");
            String courseLevelStudy = courseObject.getString("courseLevelStudy");
            String courseName = courseObject.getString("courseName");
            String courseSubject = courseObject.getString("courseSubject");
            String courseDuration = courseObject.getString("courseDuration");
            String courseEmployee = courseObject.getString("courseEmployee");
            String courseScope = courseObject.getString("courseScope");
            String courseScholar = courseObject.getString("courseScholar");
            String courseFee = courseObject.getString("courseFee");
            int courseSeats = courseObject.getInt("courseSeats");
            String courseRequirements = courseObject.getString("courseRequirements");
            int counter = courseObject.getInt("counter");
            courses.add(new Course(courseFaculty,courseLevelStudy, courseName, courseSubject, courseDuration, courseEmployee, courseScope, courseScholar, courseFee, courseSeats, courseRequirements, counter));
        }
        return courses;
    }



    //Reads source file as string and returns it
    private String readFile(String source) throws IOException
    {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

}
