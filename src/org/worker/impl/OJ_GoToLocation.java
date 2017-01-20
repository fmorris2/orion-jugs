package org.worker.impl;

import org.OrionJugs;
import org.worker.OJWorker;

public class OJ_GoToLocation extends OJWorker
{

	public OJ_GoToLocation(OrionJugs mission)
	{
		super(mission);
	}

	@Override
	public void work()
	{
		script.log(this, false, "Go to location");
		walkUtils.walkToArea(mission.MANAGER.location.getArea());
	}

}
