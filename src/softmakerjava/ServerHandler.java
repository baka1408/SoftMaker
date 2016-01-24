/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softmakerjava;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author Baka
 */
public class ServerHandler
{
    private static Connection serverConnection;
    
    protected static Boolean saveOnServer(File file, String fileName)
    {
        
        String content = "";
        
        try
        {
            Scanner strReader = new Scanner(file);

            while (strReader.hasNext())
            {
               content += strReader.nextLine(); 
            }
        }
        catch (IOException exc)
        {
            System.err.println("Error while reading from a file : " + exc.getLocalizedMessage());
        }
        
        setUpConnection();
        
        try
        {
            Statement command = serverConnection.createStatement();
            String commandStr = "INSERT INTO `Files` (username,filename,content)" +
                                "VALUES ('" + GeneralSettingsEditor.currentUser.getName() + "', " +
                                "'" + fileName + "', '" + content +"')";

            command.executeUpdate(commandStr);
        }
        catch(SQLException exc)
        {
            System.err.println("Error while executing save file query : " + exc.getLocalizedMessage());
            return false;
        }

        closeConnection();
        return true;
    }
    
    protected static File loadFromServer(String fileName)
    {
        try
        {
            setUpConnection();
            Statement command = serverConnection.createStatement();
            String commandStr = "SELECT `content` FROM `Files` " +
                                "WHERE `username` = '" + GeneralSettingsEditor.currentUser.getName() + "'" +
                                "AND `filename` = '" + fileName + "'";

            ResultSet result = command.executeQuery(commandStr);
            result.next();
            String fileContent = result.getString("content");
            closeConnection();
            
            File serverFile = new File(System.getProperty("user.dir") + "/currentFile");
            try
            {
                OutputStreamWriter strWriter = new FileWriter(serverFile);

                strWriter.write(fileContent);
                strWriter.close();
            }
            catch (IOException exc)
            {
                System.err.println("Error while writting to a file : " + exc.getLocalizedMessage());
            }
            
            return serverFile;
        }
        catch(SQLException exc)
        {
            System.err.println("Failed to load file " + exc.getLocalizedMessage());
            return null;
        }
    }
    
    protected static Boolean deleteFromServer(String fileName)
    {
        try
        {
            setUpConnection();
            Statement command = serverConnection.createStatement();
            String commandStr = "DELETE FROM `Files` " +
                                "WHERE `username` = '" + GeneralSettingsEditor.currentUser.getName() + "'" +
                                "AND `filename` = '" + fileName + "'";

            command.executeUpdate(commandStr);
            closeConnection();
            return true;
        }
        catch(SQLException exc)
        {
            System.err.println("Failed to delete file : " + exc.getLocalizedMessage());
            return false;
        }
    }
    
    protected static ArrayList<String> getFileTitles()
    {
        try
        {
            setUpConnection();
            Statement command = serverConnection.createStatement();
            String commandStr = "SELECT `filename` FROM `Files`" +
                                "WHERE `username` = '" + GeneralSettingsEditor.currentUser.getName() + "'";

            ResultSet result = command.executeQuery(commandStr);
            ArrayList<String> resultList = new ArrayList<>();
            
            while(result.next())
            {
                resultList.add(result.getString("filename"));
            }
            
            return resultList;
        }
        catch(SQLException exc)
        {
            System.err.println("Failed to load file : " + exc.getLocalizedMessage());
            return null;
        }
    }
    
    private static void setUpConnection()
    {
        Settings tmpSettings = GeneralSettingsEditor.settings;
        
        try
        {
        serverConnection = DriverManager.getConnection("jdbc:mysql://mysql614.admin.strefa.pl:3306/db1105534_SoftMaker",
                "u1105534_baka", "_mediolan1408");
        }
        catch(SQLException exc)
        {
            System.err.println("Cannot connect to a DB.");
        }
    }
    
    private static void closeConnection()
    {
        try
        {
            serverConnection.close();
        }
        catch(SQLException exc)
        {
            System.err.println("Error while commiting : " + exc.getLocalizedMessage());
        }
    }
}
