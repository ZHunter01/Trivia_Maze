package model;

public class Question {
    private String myQuestion;
    private String mySolution;
    
    
    public Question() {
        //myQ = new Question();
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
    
    //getSolution
    
    public boolean isSolution(String theInput) {
        
        return  mySolution.equals(theInput.toLowerCase());
    }
    
   
}