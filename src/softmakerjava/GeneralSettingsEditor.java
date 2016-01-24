/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softmakerjava;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Baka
 */
public class GeneralSettingsEditor
{
    public static Settings settings;
    
    public static User currentUser;
    
    private static Connection serverConnection;
    
    protected static void changeLanguage(String lang)
    {
        if (lang == "English" || lang == "Polish")
            settings.setLanguage(lang);
    }
    
    protected static boolean saveSettings(String codeLanguage, String language, String serverIP, Integer serverPort)        // Upload user's settings to a DB
    {
        try
        {
            setUpConnection();
            Statement command = serverConnection.createStatement();
            String commandStr = "UPDATE `Settings` " +
                                "SET `codeLanguage` = '" + codeLanguage + "', `language` = '" + language + "', " +
                                "`serverIP` = '" + serverIP + "', `serverPort` = '" + serverPort + "'" +
                                "WHERE `username` = '" + GeneralSettingsEditor.currentUser.getName() + "'";

            command.executeUpdate(commandStr);
            closeConnection();
            changeLanguage(language);
            
            settings.setCodeLanguage(codeLanguage);
            settings.setLanguage(language);
            settings.setServerIP(serverIP);
            settings.setServerPort(serverPort);
            
            return true;
        }
        
        catch(SQLException exc)
        {
            System.err.println("Failed to save settings : " + exc.getLocalizedMessage());
            return false;
        }
    }
    
    protected static void loadSettings()
    {
        try
        {
            setUpConnection();
            Statement command = serverConnection.createStatement();
            String commandStr = "SELECT * FROM Settings " +
                                "WHERE `username` = '" + GeneralSettingsEditor.currentUser.getName() + "'";

            ResultSet result = command.executeQuery(commandStr);
            while (result.next())
            {
                settings.setCodeLanguage(result.getString("codeLanguage"));
                settings.setLanguage(result.getString("language"));
                settings.setServerIP(result.getString("serverIP"));
                settings.setServerPort(result.getInt("serverPort"));
            }
            result.close();
            closeConnection();
        }
        
        catch(SQLException exc)
        {
            System.err.println("Failed to load settings " + exc.getLocalizedMessage());
        }
    }
    
    protected static void resetToDefault()
    {
        settings.setCodeLanguage("Java");
        settings.setLanguage("English");
        settings.setServerIP("127.0.0.1");
        settings.setServerPort(3306);
    }
    
     private static void setUpConnection()
    {
        
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
