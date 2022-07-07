import java.lang.module.ModuleDescriptor.Builder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import javax.swing.plaf.synth.SynthScrollBarUI;

public class Mypage { // generics
    private final String userName; // final: 変更ができなくする
    private final String passWord;
    private int price; // field変数
    private String answer; // answerの仮の変数
    private boolean bookingStatus; // bookingStatus

    List<String> plan = new ArrayList<String>();

    public Mypage(String username, String password, int price) {
        this.userName = username; // instansiate
        this.passWord = password; // 他のやつはlocal class
        this.price = price;
    }

    public String getUserName() { // privateになっているフィールド変数を
        return userName;// フィールド名
    }

    public String getPassWord() {
        return passWord;
    }

    public String getAnswer() {
        return answer;
    }

    void bookingStatus() {
        boolean bookingStatus = true;
    }

    void additionalPlan(char choice) { // それぞれのadditional plan rateを足す
      
        switch (choice) {
            
            case 'a':
                if (plan == true) {
                    System.out.println("You already booked this plan");
                } else {
                    System.out.println("Your plan has been added. Please confirm your booking price in the top page");
                    price = price + 50;
                    plan.add("Breakfast included");
                }

                break;

            case 'b':
                if (bookingStatus == true) {
                    System.out.println("You already booked this plan");
                } else {
                    System.out.println("Your plan has been added. Please confirm your booking price in the top page");
                    price = price + 100;
                    plan.add("Room service");
                }

                break;

            case 'c':
                if (bookingStatus == true) {
                    System.out.println("You already booked this plan");
                } else {
                    System.out.println("Your plan has been added. Please confirm your booking price in the top page");
                    price = price + 150;
                    plan.add("Cancel your reservation");
                }

                break;

            case 'd':
                if (bookingStatus == true) {
                    System.out.println("You already booked this plan");
                } else {
                    System.out.println("Your plan has been added. Please confirm your booking price in the top page");
                    price = price + 200;
                    plan.add("Spa");
                }

                break;

                default:
                System.out.println("Invalid option. Please try again.\n");
                break;
        }

    }

    void showMenu() {
        char option;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("============================");
            System.out.println("*  My page | Hotel 我的家  *");
            System.out.println("============================");
            System.out.println("A: See your booking info");
            System.out.println("B: Get additional plans");
            System.out.println("C: Cancel your reservation");
            System.out.println("D: Quit");
            option = scanner.next().charAt(0); // [a]bcd

            App.clearConsole();

            switch (option) {
                case 'a':
                    System.out.println("\n----------- Your reservation info -------------");
                    System.out.println("* Total price: CAD " + price);
                    for (int i = 0; i < plan.size(); i++) {
                        System.out.println("* Your additional plan: " + plan.get(i));
                    }

                    System.out.println("----------------------------------------------\n");
                    System.out.println("\n");
                    break;

                case 'b':
                    if (price < 1) {
                        System.out.println("You don't have any reservation.\n Please reserve a room first.\n");
                    } else {

                        System.out.println("---------------------------------");
                        System.out.println("Get additional plans");
                        System.out.println("A: Breakfast included + $50"); // +50$
                        System.out.println("B: Room service + $100"); // +100$
                        System.out.println("C: Rent a car + $150"); // +150$
                        System.out.println("D: Spa + $200"); // +200$
                        System.out.println("---------------------------------");

                        char addplan;
                        addplan = scanner.next().charAt(0); // [a]bcd
                        additionalPlan(addplan);

                        break;
                    }

                case 'c':
                    System.out.println("Are you sure you want to cancel the booking? Type [yes/no]\n");

                    answer = scanner.next();
                    if (answer.equals("yes")) {
                        System.out.println("\nYour booking canceled successfuly.");
                        System.out.println("Please confirm your price from the booking info.\n");
                        price = 0;
                        // plans = "You don't have any reservation yet.";
                    } else if (answer.equals("no")) {
                        System.out.println("You'll be redirected the menu page.\n\n");
                    } else {
                        System.out.println("Invalid option. Please try again.");
                    }

                    break;

                default:
                    System.out.println("Invalid option. Please try again.\n");
                    break;
            }

        } while (Character.toLowerCase(option) != 'd'); // optionの時のcharがe(おわり)じゃなかったら
        System.out.println("Thank you for visiting us.\n Have a nice trip!\n\n");
        scanner.close();

    }
}
