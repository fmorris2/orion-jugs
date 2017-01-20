package org.worker.impl;

import org.OrionJugs;
import org.data.Jug;
import org.worker.OJWorker;

public class OJ_GoToBank extends OJWorker
{

	public OJ_GoToBank(OrionJugs mission)
	{
		super(mission);
	}

	@Override
	public void work()
	{
		script.log(this, false, "Go to bank");
		walkUtils.walkPath(inventory.onlyContains(Jug.WATER.ID) 
				? mission.MANAGER.location.REVERSE_BANK_PATH : mission.MANAGER.location.BANK_PATH);
	}

}
