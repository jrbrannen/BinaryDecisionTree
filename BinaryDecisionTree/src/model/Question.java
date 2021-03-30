
package model;
import java.util.Scanner;

/**
 * @author Jeremy Brannen - jrbrannen
 *CIS175
 * Mar 29, 2021
 */
public class Question {
	
	private Question yes;
	private Question no;
	private String data;

	public Question() {
		super();
	}

	public Question(Question yes, Question no, String data) {
		super();
		this.yes = yes;
		this.no = no;
		this.data = data;
	}

	public Question getYes() {
		return yes;
	}

	public void setYes(Question yes) {
		this.yes = yes;
	}

	public Question getNo() {
		return no;
	}

	public void setNo(Question no) {
		this.no = no;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	/**
	 * This method creates new Question objects and checks the yes and no 
	 * properties and compares it to the user input to respond with the 
	 * appropriate question or answer. Method will run until it gets to a leaf
	 * or (null, null).
	 */
	public static void response() {
		
		Question one = new Question(null, null, "Take a nap.");
		Question two = new Question(null, null, "Do Homework.");
		Question three = new Question(one, two, "Are you tired?");
		Question four = new Question(null,null, "Go to the gym.");
		Question five = new Question(null, null, "Go for a walk.");
		Question six = new Question(four, five, "Is it raining?");
		Question seven = new Question(three, six, "Have you exercised yet?");
		
		Question current = seven;
		
		System.out.println(seven.getData());
		
		Scanner in = new Scanner(System.in);
		String decision = in.nextLine();
		
		while (current.getYes() != null && current.getNo() != null) {
			if (decision.toLowerCase().equals("yes")) {
				System.out.println(current.getYes().getData());
				decision = in.nextLine();
				current = current.getYes();
			}else {
				System.out.println(current.getNo().getData());
				decision = in.nextLine();
				current = current.getNo();
			}
		}
	in.close();	
	}

	@Override
	public String toString() {
		return "Question [yes=" + yes + ", no=" + no + ", data=" + data + "]";
	}

}
