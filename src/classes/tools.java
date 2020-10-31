/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import rojeru_san.RSMPassView;
import rojeru_san.RSMTextFull;

/**
 *
 * @author Administrateur
 */
public class tools {

    public static boolean checkTextFields(JTextField... txtField) {
        boolean isEmpty = true;
        for (JTextField txt : txtField) {
            isEmpty &= !txt.getText().trim().isEmpty();
        }
        return !isEmpty;
    }

    public static boolean checkPanelElements(JPanel panel) {
        boolean isEmpty = true;
        Component components[] = panel.getComponents();
        for (Component compo : components) {
            if (compo.getClass().getName().contains("JComboBox") && new JComboBox(compo.toString().split(" ")).getSelectedItem().toString().substring(compo.toString().indexOf("selectedItemReminder=") + "selectedItemReminder=".length(), compo.toString().length() - 1).isEmpty()) {
                isEmpty &= false;
            } else if (compo.getClass().getName().contains("JTextField") && ((JTextField) compo).getText().trim().isEmpty()) {
                isEmpty &= false;
            } else if (compo.getClass().getName().contains("RSMTextFull") && ((RSMTextFull) compo).getText().trim().isEmpty()) {
                isEmpty &= false;
            } else if (compo.getClass().getName().contains("RSMPassView") && ((RSMPassView) compo).getText().trim().isEmpty()) {
                isEmpty &= false;
            }
        }
        return isEmpty;
    }

//    public static String getText(Object obj) {
//        String object = "";
//        if (obj.getClass().getName().contains("JTextField")) {
//            object = ((JTextField) obj).getText().trim();
//        } else if (obj.getClass().getName().contains("RSMTextFull")) {
//            object = ((RSMTextFull) obj).getText().trim();
//        } else if (obj.getClass().getName().contains("RSMPassView")) {
//            object = ((RSMPassView) obj).getText().trim();
//        } else if (obj.getClass().getName().contains("JLabel")) {
//            object = ((JLabel) obj).getText().trim();
//        } else if (obj.getClass().getName().contains("JComboBox")) {
//            object = new JComboBox(obj.toString().split(" ")).getSelectedItem().toString().substring(obj.toString().indexOf("selectedItemReminder=") + "selectedItemReminder=".length(), obj.toString().length() - 1).trim();
//        }
//        return object;
//    }
//}
    public static Object forSwitchStatemnt(Object obj){
        return obj.getClass().getName();
    }
    public static String getText(Object obj) {
        String object = "";
                
        if (obj.getClass().getName().contains("JTextField")) {
            object = ((JTextField) obj).getText().trim();
        } else if (obj.getClass().getName().contains("RSMTextFull")) {
            object = ((RSMTextFull) obj).getText().trim();
        } else if (obj.getClass().getName().contains("RSMPassView")) {
            object = ((RSMPassView) obj).getText().trim();
        } else if (obj.getClass().getName().contains("JLabel")) {
            object = ((JLabel) obj).getText().trim();
        } else if (obj.getClass().getName().contains("JComboBox")) {
            object = new JComboBox(obj.toString().split(" ")).getSelectedItem().toString().substring(obj.toString().indexOf("selectedItemReminder=") + "selectedItemReminder=".length(), obj.toString().length() - 1).trim();
        }
        return object;
    }
}
