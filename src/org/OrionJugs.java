package org;

import java.util.Map;

import org.data.Jug;
import org.worker.OJ_WorkerManager;

import viking.framework.goal.Goal;
import viking.framework.goal.GoalList;
import viking.framework.item_management.IMEntry;
import viking.framework.item_management.ItemManagement;
import viking.framework.mission.CapitalMission;
import viking.framework.mission.Mission;
import viking.framework.mule.MuleManagement;
import viking.framework.mule.MuleOrder;
import viking.framework.script.VikingScript;

public class OrionJugs extends Mission implements CapitalMission, ItemManagement, MuleManagement
{	
	private static final int JUG_PURCHASE_AMT = 5000;
	
	public final OJ_WorkerManager MANAGER;
	
	public OrionJugs(VikingScript script, Goal... goals)
	{
		super(script);
		this.goals = new GoalList(goals);
		MANAGER = new OJ_WorkerManager(this);
	}

	@Override
	public boolean canEnd()
	{
		return goals.hasReachedGoals();
	}

	@Override
	public String getMissionName()
	{
		return "Orion Jugs";
	}

	@Override
	public String getCurrentTaskName()
	{
		return MANAGER.getCurrent() == null ? "Starting up..." : MANAGER.getCurrent().toString();
	}

	@Override
	public String getEndMessage()
	{
		return "Orion Jugs has ended";
	}

	@Override
	public GoalList getGoals()
	{
		return goals;
	}

	@Override
	public String[] getMissionPaint()
	{
		return null;
	}

	@Override
	public int execute()
	{
		MANAGER.work();
		return 300;
	}

	@Override
	public void onMissionStart()
	{
		script.log(this, false, "Orion Jugs has started");
	}

	@Override
	public void resetPaint()
	{}

	@Override
	public boolean needsCapital()
	{
		Map<Integer, Integer> bankCache = script.BANK_CACHE.get();
		return !bankCache.isEmpty() && !bankCache.containsKey(Jug.EMPTY.ID) && !inventory.contains(Jug.EMPTY.ID, Jug.EMPTY.ID + 1);
	}

	@Override
	public MuleOrder getOrder()
	{
		return new MuleOrder(script, Jug.WATER.ID);
	}

	@Override
	public IMEntry[] itemsToBuy()
	{
		return new IMEntry[]
		{
			new IMEntry(this, Jug.EMPTY.ID, JUG_PURCHASE_AMT, 3, "Jug")
		};
	}

	@Override
	public int[] itemsToSell()
	{
		return ItemManagement.ORION_SELL_ITEMS;
	}

}
