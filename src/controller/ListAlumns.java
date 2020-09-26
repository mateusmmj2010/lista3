package controller;

public class listaAluno {
	private static int lengthListaAluno;
	private int raAluno;
	private String nomeAluno, turmaAluno, semestreAluno;
	private listaAluno primeiroAluno, ultimoAluno;
	private listaAluno prevAluno, proxAluno;	
	
	public listaAluno() {
		super();
	}
	
	public listaAluno(int raAluno, String nomeAluno, String turmaAluno, String semestreAluno) {
		this.raAluno = raAluno;
		this.nomeAluno = nomeAluno;
		this.turmaAluno = turmaAluno;
		this.semestreAluno = semestreAluno;
		this.prevAluno = null;
		this.proxAluno = null;
		this.primeiroAluno = this;
		this.ultimoAluno = this;		
	}	
	
	public void appendInicio(int raAluno, String nomeAluno, String turmaAluno, String semestreAluno) {
		/**
		 * adiciona inicio
		 */		
		listaAluno no = new listaAluno(raAluno, nomeAluno, turmaAluno, semestreAluno);
		
		if (this.primeiroAluno == null) {
			this.primeiroAluno = no;
			this.ultimoAluno = no;
			lengthListaAluno ++;
		}
		
		else {
			listaAluno aux = new listaAluno();
			aux = this.primeiroAluno;
			aux.prevAluno = no;
			no.proxAluno = aux;
			this.primeiroAluno = no;
			lengthListaAluno ++;			
		}		
	}
	
	
	public void removeInicio() {
		/**
		 * remove inicio
		 */
		if (this.primeiroAluno == null) {
			System.out.println("remoção inválida, lista vazia");
		}
		else {
			this.primeiroAluno = this.primeiroAluno.proxAluno;
			this.primeiroAluno.prevAluno = null;
			lengthListaAluno --;
		}		
	}
	
	
	public void appendFinal(int raAluno, String nomeAluno, String turmaAluno, String semestreAluno) {
		/**
		 * adiciona no final
		 */
		if (this.primeiroAluno == null) {
			appendInicio(raAluno, nomeAluno, turmaAluno, semestreAluno);
		}
		else {
			listaAluno no = new listaAluno(raAluno, nomeAluno, turmaAluno, semestreAluno);
			listaAluno aux = new listaAluno();			
			aux = this.ultimoAluno;
			aux.proxAluno = no;
			no.prevAluno = aux;
			this.ultimoAluno = no;
			lengthListaAluno ++;
		}		
	}
	
	public void removeFinal() {
		if (this.primeiroAluno == null) {
			System.out.println("remoção inválida, lista vazia");
		}
		else {
			this.ultimoAluno = this.ultimoAluno.prevAluno;
			this.ultimoAluno.proxAluno = null;
			lengthListaAluno --;
		}
	}
	
	public void appendPosition(int raAluno, String nomeAluno, String turmaAluno, String semestreAluno, int position) {
		listaAluno no = new listaAluno(raAluno, nomeAluno, turmaAluno, semestreAluno);
		appendPosition(no, this.primeiroAluno, position, 0);
	}
	
	
	private void appendPosition(listaAluno no, listaAluno compare, int position, int contador) {
		/**
		 * RECURSIVIDADE DIRETA
		 * este metodo adiciona um item a alguma posicao da lista,
		 * para encontrar a posicao correta o metodo é chamado recursivamente, os parametros "compare" e "contador" são incrementados
		 * compare do tipo listaAluno, recebe compare.proxAluno - contador receber contador + 1		 * 
		 */
		
		try {
			if (position == 0) {
				appendInicio(no.raAluno, no.nomeAluno, no.turmaAluno, no.semestreAluno);			
			}
			else if (position == lengthListaAluno) {
				appendFinal(no.raAluno, no.nomeAluno, no.turmaAluno, no.semestreAluno);
			}
			
			else {
				if (position == contador) {
					no.prevAluno = compare.prevAluno;
					no.proxAluno = compare;
					no.prevAluno.proxAluno = no;
					no.proxAluno.prevAluno = no;
					lengthListaAluno ++;				
				}
				else {		
					// chamada recursiva
					appendPosition(no, compare.proxAluno, position, contador+1);
				}				
			}
			
		} catch (Exception e) {
			System.out.println("inclusão inválida");
		}		
	}
	
	
	public void removePosition(int posicao) {
		/**
		 * RECURSIVIDADE DIRETA
		 * este metodo remove um item de alguma posicao da lista,
		 * para encontrar a posicao correta o metodo é chamado recursivamente, os parametros "compare" e "contador" são incrementados
		 * compare do tipo listaAluno, recebe compare.proxAluno - contador receber contador + 1		 * 
		 */
		removePosition(this.primeiroAluno, posicao, 0);
	}
	
	private void removePosition(listaAluno compare, int position, int contador) {
		try {
			if (position == 0) {
				removeInicio();
			}
			
			else if (position == lengthListaAluno) {
				removeFinal();
			}
			
			else {
				if(position == contador) {
					compare.prevAluno.proxAluno = compare.proxAluno;
					compare.proxAluno.prevAluno = compare.prevAluno;
					compare = null;
				}
				else {
					// chamada recursiva
					removePosition(compare.proxAluno, position, contador+1);
				}
			}
		} catch(Exception e) {
			System.out.println("remoção inválida");
		}
	}
	
	
	public void showListaAluno() {
		/**
		 * chamar showListaAluno
		 */
		showListaAluno(this.primeiroAluno);
	}
	
	private void showListaAluno(listaAluno compare) {
		/**
		 * RECURSIVIDADE DIRETA
		 * este metodo apresenta todos os itens da lista
		 * o metodo é chamado recursivamente - o parametro compare do tipo listaAluno é incrementado, recebendo compara.proxAluno
		 * 
		 */
		try {
			if (compare != null) {
				System.out.println("aluno: "+compare.nomeAluno+" ra: "+compare.raAluno+
						" turma: "+compare.turmaAluno+" semestre "+compare.semestreAluno);
				
				showListaAluno(compare.proxAluno);
			}
			else {
				System.out.println("tamanho: "+lengthListaAluno);
			}
		} catch (Exception e) {
			System.out.println("lista vazia");
		}
	}
}
