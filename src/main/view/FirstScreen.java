//Authors:Ayu
package view;
import model.CourseStore;
import model.StudentVerification;
import controller.StudentRead;
import controller.StudentWrite;

import controller.CourseRead;
import controller.CourseWrite;

import java.io.FileNotFoundException;
import java.io.IOException;


//WelcomeScreen is the first part of the application where the user lands after the program starts.
public class FirstScreen
{
    StudentRead studentReader = new StudentRead("./data/StudentVerification.json");
    StudentWrite studentWriter = new StudentWrite("./data/StudentVerification.json");

    CourseRead courseReader = new CourseRead("./data/CourseStorage.json");
    CourseWrite courseWriter = new CourseWrite("./data/CourseStorage.json");

    StudentVerification studentVerification = new StudentVerification();
    CourseStore courseStorage = new CourseStore();

    //Constructs WelcomeScreen and opens the main screen of the application.
    public FirstScreen()
    {
        //displayMessage();
    }

    //Saves the data in .json format
    protected void saveData()
    {
        try {
            studentWriter.open();
            studentWriter.write(studentVerification);
            studentWriter.close();

            courseWriter.open();
            courseWriter.write(courseStorage);
            courseWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    //Loads the data from the .json file
    protected boolean loadData()
    {
        try
        {
            studentVerification = studentReader.read();
            courseStorage = courseReader.read();
            return true;
        }
        catch (IOException e)
        {
            return false;
        }

    }



}
