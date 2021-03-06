
public class Airport {

	private ListArrayBasedPlus<Runway> runways;
	private int planeCount;
	
	/*
	 * Creates attributes of an airport
	 * @param runWayCount The number of run-ways for the airport
	 */
	public Airport(int runwayCount, ListArrayBasedPlus<Runway> runways) {
		this.runways = runways;
		planeCount = 0;
	}
	
//  <-------------------------------------------->  //
	
	/*
	 * Returns all run-ways in the airport
	 * @return The run-ways in the airport
	 */
	public ListArrayBasedPlus<Runway> getRunways()
	{
		return runways;
	}
	
	/*
	 * Returns the count of how many planes left the airport
	 * @return The count of planes that left the airport
	 */
	public int getPlaneCount()
	{
		return planeCount;
	}
	
//  <-------------------------------------------->  //

	/*
	 * Lets the next available plane from the 
	 */
	public void dispatchPlane()
	{
		//Gets information about the run-way and plane
		Runway runway = runways.get(0);
		runways.remove(0);
		Flight plane = runway.getFromRunway();
		
		//Prints info about flight leaving
		System.out.printf("Flight %s has now taken off from runway %s\n", plane.getFlightNumber(), plane.getRunway());
		
		//Moves run-way to back of queue
		runways.add(runways.size(), runway);
		
		planeCount++;
	}
	
	
	/*
	 * Moves flight at the beginning of the queue from the run-way to the waiting list
	 */
	public void moveToWaiting()
	{
		//Gets information about the run-way 
		Runway runway = runways.get(0);
		runways.remove(0);
		Flight plane = runway.getFlightQueue().peek();
		
		//Prints information about where plane is going
		System.out.println("Flight " + plane.getFlightNumber() + " is now waiting to be allowed to re-enter a runway.");
		
		//Moves plane to waiting list on the specific run-way
		runway.addToWaiting(plane);
		
		//Moves run-way to back of queue
		runways.add(runways.size(), runway);
	}	
}
