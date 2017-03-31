/*Month class stores list of tasks and days when current*/
public class Month{
	
	/*Create instance variables for Month object*/
	int maxDays;
	LL tasks = new LL();
	String month;
	
	/*
	 *Default constructor for Month object
	 *@param String
	 */
	public Month(String month){
		this.month = month;
	}
	
	/*
	 *Add new task to the given day and month
	 *@param String
	 *@param String
	 *@param int
	 */
	public void scheduleTask(String task, String month, int day){
		Task newTask = new Task(task, month, day);
		Node<Task> nt = new Node<>(newTask);
		tasks.append(nt);
	}
	
	/*
	 *Return month
	 *@return String
	 */
	public String getMonth(){return month;}
		
	/*
	 *Add months tasks to corresponding days
	 *@param Node
	 */
	public void monthTasksToDaysList(Node tempDayNode){
		Node tempTaskNode = tasks.head;
		Day tempDay;
		Task tempTask;
		int month = 0;
		while(tempDayNode != null && month < 31){
			tempDay = (Day)tempDayNode.get();
			while(tempTaskNode != null){
				tempTask = (Task)tempTaskNode.get();
				if(tempTask.getDayDue() == tempDay.getDay()){
					tempDay.appendTask(tempTaskNode);
					tempTaskNode = tempTaskNode.next;
				}else{
					tempTaskNode = tempTaskNode.next;
				}
			}
			month++;
			tempDayNode = tempDayNode.next;
		}
		tasks = new LL();
	}
}