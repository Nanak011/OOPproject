package RISHI;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class adminCommand {
    Scanner scan=new Scanner(System.in);
    public static Map<String, String> enterWeatherInfo(Scanner scan) {
            Map<String, String> weatherMap = new HashMap<>();
            String[] dayOfWeek = {"sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday"};


            for (String day : dayOfWeek) {
                System.out.println("\nEnter weather for " + day + ":");
                String weather = scan.nextLine();
                weatherMap.put(day, weather);
            }
            return weatherMap;
        }
    }

