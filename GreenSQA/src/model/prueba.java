package model;

import java.util.Calendar;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class prueba{

    private static Scanner reader=new Scanner(System.in);
    private static int[] month=new int[6];

    public static void main(String[] args) {

        SimpleDateFormat formatD = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();

        String hola="Como esta senior #Jhon Jairo# Loca marias";

        System.out.println(  capsuleHashtag(hola) );


       

		boolean correctDate=false;
        Calendar startDate[]=new Calendar[6];
		Calendar endDate[]=new Calendar[6];
		Calendar x=Calendar.getInstance();
        String format="22/01/2023";

		
		
        for (int i = 0; i < endDate.length; i++) {

            month[i]=i+1;
            startDate[i]=Calendar.getInstance();
            endDate[i]=Calendar.getInstance();
        }

        

     
        startDate[0]=calendar;
        System.out.println(0+". "+calendar.getTime());
        endDate[0]=startDate[0];
		endDate[0].add(Calendar.MONTH,month[0]);
        System.out.println(0+". "+endDate[0].getTime());

		for (int j = 1; j < month.length; j++) {
		
		startDate[j]=endDate[j-1];
        System.out.println(j+". "+startDate[j].getTime());
		x=startDate[j];

		x.add(Calendar.MONTH, month[j]);
		endDate[j]=x;
        System.out.println(j+". "+endDate[0].getTime());

		
		
		} 
    }

        	public static String capsuleHashtag(String description) {
		String hashtag = "si no funciona";
		int init = -1;
		int finaL = -1;
		init = description.indexOf("#");
		finaL = description.indexOf("#", init + 1);

		if (init != -1 && finaL != -1) {
			hashtag = description.substring(init + 1, finaL);
		}

		return hashtag;
	}



}