package org.data.loc;

import org.data.loc.impl.FaladorWestJugs;
import org.data.loc.impl.VarrockEastJugs;

public enum JugLocation
{
	VARROCK_EAST(new VarrockEastJugs()),
	FALADOR_WEST(new FaladorWestJugs());
	
	public final JugLoc LOC;
	
	JugLocation(JugLoc loc)
	{
		LOC = loc;
	}
}
