package main;
import controller.Stack;

public class main {
	
	public static void main(String[] args) {
		Stack novo;
		novo = new Stack(10);
		novo.addItem(10);
		novo.addItem(20);
		novo.addItem(30);
		novo.addItem(40);
		novo.addItem(50);
		novo.removeItem();
		novo.removeItem();
		novo.removeItem();
		novo.removeItem();
		novo.removeItem();
		novo.addItem(30);
		novo.addItem(40);
		novo.addItem(50);
		novo.removeItem();
		novo.removeItem();
		novo.showStack();		
	}
}
