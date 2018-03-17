package com.sample;

import java.util.HashMap;
import java.util.Map;

public class LinkedListOperations {
	
	static NodeLR head;
	static Node headA, headB;

	public static void main(String[] args) {
		headA = new Node(1);
		headA.next = new Node(2);
		headA.next.next = new Node(3);
		headA.next.next.next = new Node(4);
		headB = new Node(5);
		headB.next = new Node(6);
		headB.next.next = headA.next.next;
		System.out.println(FindMergeNode(headA, headB));
		
		/*head = new NodeLR(1);
		head.prev = null;
		head.next = new NodeLR(5);
		head.next.prev = head;
		head.next.next = new NodeLR(7);
		head.next.next.prev = head.next;
		head.next.next.next = new NodeLR(9);*/
		printList(SortedInsert(SortedInsert(SortedInsert(SortedInsert(SortedInsert(SortedInsert(SortedInsert(SortedInsert(head,1), 4), 2), 3), 7), 6), 9), 10));
		
		head = new NodeLR(1);
		head.prev = null;
		head.next = new NodeLR(5);
		head.next.prev = head;
		head.next.next = new NodeLR(7);
		head.next.next.prev = head.next;
		head.next.next.next = new NodeLR(9);
		head.next.next.next.prev = head.next.next;
		printList(Reverse(head));
	}
	
	static NodeLR Reverse(NodeLR head) {
		if(head == null)
			return null;
		NodeLR prev = null, next = null, curr = null;
		while(head != null) {
			curr = head;
			prev = head.prev;
			next = head.next;
			head.next = prev;
			head.prev = next;
			head = next;
		}
		return curr;
	}
	
	static void printList(NodeLR head) {
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	static NodeLR SortedInsert(NodeLR head, int data) {
		boolean inserted = false;
		NodeLR temp = head, prev = null;
		NodeLR newNode = new NodeLR();
		newNode.data = data;
		if(temp == null) {
			head = newNode;
			inserted = true;
		}
		while(temp != null) {
			if(data <= temp.data) {
				newNode.prev = temp.prev;
				newNode.next = temp;
				if(temp.prev != null)
					temp.prev.next = newNode;
				else
					head = newNode;
				temp.prev = newNode;
				inserted = true;
				break;
			}
			prev = temp;
			temp = temp.next;
		}
		if(!inserted) {
			newNode.prev = prev;
			prev.next = newNode;
		}
		return head;
	}
	
	static int FindMergeNode(Node headA, Node headB) {
	    // Complete this function
	    // Do not write the main method. 
		Map<Node, Integer> map = new HashMap<>();
		while(headA != null) {
			map.put(headA, 1);
			headA = headA.next;
		}
		while(headB != null) {
			if(map.containsKey(headB))
				return headB.data;
			headB = headB.next;
		}
		return -1;
	}

}
