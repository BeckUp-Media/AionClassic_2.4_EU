/*
 *  Aion Classic Emu based on Aion Encom Source Files
 *
 *  ENCOM Team based on Aion-Lighting Open Source
 *  All Copyrights : "Data/Copyrights/AEmu-Copyrights.text
 *
 *  iMPERIVM.FUN - AION DEVELOPMENT FORUM
 *  Forum: <http://https://imperivm.fun/>
 *
 */
package com.aionemu.gameserver.network.aion.clientpackets;

import com.aionemu.gameserver.network.aion.AionClientPacket;
import com.aionemu.gameserver.network.aion.AionConnection.State;
import com.aionemu.gameserver.network.aion.serverpackets.S_BLOCK_LIST;

/**
 * Send when the client requests the blocklist
 *
 * @author Ben
 */
public class C_QUERY_BLOCK extends AionClientPacket
{

	public C_QUERY_BLOCK(int opcode, State state, State... restStates)
	{
		super(opcode, state, restStates);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void readImpl()
	{

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void runImpl()
	{
		sendPacket(new S_BLOCK_LIST());

	}

}
