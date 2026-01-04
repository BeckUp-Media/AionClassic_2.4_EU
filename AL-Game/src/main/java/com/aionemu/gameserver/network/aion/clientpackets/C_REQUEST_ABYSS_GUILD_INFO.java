/**
 * This file is part of aion-emu <aion-emu.com>.
 * <p>
 * aion-emu is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * aion-emu is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with aion-emu.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.aionemu.gameserver.network.aion.clientpackets;

import com.aionemu.gameserver.model.Race;
import com.aionemu.gameserver.model.gameobjects.player.AbyssRank.AbyssRankUpdateType;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.network.aion.AionClientPacket;
import com.aionemu.gameserver.network.aion.AionConnection.State;
import com.aionemu.gameserver.network.aion.serverpackets.S_ABYSS_GUILD_INFOS;
import com.aionemu.gameserver.services.abyss.AbyssRankingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author SheppeR
 */
public class C_REQUEST_ABYSS_GUILD_INFO extends AionClientPacket
{

	private Race queriedRace;
	private AbyssRankUpdateType updateType;
	private int raceId;

	private static final Logger log = LoggerFactory.getLogger(C_REQUEST_ABYSS_GUILD_INFO.class);

	public C_REQUEST_ABYSS_GUILD_INFO(int opcode, State state, State... restStates)
	{
		super(opcode, state, restStates);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void readImpl()
	{
		raceId = readC();
		switch (raceId) {
			case 0:
				queriedRace = Race.ELYOS;
				updateType = AbyssRankUpdateType.LEGION_ELYOS;
				break;
			case 1:
				queriedRace = Race.ASMODIANS;
				updateType = AbyssRankUpdateType.LEGION_ASMODIANS;
				break;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void runImpl()
	{
		// calculate rankings and send packet
		if (queriedRace != null) {
			Player player = this.getConnection().getActivePlayer();
			if (player.isAbyssRankListUpdated(updateType)) {
				sendPacket(new S_ABYSS_GUILD_INFOS(AbyssRankingCache.getInstance().getLastUpdate(), queriedRace));
			} else {
				S_ABYSS_GUILD_INFOS results = AbyssRankingCache.getInstance().getLegions(queriedRace);
				sendPacket(results);
				player.setAbyssRankListUpdated(updateType);
			}
		} else {
			log.warn("Received invalid raceId: " + raceId);
		}
	}
}
