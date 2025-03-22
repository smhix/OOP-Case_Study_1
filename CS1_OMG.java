import java.util.Scanner;

public class CS1_OMG {
    static String[] COLOR = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "gray", "white"};
    static int[] MULTIPLIERS = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

    public static int search(String[] list, String target) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nEnter the colors of the resistor's three bands, beginning with the band nearest the end.");
            System.out.println("Type the colors in lowercase letters only, NO CAPS.");
            
            System.out.print("Band 1 => ");
            String band1 = scanner.next();
            System.out.print("Band 2 => ");
            String band2 = scanner.next();
            System.out.print("Band 3 => ");
            String band3 = scanner.next();
            
            int digit1 = search(COLOR, band1);
            int digit2 = search(COLOR, band2);
            int multiplierIndex = search(COLOR, band3);
            
            if (digit1 == -1 || digit2 == -1 || multiplierIndex == -1) {
                if (digit1 == -1) System.out.println("Invalid color: " + band1);
                if (digit2 == -1) System.out.println("Invalid color: " + band2);
                if (multiplierIndex == -1) System.out.println("Invalid color: " + band3);
                System.out.print("Do you want to decode another resistor? => ");
                String choice = scanner.next();
                if (!choice.equalsIgnoreCase("y")) {
                    break;
                }
                continue;
            }
            
            int resistanceValue = (digit1 * 10 + digit2) * MULTIPLIERS[multiplierIndex];
            System.out.println("Resistance value: " + (resistanceValue / 1000) + " kilo-ohms");
            
            System.out.print("Do you want to decode another resistor? => ");
            String choice = scanner.next();
            if (!choice.equalsIgnoreCase("y")) {
                break;
            }
        }
        scanner.close();
    }
}
