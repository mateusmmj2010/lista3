package main;
import controller.Stack;

public class main {	
	public static void main(String[] args) {
		Stack newStack = new Stack(); //test stack	
		newStack.pushItem(10);
		newStack.pushItem(20);
		newStack.pushItem(30);
		newStack.pushItem(40);
		newStack.showStack();
		newStack.popItem();
		newStack.showStack();
		newStack.popItem();
		newStack.showStack();
		newStack.popItem();
		
	//	Queue newQueue = new Queue(); //test queue
	}
}
