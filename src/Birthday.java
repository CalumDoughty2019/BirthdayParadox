import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Birthday {

    //variables
    private int n;
    private ArrayList<String> birthdays;
    private int count;
    private int testNumber;

    //constructor
    public Birthday(){
        birthdays = new ArrayList<String>();
        count = 0;
        testNumber = 0;
    }

    //Run Birthday comparison
    public void run(){
        count = 0;
        System.out.println("--------------------------------------------------------");
        System.out.println("TestNo: " + ++testNumber);
        System.out.println("Please enter no. of birthdays to include: ");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        birthdayDates(n-1);
        compareDates(birthdays);

        System.out.println("");
        this.run();
    }


    //Generate random day/month/year between (probably will remove year for comparison)
    public static int randomBetween(int start, int end){
        //System.out.println(start + (int)Math.round(Math.random() * (end - start)));
        return start + (int)Math.round(Math.random() * (end - start));
    }

    //Add dates to ArrayList
    public ArrayList<String> birthdayDates(int n){
        for(int i = 0; i <= n; i++){
            int day = randomBetween(1, 31);
            int month = randomBetween(1, 12);
            int year = randomBetween(1950, 2010);
            String dob = String.format("%02d",day) + "/" + String.format("%02d",month) + "/" + Integer.toString(year) + "";
            birthdays.add(dob);
            //System.out.println(dob);
        }
        return birthdays;
    }


    //Add dates to ArrayList
    public void compareDates(ArrayList<String> birthdays){
        ArrayList<String> comparisonList = new ArrayList<>();
        comparisonList.addAll(birthdays);

        for(int i = 0; i < birthdays.size(); i++){
            String birthday = birthdays.get(i);
            comparisonList.remove(0); //remove value that is currently being checked (if we check 01012010 against 01012010 then obviously its the same)
            String updatedBirthday = birthday.substring(0, 5);
            for(int j = 0; j < comparisonList.size(); j++){
                String comparator = comparisonList.get(j);
                String updatedComparator = comparator.substring(0, 5);
                if(updatedBirthday.contentEquals(updatedComparator)){
                    count++;
                    System.out.println(updatedBirthday + " : is a match");
                }
            }
            //System.out.println(updatedBirthday);
        }
        System.out.println("Total matches: " + count);
    }
}
