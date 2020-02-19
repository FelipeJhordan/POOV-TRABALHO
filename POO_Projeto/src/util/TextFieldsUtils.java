package util;

import java.awt.Component;
import java.awt.Container;
import java.util.List;
import javax.swing.text.JTextComponent;

public class TextFieldsUtils {

    public void clearTextFields(Container container) {
        for (Component comp : container.getComponents()) {
            if (comp instanceof JTextComponent) {
                ((JTextComponent) comp).setText("");
            } else if (comp instanceof Container) {
                clearTextFields((Container) comp);
            }
        }
    }

    public List<String> getTfs(Container container,List<String> listaTf) {
         for (Component comp : container.getComponents()) {
            if (comp instanceof JTextComponent) {
                listaTf.add(((JTextComponent) comp).getText());
            } else if (comp instanceof Container) {
                getTfs((Container) comp,listaTf);
            }
        
}
         return listaTf;
    }
    public boolean verificandoVazios(List<String> listaTf){
        int i = 0;
        for (String string : listaTf) {
            if(string.trim().equals("")){
               i++; 
            }
        }
        if(i > 1){
            return true;
        }
        return false;
    }
}