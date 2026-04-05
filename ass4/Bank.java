import java.io.*;
import java.util.*;

class MinAmountException extends Exception 
{
    MinAmountException(String msg) { super(msg); }
}
class InsufficientFundsException extends Exception 
{
    InsufficientFundsException(String msg) { super(msg); }
}
class InvalidCIDException extends Exception 
{
    InvalidCIDException(String msg) { super(msg); }
}
class NegativeAmountException extends Exception 
{
    NegativeAmountException(String msg) { super(msg); }
}

class Customer 
{
    int cid;
    String cname;
    double amount;
    Customer(int cid, String cname, double amount) 
    {
        this.cid = cid;
        this.cname = cname;
        this.amount = amount;
    }
}

class Bank 
{
    static ArrayList<Customer> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void saveRecord(Customer c) 
    {
        try 
        {
            FileWriter f = new FileWriter("bank_records.txt", true);
            f.write(c.cid + "," + c.cname + "," + c.amount + "\n");
            f.close();
        } 
        catch (Exception e) 
        {
            System.out.println("File error: " + e.getMessage());
        }
    }

    static void showRecords() 
    {
        try 
        {
            BufferedReader br = new BufferedReader(new FileReader("bank_records.txt"));
            String line;
            System.out.println("\n--File Records--");
            while ((line = br.readLine()) != null)
                System.out.println(line);
            br.close();
        } 
        catch (Exception e) 
        {
            System.out.println("No records found.");
        }
    }

    static Customer findCustomer(int id) 
    {
        for (Customer c : list)
            if (c.cid == id) return c;
        return null;
    }

    public static void main(String args[]) 
    {
        int ch;
        do 
        {
            System.out.println("\n-- BANK MENU --");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Show File Records");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            ch = sc.nextInt();

            if (ch == 1) 
            {
                try 
                {
                    System.out.print("Enter CID (1-20): ");
                    int id = sc.nextInt();
                    if (id < 1 || id > 20) throw new InvalidCIDException("CID must be 1 to 20!");

                    System.out.print("Enter Name: ");
                    String name = sc.next();

                    System.out.print("Enter Amount: ");
                    double amt = sc.nextDouble();
                    if (amt < 0) throw new NegativeAmountException("Amount cant be negative!");
                    if (amt < 1000) throw new MinAmountException("Min balance is 1000!");

                    Customer c = new Customer(id, name, amt);
                    list.add(c);
                    saveRecord(c);
                    System.out.println("Account created!");

                } 
                catch (Exception e) 
                {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            else if (ch == 2) 
            {
                try 
                {
                    System.out.print("Enter CID: ");
                    Customer c = findCustomer(sc.nextInt());
                    if (c == null) { System.out.println("Not found!"); continue; }

                    System.out.print("Enter deposit amount: ");
                    double amt = sc.nextDouble();
                    if (amt < 0) throw new NegativeAmountException("Amount cant be negative!");

                    c.amount += amt;
                    System.out.println("Deposited! Balance: " + c.amount);

                } 
                catch (Exception e) 
                {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            else if (ch == 3) 
            {
                try 
                {
                    System.out.print("Enter CID: ");
                    Customer c = findCustomer(sc.nextInt());
                    if (c == null) { System.out.println("Not found!"); continue; }

                    System.out.print("Enter withdraw amount: ");
                    double amt = sc.nextDouble();
                    if (amt < 0) throw new NegativeAmountException("Amount cant be negative!");
                    if (amt > c.amount) throw new InsufficientFundsException("Not enough balance!");

                    c.amount -= amt;
                    System.out.println("Done! Remaining: " + c.amount);

                } 
                catch (Exception e) 
                {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            else if (ch == 4) 
            {
                System.out.print("Enter CID: ");
                Customer c = findCustomer(sc.nextInt());
                if (c == null) System.out.println("Not found!");
                else System.out.println(c.cname + " | Balance: " + c.amount);
            }

            else if (ch == 5) 
            {
                showRecords();
            }

            else if (ch == 6) 
            {
                System.out.println("Bye!");
            }

        } while (ch != 6);
    }
}