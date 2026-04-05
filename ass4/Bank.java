import java.util.*;
import java.io.*;

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
        catch (IOException e) 
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
        catch (IOException e) 
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
                System.out.print("Enter CID (1-20): ");
                int id = sc.nextInt();

                if (id < 1 || id > 20) 
                {
                    System.out.println("Error: CID must be 1 to 20!");
                } 
                else 
                {
                    System.out.print("Enter Name: ");
                    String name = sc.next();

                    System.out.print("Enter Amount: ");
                    double amt = sc.nextDouble();

                    if (amt < 0) 
                    {
                        System.out.println("Error: Amount cant be negative!");
                    } 
                    else if (amt < 1000) 
                    {
                        System.out.println("Error: Min balance is 1000!");
                    } 
                    else 
                    {
                        Customer c = new Customer(id, name, amt);
                        list.add(c);
                        saveRecord(c);
                        System.out.println("Account created!");
                    }
                }
            }

            else if (ch == 2) 
            {
                System.out.print("Enter CID: ");
                Customer c = findCustomer(sc.nextInt());

                if (c == null) 
                {
                    System.out.println("Customer not found!");
                } 
                else 
                {
                    System.out.print("Enter deposit amount: ");
                    double amt = sc.nextDouble();

                    if (amt < 0) 
                    {
                        System.out.println("Error: Amount cant be negative!");
                    } 
                    else 
                    {
                        c.amount += amt;
                        System.out.println("Deposited! Balance: " + c.amount);
                    }
                }
            }

            else if (ch == 3) 
            {
                System.out.print("Enter CID: ");
                Customer c = findCustomer(sc.nextInt());

                if (c == null) 
                {
                    System.out.println("Customer not found!");
                } 
                else 
                {
                    System.out.print("Enter withdraw amount: ");
                    double amt = sc.nextDouble();

                    if (amt < 0) 
                    {
                        System.out.println("Error: Amount cant be negative!");
                    } 
                    else if (amt > c.amount) 
                    {
                        System.out.println("Error: Not enough balance! Current: " + c.amount);
                    } 
                    else 
                    {
                        c.amount -= amt;
                        System.out.println("Done! Remaining: " + c.amount);
                    }
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