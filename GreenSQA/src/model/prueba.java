package model;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Calendar;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class prueba {

    private static Scanner reader = new Scanner(System.in);
    private static int[] month = new int[6];

    public static void main(String[] args) {

        SimpleDateFormat formatD = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        String[] prueba = new String[20];
        String hola = "Como esta senior #Jhon Jairo# #Loca# como esta #Maria#";
        prueba = capsuleHashtag(hola, prueba);
        String hola1 = " comprobar #prueba 2# vamos con esta otra palabra #nueva palabra# y #cara vanbiche# ";
        prueba = capsuleHashtag(hola1, prueba);

        for (String string : prueba) {
            System.out.println(string);
        }

        boolean correctDate = false;
        Calendar startDate[] = new Calendar[6];
        Calendar endDate[] = new Calendar[6];
        Calendar x = Calendar.getInstance();
        String format = "22/01/2023";

        for (int i = 0; i < endDate.length; i++) {

            month[i] = i + 1;
            startDate[i] = Calendar.getInstance();
            endDate[i] = Calendar.getInstance();
        }

        startDate[0] = calendar;
        System.out.println(0 + ". " + calendar.getTime());
        endDate[0] = startDate[0];
        endDate[0].add(Calendar.MONTH, month[0]);
        System.out.println(0 + ". " + endDate[0].getTime());

        for (int j = 1; j < month.length; j++) {

            startDate[j] = endDate[j - 1];
            System.out.println(j + ". " + startDate[j].getTime());
            x = startDate[j];

            x.add(Calendar.MONTH, month[j]);
            endDate[j] = x;
            System.out.println(j + ". " + formatD.format(endDate[0].getTime()));

        }
    }

    public static String[] capsuleHashtag(String description, String[] wordKey) {
        int finaL = 0, init = 0, contador = 0, pos = 0;

        for (int i = 0; i < description.length(); i++) {
            if (description.charAt(i) == '#') {
                contador++;

                if (contador % 2 == 0) {
                    init = description.indexOf("#", finaL);
                    finaL = description.indexOf("#", init + 1);
                    pos=getFirstValidPosition(wordKey);
                    wordKey[pos] = description.substring(init + 1, finaL);
                    finaL += 2;
                }

            }
        }

        return wordKey;

    }

    public static int getFirstValidPosition(String[] wordKay) {
        int pos = -1;
        boolean isFound = false;
        for (int i = 0; i < wordKay.length && !isFound; i++) {
            if (wordKay[i] == null) {
                pos = i;
                isFound = true;
            }
        }
        return pos;
    }

    public static String[] extraerHashtags(String texto) {
        String regex = "#(.*?)#";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        int i = 0;
        String[] hashtags = new String[texto.length()]; // crea un arreglo del tamaño del texto, esto puede ser optimizado

        while (matcher.find()) {
            hashtags[i] = matcher.group(1);
            i++;
        }
        // crea un nuevo arreglo del tamaño correcto y copia los hashtags
        String[] result = new String[i];
        System.arraycopy(hashtags, 0, result, 0, i);
        return result;
    }
}