/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softmakerjava;

import java.util.ArrayList;

/**
 *
 * @author Baka
 */
public class LoginForm extends javax.swing.JFrame
{
    private ArrayList<User> userList;
    
    
    public LoginForm()
    {
        initComponents();
        userList = new ArrayList<>();
        
        UserRepository usrRepo = new UserRepository();
        usrRepo.LoadUser();
        userList.addAll(usrRepo.users);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        loginComponenetsPanel = new javax.swing.JPanel();
        usernameField = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        infoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(800, 505));

        usernameField.setToolTipText("Type username");
        usernameField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                usernameFieldActionPerformed(evt);
            }
        });

        loginButton.setText("Login");
        loginButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                loginButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout loginComponenetsPanelLayout = new javax.swing.GroupLayout(loginComponenetsPanel);
        loginComponenetsPanel.setLayout(loginComponenetsPanelLayout);
        loginComponenetsPanelLayout.setHorizontalGroup(
            loginComponenetsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginComponenetsPanelLayout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addGroup(loginComponenetsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginComponenetsPanelLayout.createSequentialGroup()
                        .addComponent(loginButton)
                        .addGap(216, 216, 216))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginComponenetsPanelLayout.createSequentialGroup()
                        .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(189, 189, 189))))
        );
        loginComponenetsPanelLayout.setVerticalGroup(
            loginComponenetsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginComponenetsPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(usernameField, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginButton)
                .addContainerGap())
        );

        infoLabel.setText("Enter username");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginComponenetsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(infoLabel)
                .addGap(215, 215, 215))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(infoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginComponenetsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_usernameFieldActionPerformed
    {//GEN-HEADEREND:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void loginButtonMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_loginButtonMouseClicked
    {//GEN-HEADEREND:event_loginButtonMouseClicked
        for (int i=0; i < userList.size(); i++)
        {
            if (usernameField.getText().equals(userList.get(i).getName()))
            {
                loginAction(userList.get(i));
            }
        }
    }//GEN-LAST:event_loginButtonMouseClicked

    
    private void loginAction(User userObj)
    {
        MainFrame menuFrame = new MainFrame(userObj);
        menuFrame.setVisible(true);
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel infoLabel;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginComponenetsPanel;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
