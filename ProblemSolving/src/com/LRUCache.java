package com;

import java.util.ArrayList;
import java.util.HashMap;

public class LRUCache {
	class DoublyLinkedList {
		int key;
		int val;
		DoublyLinkedList prev = null;
		DoublyLinkedList next = null;

		public DoublyLinkedList(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	int count = 0;
	int capacity;
	DoublyLinkedList head = new DoublyLinkedList(-1, -1);
	DoublyLinkedList tail = new DoublyLinkedList(-1, -1);
	HashMap<Integer, DoublyLinkedList> map = new HashMap<>();

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.head.next = this.tail;
		this.tail.prev = this.head;
	}

	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}
		int val = map.get(key).val;
		remove(map.get(key));
		add(key, val);
		return val;
	}

	public void remove(DoublyLinkedList ll) {
		map.remove(ll.key);
		ll.prev.next = ll.next;
		ll.next.prev = ll.prev;
		ll.next = null;
		ll.prev = null;
		this.count--;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			remove(map.get(key));
			add(key, value);
		} else {
			if (count == capacity) {
				remove(this.tail.prev);
			}
			this.add(key, value);
		}
	}

	private void add(int key, int value) {
		DoublyLinkedList temp = new DoublyLinkedList(key, value);
		this.count++;
		temp.prev = head;
		temp.next = head.next;
		head.next.prev = temp;
		head.next = temp;
		map.put(key, temp);
	}

	public static void main(String args[]) {
		LRUCache cache = new LRUCache(2 /* capacity */ );
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1)); // returns 1
		cache.put(3, 3); // evicts key 2
		System.out.println(cache.get(2)); // returns -1 (not found)
		cache.put(4, 4); // evicts key 1
		System.out.println(cache.get(1)); // returns -1 (not found)
		System.out.println(cache.get(3)); // returns 3
		System.out.println(cache.get(4)); // returns 4
	}
}
