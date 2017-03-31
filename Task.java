/*Task class stores the name of a task, the day and month due, and if the task is complete*/
public class Task{
	
	/*Define instance variables String task int day due String month due*/
	String toDo;
	int dayDue;
	String monthDue;
	
	/*
	 *Default constructor
	 *@param String
	 *@param int
	 */
	public Task(String toDo, int monthDue){
		this.toDo = toDo;
		this.dayDue = monthDue;
	}
	/*
	 *Default constructor
	 *@param String
	 *@param String
	 *@param int
	 */
	public Task(String toDo, String monthDue, int dayDue){
		this.toDo = toDo;
		this.dayDue = dayDue;
		this.monthDue = monthDue;
	}
	
	/*
	 *Return toDo
	 *@return String
	 */
	public String getTask(){return this.toDo;}
	
	/*
	 *Set day due
	 *@param dayDue
	 */
	public void setDayDue(int dayDue){this.dayDue = dayDue;}
	
	/*
	 *Return dayDue
	 *@return int
	 */
	public int getDayDue(){return this.dayDue;}
	
	/*
	 *Set monthDue
	 *@param String
	 */
	public void setMonthDue(String monthDue){this.monthDue = monthDue;}
	
	/*
	 *Return monthDue
	 *@return String
	 */
	public String getMonthDue(){return this.monthDue;}
	
}