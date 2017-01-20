package org.worker;

import org.OrionJugs;
import org.data.Jug;
import org.data.loc.JugLoc;
import org.data.loc.JugLocation;
import org.osbot.rs07.script.MethodProvider;
import org.worker.impl.FillJugs;
import org.worker.impl.OJ_GoToBank;
import org.worker.impl.OJ_GoToLocation;
import org.worker.impl.WithdrawJugs;

import viking.framework.worker.Worker;
import viking.framework.worker.WorkerManager;

public class OJ_WorkerManager extends WorkerManager<OrionJugs>
{
	public final FillJugs FILL_JUGS;
	public final OJ_GoToBank GO_TO_BANK;
	public final WithdrawJugs WITHDRAW_JUGS;
	public final OJ_GoToLocation GO_TO_LOCATION;
	
	public JugLoc location;
	
	public OJ_WorkerManager(OrionJugs mission)
	{
		super(mission);
		FILL_JUGS = new FillJugs(mission);
		GO_TO_BANK = new OJ_GoToBank(mission);
		WITHDRAW_JUGS = new WithdrawJugs(mission);
		GO_TO_LOCATION = new OJ_GoToLocation(mission);
		location = JugLocation.values()[MethodProvider.random(0, JugLocation.values().length - 1)].LOC;
	}

	@Override
	public Worker<OrionJugs> decide()
	{
		final boolean IN_BANK = mission.bankUtils.isInBank(false);
		final boolean FULL_INV = inventory.isFull();
		final boolean ONLY_HAS_JUGS = inventory.onlyContains(Jug.EMPTY.ID, Jug.WATER.ID);
		
		if(!location.isIn(myPlayer()))
			return GO_TO_LOCATION;
				
		if(FULL_INV && ONLY_HAS_JUGS)
		{
			return FILL_JUGS;
		}
		
		return IN_BANK ? WITHDRAW_JUGS : GO_TO_BANK;
	}

}
