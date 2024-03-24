import java.util.Scanner;
public class DateCalc{
    public static void main (String[] args){

        Scanner keyboard = new Scanner(System.in);

        String case1Input, case3InputA, case4Input, case5InputA, case5InputB;
        int case2Input, case3InputB;
        final int GREGORIAN_YEAR_MINIMUM = 1900, GREGORIAN_YEAR_MAXIMUM = 2150, JULIAN_YEAR_MINIMUM = 1900000, JULIAN_YEAR_MAXIMUM = 2150000; 
        boolean menuLoop = true;

        System.out.println("Welcome to the Date Calculator Machine!");

        while (menuLoop){

            System.out.println("Date Calulcator Operations Menu:");
            System.out.println("[1] Gregorian >> Julian ");
            System.out.println("[2] Julian >> Gregorian ");
            System.out.println("[3] Add or Subtract Days");
            System.out.println("[4] Convert to Readable");
            System.out.println("[5] Distance between Dates");
            System.out.println("[6] Exit Program ");
            System.out.print("Please enter the number of the desired operation: ");

            int menuChoice = keyboard.nextInt();

            switch(menuChoice){

                case 1:
                    int yearSubstringCase1;
                    System.out.println("\nYou Chose: Gregorian To Julian Operation");
                    
                    do {
                        System.out.printf("please enter a date between %2d - %2d in (MM/DD/YYYY) format: ",GREGORIAN_YEAR_MINIMUM, GREGORIAN_YEAR_MAXIMUM);
                        case1Input = keyboard.next();
                        yearSubstringCase1 = Integer.parseInt(case1Input.substring(6));
                    } while (yearSubstringCase1 < GREGORIAN_YEAR_MINIMUM || yearSubstringCase1 > GREGORIAN_YEAR_MAXIMUM);
                    
                    System.out.println("The Date " + case1Input + " In Julian format is: " + DateCalcInfo.convertToJulian(case1Input) + "\n");
                    break;

                case 2:
                    System.out.println("\nYou Chose: Julian to Gegorian");
                    
                    do{
                        System.out.printf("please enter a date between %2d - %2d in (YYYYDDD) format: ",JULIAN_YEAR_MINIMUM, JULIAN_YEAR_MAXIMUM);
                        case2Input = keyboard.nextInt();
                    } while (case2Input < JULIAN_YEAR_MINIMUM || case2Input > JULIAN_YEAR_MAXIMUM);
                    
                    System.out.println("The Date " + case2Input + " In Gregorian format is: " + DateCalcInfo.convertToGregorian(case2Input) + "\n");
                    break;

                case 3:
                    int yearSubstringCase3;
                    System.out.println("\nYou Chose: Add or subtract Days Operation");
                    
                    do {
                        System.out.printf("please enter a date between %2d - %2d in (MM/DD/YYYY) format: ",GREGORIAN_YEAR_MINIMUM, GREGORIAN_YEAR_MAXIMUM);
                        case3InputA = keyboard.next();
                        yearSubstringCase3 = Integer.parseInt(case3InputA.substring(6));
                    } while (yearSubstringCase3 < GREGORIAN_YEAR_MINIMUM || yearSubstringCase3 > GREGORIAN_YEAR_MAXIMUM);
                    
                    System.out.println("Please enter the amount of days your would like to add or subtract");
                    System.out.print("Use a negative number (-) to indicate subtracting: ");
                    case3InputB = keyboard.nextInt();
                    System.out.println("The Date " + case3InputA + " modified by " + case3InputB + " days is: " + DateCalcInfo.addSubtractDays(case3InputA, case3InputB) + "\n");
                    break;

                case 4:
                    int yearSubstringCase4;
                    System.out.println("\nYou Chose: Convert to readable format");
                    
                    do {
                        System.out.printf("Please enter a date between %2d - %2d in (MM/DD/YYYY) format: ",GREGORIAN_YEAR_MINIMUM, GREGORIAN_YEAR_MAXIMUM);
                        case4Input = keyboard.next();
                        yearSubstringCase4 = Integer.parseInt(case4Input.substring(6));
                    } while (yearSubstringCase4 < GREGORIAN_YEAR_MINIMUM || yearSubstringCase4 > GREGORIAN_YEAR_MAXIMUM);
                    
                    System.out.println("The Date " + case4Input + " in readable format is " + DateCalcInfo.formatDateString(case4Input) + "\n");                  
                    break;

                case 5:
                    int yearSubstringCase5A, yearSubstringCase5B;
                    System.out.println("\nYou Chose: Days Between Dates Operation");
                    
                    do{
                        System.out.printf("Please enter a start date between %2d - %2d in (MM/DD/YYYY) format: ",GREGORIAN_YEAR_MINIMUM, GREGORIAN_YEAR_MAXIMUM);
                        case5InputA = keyboard.next();
                        yearSubstringCase5A = Integer.parseInt(case5InputA.substring(6));
                    } while (yearSubstringCase5A < GREGORIAN_YEAR_MINIMUM || yearSubstringCase5A > GREGORIAN_YEAR_MAXIMUM);
                    
                    do {
                        System.out.printf("Please enter a end date between %2d - %2d in (MM/DD/YYYY) format: ",GREGORIAN_YEAR_MINIMUM, GREGORIAN_YEAR_MAXIMUM);
                        case5InputB = keyboard.next();
                        yearSubstringCase5B = Integer.parseInt(case5InputB.substring(6));
                    } while (yearSubstringCase5B < GREGORIAN_YEAR_MINIMUM || yearSubstringCase5B > GREGORIAN_YEAR_MAXIMUM);
                    
                    System.out.println("The difference between " + case5InputA + " & " + case5InputB + " is days is: " + DateCalcInfo.daysDifferent(case5InputA, case5InputB) + "\n");
                    break;

                case 6:
                    System.out.println("Thank you for using the Date Calculator");
                    menuLoop = false;
                    keyboard.close();
                    break;

                default:
                System.out.println("Please enter a number [1] - [6]");
            }
        }
    }
}