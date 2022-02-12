package javaphase1.Lesson2Assignment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FilterEmailAddress {

    private String[] emailAddressArray;

    public FilterEmailAddress() {
        this.emailAddressArray = new String[]{"joey@gmail.com ", "Jack@hotmail.com", "Jim@github.com", "John@hotdog.com", "Ajoy@gmail.com"};

    }


    public static void main(String[] args) {
        FilterEmailAddress filterEmailAddress = new FilterEmailAddress();
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> emailList = new ArrayList<>(Arrays.asList(filterEmailAddress.emailAddressArray));
        System.out.println("Email Address list : " + emailList);
        System.out.println("Enter email string to be searched from above list:");
        String searchString = scanner.next();

        /* Use stream filter , lambda expression , method reference introduced in Java 8 */

        ArrayList<String> filteredEmailAddress = emailList.stream()
                .filter(x -> x.toLowerCase().contains(searchString.toLowerCase()))
                .collect(Collectors.toCollection(ArrayList::new));

        if (!filteredEmailAddress.isEmpty()) {
            System.out.println("Email address matching the search :" + filteredEmailAddress);
        } else {
            System.out.println("Entered email String not found");
        }

    }
}