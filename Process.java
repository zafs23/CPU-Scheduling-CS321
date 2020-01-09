import java.util.Random;

/**
 * Process class represents a process and implements the Comparable interface. 
 * The comparison between nodes in max-heap is done by calling the
 * compareTo method.
 * 
 * @author Sajia Zafreen
 *
 */

public class Process implements Comparable<Process> {
	private int arrivalTime;
	private int maxProcessTime;
	private int priority;
	private int timeRemaining;
	private int timeNotProcessed;

	/**
	 * Constructs a Process with arrival time which is the current CPU time, the
	 * maxProcess time which is the highest time needed to finish the process and
	 * the priority is the highest priority the process can have.
	 * 
	 * @param arrivalTime    the current CPU time
	 * @param maxProcessTime time to finish the process which will be random from 1
	 *                       unit to highest process time unit provided
	 * @param priority       will be random between 1 to highest level of priority
	 *                       the process can have
	 */
	public Process(int arrivalTime, int maxProcessTime, int priority) {
		Random randomNumber = new Random();
		this.arrivalTime = arrivalTime;
		this.maxProcessTime = 1 + randomNumber.nextInt(maxProcessTime);// will be random
		this.priority = 1 + randomNumber.nextInt(priority);
		this.timeRemaining = this.maxProcessTime;// when the job starts the maxProcess = time remaining
		this.timeNotProcessed = 0;
	}

	/**
	 * Returns the arrival time of the Process
	 * 
	 * @return returns the arrival time of the process
	 */
	public int getArrivalTime() {
		return arrivalTime;
	}

	/**
	 * Sets the arrival time of the process
	 * 
	 * @param arrivalTime is the arrival time the process will be set to
	 */
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/**
	 * Returns the maximum process time of the process
	 * 
	 * @return returns the maximum process time of the process
	 */
	public int getMaxProcessTime() {
		return maxProcessTime;
	}

	/**
	 * Sets the maximum process time of the process
	 * 
	 * @param maxProcessTime is the maximum process time the process will be set to
	 */
	public void setMaxProcessTime(int maxProcessTime) {
		this.maxProcessTime = maxProcessTime;
	}

	/**
	 * Returns the priority level of the process
	 * 
	 * @return returns the priority level of the process
	 */
	public int getPriority() {
		return this.priority;
	}

	/**
	 * Sets the priority of the process
	 * 
	 * @param priority is the priority of the process will be set to
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * Increases the priority of the process by one level.
	 */
	public void increasePriority() {
		this.priority++;
	}

	/**
	 * Returns the time remaining to finish the process
	 * 
	 * @return returns the time remaining to finish the process
	 */
	public int getTimeRemaining() {
		return timeRemaining;
	}

	/**
	 * Sets the time remaining of the Process
	 * 
	 * @param timeRemaining is the time remaining will be set for the process
	 */
	public void setTimeRemaining(int timeRemaining) {
		this.timeRemaining = timeRemaining;
	}

	/**
	 * Reduces the time remaining to finish the project by one unit
	 */
	public void reduceTimeRemaining() {
		--timeRemaining;
	}

	/**
	 * Returns the time of the process didn't get the current CPU time
	 * 
	 * @return returns the time the process didn't get the current CPU time
	 */
	public int getTimeNotProcessed() {
		return timeNotProcessed;
	}

	/**
	 * Sets the time of the process when it didn't get the current CPU time
	 * 
	 * @param timeNotProcessed is the time the process didn't get current CPU time
	 */
	public void setTimeNotProcessed(int timeNotProcessed) {
		this.timeNotProcessed = timeNotProcessed;
	}

	/**
	 * Increases the time not processed of the process by one unit
	 */
	public void increaseTimeNotProcessed() {
		timeNotProcessed++;
	}

	/**
	 * Resets the time not processed of the process to zero.
	 */
	public void resetTimeNotProcessed() {
		timeNotProcessed = 0;
	}

	/**
	 * Returns if the process is finished.
	 * 
	 * @return true if the process is finished
	 */
	public boolean finish() {
		return timeRemaining == 0;
	}

	@Override
	public int compareTo(Process process) {
		if (this.priority > process.getPriority()) {
			return 1;
		} else if (this.priority < process.getPriority()) {
			return -1;
		} else {
			if (this.arrivalTime < process.getArrivalTime()) {
				return 1;
			} else if (this.arrivalTime > process.getArrivalTime()) {
				return -1;
			} else {
				return 0;
			}
		}
	}
}
