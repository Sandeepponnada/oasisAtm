import java.util.*;
public class ATM{
    public static HashMap<Integer,ArrayList<String>> customerDetails =  new HashMap<Integer,ArrayList<String>>();
    public static ArrayList<ArrayList<String>> transactionDetails = new ArrayList<ArrayList<String>>();
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter Your Choice:\n1.Customer Login\n2.Exit");
            int n = sc.nextInt();
            switch(n){
                case 1:customerLogin();
                break;
                case 2:
                System.out.println("Thanks for using our services!!!\nVISIT AGAIN😊");
                System.exit(0);
                break;
                default:System.out.println("Enter valid choice.");
            }
        }
    }
    public static void customerLogin(){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> details = new ArrayList<>();
        details.add("1234");
        details.add("sandeep");
        details.add("50000");
        customerDetails.put(830936521,details);
        System.out.println("please, enter your credit card number.");
        int creditNumber = sc.nextInt();
        System.out.println("please, enter your pin.");
        int pin = sc.nextInt();
        if(customerDetails.containsKey(creditNumber)){
            if(pin == Integer.parseInt(customerDetails.get(creditNumber).get(0))){
                System.out.println("Welcome!!! "+customerDetails.get(creditNumber).get(1));
                System.out.println("You are ready to proceed with your transactions");
                while(true){
                System.out.println("enter your choice:\n1.Balance Enquiry\n2.Withdraw Amount\n3.Deposit Amount\n4.Transfer Amount\n5.Mini Statement\n6.exit");
                int choice = sc.nextInt();
                switch(choice){
                    case 1:balanceEnquiry(creditNumber);
                    break;
                    case 2:withdraw(creditNumber);
                    break;
                    case 3:deposit(creditNumber);
                    break;
                    case 4:transfer(creditNumber);
                    break;
                    case 5:miniStatement(creditNumber);
                    break;
                    case 6:System.out.println("Thanks for using our services!!!\nVISIT AGAIN😊");
                    System.exit(0);
                    break;
                    default:System.out.println("please enter a valid choice.");

                }
                }
            }
            else{
                System.out.println("please enter a valid pin.");
            }
        }
        else{
            System.out.println("please enter valid credit card number.");
        }
    }
    public static void balanceEnquiry(int creditNumber){
        System.out.println("Your current account balance is "+customerDetails.get(creditNumber).get(2));

    }
    public static void withdraw(int creditNumber){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount you want to withdraw.");
        int amount = sc.nextInt();
        if(amount <= Integer.parseInt(customerDetails.get(creditNumber).get(2))){
        int totalBalance  = Integer.parseInt(customerDetails.get(creditNumber).get(2));
        totalBalance -= amount;
        ArrayList<String> details = customerDetails.get(creditNumber);
        details.set(2,String.valueOf(totalBalance));
        customerDetails.put(creditNumber,details);
        ArrayList<String> information = new ArrayList<>();
        information.add(String.valueOf(creditNumber));
        information.add("Withdraw");
        information.add(String.valueOf(amount));
        Date date = new Date();
        information.add(date.toString());
        transactionDetails.add(information);
        System.out.println("Your current balance is: "+customerDetails.get(creditNumber).get(2));
        }
        else{
            System.out.println("Insufficient Funds!");
        }
    }
    public static void deposit(int creditNumber){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount you want to deposit.");
        int amount = sc.nextInt();
        int totalBalance  = Integer.parseInt(customerDetails.get(creditNumber).get(2));
        totalBalance += amount;
        ArrayList<String> details = customerDetails.get(creditNumber);
        details.set(2,String.valueOf(totalBalance));
        customerDetails.put(creditNumber,details);
        ArrayList<String> information = new ArrayList<>();
        information.add(String.valueOf(creditNumber));
        information.add("Deposit");
        information.add(String.valueOf(amount));
        Date date = new Date();
        information.add(date.toString());
        transactionDetails.add(information);
        System.out.println("Your current balance is: "+customerDetails.get(creditNumber).get(2));
    }
    public static void transfer(int creditNumber){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter credit card Number to which you want to transfer.");
        int transferNumber = sc.nextInt();
        if(String.valueOf(transferNumber).length() == 10){
        System.out.println("Enter the amount you want to transfer.");
        int amount = sc.nextInt();
        if(amount <= Integer.parseInt(customerDetails.get(creditNumber).get(2))){
        System.out.println("Successfully, transferred the amount:"+amount+" to the account number:"+transferNumber);
        int totalBalance  = Integer.parseInt(customerDetails.get(creditNumber).get(2));
        totalBalance -= amount;
        ArrayList<String> details = customerDetails.get(creditNumber);
        details.set(2,String.valueOf(totalBalance));
        customerDetails.put(creditNumber,details);
        ArrayList<String> information = new ArrayList<>();
        information.add(String.valueOf(creditNumber));
        information.add("Transfer to:"+transferNumber);
        information.add(String.valueOf(amount));
        Date date = new Date();
        information.add(date.toString());
        transactionDetails.add(information);
        System.out.println("Your current balance is: "+customerDetails.get(creditNumber).get(2));
        }
        else{
            System.out.println("Insufficient Funds!");
        }
        }
        else{
            System.out.println("please enter a valid credit card number.");
        }
    }
    public static void miniStatement(int creditNumber){
        System.out.println("Your recent transaction history is:");
        for(ArrayList<String> i:transactionDetails){
            if(Integer.parseInt(i.get(0)) == creditNumber){
                for(String j:i){
                    System.out.print(j+"    ");
                }
                System.out.println();
            }
        }
    }
}