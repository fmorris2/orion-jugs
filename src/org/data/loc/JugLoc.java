package org.data.loc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.osbot.rs07.api.map.Position;

import viking.api.location.Location;

public abstract class JugLoc extends Location
{
	public final List<Position> BANK_PATH;
	public final List<Position> REVERSE_BANK_PATH;
	
	public JugLoc()
	{
		super();
		BANK_PATH = Arrays.asList(getBankPath());
		REVERSE_BANK_PATH = Arrays.asList(getBankPath());
		Collections.reverse(REVERSE_BANK_PATH);
	}
	
	protected abstract Position[] getBankPath();
	
	@Override
	public Position constructDepositBoxTile()
	{
		return null;
	} 

}
