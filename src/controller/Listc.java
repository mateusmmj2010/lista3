package controller;

public class listaTemperatura {
	
	public listaTemperatura primeira_temp, ultima_temp, prox_temp, prev_temp;
	private double temperatura;
	private static int lengthLista;
	
	public listaTemperatura(){
		/**
		 * constructor
		 */
		super();
	}
		
	public listaTemperatura (double temperatura) {
		/**
		 * constructor(double temperature)
		 */
		this.temperatura = temperatura;
		this.prev_temp = null;
		this.prox_temp = null;
		this.primeira_temp = this;
		this.ultima_temp = this;
	}	
	
	
	public void appendInicio (double temperatura) {
		/**
		 * adiciona inicio/cria lista
		 */
		listaTemperatura no = new listaTemperatura(temperatura);		
		
		if (primeira_temp == null) {
			this.primeira_temp = no;
			this.ultima_temp = no;
			lengthLista ++;
		}
		else {
			listaTemperatura auxA = new listaTemperatura();
			auxA = this.primeira_temp;			
			auxA.prev_temp = no;
			no.prox_temp = auxA;			
			this.primeira_temp = no;	
			lengthLista ++;
		}		
	}
	
	public void removeInicio () {
		/**
		 * remove inicio
		 */
		if (primeira_temp == null) {
			System.out.println("Operação inválida, lista vazia");
		}
		else {
			this.primeira_temp = this.primeira_temp.prox_temp;
			this.primeira_temp.prev_temp = null;
			lengthLista --;
		}		
	}
	
	
	public void appendFinal(double temperatura) {
		/**
		 * adiciona final
		 */
		listaTemperatura no = new listaTemperatura(temperatura);
		
		if (primeira_temp==null) {
			appendInicio(temperatura);
		}
		else {
			listaTemperatura aux = new listaTemperatura();
			aux = this.ultima_temp;
			aux.prox_temp = no;
			no.prev_temp = aux;
			this.ultima_temp = no;		
			lengthLista ++;
		}		
	}
	
	
	public void removeFinal() {
		/**
		 * remove final
		 */
		if (primeira_temp == null) {
			System.out.println("Operação inválida, lista vazia");
		}
		else {
			this.ultima_temp = this.ultima_temp.prev_temp;
			this.ultima_temp.prox_temp = null;
			lengthLista --;
		}
	}	
	
	public void insertPosition(double temperatura, int posicao) {
		/**
		 * chama InsertionPosition
		 */
		insertPosition(temperatura, posicao, 0, this.primeira_temp);
	}
	
	public void insertPosition(double temperatura, int posicao, int contador, listaTemperatura compare) {
		/**
		 * insere a temperatura na posicao[posicao]
		 */
		try {

			if (posicao == 0) {
				appendInicio(temperatura);
			}
			else if(posicao == lengthLista) {
				appendFinal(temperatura);
			}		
			else {
				if (posicao == contador) {
					listaTemperatura aux = new listaTemperatura(temperatura);
					aux.prev_temp = compare.prev_temp;
					aux.prox_temp = compare;
					aux.prev_temp.prox_temp = aux;
					aux.prox_temp.prev_temp = aux;
				}
				else {
					insertPosition(temperatura, posicao, contador+1, compare.prox_temp);
				}
			}		
		} catch (NullPointerException e) {
			System.out.println("[insertPosition] - operação inválida - {temperatura: "
								+temperatura+" posição "+posicao+ "} mensagem ["+ e.getMessage()+"]");
		}
	}
	
	public void removePosition(int posicao) {
		/**
		 * chama removePosition
		 */
		removePosition(posicao, 0, this.primeira_temp);
	}
	
	public void removePosition(int posicao, int contador, listaTemperatura compare) {
		/**
		 * remove o item da posicao[posicao]
		 */
		try {
			if (posicao == 0) {
				removeInicio();
			}
			
			else if(posicao == lengthLista-1) {
				removeFinal();
				
			}
			else {
				if (posicao == contador) {
					compare.prox_temp.prev_temp = compare.prev_temp;
					compare.prev_temp.prox_temp = compare.prox_temp;
					compare = null;
				}
				else {
					removePosition(posicao, contador+1, compare.prox_temp);
				}				
			}			
		}catch(NullPointerException e) {
			System.out.println("Operação inválida, lista vazia");
		}		
	}	
	
	public void showLista() {
		/**
		 * chama showLista
		 */		
		showLista(this.primeira_temp);
	}
	
	public void showLista(listaTemperatura compare) {
		/**
		 * mostra itens da lista
		 */		
		if (compare != null) {
			System.out.println(compare.temperatura);
			showLista(compare.prox_temp);
		}
		else {
			System.out.println("tamanho da lista [" + lengthLista + "]");
		}
	}
}
