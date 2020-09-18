package controller;

public class Stack {
	
	private int stackItem;
	private Stack abaixo;
	
	public Stack (int stackItem) {
		this.stackItem = stackItem;
		this.abaixo = null;
	}
	
	public void addItem(int stackItem) {		
		Stack no = new Stack(stackItem);
		no.abaixo = this.abaixo;
		no.stackItem = this.stackItem;
		this.abaixo = no;	
		this.stackItem = stackItem;			
	}
	
	public void showStack() {
		Stack no = this;
		while (no.abaixo != null) {
			System.out.println(no.stackItem);
			no = no.abaixo;
		}			
	}
}
