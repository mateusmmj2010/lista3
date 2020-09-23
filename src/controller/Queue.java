package controller;

public class Queue {
	/**
	 *  FALTA DOCUMENTAR A CLASSE E SEGUIR OS PADRÕES
	 */	
	private Queue firstItem, lastItem;
	private Queue prevItem, nextItem;
	private int numeroItem, lengthQueue;
	
	public Queue() {
		super();			
	}	
	
	public void enqueue (int item) {
		Queue no = new Queue();
		no.numeroItem = item;	
		if (firstItem == null) {	
			this.firstItem = no;
			this.lastItem = no;
			lengthQueue++;
		}
		else {
			Queue aux = new Queue();
			aux = this.lastItem;
			aux.nextItem = no;
			this.lastItem = no;
			this.lastItem.prevItem = aux;			
			lengthQueue++;
		}
	}
	
	
	public void dequeue() {
		try {
			this.firstItem = this.firstItem.nextItem;
			this.firstItem.nextItem = null;
			lengthQueue--;
		} catch (NullPointerException e) {
			System.out.println("impossivel eliminar elementos, a fila esta vazia");
		}
	}	
	
	
	public void showQueue(String param) {
		
		switch(param) {
		
		case "all":
			try {
				Queue aux = this.firstItem;
				do {
					System.out.println(aux.numeroItem);
					aux = aux.nextItem;
				} while (aux != null);	
			} catch (NullPointerException e) {
				System.out.println("fila vazia");
			}
			break;
		
		case "last":
			try {
				System.out.println("last item: "+ this.lastItem.numeroItem);
			} catch (NullPointerException e) {
				System.out.println("fila vazia");
			}
			break;
		
		case "first":
			try {
				System.out.println("first item: "+ this.firstItem.numeroItem);
			} catch (NullPointerException e) {
				System.out.println("fila vazia");
			}
			break;
		
		case "length":
			System.out.println("Length Queue: "+ this.lengthQueue);
			break;
			
		default:
			System.out.println("opção inválida");
			break;			
		}				
	}	
}