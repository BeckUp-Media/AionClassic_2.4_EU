package com.aionemu.gameserver.network.aion.clientpackets;

import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.network.aion.AionClientPacket;
import com.aionemu.gameserver.network.aion.AionConnection.State;
import com.aionemu.gameserver.services.WebshopService;

public class C_SAVE extends AionClientPacket
{

	public C_SAVE(int opcode, State state, State... restStates)
	{
		super(opcode, state, restStates);
	}

	protected void readImpl()
	{
	}

	protected void runImpl()
	{
		Player player = getConnection().getActivePlayer();
		WebshopService.getInstance().check(player);
	}
}
