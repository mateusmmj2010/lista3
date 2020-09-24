package main;
import controller.Stack;
import controller.ListAlumns;
import controller.Listc;
import controller.Queue;

public class main {	
	public static void main(String[] args) {
//		Stack newStack = new Stack(); //test stack	
//		Queue newQueue = new Queue(); //test queue
     	Listc novo = new Listc(); //test list
//		ListAlumns novo = new ListAlumns();
//		
//		novo.inserList(10, "m", "a", "b", 0);
//		novo.inserList(10, "m", "b", "b", 0);
//		novo.inserList(10, "m", "c", "b", 1);
//		
     	novo.inserList(50, 0);
     	novo.inserList(60, 0);
     	novo.inserList(70, 1);
     	novo.showList();
		
     	
		
		// TRATAMENTO DE EXCEÇÃO NA CHAMADA DO METODO  - para null ou tipo diferente

		
		
	}
}
