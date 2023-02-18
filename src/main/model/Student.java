//Authors: Faiz & Ayu
package model;

import org.json.JSONArray;
import org.json.JSONObject;
import controller.Writable;
import java.util.*;


// Student class holds the basic information of Students on the system.
public class Student extends UserSystem implements Writable
{
    //courseRegistered stores the list of courses registered by a student on the courselist
    protected List<Course> courseRegistered;

    // Parametrized Constructor creates a Course ArrayList
    public Student(String level,String name, String id, String password)
    {
        this.level = level;
        this.name = name;
        this.id = id;
        this.password = password;
        this.courseRegistered = new ArrayList<>();
    }

    //Accessor Method
    public String getLevel()
    {
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public String getPassword() {
        return this.password;
    }

    public List<Course> getCourseRegistered() {
        return courseRegistered;
    }


    //Registers the course in the student's worklist.
    public void setCourseRegistered(Course c)
    {
        courseRegistered.add(c);
    }

    //De-registers the course in the student's worklist.
    public void removeregisterCourse(String name)
    {
        courseRegistered.removeIf(course -> course.getCourseName().equals(name));
    }


    //Copies the JSON Array to courseRegistered List
    public void copyCourseList(List<Course> courseRegistered)
    {
        this.courseRegistered = courseRegistered;
    }


    //Returns this class as a JSON object
    @Override
    public JSONObject toJson()
    {
        JSONObject json = new JSONObject();
        json.put("level", level);
        json.put("name", name);
        json.put("id", id);
        json.put("password", password);
        JSONArray jsonArray = new JSONArray();
        for (Course c : courseRegistered)
        {
            jsonArray.put(c.toJson());
        }
        json.put("courseRegistered", jsonArray);
        return json;
    }

}
