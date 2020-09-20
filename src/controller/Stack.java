package controller;

public class Stack {
	/**
	 *  this class implements a stack based on dynamic memory allocation
	 *  properties - int stackItem, Stack belowStack, int stackLength
	 *  methods - pushItem(), popItem(), rangeStack(), showStack()
	 */		
	private int stackItem;
	private Stack belowStack;	
	private int stackLength;

	public Stack() {
		/**
		 * constructor
		 */
	}	
	
	public Stack (int stackItem) {
		/**
		 * constructor
		 */
		this.stackItem = stackItem;
		this.belowStack = null;
	}
	
	public void pushItem(int stackItem) {		
		/**
		 * add item to stack
		 */
		if (this.stackLength > 0) {
			Stack no = new Stack(this.stackItem);			
			no.belowStack = this.belowStack;
			this.stackItem = stackItem;			
			this.belowStack = no;
			this.stackLength += 1;
		}
		else {
			this.stackItem = stackItem;
			this.stackLength += 1;
		}
	}
	
	public void popItem() {
		/**
		 * remove item from stack
		 */
		String removedItem;
		try {
			removedItem = " item " + Integer.toString(this.stackItem) + " was removed";
			this.stackItem = this.belowStack.stackItem;
			this.belowStack  = this.belowStack.belowStack;
			this.stackLength -= 1;
			System.out.println(removedItem);		}
		
		catch(NullPointerException e) {
			try {
				removedItem = "o item " + Integer.toString(this.stackItem) +" was removed, empty stack";
				this.stackItem = (Integer) null;
				this.belowStack = null;		
				this.stackLength -= 1;
				System.out.println(removedItem);				
			}
			catch(NullPointerException f) {
				removedItem = "invalid operation, empty stack";	
				System.out.println(removedItem);
			}						
		}
	}	
	
	public int rangeStack() {
		/**
		 * return range stack
		 */
		return this.stackLength;
	}	
	
	public void showStack() {
		/**
		 * show all items on stack
		 */
		Stack no = this;
		while (no != null){
			System.out.println("item" + no.stackItem);
			no = no.belowStack;
		}
	}
}
