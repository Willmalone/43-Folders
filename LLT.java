public class LLT{

	Task head;
	Task tail;
	int size;
	int maxSize;
	
	public LinkedList(int maxSize){
		maxSize = maxSize;
		size = 0;
		head = null;
		tail = null;
	}
	
	public void push(Task t){
		if(isEmpty()){
			head = t;
			tail = t;
		}else{
			tail.next = t;
			tail = t;
		}
		size++;
	}	
	
	public boolean isEmpty(){ 
		return (size == 0);
	}
		
}