package com.sample;

public class NodeLR {
	
	int data;
	NodeLR prev, next;
	
	NodeLR() {
		
	}
	
	NodeLR(int item) {
		data = item;
		prev = next = null;
	}

}
