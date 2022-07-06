import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        //assume an account has already been created
        Mypage account = new Mypage("hikari","12345", 300);

        System.out.println("----------------------");
        System.out.println("Welcome to travel.com!");
        System.out.println("----------------------");

        while(true) {
            System.out.println("Please enter your username");
            String user = input.nextLine();
            System.out.println("Please enter your password");
            String pass = input.nextLine();

            if(user.equals(account.getUserName()) && pass.equals(account.getPassWord())){
                System.out.println("\n Welcome " + account.getUserName() + "!" + "\n You can confirm your travel details");
                break;

            }

            System.out.println(
                "Invalid credentials\n\n" +
                "Press [enter] key to try again or press [Q] to exis \n\n"
            );
            if(input.nextLine().toLowerCase().equals("q")) {
                System.out.println("Have a nice trip!");
            }

        }
        account.showMenu();
        input.close();
    }
}
