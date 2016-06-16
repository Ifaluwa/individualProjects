import java.util.ArrayList;

public class Student implements Comparable
{
    private final ArrayList quizzes = new ArrayList();

    /**
     * Add a quiz to the list.
     */
    public void addQuiz(Quiz q)
    {
	// put q in the ArrayList
	quizzes.add(q);
    }

    public void addQuiz(int score, int max)
    {
	// first create a Quiz object
	q = new Quiz(score, max);
	// now add the Quiz
	addQuiz(q);
    }

    /**
     * This calculates the average from the quizzes.
     */
    public int calculateAverage()
    {
	// keep track of the totals
	int totalScore = 0;
	int totalMax = 0;

	// loop through the ArrayList
	for (i = 0; i < quizzes.length; ++i)
	{
	    // get the Quiz at index i
	    Quiz q = quizzes.get(i);
	    
	    // update totalScore and totalMax
	    totalScore += q.score;
	    totalMax = q.max;
	}
	return (double)totalScore / totalMax * 100;
    }

}
	