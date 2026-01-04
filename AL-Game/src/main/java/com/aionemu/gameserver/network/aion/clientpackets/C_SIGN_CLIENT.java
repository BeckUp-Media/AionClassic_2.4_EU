package com.aionemu.gameserver.network.aion.clientpackets;

import com.aionemu.gameserver.configs.main.GSConfig;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.network.aion.AionClientPacket;
import com.aionemu.gameserver.network.aion.AionConnection.State;
import com.aionemu.gameserver.network.aion.serverpackets.S_SIGN_CLIENT;
import com.aionemu.gameserver.network.chatserver.ChatServer;
import com.aionemu.gameserver.utils.PacketSendUtility;

public class C_SIGN_CLIENT extends AionClientPacket
{
	public C_SIGN_CLIENT(int opcode, State state, State... restStates)
	{
		super(opcode, state, restStates);
	}

	@Override
	protected void readImpl()
	{
		@SuppressWarnings("unused")
		int objectId = readD();
		@SuppressWarnings("unused")
		byte[] macAddress = readB(6);
	}

	@Override
	protected void runImpl()
	{
		Player player = getConnection().getActivePlayer();
		if (GSConfig.ENABLE_CHAT_SERVER) {
			if (!player.isInPrison()) {
				ChatServer.getInstance().sendPlayerLoginRequst(player);
			}
		} else {
			PacketSendUtility.sendPacket(player, new S_SIGN_CLIENT(new byte[0]));
		}
	}
}