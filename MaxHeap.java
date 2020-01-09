import java.util.Arrays;

/**
 * Implements a Max Heap data structure using an array. Each node in Max Heap contains a process. 
 * 
 * @author Sajia Zafreen
 *
 */

public class MaxHeap {
	private static final int DEFAULT_CAPACITY = 10;

	private Process[] heapArray;
	private int rear; // is the size of the array and there is no element in it

	/**
	 * Max Heap Constructor
	 */
	public MaxHeap() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Max Heap Constructor which makes a MaxHeap with initial capacity
	 * 
	 * @param initialCapacity the initial heap capacity
	 */
	public MaxHeap(int initialCapacity) {
		heapArray = new Process[initialCapacity]; // or add +1 when starting at 1
		rear = 0; // should be 1 if starting at 1
	}

	/**
	 * Max Heapify up from the index node.
	 * 
	 * @param index is the index where the max heapify up is called
	 */
	public void maxHeapifyUp(int index) {
		while (index > 0 && heapArray[parent(index)].compareTo(heapArray[index]) == -1) {// except the root
			exchange(index, parent(index));
			index = parent(index);
		}
	}

	/**
	 * Max Heapify down from the index node
	 * 
	 * @Precondition: The left and right subtrees rooted at the left (index) and
	 *                right (index) need to be max heaps.
	 * @PostConditon: The subtree rooted at the node (index) will be a max heap.
	 * 
	 * @param index index where the max heapify down is called
	 * 
	 */
	public void maxHeapifyDown(int index) {
		int left = leftChild(index);
		int right = rightChild(index);
		int largest = index;
		if (left < rear && heapArray[left].compareTo(heapArray[largest]) == 1) {// not the length of array, it is rear
			// cz length can be bigger than rear, but rear is the heapsize, where there is
			// element
			largest = left;
		}
		if (right < rear && heapArray[right].compareTo(heapArray[largest]) == 1) {
			largest = right;
		}
		if (largest != index) {// only is done when largest value changes, otherwise does nothing
			exchange(largest, index);
			maxHeapifyDown(largest);
		}
	}

	/**
	 * Inserts a Process data in the max heap
	 * 
	 * @param data the Process to be added
	 */
	public void maxHeapInsert(Process data) {
		expandIfNecessary();
		heapArray[rear] = data;
		maxHeapifyUp(rear);
		rear++;// before or after
	}

	/**
	 * Extracts the root node of the max heap.
	 * 
	 * @return the root node of the max heap
	 */
	public Process maxHeapExtract() {
		// exchange root and the last element
		Process returnProcess = heapArray[0];
		exchange(0, rear - 1);
		rear--; // must be done here before calling maxHeapifyDown,otherwise, it will still
				// consider the last element
		maxHeapifyDown(0);
		return returnProcess;
	}

	/**
	 * Deletes a node from the index
	 * 
	 * @param index from where the node will be deleted
	 * @return the deleted node
	 */
	public Process maxHeapDelete(int index) {
		Process returnProcess = heapArray[index];
		boolean higher = false;
		boolean decrease = false;
		if (returnProcess.compareTo(heapArray[rear - 1]) == 1) {// return process higher than rear
			higher = true;// means after exchange decrease
		}
		if (returnProcess.compareTo(heapArray[rear - 1]) == -1) {
			decrease = true;// means after exchange increased
		}
		exchange(index, rear - 1);
		rear--;
		if (higher) {// return higher, return
			maxHeapifyDown(index);
		}
		if (decrease) {
			maxHeapifyUp(index);
		}
		return returnProcess;
	}

	/**
	 * Returns the size of the Max Heap
	 * 
	 * @return the size of the Max Heap
	 */
	public int size() {
		return rear;
	}

	/**
	 * Returns the Max Heap array.
	 * 
	 * @return the Max Heap array
	 */
	public Process[] getHeapArray() {
		return heapArray;
	}

	/**
	 * Sets the Max Heap array
	 * 
	 * @param heapArray
	 */
	public void setHeapArray(Process[] heapArray) {
		this.heapArray = heapArray;
	}

	/**
	 * Expands the array size if needed
	 */
	private void expandIfNecessary() {
		if (rear == heapArray.length) { // calculation of the array
			heapArray = Arrays.copyOf(heapArray, heapArray.length * 2);
		}
	}

	/**
	 * Returns the index of the parent of the node at index
	 * 
	 * @param index is the index whose Parent node index will be returned
	 * @return returns the parent node of the node at index will be returned
	 */
	private int parent(int index) {
		if (index == 0) {
			return 0;
		}
		return (index - 1) / 2;
	}

	/**
	 * Returns the left child index of the node at index
	 * 
	 * @param index is the index whose left child index will be returned
	 * @return returns the left child index of the node at index
	 */
	private int leftChild(int index) {
		return (2 * index) + 1;
	}

	/**
	 * Returns the right child index of the node at index
	 * 
	 * @param index is the index whose right child index will be returned
	 * @return returns the right child index of the node at index
	 */
	private int rightChild(int index) {
		return (2 * index) + 2;
	}

	/**
	 * Exchanges the first and second elements in the Max Heap array
	 * 
	 * @param first  is one of the element in the Max Heap
	 * @param second is another element in the Max Heap
	 */
	private void exchange(int first, int second) {
		Process tmpProcess;
		tmpProcess = heapArray[first];
		heapArray[first] = heapArray[second];
		heapArray[second] = tmpProcess;
	}

}
