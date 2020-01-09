/**
 * Implements a Priority Queue using a Max Heap.
 * 
 * @author Sajia Zafreen
 *
 */
public class PQueue {

	private MaxHeap maxHeap;

	/**
	 * Constructor of Priority Queue
	 */
	public PQueue() {
		maxHeap = new MaxHeap();
	}

	/**
	 * Inserts the Process next in a priority queue
	 * 
	 * @param next the process to be inserted in a priority queue
	 */
	public void enPQueue(Process next) {
		maxHeap.maxHeapInsert(next);
	}

	/**
	 * Updates the all the Processes in the priority queue
	 * 
	 * @param timeToIncrementLevel is the time to increment the priority level of a
	 *                             process in the priority queue
	 * @param maxLevel             is the maximum level of priority of a Process in
	 *                             priority queue
	 */
	public void update(int timeToIncrementLevel, int maxLevel) {// not doing for job dequeued
		for (int i = 0; i < maxHeap.size(); i++) {
			maxHeap.getHeapArray()[i].increaseTimeNotProcessed();
			if (maxHeap.getHeapArray()[i].getTimeNotProcessed() >= timeToIncrementLevel) {
				maxHeap.getHeapArray()[i].resetTimeNotProcessed();
				if (maxHeap.getHeapArray()[i].getPriority() < maxLevel) {
					maxHeap.getHeapArray()[i].increasePriority();
					maxHeap.maxHeapifyUp(i);
				}
			}
		}
	}

	/**
	 * Deletes the highest priority element in the priority queue
	 * 
	 * @return returns the highest priority element that is deleted from the
	 *         priority queue
	 */
	public Process dePQueue() {
		return maxHeap.maxHeapExtract();
	}

	/**
	 * Returns true if the priority queue is empty
	 * 
	 * @return returns true if the priority queue is empty
	 */
	public boolean isEmpty() {
		return maxHeap.size() == 0;
	}

}
