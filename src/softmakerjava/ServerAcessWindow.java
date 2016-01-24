/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softmakerjava;

import java.io.File;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Baka
 */
public class ServerAcessWindow extends javax.swing.JFrame
{
    private final JFrame parentFrame;
    
    public ServerAcessWindow(JFrame parentFrame)
    {
        initComponents();
        this.parentFrame = parentFrame;
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        fillFileList();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        filesScrollPanel = new javax.swing.JScrollPane();
        filesList = new javax.swing.JList();
        filesListLabel = new javax.swing.JLabel();
        newFileBut = new javax.swing.JButton();
        delFileBut = new javax.swing.JButton();
        reloadBut = new javax.swing.JButton();
        filenameField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                formWindowClosing(evt);
            }
        });

        filesList.setModel(new javax.swing.AbstractListModel()
        {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        filesScrollPanel.setViewportView(filesList);

        filesListLabel.setText("Your server files");

        newFileBut.setText("Add new file");
        newFileBut.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                newFileButActionPerformed(evt);
            }
        });

        delFileBut.setText("Delete file");
        delFileBut.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                delFileButActionPerformed(evt);
            }
        });

        reloadBut.setText("Reload files");
        reloadBut.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                reloadButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filesScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(newFileBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(delFileBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(filenameField))
                .addGap(0, 12, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(filesListLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(reloadBut)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(filesListLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filesScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(filenameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newFileBut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delFileBut)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reloadBut)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
        parentFrame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    private void reloadButActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_reloadButActionPerformed
    {//GEN-HEADEREND:event_reloadButActionPerformed
        fillFileList();
    }//GEN-LAST:event_reloadButActionPerformed

    private void delFileButActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_delFileButActionPerformed
    {//GEN-HEADEREND:event_delFileButActionPerformed
        String titleToDel = (String) filesList.getSelectedValue();
        if (ServerHandler.deleteFromServer(titleToDel))
        {
            JOptionPane.showMessageDialog(this, "File has been deleted successfully!");
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Unable to delete file!");
        }
    }//GEN-LAST:event_delFileButActionPerformed

    private void newFileButActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_newFileButActionPerformed
    {//GEN-HEADEREND:event_newFileButActionPerformed
        JFileChooser fileSelection = new JFileChooser("/");
        fileSelection.setApproveButtonText("Send file");
        fileSelection.showSaveDialog(parentFrame);
        File selectedFile = fileSelection.getSelectedFile();
        
        if (selectedFile.isFile())
            if(ServerHandler.saveOnServer(selectedFile, filenameField.getText()))
            {
                JOptionPane.showMessageDialog(this, "File has been uploaded successfully!");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Unable to upload!");
            }
                
    }//GEN-LAST:event_newFileButActionPerformed

    
    private void fillFileList()
    {
        filesList.removeAll();
        
        DefaultListModel<String> titlesList = new DefaultListModel<String>();
        
        ArrayList<String> fileTitles = ServerHandler.getFileTitles();
        if (fileTitles != null)
        {
            for (String title : fileTitles)
            {
                titlesList.addElement(title);
            }

            filesList.setModel(titlesList);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delFileBut;
    private javax.swing.JTextField filenameField;
    private javax.swing.JList filesList;
    private javax.swing.JLabel filesListLabel;
    private javax.swing.JScrollPane filesScrollPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton newFileBut;
    private javax.swing.JButton reloadBut;
    // End of variables declaration//GEN-END:variables
}
