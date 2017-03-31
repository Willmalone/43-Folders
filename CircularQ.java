/*CircularQ creates a looped list*/
public class CircularQ{

	/*Create instance variable*/
	LL list;
	
	/*
	 *Default constructor setting maxSize
	 *@param int
	 */
	public CircularQ(int maxSize){
		list = new LL(maxSize);
	}
	
	/*
	 *Return size
	 *@return int
	 */
	public int getSize(){
		return list.getSize();
	}
	
	/*
	 *Add Node to end of list
	 *@param Node
	 */
	public void append(Node n){
		if((list.size + 1) == list.maxSize){
			list.appendLast(n);
		}else{
			list.append(n);
		}
	}
	
	/*
	 *Return if list is empty
	 *@return boolean
	 */
	public boolean isEmpty(){return list.isEmpty();}
	
	/*
	 *Return if list is full
	 *@return boolean
	 */
	public boolean isFull(){return list.isFull();}
	
	/*Advance current to next Node*/
	public void advance(){list.advance();}
	
	/*
	 *Return current
	 *@return Node
	 */
	public Node getCurrent(){return list.getCurrent();}	
}