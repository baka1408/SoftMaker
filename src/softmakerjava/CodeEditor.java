/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softmakerjava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 *
 * @author Baka
 */
public class CodeEditor
{
    
    public File openedFile;
    
    public Boolean saveFile(String content)
    {
        try
        {
            OutputStreamWriter strWriter = new FileWriter(openedFile);
            strWriter.write(content);
            strWriter.close();
            
            return true;
        }
        catch (IOException exc)
        {
            System.err.println("Error while saving file : " + exc.getLocalizedMessage());
            return false;
        }
    }
    
    public boolean CreateNewFile(String name)
    {
        openedFile = new File(name);
        try
        {
            return openedFile.createNewFile();
        }
        catch(IOException exc)
        {
            return false;
        }
    }
    
    public void OpenFile(String name, boolean isLocal)
    {
        File file = null;
        if (isLocal)
        {
            file = new File("Saved files/" + name);
        }
        else
        {
            file = ServerHandler.loadFromServer(name);
        }
        
        if (file.isFile())
            openedFile = file;
        else
        {
            openedFile = ServerHandler.loadFromServer(name);
        }
    }
    
    public String GetFileContent()
    {
        return CheckSyntax();
    }
    
    public String CheckSyntax()
    {
        // Not critical requirement
        
        Scanner filereader = null;
        try
        {
            filereader = new Scanner(openedFile);
        }
        catch (FileNotFoundException exc)
        {
            return "FILE NOT FOUND! CRITICAL ERROR !";
        }
        
        // Some code-check algorithm should be placed here
        
        String codeStr = "";
        while(filereader.hasNext())
            codeStr += filereader.nextLine();
        
        return codeStr;
    }
    
}
