package main;
import controller.Stack;
import controller.Listc;
import controller.Queue;

public class main {	
	public static void main(String[] args) {
//		Stack newStack = new Stack(); //test stack	
//		Queue newQueue = new Queue(); //test queue
		Listc newList = new Listc(); //test list
		newList.inserList(10,1);
		newList.inserList(20,1);
		newList.showList();
		
	}
}
