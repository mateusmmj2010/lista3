package main;
import controller.Stack;

public class main {	
	public static void main(String[] args) {
		Stack novo;
		novo = new Stack(10);
		novo.pushItem(10);
		novo.pushItem(20);
		novo.pushItem(30);
		novo.pushItem(40);
		novo.pushItem(50);
		novo.popItem();
		novo.popItem();
		novo.popItem();
		novo.popItem();
		novo.popItem();
		novo.pushItem(30);
		novo.pushItem(40);
		novo.pushItem(50);
		novo.popItem();
		novo.popItem();
		novo.showStack();		
	}
}
