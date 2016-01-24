/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softmakerjava;

import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Baka
 */
public class CodeViewer extends javax.swing.JFrame
{

    private final JFrame parentFrame;
    
    private CodeEditor editor;
    
    public CodeViewer(JFrame parentFrame)
    {
        initComponents();
        this.parentFrame = parentFrame;
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        fillFileList();
        editor = new CodeEditor();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane1 = new javax.swing.JScrollPane();
        codeArea = new javax.swing.JTextArea();
        buttons1Panel = new javax.swing.JPanel();
        newBut = new javax.swing.JButton();
        closeBut = new javax.swing.JButton();
        saveBut = new javax.swing.JButton();
        buttons2Panel = new javax.swing.JPanel();
        openBut = new javax.swing.JButton();
        filesCombo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                formWindowClosing(evt);
            }
        });

        codeArea.setColumns(20);
        codeArea.setRows(5);
        jScrollPane1.setViewportView(codeArea);

        buttons1Panel.setLayout(new javax.swing.BoxLayout(buttons1Panel, javax.swing.BoxLayout.LINE_AXIS));

        newBut.setText("New file");
        newBut.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                newButActionPerformed(evt);
            }
        });
        buttons1Panel.add(newBut);

        closeBut.setText("Close file");
        closeBut.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                closeButActionPerformed(evt);
            }
        });
        buttons1Panel.add(closeBut);

        saveBut.setText("Save file");
        saveBut.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saveButActionPerformed(evt);
            }
        });
        buttons1Panel.add(saveBut);

        buttons2Panel.setLayout(new javax.swing.BoxLayout(buttons2Panel, javax.swing.BoxLayout.LINE_AXIS));

        openBut.setText("Open selected file");
        openBut.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                openButActionPerformed(evt);
            }
        });
        buttons2Panel.add(openBut);

        filesCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        buttons2Panel.add(filesCombo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttons1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149)
                        .addComponent(buttons2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttons2Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttons1Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openButActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_openButActionPerformed
    {//GEN-HEADEREND:event_openButActionPerformed
        String fileName = (String) filesCombo.getSelectedItem();
        File file = ServerHandler.loadFromServer(fileName);
        editor.openedFile = file;
        codeArea.setText(editor.GetFileContent());
    }//GEN-LAST:event_openButActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
        this.setVisible(false);
        parentFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void saveButActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveButActionPerformed
    {//GEN-HEADEREND:event_saveButActionPerformed
        if (editor.saveFile(codeArea.getText()))
            JOptionPane.showMessageDialog(this, "Saved successfully");
        else
            JOptionPane.showMessageDialog(this, "Failed to save");

    }//GEN-LAST:event_saveButActionPerformed

    private void closeButActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_closeButActionPerformed
    {//GEN-HEADEREND:event_closeButActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_closeButActionPerformed

    private void newButActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_newButActionPerformed
    {//GEN-HEADEREND:event_newButActionPerformed
        codeArea.setText("");
        String fileName = JOptionPane.showInputDialog("Enter name for new file", "newFile");
        editor.CreateNewFile(fileName);
    }//GEN-LAST:event_newButActionPerformed

    private void fillFileList()
    {
        ArrayList<String> files = ServerHandler.getFileTitles();
        filesCombo.removeAllItems();
        
        if (files != null)
        {
            for (String item : files)
            {
                filesCombo.addItem(item);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttons1Panel;
    private javax.swing.JPanel buttons2Panel;
    private javax.swing.JButton closeBut;
    private javax.swing.JTextArea codeArea;
    private javax.swing.JComboBox filesCombo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newBut;
    private javax.swing.JButton openBut;
    private javax.swing.JButton saveBut;
    // End of variables declaration//GEN-END:variables
}
