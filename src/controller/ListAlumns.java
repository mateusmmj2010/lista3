package controller;

public class ListAlumns {
	/**
	 *  FALTA DOCUMENTAR CLASSE - ALUNOS - EXERCICIO 3
	 */	
	public ListAlumns firstItem, lastItem;
	private ListAlumns prevItem, nextItem;
	private int RaAlumn;
	private String nome, turma, semestre;
	private int length = 0;
	
	public ListAlumns() {
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
	

	public void inserList(int RaAlumn, String nome, String turma, String semestre, int position) {
		/**
		 *  this methods insert a element acording a indice
		 */
		try {		
			ListAlumns no = new ListAlumns();
			no.RaAlumn = RaAlumn;
			no.nome = nome;
			no.turma = turma;
			no.semestre = semestre;			
		
			if (this.length < 1 && position == this.length && position >= 0 ) {
				appendList(no);
			}		
			
			else if (position > this.length || position < 0) {
				System.out.println("inserção inválida, posição inexistente");
			}

			else {
			
				if (position == 0) {
					insertInicio(no);			
				}

				else {				
					insertPosition(position, 0, no, this.firstItem);	
				}
			}		
		} catch (Exception e) {
			System.out.println("inclusão inválida A");
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
	
	public void insertInicio(ListAlumns aluno) {
		/**
		 *  this methods insert elements in indice 0
		 */
		try {
			ListAlumns auxA = new ListAlumns();
			auxA = this.firstItem;
			auxA.prevItem = this.firstItem ;
			this.firstItem = aluno;
			this.firstItem.nextItem = auxA;
			this.firstItem.prevItem = null;			
			this.length++;
		} catch (Exception e) {
			System.out.println("inclusão inválida B");
		}
	}	
	
	public void insertPosition(int position, int contador, ListAlumns no, ListAlumns itemCompare) {	
		/**
		 * this methods insert element in indice != 0 && != list.length
		 */
		try {
			if (position == contador) {
				no.prevItem = itemCompare.prevItem;
				no.nextItem = itemCompare;
				no.nextItem.prevItem = no;
				no.prevItem.nextItem = no;
				this.length ++;		
			}
			else {
				insertPosition(position, contador+1,no, itemCompare.nextItem);
			}		
		} catch(Exception e) {
			System.out.println("inclusão inválida C");
		}
	}
	
	public void removePosition(int position, int contador, ListAlumns itemCompare) {
		try {
			if(position == contador) {				
				itemCompare.nextItem.prevItem = itemCompare.prevItem;
				itemCompare.prevItem.nextItem = itemCompare.nextItem;
				itemCompare = null;
				this.length --;
			}
			else {
				System.out.println("aqui" + position + contador);
				removePosition(position, contador+1,itemCompare.nextItem);
			}
		} catch (Exception e) {
			System.out.println("remoção inválida");
		}
	}
	
	
	public void appendList (ListAlumns aluno) {
		/**
		 * tis methods add item on final of list
		 */
		try {
			if (this.firstItem == null) {
				this.firstItem = aluno;
				this.lastItem = aluno;		
				this.length ++;
			}
			else {
				ListAlumns aux = new ListAlumns();
				aux = this.lastItem;
				aux.nextItem = aluno;
				this.lastItem = aluno;
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
			ListAlumns aux = this.firstItem;
			do {
				System.out.println("nome "+aux.nome+" ra "+aux.RaAlumn+" sala "+aux.turma+" semeste "+aux.semestre);
				aux = aux.nextItem;
			} while (aux != null);	
			System.out.print(length);
		} catch (NullPointerException e) {
			System.out.println("item não pode ser exibido");			
		}
	}
}
