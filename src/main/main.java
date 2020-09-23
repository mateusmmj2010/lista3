package main;
import controller.Stack;
import controller.Queue;

public class main {	
	public static void main(String[] args) {
//		Stack newStack = new Stack(); //test stack	
		Queue newQueue = new Queue(); //test queue
		
		newQueue.enqueue(10);
		newQueue.enqueue(20);
		newQueue.enqueue(30);
		newQueue.enqueue(40);
		newQueue.enqueue(50);
		newQueue.enqueue(60);
		newQueue.enqueue(70);
		newQueue.enqueue(80);
		newQueue.showQueue("length");
		newQueue.showQueue("all");
		newQueue.dequeue();
		newQueue.enqueue(90);
		newQueue.showQueue("length");
	}
}
