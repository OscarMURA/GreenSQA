package model;
import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Verify{

    private Scanner input=new Scanner(System.in);

    public Calendar verifyDate(){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		boolean correctDate=false;
		String format="";

		do{
		System.out.print("Type the date in format: dd/MM/yyyy: ");
		format=input.nextLine();
		input.nextLine();

		try {
            calendar.setTime(formatDate.parse(format));
			correctDate=true;

        } catch (Exception e) {
            System.out.println("The entered date is invalid");
			correctDate=false;
        }
		}while(!correctDate);
		
		return calendar;
	}

    public Verify(){}

}