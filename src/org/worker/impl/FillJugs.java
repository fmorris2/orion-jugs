package org.worker.impl;

import org.OrionJugs;
import org.worker.OJWorker;

import viking.api.Timing;

public class FillJugs extends OJWorker
{
	private long ANIM_THRESH = 600;
	private long lastAnim;
	
	public FillJugs(OrionJugs mission)
	{
		super(mission);
	}

	@Override
	public void work()
	{
		script.log(this, false, "Fill Jugs");
		if(bank.isOpen())
			bank.close();
		else if(myPlayer().isAnimating())
			lastAnim = Timing.currentMs();
		else if(Timing.timeFromMark(lastAnim) > ANIM_THRESH && iFact.itemOnObj("Jug", mission.MANAGER.location.WATER_SOURCE, 20).execute())
			Timing.waitCondition(() -> myPlayer().isAnimating(), 6500);
	}

}
