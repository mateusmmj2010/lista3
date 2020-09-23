package controller;

public class Listc {
	/**
	 *  FALTA DOCUMENTAR CLASSE
	 */
	
	private Listc firstItem, lastItem;
	private Listc prevItem, nextItem;
	private double temperatura;
	private int length;
	
	public Listc() {
		super();
	}
	
	public void appendList (double temp) {
		Listc no = new Listc();
		no.temperatura = temp;
		
		if (this.firstItem == null) {
			this.firstItem = no;
			this.lastItem = no;		
			this.length ++;
		}
		else {
			Listc aux = new Listc();
			aux = this.lastItem;
			aux.nextItem = no;
			this.lastItem = no;
			this.lastItem.prevItem = aux;
			this.length ++;
		}		
	}
	
	public void popList() {
		try {
			this.lastItem = this.lastItem.prevItem;
			this.lastItem.nextItem = null;
			this.length --;
		} catch (NullPointerException e) {
			System.out.println("lista vazia");
		}
	}	
	
	public void inserList(double value, int position) {
		Listc no = new Listc();
		no.temperatura = value;
		
		if (this.length < 1 || position == this.length ) {
			appendList(value);
		}
		
		else if (position > this.length) {
			System.out.println("inserção inválida, posição inexistente");
		}
		
		else {
			
			if (position == 0) {
				Listc noA = new Listc();
				noA.temperatura = value;	
				
				Listc aux = new Listc();
				aux = this.firstItem;
				aux.prevItem = this.firstItem ;
				this.firstItem = no;
				this.firstItem.nextItem = aux;
				this.firstItem.prevItem = null;			
				length++;
				
				
			}

			else {
				Listc auxA = this.firstItem;
				int auxB = 0;
				int auxC = 0;
				
				while (auxC == 0) {
					if (auxB == position) {
						no.prevItem = auxA.prevItem;
						no.nextItem = auxA;
						no.nextItem.prevItem = no;
						no.prevItem.nextItem = no;
						auxC ++;
						this.length ++;
					}
					else {
						auxB ++;
						auxA = auxA.nextItem;
					}				
				}				
			}
		}		
	}
	
	
	public void showList() {
		Listc aux = this.firstItem;
		
		do {
			System.out.println("item "+aux.temperatura);
			aux = aux.nextItem;
		} while (aux != null);	
		System.out.print(length);
	}
}
