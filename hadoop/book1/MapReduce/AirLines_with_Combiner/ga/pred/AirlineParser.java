package ga.pred;

import org.apache.hadoop.io.Text;

public class AirlineParser {
	private int year;
	private int month;
	
	private int arriveDelayTime = 0;
	private int departureDelayTime = 0;
	private int distance = 0;

	private boolean arriveDelayAvailable = true; 
	private boolean departureDelayAvailable = true;
	private boolean distanceAvailable = true;

	private String uniqueCarrier;

	public AirlineParser(Text text) {
		try{
			String[] line = text.toString().split(",");

			year = Integer.parseInt(line[0]);
			month = Integer.parseInt(line[1]);
			uniqueCarrier = line[8];

			if (!line[15].equals("NA")) {
				departureDelayTime = Integer.parseInt(line[15]);
			} else {
				departureDelayAvailable = false;
			}

			if (!line[14].equals("NA")) {
				arriveDelayTime = Integer.parseInt(line[15]);
			} else {
				arriveDelayAvailable = false;
			}

			if (!line[18].equals("NA")) {
				distance = Integer.parseInt(line[18]);
			} else {
				distanceAvailable = false;
			}
		} catch (Exception e) {
			System.out.println("Error parsing a record: " + e.getMessage());
		}
	}

	public int getYear() 						{	return year;	}
	public int getMonth() 						{	return month;	}
	public String getUniqueCarrier() 			{	return uniqueCarrier;	}
	public int getArriveDelayTime() 			{	return arriveDelayTime;	}
	public int getDepartureDelayTime() 			{	return departureDelayTime;	}
	public int getDistance() 					{	return distance;	}
	public boolean isArriveDelayAvailable() 	{	return arriveDelayAvailable;	}
	public boolean isDepartureDelayAvailable() 	{	return departureDelayAvailable;	}
	public boolean isDistanceAvailable() 		{	return distanceAvailable;	}
}
