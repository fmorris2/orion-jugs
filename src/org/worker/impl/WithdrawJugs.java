package org.worker.impl;

import org.OrionJugs;
import org.data.Jug;
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
		if(bank.isOpen())
		{
			if(!inventory.isEmpty())
			{	
				script.log(this, false, "Depositing erroneous items");
				bank.depositAll();
			}
			else
			{
				script.log(this, false, "Withdrawing empty jugs");
				bank.withdraw(Jug.EMPTY.ID, 0);
			}		
		}
		else
		{
			script.log(this, false, "Open bank");
			bankUtils.open();
		}
	}

}
