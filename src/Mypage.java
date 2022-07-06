import java.util.Scanner;

import javax.swing.plaf.synth.SynthScrollBarUI;

/* 1) login: user_name, PW
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
// public class Mypage <S1, S2> {  //generics

/*やること
 * デフォルトのprice(700)からそれぞれのオプションを足せるようにする
 * キャンセルしたらcurrent price分を全て無くすようにする
 */


public class Mypage  {  //generics
    private final int price;              //field変数
    private final String userName;      //final: 変更ができなくする
    private final String passWord;
    private final String plan;
    // private int plan1; //RO
    // private int plan2; //BF
    // private int plan3; //HB
    // private int plan4; //FB

    private String answer;



    public Mypage(String string, String string2, int price, String plan) {
        this.userName = string;      //instansiate
        this.passWord = string2;      //他のやつはlocal class
        this.price = price;   
        this.plan = plan;
    }

    public String getUserName() {  //privateになっているフィールド変数を
        return userName;//フィールド名
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

void hotelFee(int fee) {
    System.out.println("500 CAD is the standard price (Room Only)");
}

    void planPrice(int plan1, int plan2, int plan3, int plan4, int price) {
        if (plan.equals(plan1)) {
            price = price + 50;    //????????
        } else if (plan.equals(plan2)){
            price = price + 100; 
        } 
        else if (plan.equals(plan3)){
            price = price + 150; 
        } 
         else{
            price = price + 200; 
        } 
    }


    void showMenu() {
        char option;
        char option2;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("============================");
            System.out.println("*  My page | Hotel mi casa *");
            System.out.println("============================");
            System.out.println("A: See your booking info");
            System.out.println("B: Add option/amenity");
            System.out.println("C: Cancel the reservation");
            System.out.println("D: Quit");
            option = scanner.next().charAt(0);  //[a]bcd
            

            switch (option) {
                case 'a': 
                System.out.println("----------- Your reservation info -------------");
                System.out.println("* Total price: CAD " + price);
                System.out.println("* The meal plan: " + plan);
                System.out.println("----------------------------------------------");
                System.out.println("\n");
                break;

                case 'b':
                System.out.println("----------------------------------------------------");
                System.out.println("Add option/amenity");
                System.out.println("1: Breakfast");   // +50$
                System.out.println("2: Room service");   // +100$
                System.out.println("3: Pet-friendly");  // +150$
                System.out.println("4: Spa");   // +200$
                System.out.println("----------------------------------------------------");
                System.out.println("\n");

                answer = scanner.next();
                switch (option) {
                    case '1':
                    if ((answer.equals("1"))) {
                        System.out.println("You already booked that plan");
                    } else {
                        System.out.println("Your plan has been changed. Please confirm your booking price in the top page");
                        planPrice(price);
                    }
                        break;
                    case '2':
                    if (answer.equals("2")) {
                        System.out.println("You already booked that plan");
                    } else {
                        System.out.println("Your plan has been changed. Please confirm your booking price in the top page");
                        planPrice(price);
                    }
                        break;
                    case '3':
                    if (answer.equals("3")) {
                        System.out.println("You already booked that plan");
                    } else {
                        System.out.println("Your plan has been changed. Please confirm your booking price in the top page");
                        planPrice(price);
                    }
                        break;
                    case '4':
                    if (answer.equals("4")) {
                        System.out.println("You already booked that plan");
                    } else {
                        System.out.println("Your plan has been changed. Please confirm your booking price in the top page");
                        planPrice(price);
                    }
                        break;
                
                    // default:
                    // System.out.println("Invalid option. Please try again.");
                    //     break;
                }


                break;

                case 'c':
                System.out.println("Are you sure you want to cancel the booking? Type [yes/no]");
                answer = scanner.next();
                if (answer.equals("yes")){
                    System.out.println("Your booking canceled successfuly.");
                } else if (answer.equals("no")) {
                    System.out.println("We'll redirect the menu page. Have a nice trip!");
                }
                else {
                    System.out.println("Invalid option. Please try again.");
                }
					
                break;    

                default:
                System.out.println("Invalid option. Please try again.");
                break;
                }

            
        

            } while (Character.toLowerCase(option)!= 'd');   //optionの時のcharがe(おわり)じゃなかったら
            System.out.println("Thank you for visiting us. Have a nice trip!");
            scanner.close();

    }

    private void planPrice(int price2) {
    }
    
}
