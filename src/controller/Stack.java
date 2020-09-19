package controller;

public class Stack {
	
	private int stackItem;
	private Stack abaixo;
	
	public Stack (int stackItem) {
		this.stackItem = stackItem;
		this.abaixo = null;
	}
	
	public void addItem(int stackItem) {		
		/**
		 * adicionar item à pilha
		 */
		Stack no = new Stack(this.stackItem);
		no.abaixo = this.abaixo;
		this.stackItem = stackItem;			
		this.abaixo = no;	
	}
	
	public void removeItem() {
		/*
		 * remover item da pilha
		 */
		String itemRemovido;
		try {
			itemRemovido = "o item " + Integer.toString(this.stackItem) + " foi removido";
			this.stackItem = this.abaixo.stackItem;
			this.abaixo  =this.abaixo.abaixo;
			System.out.println(itemRemovido);		}
		
		catch(NullPointerException e) {
			try {
				itemRemovido = "o item " + Integer.toString(this.stackItem) +" foi removido\nLista Vazia";
				this.stackItem = (Integer) null;
				this.abaixo = null;		
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
		 * exibir todos os items da pilha
		 */
		Stack no = this;
		while (no.abaixo != null) {
			System.out.println(no.stackItem);
			no = no.abaixo;
		}			
	}
}
