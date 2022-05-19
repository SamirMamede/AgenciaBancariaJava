import java.text.NumberFormat;
import java.text.DecimalFormat;

public class Utils {

    static NumberFormat formatandoValores = new DecimalFormat("R$ #,##0.00");
    public static String doubleToString(Double valor){
        return formatandoValores.format(valor);
    }
}
