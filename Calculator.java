import java.util.Scanner;

public class Calculator{

    public static boolean isNumeric(String string) {
        if(string == null || string.equals("")) {
            return false;
        }
        try {
            Double.parseDouble(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double lastNumber = 0, newNumber;
        double result = 0;
        String operator = null;

        System.out.println("Welcome in Calculator! Everything separate by Enter");
        System.out.println("You can overwrite numbers and operators");
        System.out.println("Use E to exit");
        System.out.println("Let's go!\n\n");
        System.out.println("0");

        String value = scanner.next();

        while (true) {
            if (isNumeric(value)) {
                lastNumber = Double.parseDouble(value);
                while (true) {
                    String nextValue = scanner.next();
                    if (isNumeric(nextValue)) {
                        lastNumber = Double.parseDouble(nextValue);
                    } else {
                        value = nextValue;
                        break;
                    }
                }
            } else {
                while (true) {
                    if (isNumeric(value)) {
                        newNumber = Double.parseDouble(value);
                        if (operator != null) {
                            switch (operator) {
                                case "+" -> result = lastNumber + newNumber;
                                case "-" -> result = lastNumber - newNumber;
                                case "*" -> result = lastNumber * newNumber;
                                case "/" -> result = lastNumber / newNumber;
                                case "%" -> result = lastNumber % newNumber;
                            }
                            System.out.println("= " + result);
                            lastNumber = result;
                            operator = null;
                            break;
                        }
                    } else {
                        switch (value) {
                            case "+", "-", "*", "/", "%" -> operator = value;
                            case "s" -> {
                                result = Math.sqrt(lastNumber);
                                System.out.println("= " + result);
                                lastNumber = result;
                            }
                            case "**" -> {
                                result = lastNumber * lastNumber;
                                System.out.println("= " + result);
                                lastNumber = result;
                            }
                            case "E", "e" -> {
                                System.out.println("Bye bye!");
                                System.exit(0);
                            }
                            default -> System.out.print("Sorry, I understand only + - * / % ** E, so try again\n");
                        }
                    }
                    value = scanner.next();
                }
            }
        }
    }
}
