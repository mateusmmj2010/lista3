package main;
import controller.Stack;
import controller.Listc;
import controller.Queue;

public class main {	
	public static void main(String[] args) {
//		Stack newStack = new Stack(); //test stack	
//		Queue newQueue = new Queue(); //test queue
		Listc newList = new Listc(); //test list
		
		
		newList.inserList(15,0);
		newList.inserList(17,1);
		newList.popFirstList();
		newList.inserList(10,2);
		newList.popList();
		newList.inserList(20,3);
		newList.inserList(30,4);
		newList.inserList(5,5);
		newList.showList();

		// TRATAMENTO DE EXCEÇÃO NA CHAMADA DO METODO  - para null ou tipo diferente

		
		
	}
}
