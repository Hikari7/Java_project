import java.util.Scanner;
import javax.swing.plaf.synth.SynthScrollBarUI;

public class Mypage { // generics
    private final String userName; // final: 変更ができなくする
    private final String passWord;
    private int price; // field変数
    private String plan;
    private String answer; // answerの仮の変数
    private boolean bookingStatus; // bookingStatus
    private String addplan;

    public Mypage(String username, String password, int price, String plan) {
        this.userName = username; // instansiate
        this.passWord = password; // 他のやつはlocal class
        this.price = price;
        this.plan = plan;
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

    public String getPlan() {
        return plan;
    }

    void additionalPlan(char choice) { // それぞれのadditional plan rateを足す
        switch (choice) {
            case 'a':
                if (bookingStatus == true) {
                    System.out.println("You already booked this plan");
                } else {
                    System.out.println("Your plan has been added. Please confirm your booking price in the top page");
                    price = price + 50;
                }

                break;

            case 'b':
                if (bookingStatus == true) {
                    System.out.println("You already booked this plan");
                } else {
                    System.out.println("Your plan has been added. Please confirm your booking price in the top page");
                    price = price + 100;
                }

                break;

            case 'c':
                if (bookingStatus == true) {
                    System.out.println("You already booked this plan");
                } else {
                    System.out.println("Your plan has been added. Please confirm your booking price in the top page");
                    price = price + 150;
                }

                break;

            case 'd':
                if (bookingStatus == true) {
                    System.out.println("You already booked this plan");
                } else {
                    System.out.println("Your plan has been added. Please confirm your booking price in the top page");
                    price = price + 200;
                }

                break;

        } // defauleがいっつも出てきてうざい

        // if (Character.toLowerCase(choice) == 'a') {
        // price = price + 50;
        // } else if (addplan.equals("B")) {
        // price = price + 100;
        // } else if (addplan.equals("C")) {
        // price = price + 150;
        // } else{
        // price = price + 200;
        // }
    }

    void showMenu() {
        char option;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("============================");
            System.out.println("*  My page | Hotel Nae Jib *");
            System.out.println("============================");
            System.out.println("A: See your booking info");
            System.out.println("B: Get additional plans");
            System.out.println("C: Cancel your reservation");
            System.out.println("D: Quit");
            option = scanner.next().charAt(0); // [a]bcd

            App.clearConsole();

            switch (option) {
                case 'a':

                    System.out.println("----------- Your reservation info -------------");
                    System.out.println("* Total price: CAD " + price);
                    System.out.println("* Your additional plan: " + plan);
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
                        System.out.println("\n");

                        char addplan;
                        addplan = scanner.next().charAt(0); // [a]bcd
                        additionalPlan(addplan);
                        // switch (addplan) {
                        // case 'a':
                        // if(bookingStatus == true){
                        // System.out.println("You already booked this plan");
                        // } else {
                        // System.out.println("Your plan has been added. Please confirm your booking
                        // price in the top page");
                        // additionalPlan(price, addplan);
                        // }

                        // break;

                        // case 'b':
                        // if(bookingStatus == true){
                        // System.out.println("You already booked this plan");
                        // }
                        // System.out.println("Your plan has been added. Please confirm your booking
                        // price in the top page");
                        // additionalPlan(price);

                        // break;

                        // case 'c':
                        // if(bookingStatus == true){
                        // System.out.println("You already booked this plan");
                        // }
                        // System.out.println("Your plan has been added. Please confirm your booking
                        // price in the top page");
                        // additionalPlan(price);

                        // break;

                        // case 'd':
                        // if(bookingStatus == true){
                        // System.out.println("You already booked this plan");
                        // }
                        // System.out.println("Your plan has been added. Please confirm your booking
                        // price in the top page");
                        // additionalPlan(price);

                        // break;

                        // } //defauleがいっつも出てきてうざい
                        break;
                    }

                case 'c':
                    System.out.println("Are you sure you want to cancel the booking? Type [yes/no]");

                    answer = scanner.next();
                    if (answer.equals("yes")) {
                        System.out.println("\nYour booking canceled successfuly.");
                        System.out.println("Please confirm your price from the booking info.\n");
                        price = 0;
                        plan = "You don't have any reservation yet.";
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

/*
 * 1) login: user_name, PW
 * 2) reservation number
 * 3) showMenu
 * 4)
 * A: check current info
 * - DD/MM/YYYY, Price, Option (Breakfast Only)
 * - $250
 * 
 * B: Change the meal plans
 * 
 * a: Room Only -> - $50
 * b: Brakfast Only -> 0
 * c: Half Board -> + $60
 * d: Full Board -> + $80
 * 
 * C: Cancel the reservation
 * -> show the refund price
 * 
 * D: Quit "Thank you!"
 * 
 * E: error message
 */
// public class Mypage <S1, S2> { //generics

/*
 * やること
 * デフォルトのprice(700)からそれぞれのオプションを足せるようにする
 * キャンセルしたらcurrent price分を全て無くすようにする
 */
