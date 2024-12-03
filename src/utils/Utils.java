package utils;

public class Utils {
    public static boolean validarEquipaje(int cantidad, double pesoTotal) {
        // Supongamos que el límite es 2 maletas y 30 kg
        if (cantidad <= 2 && pesoTotal <= 30) {
            return true;
        }
        return false;
    }
}
