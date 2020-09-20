package controller;

public class Stack {
	
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
		String itemRemovido;
		try {
			itemRemovido = "o item " + Integer.toString(this.stackItem) + " foi removido";
			this.stackItem = this.belowStack.stackItem;
			this.belowStack  =this.belowStack.belowStack;
			System.out.println(itemRemovido);		}
		
		catch(NullPointerException e) {
			try {
				itemRemovido = "o item " + Integer.toString(this.stackItem) +" foi removido\nLista Vazia";
				this.stackItem = (Integer) null;
				this.belowStack = null;		
				System.out.println(itemRemovido);				
			}
			catch(NullPointerException f) {
				itemRemovido = "operação inválida, a lista esta vazia";	
				System.out.println(itemRemovido);
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
