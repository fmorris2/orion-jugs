package org.worker.impl;

import java.util.List;

import org.OrionJugs;
import org.osbot.rs07.api.map.Position;
import org.worker.OJWorker;

import viking.api.Timing;

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
		List<Position> path = mission.MANAGER.location.REVERSE_BANK_PATH;
		if(walkUtils.walkPath(path) || walkUtils.walkTo(path.get(path.size() - 1)))
			Timing.waitCondition(() -> bankUtils.isInBank(false), 5000);
			
	}

}
