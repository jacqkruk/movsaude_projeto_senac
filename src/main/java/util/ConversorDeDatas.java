package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public final class ConversorDeDatas {

    public ConversorDeDatas() {
    }
    
    public static Date converteStringParaDate(String dataString) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            return formato.parse(dataString);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Data não foi convertida corretamente.");
            return null;
        }
    }
    
    public static String converteDateParaString(Date data) {
        if (data == null) return "";
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(data);
    }
}
