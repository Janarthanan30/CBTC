import java.util.HashMap;
import java.util.Scanner;

public class exam {
	HashMap<String, String> obj = new HashMap<String, String>();
    Scanner input = new Scanner(System.in);

    public void login() {
        System.out.println("\n********** Welcome to Online Examinate **********\n");
        System.out.println("1.Sign Up\n2. Login");
        System.out.println("\n Enter your choice: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
            	signUp();
                break;
            case 2:
                authenticate();
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
                login();
        }
    }

    public void authenticate() {
        
        System.out.println("Enter Username: ");
        String temp=input.next();
        String userName = input.nextLine();
        System.out.println("Enter Password: ");
        String password = input.nextLine();

        if (obj.containsKey(userName) && obj.get(userName).hashCode() == password.hashCode()) {
            System.out.println("Log-In Successful!");
            main();
        } else {
            System.out.println("Invalid Username or Password !! Please Signing Up !!");
            login();
        }
    }

    public void signUp() {
        System.out.println("Enter Username: ");
        String temp=input.next();
        String userName = input.nextLine();
        if (obj.containsKey(userName)) {
            System.out.println("User Already Exists ! Please try Logging in.");
            login();
        } else {
            System.out.println("Enter Password: ");
            String password = input.nextLine();
            obj.put(userName, password);
            System.out.println("Sign Up Successful! Please Login to continue:)");
            login();
        }
    }

    public void main() {
        System.out.println("\n1.Change Your Acccount Password\n2.Start test\n3.Logout");
        System.out.println("\n Enter your choice: ");
        int op = input.nextInt();
        switch (op) {
            case 1:
                update();
                main();
                break;
            case 2:
                solve();
                main();
                break;
            case 3:
                System.out.println("**********Success fully logout***********");
                break;
            default:
                System.out.println("Invalid Choice!");
        }
    }

    public void update() {
        System.out.println("\n----- Update YOu Password -----");
        System.out.println("Enter Username: ");
        String id = input.next();

        if (obj.containsKey(id)) {
            System.out.println("Enter New Password: ");
            String newpd = input.nextLine();
            obj.replace(id, newpd);
            System.out.println("Profile Update Success!");
        } else {
            System.out.println("User does not exist...");
            System.out.println("Profile Update Failed!");
        }
    }

    public void solve() {
        long start = System.currentTimeMillis();
        long terminate = start + 60 * 1000;
        int score = 0;
        int c = 0, w = 0;
        char ans;
        System.out.println("\n\n***** Starting The Test *****");
        System.out.println("You have 1 Minute to answer each question. Select the options wisely... ");
        System.out.println("Each question gives +2 marks for a correct answer and -1 mark for a wrong answer.");
        System.out.println("All the very best!!");

        while (System.currentTimeMillis() < terminate) {
            System.out.println("\nQ1. Which of the following option leads to the portability and security of Java?");
            
            System.out.println("a.Bytecode is executed by JVM\nb.The applet makes the Java code secure and portable\nc.Use of exception handling\nd.Dynamic binding between objects");
            System.out.println("Answer:");
            ans = input.next().charAt(0);
            if (ans == 'a') {
                c += 1;
            } else
                w -= 1;

            System.out.println("\nQ2_____ is used to find and fix bugs in the Java programs.");
            System.out.println("a.JVM\nb.JRE\nc.JDK\nd.JDB");
            System.out.println("Answer:");
            ans = input.next().charAt(0);
            if (ans == 'd') {
                c += 1;
            } else
                w -= 1;

            System.out.println("\nQ3.What is the return type of the hashCode() method in the Object class?");
            System.out.println(
                    "a.Object.\nb.int.\nc.long.\nd.void.");
            System.out.println("Answer:");
            ans = input.next().charAt(0);
            if (ans == 'b') {
                c += 1;
            } else
                w -= 1;

            System.out.println("\nQ4.What does the expression float a = 35 / 0 return?");
            System.out.println("a.0\nb.Not a Number\nc.Infinity\nd.Run time exception");
            System.out.println("Answer:");
            ans = input.next().charAt(0);
            if (ans == 'c') {
                c += 1;
            } else
                w -= 1;

            System.out.println("\nQ5.In which process, a local variable has the same name as one of the instance variables?");
            System.out.println(
                    "a.Serialization.\nb.Variable Shadowing.\nc.Abstraction.\nd.Multi-threading.");
            System.out.println("Answer:");
            ans = input.next().charAt(0);
            if (ans == 'b') {
                c += 1;
            } else
                w -= 1;
            break;
        }

        System.out.println("\n*********Thank You Submit Test Successfully:)*************");
        score = ((c * 2) + w);
        System.out.println("Total NUmber of Questions(5)");
        System.out.println(" Your Number of correct answers: " + c);
        System.out.println("Congratulations!! Your Test score is " + score + " Out of 10.\n");
    }

    public static void main(String args[]) {
    	exam e = new exam();
        e.login();
    }
}
