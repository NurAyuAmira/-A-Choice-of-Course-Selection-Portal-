//Authors:Nur Ayu Amira & Muhammad Dhiyaul Naufal
package controller;
import model.StudentVerification;
import org.json.JSONObject;
import java.io.*;


// Represents a writer that writes JSON representation of Students to file.
public class StudentWrite
{
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    //Constructors writer to write to destination file
    public StudentWrite(String destination)
    {
        this.destination = destination;
    }

    //Opens writer; throws FileNotFoundException if destination file cannot be opened for writing
    public void open() throws FileNotFoundException
    {
        writer = new PrintWriter(new File(destination));
    }


    //Writes JSON representation of Students to file
    public void write(StudentVerification s)
    {
        JSONObject json = s.toJson();
        saveToFile(json.toString(TAB));
    }

    //Closes writer
    public void close()
    {
        writer.close();
    }

    //Writes string to file
    private void saveToFile(String json)
    {
        writer.print(json);
    }





















}
