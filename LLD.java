public class LLD{

	Day head;
	Day tail;
	int size;
	int maxSize;
	
	public LinkedList(int maxSize){
		maxSize = maxSize;
		size = 0;
		head = null;
		tail = null;
	}
	
	public void push(Day d){
		if(isEmpty()){
			head = d;
			tail = d;
		}else{
			tail.next = d;
			tail = d;
		}
		size++;
	}	
	
	public boolean isEmpty(){ 
		return (size == 0);
	}
		
}