/*LL data structure for linking nodes to create a list*/
public class LL{

	/*Create instance variables*/
	Node head;
	Node tail;
	Node current;
	int size;
	int maxSize;
	
	/*Default constructor for LL*/
	public LL(){
		this.head = null;
		this.tail = null;
		this.current = null;
		this.size = 0;
	}
	
	/*
	 *Contstructor for LL sets maxSize
	 *@param int
	 */
	public LL(int maxSize){
		this.maxSize = maxSize;
		this.size = 0;
		this.head = null;
		this.tail = null;
		this.current = null;
	}
	
	/*
	 *Add Node to the front of list
	 *@param Node
	 */
	public void push(Node n){
		if(isEmpty()){
			this.head = n;
			this.tail = n;
			this.current = n;
		}else{
			n.next = this.head;
			this.head = n;
		}
		this.size++;
	}
	
	/*
	 *Add Node to the end of list
	 *@param Node
	 */
	public void append(Node n){
		if(isEmpty()){
			this.head = n;
			this.tail = n;
			this.current = n;
		}else{
			this.tail.next = n;
			this.tail = n;
		}
		size++;
	}
	
	/*
	 *Add Node to end of list creating circle
	 *@param Node
	 */
	public void appendLast(Node n){
		this.tail.next = n;
		this.tail = n;
		n.next = this.head;
		this.size++;
	}
	
	/*
	 *Return last in list of Nodes
	 *@return Node
	 */
	public Node pop(){
		Node temp = this.head;
		Node prev = null;
		if(!isEmpty()){
			while(temp != null){
				prev = temp;
				temp = temp.next;
			}
		}
		this.tail = prev;
		size--;
		return temp;
	}
	
	/*
	 *Return if list is empty
	 *@return boolean
	 */
	public boolean isEmpty(){ 
		return (size == 0);
	}
	
	/*
	 *Return is list is full
	 *@return boolean
	 */
	public boolean isFull(){
		return (size == maxSize);
	}
	
	/*Advance the current node to the next*/
	public void advance(){
		this.current = this.current.next;		
	}
	
	/*
	 *Return current node
	 *@return Node
	 */
	public Node getCurrent(){
		return this.current;
	}
	
	/*
	 *Return list size
	 *@return int
	 */
	public int getSize(){
		return this.size;
	}
}