package com.pfrñfe;

import com.pfrñfe.view.auth.LoginView;

public class Main {
    public static void main(String args[]){
        java.awt.EventQueue.invokeLater(() -> new LoginView().setVisible(true));
    }
}
