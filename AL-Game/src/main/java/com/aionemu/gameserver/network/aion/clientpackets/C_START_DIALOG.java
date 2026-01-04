package com.aionemu.gameserver.network.aion.clientpackets;

import com.aionemu.gameserver.model.gameobjects.Npc;
import com.aionemu.gameserver.model.gameobjects.VisibleObject;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.network.aion.AionClientPacket;
import com.aionemu.gameserver.network.aion.AionConnection.State;

public class C_START_DIALOG extends AionClientPacket
{
	private int targetObjectId;

	public C_START_DIALOG(int opcode, State state, State... restStates)
	{
		super(opcode, state, restStates);
	}

	@Override
	protected void readImpl()
	{
		targetObjectId = readD();
	}

	@Override
	protected void runImpl()
	{
		Player player = getConnection().getActivePlayer();
		if (player.isTrading()) {
			return;
		}
		VisibleObject obj = player.getKnownList().getObject(targetObjectId);
		if (obj instanceof Npc) {
			((Npc) obj).getController().onDialogRequest(player);
		}
	}
}