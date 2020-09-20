package controller;

public class Queue {
	/**
	 * this class implements a Queue based on dynamic memory alocation
	 */
	private int queueItem;
	private Queue queuePreviosItem, queueNextItem;
	static private int queueLength = 0;
	static private Queue queueFirstItem, queueLastItem;
	
	public Queue(){
		this.queueFirstItem = this;		
		this.queueLastItem = this;	
		this.queuePreviosItem = null;
		this.queueNextItem = null;			
	}

	public Queue(int queueItem){
		this.queueFirstItem = this;
		this.queueLastItem = this;	
		this.queueItem = queueItem;
		this.queuePreviosItem = null;
		this.queueNextItem = null;		
	}
	
	public void enqueue(int item, String param){
		switch (param){
			case "inicio":
				Queue noF = this.queueFirstItem;
				noF.queuePreviosItem = this.queueFirstItem;
				this.queueFirstItem.queueItem = item;
				this.queueFirstItem.queueNextItem = noF;
				this.queueFirstItem.queuePreviosItem = null;
				System.out.print("certo");
				break;
			
			case "final":
				Queue noL = this.queueLastItem;
				noL.queueNextItem = this.queueLastItem;
				this.queueLastItem.queueItem = item;
				this.queueLastItem.queuePreviosItem = noL;
				this.queueLastItem.queueNextItem = null;				
				break;
			
			default:
				System.out.print("invalide method");
				break;
				
		}
		
	}
	
}
