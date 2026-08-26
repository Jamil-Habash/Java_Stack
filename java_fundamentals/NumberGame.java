import java.util.Random;
public class NumberGame {
    public static void main(String[] args) {
        System.out.println("Hello, human. I am thinking of a number between 0 and 10.");

        System.out.println("*********************************************************");
        System.out.println("Can you guess the number?");
        System.out.println("If you are not to the task, you can always type 'q' to quit.");
        System.out.println("You only have 3 tries");
        for(int i = 0;i<3;i++){
            int answer = 0;
            if(i == 0){
                answer = new Random().nextInt(0,10);
                System.out.println(answer);
            }
            String guess = System.console().readLine();
            if(guess.equals("q")){
                System.out.println("I knew you didnt have it in you.");
                System.out.println("Shutting down...");
                break;
            }
            try{
                if(Integer.parseInt(guess) < 0 || Integer.parseInt(guess) > 10){
                    System.out.println("I said from 0 to 10");
                    i=-1;
                    continue;
                }
                if(Integer.parseInt(guess) == answer){
                System.out.println("Lucky guess! but can you do it again?");
                i = 2;
            }else{
                System.out.println("Swing and a miss! keep trying...");
            }
            } catch (NumberFormatException e){
                System.out.println("Only numbers from 0 to 10 or q to quit");
                i=-1;
            }
            if(i == 2){
                System.err.println("Game Over. if you want to play again enter 'y'");
                String con = System.console().readLine();
                if(con.equals("y")){
                    i = -1;
                    continue;
                }
            }
        }
        System.out.println("Game Over. Shutting down...");
    }
}
