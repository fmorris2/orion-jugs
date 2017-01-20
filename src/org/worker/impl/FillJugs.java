package org.worker.impl;

import org.OrionJugs;
import org.worker.OJWorker;

public class FillJugs extends OJWorker
{

	public FillJugs(OrionJugs mission)
	{
		super(mission);
	}

	@Override
	public void work()
	{
		script.log(this, false, "Fill Jugs");
	}

}
