package model;

//import db.SqliteDB;

public class Question {
    private String myQuestion;
    private String mySolution;
    //private SqliteDB database;
    
    
    public Question() {
        //myQ = new Question();
        //getQuestion();
        //To be changed once database is up
        myQuestion = "What color is the sky?";
        mySolution = "blue";
        //database = new SqliteDB();
    }

    public Question(String theQuestion, String theSolution) {
        //myQ = new Question();
        //getQuestion();
        myQuestion = theQuestion;
        mySolution = theSolution;
    }
    
    
    //getQuestion - say they're a string for now
    public String getQuestion() {
        return myQuestion;
    }
    
    public String getSolution() {
        return mySolution;
    }
    
    //getSolution

    public void setQuestionAndSolution(final String theQ, final String theSol) {
        myQuestion = theQ;
        mySolution = theSol;
    }

    //Determine if input is solution
    public boolean isSolution(final String theInput) {
        return  mySolution.equalsIgnoreCase(theInput);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return question.myQuestion.equalsIgnoreCase(myQuestion) && question.mySolution.equalsIgnoreCase(mySolution);
        //return Objects.equals(myQuestion, question.myQuestion) && Objects.equals(mySolution, question.mySolution);
    }
}
