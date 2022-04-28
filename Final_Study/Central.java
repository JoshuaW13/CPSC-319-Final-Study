import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class Central {
    private LinkedQueue myTest = new LinkedQueue();
    private int correct =0;
    private int size = 0;

    public Central(String infile){
        try {
            File file = new File(infile);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st = "";
            while((st = br.readLine()) != null){
                String [] tmp = st.split("\\$");
                Question q = new Question(tmp[0], tmp);
                this.myTest.enqueue(q);
                this.size++;
            }
            
            br.close();
            
        } catch (Exception e) {
            System.out.println("There was an erro opening the file!");
            
        }

    }

    public void test(){
        while(!myTest.isEmpty()){
            Question q = myTest.poll();
            boolean response = q.askQuestion();
            if(response){correct++;}
        }

    }

    public int getCorrect(){return this.correct; }
    public int getSize(){return this.size;}

    public static void main(String[] args) {
        Central myapp = new Central("questions.txt");
        myapp.test();
        System.out.println("Thank you for playing! You got "+myapp.getCorrect()+" out of "+myapp.getSize()+" correct!");
        
    }
    
}
