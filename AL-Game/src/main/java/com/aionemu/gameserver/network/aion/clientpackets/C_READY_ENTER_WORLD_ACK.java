package com.aionemu.gameserver.network.aion.clientpackets;

import com.aionemu.gameserver.network.aion.AionClientPacket;
import com.aionemu.gameserver.network.aion.AionConnection.State;

public class C_READY_ENTER_WORLD_ACK extends AionClientPacket
{

	public C_READY_ENTER_WORLD_ACK(int opcode, State state, State... restStates)
	{
		super(opcode, state, restStates);
	}

	@Override
	protected void readImpl()
	{
		readD();
	}

	@Override
	protected void runImpl()
	{

	}
}
