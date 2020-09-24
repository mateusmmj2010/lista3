package controller;

public class Listc {
	/**
	 *  FALTA DOCUMENTAR CLASSE
	 */	
	public Listc firstItem, lastItem;
	private Listc prevItem, nextItem;
	private double temperatura;
	private int length = 0;
	
	public Listc() {
		super();
	}
	
	public boolean emptyList() {
		/**
		 *  this methods returns TRUE if list if first item is null
		 */
		try {
			if (firstItem == null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			String erro = e.getMessage();
			System.out.println("exceção não tratada" + erro);
			return false;
		}
	}	
	

	public void inserList(double value, int position) {
		/**
		 *  this methods insert a element acording a indice
		 */
		try {		
			Listc no = new Listc();
			no.temperatura = value;
		
			if ((this.length < 1 || position >= this.length) && position >= 0 ) {
				appendList(value);
			}
		
			
			else if (position > this.length || position < 0) {
				System.out.println("inserção inválida, posição inexistente");
			}

			else {
			
				if (position == 0) {
					insertInicio(no);			
				}

				else {				
					insertPosition(value, position, 0, no, this.firstItem);	
				}
			}		
		} catch (Exception e) {
			System.out.println("inclusão inválida");
		}
	}
	
	
	public void removeList(int position) {

		try {
			if (this.length < 1 || position > this.length){
				System.out.println("remoção inválida");
			}
	
			else if (position == 0){
				popFirstList();
			}
	
			else if (position == this.length-1){
				popList();
			}
	
			else{
				removePosition(position, 0, this.firstItem);
			}
		} catch (Exception e){
			System.out.println("remoção inválida");
		}
		
	}
	
	public void insertInicio(Listc no) {
		/**
		 *  this methods insert elements in indice 0
		 */
		try {
			Listc auxA = new Listc();
			auxA = this.firstItem;
			auxA.prevItem = this.firstItem ;
			this.firstItem = no;
			this.firstItem.nextItem = auxA;
			this.firstItem.prevItem = null;			
			this.length++;
		} catch (Exception e) {
			System.out.println("inclusão inválida");
		}
	}	
	
	public void insertPosition(double value, int position, int contador, Listc no, Listc itemCompare) {	
		/**
		 * this methods insert element in indice != 0 && != list.length
		 */
		try {
			if (position-1 == contador) {
				no.prevItem = itemCompare.prevItem;
				no.nextItem = itemCompare;
				no.nextItem.prevItem = no;
				no.prevItem.nextItem = no;
				this.length ++;		
			}
			else {
				insertPosition(value, position, contador+1,no, itemCompare.nextItem);
			}		
		} catch(Exception e) {
			System.out.println("inclusão inválida");
		}
	}
	
	public void removePosition(int position, int contador, Listc itemCompare) {
		try {
			if(position == contador) {				
				itemCompare.nextItem.prevItem = itemCompare.prevItem;
				itemCompare.prevItem.nextItem = itemCompare.nextItem;
				itemCompare = null;
				this.length --;
			}
			else {
				System.out.println("arqui" + position + contador);
				removePosition(position, contador+1,itemCompare.nextItem);
			}
		} catch (Exception e) {
			System.out.println("remoção inválida");
		}
	}
	
	
	public void appendList (double temp) {
		/**
		 * tis methods add item on final of list
		 */
		try {
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
		} catch(Exception e) {
			System.out.println("inclusão inválida");
		}
	}
	
	public void popList() {
		/**
		 * this methods remove last item
		 */
		try {
			this.lastItem = this.lastItem.prevItem;
			this.lastItem.nextItem = null;
			this.length --;
		}catch (NullPointerException e) {
			System.out.println("lista vazia");
		}
	}
	
	public void popFirstList() {
		/**
		 * this methods remove first item
		 */
		try {
			if (this.length == 1) {
				this.firstItem = null;
				this.length --;
			} else if (this.length > 1){ 
				this.firstItem = this.firstItem.nextItem;
				this.firstItem.prevItem = null;
				this.length --;
			} else {
				System.out.println("lista vazia");
			}			
			
		} catch(Exception e) {
			System.out.println("lista vazia");
		}
		
	}
	
	public void showList() {
		/**
		 * this methods shows all items on list
		 */
		try {
			Listc aux = this.firstItem;
			do {
				System.out.println("item "+aux.temperatura);
				aux = aux.nextItem;
			} while (aux != null);	
			System.out.print(length);
		} catch (NullPointerException e) {
			System.out.println("item não pode ser exibido");			
		}
	}
}
