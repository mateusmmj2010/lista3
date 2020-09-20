package controller;

public class Stack {
	/**
	 *  this class implements a stack based on dynamic memory allocation
	 */
	
	private int stackItem;
	private Stack belowStack;
	
	public Stack (int stackItem) {
		this.stackItem = stackItem;
		this.belowStack = null;
	}
	
	public void pushItem(int stackItem) {		
		/**
		 * add item to stack
		 */
		Stack no = new Stack(this.stackItem);
		no.belowStack = this.belowStack;
		this.stackItem = stackItem;			
		this.belowStack = no;	
	}
	
	public void popItem() {
		/**
		 * remove item from stack
		 */
		String removedItem;
		try {
			removedItem = " item " + Integer.toString(this.stackItem) + " was removed";
			this.stackItem = this.belowStack.stackItem;
			this.belowStack  =this.belowStack.belowStack;
			System.out.println(removedItem);		}
		
		catch(NullPointerException e) {
			try {
				removedItem = "o item " + Integer.toString(this.stackItem) +" was removed, empty stack";
				this.stackItem = (Integer) null;
				this.belowStack = null;		
				System.out.println(removedItem);				
			}
			catch(NullPointerException f) {
				removedItem = "invalid operation, empty stack";	
				System.out.println(removedItem);
			}						
		}
	}	
	
	public void showStack() {
		/**
		 * show all items on stack
		 */
		Stack no = this;
		while (no.belowStack != null) {
			System.out.println(no.stackItem);
			no = no.belowStack;
		}			
	}
}
