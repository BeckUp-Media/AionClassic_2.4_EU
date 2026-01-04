package com.aionemu.gameserver.network.aion.clientpackets;

import com.aionemu.gameserver.model.gameobjects.Summon;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.model.summons.SummonMode;
import com.aionemu.gameserver.model.summons.UnsummonType;
import com.aionemu.gameserver.network.aion.AionClientPacket;
import com.aionemu.gameserver.network.aion.AionConnection.State;
import com.aionemu.gameserver.services.summons.SummonsService;

public class C_PET_ORDER extends AionClientPacket
{
	private int mode;
	private int targetObjId;

	public C_PET_ORDER(int opcode, State state, State... restStates)
	{
		super(opcode, state, restStates);
	}

	@Override
	protected void readImpl()
	{
		mode = readC();
		readD();
		readD();
		targetObjId = readD();
	}

	@Override
	protected void runImpl()
	{
		Player activePlayer = getConnection().getActivePlayer();
		Summon summon = activePlayer.getSummon();
		SummonMode summonMode = SummonMode.getSummonModeById(mode);
		if (summon != null && summonMode != null) {
			SummonsService.doMode(summonMode, summon, targetObjId, UnsummonType.COMMAND);
		}
	}
}