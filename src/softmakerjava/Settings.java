/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softmakerjava;

/**
 *
 * @author Baka
 */
public class Settings
{

    public String getLanguage()
    {
        return Language;
    }

    public void setLanguage(String Language)
    {
        this.Language = Language;
    }

    public String getCodeLanguage()
    {
        return CodeLanguage;
    }

    public void setCodeLanguage(String CodeLanguage)
    {
        this.CodeLanguage = CodeLanguage;
    }

    public String getServerIP()
    {
        return ServerIP;
    }

    public void setServerIP(String ServerIP)
    {
        this.ServerIP = ServerIP;
    }

    public int getServerPort()
    {
        return ServerPort;
    }

    public void setServerPort(int ServerPort)
    {
        this.ServerPort = ServerPort;
    }
    
    private String Language;
    private String CodeLanguage;
    private String ServerIP;
    private int ServerPort;
    
}
