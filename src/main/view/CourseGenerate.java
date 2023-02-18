//Authors:Faiz & Ayu
package view;
import java.util.*;
import model.CourseStore;
import model.Course;
import model.exceptions.DuplicateCourseException;

public class CourseGenerate
{
    private CourseStore courseStore = new CourseStore();

    // Opens the courseOperations functions.
    public CourseGenerate()
    {
        //courseOperation();
    }


    // Creates a new course and puts in the list of courses offered.
    public boolean newCourse(Course course1)
    {

        try
        {
            courseStore.addCourse(course1);
            return true;
        }
        catch (DuplicateCourseException e)
        {
            return false;
        }

    }


    //Deletes a course from the list of courses offered.
    public boolean removeCourse(int index)
    {
        return courseStore.deleteCourse(index);
    }



    //Returns a course list to the CourseGeneratorGUI
    public List<String> viewCourseGUI()
    {
        List<String> list = new ArrayList<>();

        if (courseStore.getCourseList().size() == 0)
        {
            list.add("No Courses have been created yet!");
        }
        else
        {
            for (int i = 0; i < courseStore.getCourseList().size(); i++)
            {
                String entry = (i + 1) + "." + courseStore.getCourseList().get(i).toString();
                list.add(entry);
            }
        }
        return list;
    }




















}
