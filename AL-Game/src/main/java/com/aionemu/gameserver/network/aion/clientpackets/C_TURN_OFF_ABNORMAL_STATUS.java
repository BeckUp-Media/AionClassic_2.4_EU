package com.aionemu.gameserver.network.aion.clientpackets;

import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.network.aion.AionClientPacket;
import com.aionemu.gameserver.network.aion.AionConnection.State;

/**
 * @author dragoon112
 */
public class C_TURN_OFF_ABNORMAL_STATUS extends AionClientPacket
{

	private int skillid;

	/**
	 * @param opcode
	 */
	public C_TURN_OFF_ABNORMAL_STATUS(int opcode, State state, State... restStates)
	{
		super(opcode, state, restStates);
	}

	/*
	 * (non-Javadoc)
	 * @see com.aionemu.commons.network.packet.BaseClientPacket#readImpl()
	 */
	@Override
	protected void readImpl()
	{
		skillid = readH();
		readC();//4.3
	}

	/*
	 * (non-Javadoc)
	 * @see com.aionemu.commons.network.packet.BaseClientPacket#runImpl()
	 */
	@Override
	protected void runImpl()
	{
		final Player player = getConnection().getActivePlayer();
		if (player == null || !player.isSpawned()) {
			return;
		}
		if (player.isProtectionActive()) {
			player.getController().stopProtectionActiveTask();
		}
		if (player.getController().isInShutdownProgress()) {
			return;
		}
		player.getEffectController().removeEffect(skillid);
	}
}