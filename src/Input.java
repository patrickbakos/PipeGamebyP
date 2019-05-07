import java.util.HashMap;
import java.util.Scanner;

public class Input {
    public int[] elementForRotation() {
        int[] coordinates = new int[2];
        HashMap<Character, Integer> firstInputMap = new HashMap<>();
        firstInputMap.put('a', 1); firstInputMap.put('b', 2); firstInputMap.put('c', 3);
        firstInputMap.put('d', 4); firstInputMap.put('e', 5);
        Scanner inputHandler = new Scanner(System.in);
        System.out.println("Give me a field to rotate:");
        String rawCoordinates = inputHandler.next();
        if (inputValidation(rawCoordinates)) {
            coordinates[0] = firstInputMap.get(Character.toLowerCase(rawCoordinates.charAt(0))) + 1;
            coordinates[1] = (Integer.parseInt(String.valueOf(rawCoordinates.charAt(1))) + 1);
            System.out.println(coordinates[1]);
            System.out.println(coordinates[0]);
        }
        else {System.out.print("saske");}
        return coordinates;
    }
    public boolean inputValidation(String input) {
        boolean isValid = false;
        char[] firstInputField = new char[]{'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E'};
        char[] secondInputField = new char[]{'1', '2', '3', '4', '5'};
        for (int i=0;i<firstInputField.length;i++) {
            if (firstInputField[i] == input.charAt(0)) isValid = true;
            if (i<5) {
                if (secondInputField[i] == input.charAt(1)) isValid = true;
            }
        }
        return isValid;

    }
}
