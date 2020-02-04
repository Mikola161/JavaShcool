import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Scanner in = new Scanner(Paths.get("c:\\Temp\\example.txt"), "UTF-8");

        String stringResult = "";
        String string = scanner.nextLine();
        int count = scanner.nextInt();
//      int temp;
//      int position = 0;
//      int newPosition = 0;
        if (count != 0) {
            string = string + ",";
            String[] arraySource = string.split(",");
            for(int i = 0; i < arraySource.length; i++) {
                if (arraySource[i].length() >= count) {
                    if (stringResult == "") {
                        stringResult = stringResult + arraySource[i];
                    } else {
                        stringResult = stringResult + "," +arraySource[i];
                    }
                }
            }
//
//
//
//            while ((newPosition + 1) != string.length()) {
//                newPosition = string.indexOf(",", position + 1);
//                temp = newPosition - (position + 1);
//                if (temp >= count) {
//                    if (stringResult == "") {
//                        stringResult = stringResult + string.substring(position + 1, newPosition);
//                    }
//                    else stringResult = stringResult + "," + string.substring(position + 1, newPosition);
//                }
//                position = newPosition;
//            }
        }
        else stringResult = string;
        System.out.println(stringResult);
    }
}