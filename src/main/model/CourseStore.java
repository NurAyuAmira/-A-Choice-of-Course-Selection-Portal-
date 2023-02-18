//Authors:Ayu, Naufal & Faiz
package model;
import model.exceptions.DuplicateCourseException;
import org.json.JSONArray;
import org.json.JSONObject;
import controller.Writable;

import java.util.ArrayList;
import java.util.List;

//CourseStorage class stores the list of available courses and allows user to perform their corresponding actions.
public class CourseStore implements Writable
{
    // Stores the total list of courses available
    protected static List<Course> courseList = new ArrayList<>();

    //Accessor Methods
    public List<Course> getCourseList()
    {
        return courseList;
    }

    // Add a course to the list of available courses.
    public void addCourse(Course c) throws DuplicateCourseException
    {
        for (Course course : courseList)
        {
            if (c.getCourseName().equals(course.getCourseName()))
            {
                throw new DuplicateCourseException();
            }
        }
        courseList.add(c);
    }


    //Delete a course from the list of available course
    public boolean deleteCourse(String name)
    {

        for (Course course : courseList)
        {
            if (course.getCourseName().equals(name)) {
                for (Student student : StudentVerification.getStudentList())
                {
                    student.removeregisterCourse(name);
                }
                courseList.remove(course);
                return true;
            }

        }
        return false;
    }

    public boolean deleteCourse(int index)
    {
        Course course = courseList.get(index);

        for (Student student : StudentVerification.getStudentList())
        {
            student.removeregisterCourse(course.getCourseName());
        }
        courseList.remove(course);
        return true;
    }


    //Register the course to the student's worklist
    public int registerCourse(String name, Student s)
    {
        for (Course course : courseList)
        {
            if (course.getCourseName().equals(name))
            {
                if (!s.getCourseRegistered().contains(course))
                {
                    s.setCourseRegistered(course);
                    course.incCounter();
                    return 0;

                }
                else
                {
                    return 1;
                }
            }
        }
        return 2;
    }


    //De-registers the course from the student's worklist.
    public boolean unregisterCourse(String name, Student s)
    {
        for (Course course : s.getCourseRegistered())
        {
            if (course.getCourseName().equals(name))
            {
                s.removeregisterCourse(name);
                course.decCounter();

                return true;
            }
        }
        return false;
    }


    //copies the list of courses
    public void copyCourseList(List<Course> courses)
    {
        courseList = courses;
    }


    //Returns this class as a JSON Object
    @Override
    public JSONObject toJson()
    {
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        for (Course c : courseList)
        {
            jsonArray.put(c.toJson());
        }

        json.put("courseList", jsonArray);
        return json;
    }
}
