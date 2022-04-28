import java.io.BufferedReader;
import java.io.*;

public class Question{
    //Fields
    private String question;
    private String correctAnswer;
    private String [] answers = new String[4];

    //Constructors
    public Question(String q, String[] a){
        this.question = q;
        this.answers = a;
        for(int i =0; i<answers.length;i++){
            char temp = answers[i].charAt(0);
            if(Character.compare('#',temp) == 0){
                answers[i] = answers[i].replaceFirst("#", "");
                this.correctAnswer  = answers[i];              
            }
        }
    }
    //private methods
    private boolean validateAnswer(String answer){
        if(this.answers.length == 5){
            if(answer.compareTo("a")==0){answer = answers[1];}
            else if(answer.compareTo("b")==0){answer = answers[2];}
            else if(answer.compareTo("c")==0){answer = answers[3];}
            else if(answer.compareTo("d")==0){answer = answers[4];}
            else{return false;}
        }
        else{
            if(answer.compareTo("a")==0){answer = answers[1];}
            else if(answer.compareTo("b")==0){answer = answers[2];}
        }
        if(this.correctAnswer.compareTo(answer)==0){return true;}
        return false;
    }

    //public methods

    public boolean askQuestion(){
        System.out.println(question+"\n\n");
        char temp = 'a';
        for(int i =1;i<answers.length;i++){
            System.out.println(temp+". "+answers[i]+"\n");
            temp++;
        }
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            if(this.answers.length == 5){
                System.out.println("Enter answer a,b,c,d: ");
            }           
            String answer = br.readLine();
            boolean correct =validateAnswer(answer.toLowerCase());
            if(correct){
                System.out.println("Corect!");
                System.out.println("\n<<ENTER>>");
                br.readLine();
                return true;
            }
            else{
                System.out.println("Incorrect! The correct answer was: "+this.correctAnswer);
                System.out.println("\n<<ENTER>>");
                br.readLine();
                return false;
            }
            
        } catch (Exception e) {
            System.out.println("Error getting user input!");
        }
        return false;
        
    }

}