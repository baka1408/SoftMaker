/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softmakerjava;

import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Baka
 */
public class SettingsPanel extends javax.swing.JFrame
{

    private final JFrame parentFrame;
    
    public SettingsPanel(JFrame parentFrame)
    {
        initComponents();
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.parentFrame = parentFrame;
        GeneralSettingsEditor.settings = new Settings();
        GeneralSettingsEditor.loadSettings();
        this.fillWithCurrentSettings();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        comboPanel = new javax.swing.JPanel();
        spokenCombo = new javax.swing.JComboBox();
        codeCombo = new javax.swing.JComboBox();
        appLanLabel = new javax.swing.JLabel();
        codeLanLabel = new javax.swing.JLabel();
        ipField = new javax.swing.JTextField();
        portField = new javax.swing.JTextField();
        sIpLabel = new javax.swing.JLabel();
        sPortLabel = new javax.swing.JLabel();
        saveBut = new javax.swing.JButton();
        cancelBut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evt)
            {
                formWindowClosing(evt);
            }
        });

        comboPanel.setLayout(new javax.swing.BoxLayout(comboPanel, javax.swing.BoxLayout.PAGE_AXIS));

        spokenCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Polski", "English" }));
        comboPanel.add(spokenCombo);

        codeCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Java", "Python", "C++", "C#", "JavaScript", "Assembly" }));
        comboPanel.add(codeCombo);

        appLanLabel.setText("Application language");

        codeLanLabel.setText("Code language");

        sIpLabel.setText("Server IP");

        sPortLabel.setText("Server port");

        saveBut.setText("Save changes");
        saveBut.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saveButActionPerformed(evt);
            }
        });

        cancelBut.setText("Cancel");
        cancelBut.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cancelButActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(appLanLabel)
                            .addComponent(codeLanLabel)))
                    .addComponent(saveBut))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sPortLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sIpLabel))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(cancelBut)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(appLanLabel)
                            .addComponent(ipField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(sIpLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sPortLabel)
                            .addComponent(codeLanLabel))))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBut)
                    .addComponent(cancelBut))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveButActionPerformed
    {//GEN-HEADEREND:event_saveButActionPerformed
        String codeLang = (String) codeCombo.getSelectedItem();
        String lang = (String) spokenCombo.getSelectedItem();
        String serverIP = (String) ipField.getText();
        Integer serverPort = Integer.parseInt((String) portField.getText());
        
        if (GeneralSettingsEditor.saveSettings(codeLang, lang, serverIP, serverPort))
            JOptionPane.showMessageDialog(this, "Settings saved successfully");
        else
            JOptionPane.showMessageDialog(this, "Settings save failed - check server settings");
    }//GEN-LAST:event_saveButActionPerformed

    private void cancelButActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cancelButActionPerformed
    {//GEN-HEADEREND:event_cancelButActionPerformed
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_cancelButActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
    {//GEN-HEADEREND:event_formWindowClosing
        this.setVisible(false);
        parentFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void fillWithCurrentSettings()
    {
        codeCombo.setSelectedItem(GeneralSettingsEditor.settings.getCodeLanguage());
        spokenCombo.setSelectedItem(GeneralSettingsEditor.settings.getLanguage());
        ipField.setText(GeneralSettingsEditor.settings.getServerIP());
        portField.setText(String.valueOf(GeneralSettingsEditor.settings.getServerPort()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appLanLabel;
    private javax.swing.JButton cancelBut;
    private javax.swing.JComboBox codeCombo;
    private javax.swing.JLabel codeLanLabel;
    private javax.swing.JPanel comboPanel;
    private javax.swing.JTextField ipField;
    private javax.swing.JTextField portField;
    private javax.swing.JLabel sIpLabel;
    private javax.swing.JLabel sPortLabel;
    private javax.swing.JButton saveBut;
    private javax.swing.JComboBox spokenCombo;
    // End of variables declaration//GEN-END:variables
}
