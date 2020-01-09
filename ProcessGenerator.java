import java.util.Random;

/**
 * Randomly generates processes with a given probability.Also, while generating
 * a new process, both its priority and the required time units to finish the
 * process are randomly generated within given ranges.
 * 
 * @author Sajia Zafreen
 *
 */
public class ProcessGenerator {

	private double probability;

	/**
	 * Constructor for process generator with a given probability
	 * 
	 * @param probability of a process to be generated
	 */
	public ProcessGenerator(double probability) {
		this.probability = probability;
	}

	/**
	 * Generates a Process with the current CPU time, maximum process time unit, and
	 * maximum priority level provided by the user
	 * 
	 * @param currentTime      is the current CPU time
	 * @param maxProcessTime   is the maximum process time unit the process can have
	 * @param maxPriorityLevel is the maximum priority level a process can have
	 * @return returns the process generated
	 */
	public Process getNewProcess(int currentTime, int maxProcessTime, int maxPriorityLevel) {
		return new Process(currentTime, maxProcessTime, maxPriorityLevel);
	}

	/**
	 * Returns true if probability is higher than a compared random number between 0
	 * and 1
	 * 
	 * @return returns true if the probability is higher than a compared random
	 *         number between 0 and 1
	 */
	public boolean query() {
		Random random = new Random();
		double compareRandom = random.nextDouble();
		// double tolerance = 0.01;
		// if (Math.abs(probability - compareRandom) < tolerance) {
		if (probability > compareRandom) {
			return true;
		} else
			return false;
	}

	/**
	 * Returns the probability of a process to be generated
	 * 
	 * @return
	 */
	public double getProbability() {
		return probability;
	}

	/**
	 * Sets the probability of a process to be generated
	 * 
	 * @param probability is the probability to be set for a process to be generated
	 */
	public void setProbability(double probability) {
		this.probability = probability;
	}

}
