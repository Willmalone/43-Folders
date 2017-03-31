//import scanner
import java.util.*;

/*
 *Tickler class creates structures required for the 43 folder system
 *and allows the user to add, reschedule, complete tasks and advance days
 */
public class Tickler{
	/*Instance variables storing months and days used by system*/
	CircularQ monthll = new CircularQ(12);
	CircularQ dayll = new CircularQ(31);
	
	/*Instantiate new Tickler file*/
	public static void main(String[] args){
		new Tickler();
	}
	
	/*Define months and days for use in duration of program starts the mainloop*/	
	public Tickler(){
		addMonth("January");
		addMonth("February");
		addMonth("March");
		addMonth("April");
		addMonth("May");
		addMonth("June");
		addMonth("July");
		addMonth("August");
		addMonth("September");
		addMonth("October");
		addMonth("November");
		addMonth("December");
		for(int i = 1; i <= 31; i++){
			addDay(i);
		}
		mainloop();
	}
	/*Main loop of program keeps user in until they exit*/
	public void mainloop(){
		boolean cont = true;
		System.out.println("Welcome to the 43 folders system\n");
		do{	
			Month tempMonth = (Month)monthll.getCurrent().get();
			Day tempDay = (Day)dayll.getCurrent().get();
			System.out.println(tempMonth.getMonth() + " " + tempDay.getDay());
			System.out.println("1. List Today's tasks\n2. Scehdule task\n3. Reschedule Task\n4. Complete task\n5. Advance Day\n6. Exit");
			Scanner getInput = new Scanner(System.in);
			int input = 0;
			String[] in;
			String task;
			String month;
			int day;
			try{
				input = getInput.nextInt();
			}catch(NumberFormatException nfe){
				System.out.println(nfe);
			}
			switch(input){
				case 1:
					listDaysTasks();
					break;
				case 2:
					in = getTaskInfo(input).split(" ",3);
					task = in[0];
					month = in[1];
					day = Integer.parseInt(in[2]);
					scheduleTask(task, month, day);
					break;
				case 3:
					in = getTaskInfo(input).split(" ",3);
					task = in[0];
					month = in[1];
					day = Integer.parseInt(in[2]);
					rescheduleTask(task, month, day);
					break;
				case 4:
					task = getTaskInfo(input);
					completeTask(task);
					break;
				case 5:
					advanceDay();
					break;
				case 6:
					cont = false;
					break;
			}
		}while(cont);
	}
	
	/*Display list of the days tasks to the cmd*/
	public void listDaysTasks(){
		Node tempNode = dayll.getCurrent();
		Day tempDay = (Day)tempNode.get();
		tempDay.printTaskList();
	}
	
	/*Advance to the next day adding unfinished tasks to the next day*/
	public void advanceDay(){
		Node tempDayNode = dayll.getCurrent();
		Node tempNextDay = tempDayNode.next;
		Day tempDay = (Day)tempDayNode.get();
		Day nextDay = (Day)tempNextDay.get();
		Node tempTaskNode = tempDay.tasks.head;
		while(tempTaskNode != null){
			nextDay.tasks.append(tempTaskNode);
			tempTaskNode = tempTaskNode.next;
		}
		if(tempDay.getDay() == 31){
			monthll.advance();
			Node tempMonthNode = monthll.getCurrent();
			Month tempMonth = (Month)tempMonthNode.get();
			tempMonth.monthTasksToDaysList(tempDayNode.next);
		}
		dayll.advance();
	}
	
	/*Add new task to the given day and month*/
	public void scheduleTask(String task, String month, int day){
		Node tempMonthNode = monthll.getCurrent();
		Month tempMonth = (Month)tempMonthNode.get();
		Node tempDayNode = dayll.getCurrent();
		if(tempMonth.getMonth().equals(month)){
			while(tempDayNode != null){
				Day tempDay = (Day)tempDayNode.get();
				if(tempDay.getDay() == day){
					tempDay.scheduleTask(task, month, day);
					tempDayNode = null;
				}else{
					tempDayNode = tempDayNode.next;
				}
			}
		}else{			
			while(!tempMonth.getMonth().equals(month)){
				tempMonth = (Month)tempMonthNode.get();
				tempMonthNode = tempMonthNode.next;
			}
			tempMonth.scheduleTask(task, month, day);
		}
	}
	
	/*Change the date of a given task*/
	public void rescheduleTask(String task, String newMonth, int newDay){
		Node tempMonthNode = monthll.getCurrent();
		while(tempMonthNode != null){
			Month tempMonth = (Month)tempMonthNode.get();
			Node tempDayNode = dayll.getCurrent();
			while(tempDayNode != null){
				Day tempDay = (Day)tempDayNode.get();
				Node prevTaskNode = null;
				Node tempTaskNode = tempDay.tasks.head;
				while(tempTaskNode != null){
					Task tempTask = (Task)tempTaskNode.get();
					if(tempTask.getTask().equals(task)){
						if(tempTask == tempDay.tasks.head.get()){
							tempDay.tasks.head = tempTaskNode.next;
							tempTaskNode.next = null;
						}else if(tempTaskNode == tempDay.tasks.tail){
							tempDay.tasks.tail = prevTaskNode;
							tempDay.tasks.tail = null;
						}else{
							prevTaskNode.next = tempTaskNode.next;
							tempTaskNode.next = null;
						}
						tempTaskNode = null;
						tempDayNode = null;
						tempMonthNode = null;
						scheduleTask(task, newMonth, newDay);
					}else{
						prevTaskNode = tempTaskNode;
						tempTaskNode = tempTaskNode.next;
					}
				}
			}	
		}
	}
	
	/*
	 *Mark task as complete and remove it
	 *@param String task
	 */
	public void completeTask(String task){
		Node tempNode = dayll.getCurrent();
		Day tempDay = (Day)tempNode.get();
		tempDay.completeTask(task);		
	}
	/*
	 *Add months to the circular queue
	 *@param String month
	 */
	public void addMonth(String month){
		Month newMonth = new Month(month);
		Node<Month> newNode = new Node<>(newMonth);
		monthll.append(newNode);
	}
	/*
	 *Add days to the dayll
	 *@param int day
	 */
	public void addDay(int day){
		Day newDay = new Day(day);
		Node<Day> newNode = new Node<>(newDay);
		dayll.append(newNode);
	}
	/*
	 *Get task input from user
	 *@return String
	 */
	public String getTaskInfo(int choice){
		if(choice == 4){
			System.out.println("Enter the task to complete");
		}else{
			System.out.println("Enter the task and the month and day due\nExample: Quarterly Statment January 1");
		}
		Scanner getInput = new Scanner(System.in);
		String input = "";
		try{
			input = getInput.nextLine();
		}catch(InputMismatchException ime){
			System.out.println("Bad input");
		}
		return input;
	}
}