package model;

public class Question {
    private String myQuestion;
    private String mySolution;
    
    
    public Question() {
        //myQ = new Question();
        //getQuestion();
        myQuestion = "What color is the sky?";
        mySolution = "blue";
    }
    
    
    //getQuestion - say they're a string for now
    public String getQuestion() {
        return myQuestion;
    }
    
    public String getSolution() {
        return mySolution;
    }
    
    public void setQuestionAndSolution(final String theQ, final String theSol) {
        myQuestion = theQ;
        mySolution = theSol;
    }
    
    //Determine if input is solution  
    public boolean isSolution(final String theInput) {
        return  mySolution.toLowerCase().equals(theInput.toLowerCase());
    }
    
   
}
