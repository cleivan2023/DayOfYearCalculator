public class DayOfYearCalculator {
    public static int toDayOfYear(int[] date) {
        int day = date[0];
        int month = date[1];
        int year = date[2];

        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Verifica si es un año bisiesto
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            daysInMonth[2] = 29;  // Febrero tiene 29 días en años bisiestos
        }

        // Verifica si el mes y el día están dentro de los rangos válidos
        if (month < 1 || month > 12 || day < 1 || day > daysInMonth[month]) {
            throw new IllegalArgumentException("Fecha no válida");
        }

        // Calcula el número del día del año
        int dayOfYear = day;
        for (int i = 1; i < month; i++) {
            dayOfYear += daysInMonth[i];
        }

        return dayOfYear;
    }

    public static void main(String[] args) {
        int[] date = {1, 1, 2000};
        int dayOfYear = toDayOfYear(date);
        System.out.println("Día del año: " + dayOfYear);  // Debería imprimir "1"
    }
}
 /*INSTRUCCIONES
 Calcula qué número de día del año es.

toDayOfYear([1, 1, 2000]) => 1
El argumento pasado a la función es una matriz con el formato [D, M, YYYY], por ejemplo, [1, 2, 2000]para el 1 de febrero de 2000 o [22, 12, 1999]para el 22 de diciembre de 1999.

¡No olvides comprobar si es año bisiesto ! Se deben tener en cuenta tres criterios para identificar los años bisiestos:

El año se puede dividir uniformemente entre 4;
Si el año se puede dividir uniformemente entre 100, NO es un año bisiesto, a menos que;
El año también es divisible por 400. Entonces es un año bisiesto.
  */
