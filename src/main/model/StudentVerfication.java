//Authors:Ayu & Faiz
package model;
import org.json.JSONArray;
import org.json.JSONObject;
import controller.Writable;
import java.util.ArrayList;
import java.util.List;

//StudentVerification stores information of registered students and facultyAdmin and validates login process of the user.
public class StudentVerification implements Writable
{
    private Faculty faculty = new Faculty();

    //studentList array stores the information of students registered on the system.
    protected static List<Student> studentList = new ArrayList<>();

    //create a new student profile
    public boolean newStudent(Student s)
    {
        if (faculty.id.equals(s.getId()))
        {
            return false;
        }
        for (Student student : studentList) {
            if (student.getId().equals(s.getId()))
            {
                return false;
            }
        }
        studentList.add(s);
        return true;
    }

    //returns true if a student logs in successfully and stores the information.
    public Student verifyStudent(String id, String password)
    {
        for (Student student : studentList)
        {
            if (student.getId().equals(id) && student.getPassword().equals(password))
            {
                return student;
            }
        }
        return null;
    }


    //Accessor Method
    public static List<Student> getStudentList()
    {
        return studentList;
    }

    public void copyStudentList(List<Student> students)
    {
        studentList = students;
    }

    //Returns this class as a JSON Object
    @Override
    public JSONObject toJson()
    {
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        for (Student s : studentList)
        {
            jsonArray.put(s.toJson());
        }

        json.put("studentList", jsonArray);

        return json;
    }

}
