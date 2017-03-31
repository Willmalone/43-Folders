/*Node class data structure for storing objects generic type*/
public class Node<T>{

	/*Instance variables for Node object*/
	T data;
	Node next;

	/*
	 *Default constructor
	 *@param T
	 */
	public Node(T data){
		this.data = data;
		this.next = null;
	}
	
	/*
	 *Retun data
	 *@return T
	 */
	public T get(){
		return data;
	}
}