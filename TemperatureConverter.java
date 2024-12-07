//import the scanner class that allows me to collect user input
import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {

        //introduce a Scanner object to accept user input
        Scanner conversion = new Scanner(System.in);
        //ask the user for their preferred conversion stream
        System.out.println("""
          \nTEMPERATURE CONVERTER\s\s
          What conversion would you like to do?\s
            1. Celsius => Fahrenheit\s
            2. Fahrenheit => Celsius\s
          Enter either '1' or '2'
          """);

        //try-catch throws an error for non-numerical inputs
        try {
            int i = conversion.nextInt();

            //validate the input by setting it to 0 if anything other than 1 or 2 is entered
            int input = i == 1 || i == 2 ? i : 0;

            //stores the selected scale name
            String scale = input == 1 ? "Celsius" : "Fahrenheit";

            if (input != 0) { /* ie: if input is valid */
                Scanner temperatureInput = new Scanner(System.in);
                //request for the temperature to be converted
                System.out.printf("\nTemperature to convert (in %s): ", scale);
                int temperature = temperatureInput.nextInt();

                //create variable to hold the conversion return value
                int solution = converter(input, temperature);

                //handles units
                String iUnit = input == 1 ? "°C" : "°F";
                String sUnit = input == 1 ? "°F" : "°C";
                //'input Unit' and 'solution Unit'

                //formatted string
                System.out.printf("\n%d%s converts to %d%s\n", temperature, iUnit, solution, sUnit);
            } else {
                //output when user input is invalid
                System.out.println("ERROR: INVALID INPUT!");
            }
        } catch (Exception e) {
            System.out.println("ERROR: INVALID (NON-NUMERICAL) INPUT!");
        }
    }
    //this method handles my conversions. This is "Abstraction" :)
    private static int converter(int a, int b) {
        return a == 1 ? (b * 9 / 5) + 32 : (b - 32) * 5 / 9;
        //the converter first checks which conversion it will be handling
        //that is: Celsius to Fahrenheit if a == 1 and vice versa otherwise
        //it then uses the appropriate branch of the ternary operation to convert
        //it returns the solution value as an integer
    }
}