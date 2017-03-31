/*Day class stores a lists of tasks for that day and the number of the day in the month*/
public class Day{
	
	//Create instance vars list of tasks and the day of the month
	LL tasks;
	int day;
	
	/*
	 *Default constructure for Day object
	 *@param int
	 */
	public Day(int day){
		this.day = day;
		tasks = new LL();
	}
	
	/*
	 *Add Node to end of task list
	 *@param Node
	 */	
	public void appendTask(Node n){tasks.append(n);}
	
	/*
	 *Add new task to the given day and month
	 *@param String, String, int
	 */
	public void scheduleTask(String task, String month, int day){
		Task newTask = new Task(task, month, day);
		Node<Task> nt = new Node<>(newTask);
		tasks.append(nt);
	}
	
	/*
	 *Mark task as complete and removes it from the days list of tasks
	 *@param String
	 */
	public void completeTask(String task){
		String wasFound = "";
		if(!tasks.isEmpty()){
			Node tempNode = tasks.head;
			Node prevNode = null;
			Task temp = null;
			while(tempNode != null){
				temp = (Task)tempNode.get();
				if(temp.getTask().equals(task)){
					if(tempNode == tasks.head){
						if(tempNode.next == null){
							tasks.head = null;							
						}
						tasks.head = tempNode.next;
						tempNode.next = null;
					}else if(tempNode == tasks.tail){
						tasks.tail = prevNode;
					}else{
						prevNode.next = tempNode.next;
						tempNode.next = null;
					}
					tempNode = null;
					tasks.size--;
					wasFound = "completed!";
				}else{
					prevNode = tempNode;
					tempNode = tempNode.next;
					wasFound = "does not exist for this day.";
				}
			}
		}else{
			wasFound = "does not exist for this day.";
		}
		System.out.println(task + " task " + wasFound);
	}
	
	/*Print the list of tasks for the day*/
	public void printTaskList(){
		if(!tasks.isEmpty()){
			Node tempNode = tasks.head;
			while(tempNode != null){
				Task tempTask = (Task)tempNode.get();
				System.out.println(tempTask.getTask());
				tempNode = tempNode.next;
			}
		}else{
			System.out.println("No tasks for today!");
		}
	}
	
	/*
	 *Get the number of the day in the month
	 *@return int
	 */
	public int getDay(){return day;}
	
}