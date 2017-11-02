

import java.io.IOException;

public class BinaryHeap {
	private int heap[] = new int[10];
	private int count = 0;
	
	public void add(int v) {
		if (count >= heap.length) {
			int temp[] = new int[heap.length * 2];
			for (int i = 0; i < heap.length; i ++) {
				temp[i] = heap[i];
			}
			heap = temp;
		}
		if (count == 0) {
			 heap[0] = v;
		} else {
			int m = count;
			while (m > 0) {
				int parentNum = (m - 1) / 2;
				if (heap[parentNum] <= v) {
					break;
				}
				heap[m] = heap[parentNum];
				m = parentNum;
			}
			heap[m] = v;
		}
		count++;
	}
	
	public int remove() {
		if (count == 0) {
			throw new NullPointerException();
		}
		int r = heap[0];
		int last = heap[--count];
		int parentNum = 0;
		if (count != 0) {
			while (parentNum < (count / 2)) {
				int childNum = parentNum * 2 + 1;
				int c = heap[childNum];
				int rightNum = childNum + 1;
				if (rightNum < count && c > heap[rightNum]) {
					c = heap[rightNum];
					childNum = rightNum;
				}
				if (last <= c) {
					break;
				}
				heap[parentNum] = c;
				parentNum = childNum;
			}
			heap[parentNum] = last;
		}
		return r;
	}
}
