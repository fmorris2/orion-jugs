package org.worker.impl;

import org.OrionJugs;
import org.worker.OJWorker;

public class DepositJugs extends OJWorker
{

	public DepositJugs(OrionJugs mission)
	{
		super(mission);
	}

	@Override
	public void work()
	{
		script.log(this, false, "Deposit Jugs");
	}

}
