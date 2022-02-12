package javaphase1.Lesson2Assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SearchEmailAddress {

    private String[] emailAddressArray;

    public SearchEmailAddress() {
        this.emailAddressArray = new String[]{"joey@gmail.com ", "Jack@hotmail.com", "Jim@github.com", "John@hotdog.com", "Ajoy@gmail.com"};

    }


    public static void main(String[] args) {
        SearchEmailAddress searchEmailAddress = new SearchEmailAddress();
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> emailList = new ArrayList<>(Arrays.asList(searchEmailAddress.emailAddressArray));
        System.out.println("Email Address list : " + emailList);
        System.out.println("Enter email string to be searched from above list:");
        String searchString = scanner.next();
        ArrayList<String> result = searchEmailAddress.searchStrArray(emailList, searchString);
        if (!result.isEmpty()) {
            System.out.println("Email address matching the search :" + result);
        } else {
            System.out.println("Entered email String not found");
        }

    }


    public ArrayList<String> searchStrArray(final ArrayList<String> emailList, final String searchStr) {

        ArrayList<String> resultString = new ArrayList<>();
        for (String currentStr : emailList) {
            if (currentStr.toLowerCase().contains(searchStr.toLowerCase())) {
                resultString.add(currentStr);
            }
        }
        return resultString;
    }
}
