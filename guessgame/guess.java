import java.util.Random;
import java.util.Scanner;

 class imp{

    int Guess;

    public imp(int Guess)
    {
        this.Guess=Guess;
    }

} 

public class guess {
    public static void main(String a[])
    {
         int Guesses=0,points=0;
         String mode;
        Scanner in = new Scanner(System.in);

        Random numb = new Random();

        System.out.printf("Press any key to continue");

        mode=in.nextLine ();

      
{
    int toguessH=numb.nextInt(1,100);

    System.out.println("Enter your guess between 1-100");

  while(Guesses <= 5)
  {
    imp obj = new imp(in.nextInt());

    if(Guesses == 5)
    {
    System.out.println("Better luck next time");
    break;
   }

   if(obj.Guess == toguessH)
   {
    Guesses++;
    
        if(Guesses==1 && obj.Guess == toguessH)
        {
            points+=100;

                System.out.println("******************************************");
                System.out.println("You found the Number in First try "+toguessH);
                System.out.println("Your Guesses count = "+Guesses);
                System.out.println("Your Final Score : "+points);
                System.out.println("******************************************");
                break;
            }
    
        else if(Guesses==2 && obj.Guess == toguessH)
        {
            points+=70;

                System.out.println("******************************************");
                System.out.println("You found the Number "+toguessH);
                System.out.println("Your Guesses count = "+Guesses);
                System.out.println("Your Final Score : "+points);
                System.out.println("******************************************");
                break;
            }

            else if(Guesses==3 && obj.Guess == toguessH)
            {
                points+=50;

                    System.out.println("******************************************");
                    System.out.println("You found the Number "+toguessH);
                    System.out.println("Your Guesses count = "+Guesses);
                    System.out.println("Your Final Score : "+points);
                    System.out.println("******************************************");
                    break;
                }

                else if(Guesses==4 && obj.Guess == toguessH)
                {
                    points+=30;
    
                        System.out.println("******************************************");
                        System.out.println("You found the Number "+toguessH);
                        System.out.println("Your Guesses count = "+Guesses);
                        System.out.println("Your Final Score : "+points);
                        System.out.println("******************************************");
                        break;
                    }

                    else if(Guesses==5 && obj.Guess == toguessH)
                    {
                        points+=10;
        
                            System.out.println("******************************************");
                            System.out.println("You found the Number "+toguessH);
                            System.out.println("Your Guesses count = "+Guesses);
                            System.out.println("Your Final Score : "+points);
                            System.out.println("******************************************");
                            break;
                        }
   }

   else if(obj.Guess < toguessH)
   {
    System.out.println("Try little higher!!");
    Guesses++;
    continue;
   }

   else if(obj.Guess > toguessH)
   {
    System.out.println("Try little lower!!");
    Guesses++;
    continue;
   }

   else{
    System.out.println("Enter a valid number between 1-100");
   }
   
  }

        


    }

    }
}
