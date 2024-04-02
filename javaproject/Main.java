package RISHI;
import java.util.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();

        users.add(new User(1, "admin", "admin"));
        users.add(new User(2, "General", "General"));

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter 1 for Admin user && 2 for general user");
        String userType = scan.nextLine();
        if (userType.equals("1")) {
            System.out.println("\nEnter admin username:");
            String username = scan.nextLine();
            username=username.replaceAll("\\s","");

            System.out.println("\nEnter admin password:");
            String password = scan.nextLine();
            password=password.replaceAll("\\s","");

            boolean isAdminValid = false;
            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    isAdminValid = true;
                    break;
                }
            }
            if (isAdminValid) {
                System.out.println("\nAdmin logged successfully!!!!");
                Map<String, String> weatherMap = adminCommand.enterWeatherInfo(scan);
                System.out.println("\nWeather data entered by admin successfully! Now login as a general user to check the Weather-info.");
                generalUserLogin(scan, weatherMap);
            } else {
                System.out.println("\nInvalid admin credentials.\tExiting....");
            }
        } else if (userType.equals("2")) {
            generalUserLogin(scan, null);
        } else {
            System.out.println("\nInvalid user type.\tExiting...");
        }
    }



    public static void generalUserLogin(Scanner scan, Map<String, String> weatherMap) {
        System.out.println("\nEnter general username:");
        String username = scan.nextLine();

        System.out.println("\nEnter general password:");
        String password = scan.nextLine();

        boolean isGeneralValid = false;
        if (username.equals("general")) {
            isGeneralValid = true;
        }
        if (isGeneralValid) {
            System.out.println("\nGeneral user logged in successfully!!!");
            if (weatherMap != null) {
                while (true) {
                    System.out.println("\nEnter the day of the week to check the weather (or type 'q/Q' to Quit):");
                    String day = scan.nextLine();
                    day=day.toLowerCase();
                    if (day.equalsIgnoreCase("q")) {
                        break;
                    } else if (weatherMap.containsKey(day)) {
                        System.out.println("\nWeather for " + day + ": " + weatherMap.get(day));
                    } else {
                        System.out.println("\nInvalid day. please enter valid day for week.");
                    }
                }
            } else {
                System.out.println("\nInvalid general user credentials.\tExiting...");
            }
        }
    }
}

