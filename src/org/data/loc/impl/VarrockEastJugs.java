package org.data.loc.impl;

import org.data.loc.JugLoc;
import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;

public class VarrockEastJugs extends JugLoc
{

	@Override
	protected Position[] getBankPath()
	{
		return new Position[] { new Position(3253, 3420, 0), new Position(3247, 3428, 0), new Position(3239, 3433, 0) };
	}

	@Override
	public Area constructArea()
	{
		return new Area(3230, 3441, 3269, 3411);
	}

	@Override
	public Position getCenterTile()
	{
		return new Position(3247, 3429, 0);
	}

	@Override
	protected String waterSource()
	{
		return "Fountain";
	}

}
