package DesignQuestions;
class StackNode{
	int value;
	int min;
	StackNode next;
	public StackNode(int k) {
		
		this.value=k;
		next=null;
		this.min=k;
		
	}
}