package org.worker.impl;

import org.OrionJugs;
import org.osbot.rs07.api.model.RS2Object;
import org.worker.OJWorker;

import viking.api.Timing;

public class FillJugs extends OJWorker
{
	private static final int WATER_DIST_THRESH = 7; 
	private static final long ANIM_THRESH = 600;
	
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
		else if(Timing.timeFromMark(lastAnim) > ANIM_THRESH)
		{
			String source = mission.MANAGER.location.WATER_SOURCE;
			RS2Object water = objects.closest(source);
			if(water != null && myPosition().distance(water.getPosition()) > WATER_DIST_THRESH)
				walkUtils.walkPath(mission.MANAGER.location.BANK_PATH);
			else if(iFact.itemOnObj("Jug", source, 10).execute() && Timing.waitCondition(() -> myPlayer().isAnimating(), 6500))
				lastAnim = Timing.currentMs();
		}
	}

}
