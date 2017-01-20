package org.worker;

import org.OrionJugs;

import viking.framework.worker.Worker;

public abstract class OJWorker extends Worker<OrionJugs>
{

	public OJWorker(OrionJugs mission)
	{
		super(mission);
	}

	@Override
	public boolean needsRepeat()
	{
		return false;
	}
}
