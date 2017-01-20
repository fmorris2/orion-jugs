package org.worker.impl;

import org.OrionJugs;
import org.worker.OJWorker;

public class WithdrawJugs extends OJWorker
{

	public WithdrawJugs(OrionJugs mission)
	{
		super(mission);
	}

	@Override
	public void work()
	{
		script.log(this, false, "Withdraw jugs");
	}

}
