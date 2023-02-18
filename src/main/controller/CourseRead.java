//Authors: Engku Faiz Naqiuddin, Daniel Imtiyaz & Haziq Fikri
package controller;
import model.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.json.*;

//Represents a reader that reads Course data from JSON data stored in file.
public class CourseRead
{
    private String source;

    //constructs reader to read from source file.
    public CourseRead(String source)
    {
        this.source = source;
    }

    //reads courses from file and returns it.
    //throws an IOException if an error occurs when reading data from the file

    public CourseStore read() throws IOException
    {
          /*It has composition, as the CourseRead class contains an ArrayList of Course objects and returns a CourseStore object,
            which means it makes use of the Course and CourseStore classes to perform its functionality.
           */
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        JSONArray courseArray = jsonObject.getJSONArray("courseList");

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
            String courseRequirements = courseObject.getString("courseFee");
            int courseSeats = courseObject.getInt("courseSeats");
            int counter = courseObject.getInt("counter");
            courses.add(new Course(courseFaculty,courseLevelStudy, courseName, courseSubject, courseDuration, courseEmployee, courseScope, courseScholar, courseFee,  courseSeats, courseRequirements, counter));
        }
        CourseStore courseStorage = new CourseStore();
        courseStorage.copyCourseList(courses);

        return courseStorage;
    }

    // reads source file as string and returns it
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
