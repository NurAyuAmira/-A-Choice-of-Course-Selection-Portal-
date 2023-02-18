//Authors: Naufal
package model;
import java.util.*;

/*
     Faculty class stores the basic information of the faculty administrator who can:
     - add/remove courses
     - determine ,subjects taught, the course duration, the employment opportunities,
       the scope for further studies, the scholarship facilities available, and the fee structure.
     - determine number of seats in a course
     - determine number of credits of a course
     - There is only a single administrator with pre-defined details
*/

public class Faculty extends UserSystem
{

    //Parametrized Constructor
    public Faculty()
    {
        //Used "this" to refer to the current instance of the class Faculty that is being created.
        this.id = "Faculty";
        this.name = "Muhammad Dhiyaul Naufal";
        this.password = "fc";
    }

    //Accessor Method (Getter Method)
    public String getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public String getPassword()
    {
        return this.password;
    }


    /*
        Function : Return true if id and password matches
                 : Else Return false if id and password wrong
     */
    public boolean checkLogin(String id, String password)
    {
        if (id.equals(this.id) && password.equals(this.password))
        {
            return true;
        }
        return false;
    }
}
