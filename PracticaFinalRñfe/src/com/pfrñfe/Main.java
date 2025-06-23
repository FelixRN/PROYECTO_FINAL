package com.pfrñfe;

import com.pfrñfe.view.auth.LoginView;
import java.io.IOException;
import java.sql.SQLException;


public class Main {
    public static void main(String args[]){
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new LoginView().setVisible(true);
            } catch (ClassNotFoundException ex) {
                System.getLogger(Main.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            } catch (SQLException ex) {
                System.getLogger(Main.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            } catch (IOException ex) {
                System.getLogger(Main.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        });
    }
}
