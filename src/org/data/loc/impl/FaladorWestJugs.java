package org.data.loc.impl;

import org.data.loc.JugLoc;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;

public class FaladorWestJugs extends JugLoc
{

	@Override
	protected Position[] getBankPath()
	{
		return new Position[] { new Position(2946, 3368, 0), new Position(2949, 3376, 0), new Position(2949, 3382, 0) };
	}

	@Override
	public Area constructArea()
	{
		return new Area(2939, 3388, 2958, 3365);
	}

	@Override
	public Position getCenterTile()
	{
		return new Position(2950, 3376, 0);
	}

}
