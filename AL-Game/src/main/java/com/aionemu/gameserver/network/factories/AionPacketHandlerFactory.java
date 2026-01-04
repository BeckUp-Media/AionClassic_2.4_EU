package com.aionemu.gameserver.network.factories;

import com.aionemu.gameserver.network.aion.AionClientPacket;
import com.aionemu.gameserver.network.aion.AionConnection.State;
import com.aionemu.gameserver.network.aion.AionPacketHandler;
import com.aionemu.gameserver.network.aion.clientpackets.*;

public class AionPacketHandlerFactory {
    private AionPacketHandler handler;

    public static AionPacketHandlerFactory getInstance() {
        return SingletonHolder.instance;
    }

    public AionPacketHandlerFactory() {
        handler = new AionPacketHandler();
        addPacket(new C_VERSION(0xF2, State.CONNECTED));
		addPacket(new C_ASK_QUIT(0xEE, State.AUTHED, State.IN_GAME));
		addPacket(new C_READY_TO_QUIT(0xF1, State.AUTHED, State.IN_GAME));
		addPacket(new C_EDIT_CHARACTER(0xED, State.AUTHED));
		addPacket(new C_ENTER_WORLD(0xEA, State.AUTHED));
		addPacket(new C_LEVEL_READY(0xEB, State.IN_GAME));
		addPacket(new C_SAVE_CLIENT_SETTINGS(0xE8, State.IN_GAME));
		addPacket(new C_FIND_NPC_POS(0xE9, State.IN_GAME));
		addPacket(new C_CHANGE_OPTION_FLAGS(0xE6, State.IN_GAME));
		addPacket(new C_CAPTCHA(0xE4, State.IN_GAME));
		addPacket(new C_DESTINATION_AIRPORT(0x11E, State.IN_GAME));
        addPacket(new C_SYNC_TIME(0xE0, State.CONNECTED, State.AUTHED, State.IN_GAME));
		addPacket(new C_GATHER(0xE1, State.IN_GAME));
		addPacket(new C_FUNCTIONAL_PET_MOVE(0x9E, State.IN_GAME));
		addPacket(new C_FUNCTIONAL_PET(0x9C, State.IN_GAME));
		addPacket(new C_TOGGLE_DOOR(0x9D, State.IN_GAME));
		addPacket(new C_WHISPER(0x96, State.IN_GAME));
		addPacket(new C_CHANGE_TARGET(0x95, State.IN_GAME));
		addPacket(new C_ATTACK(0xD2, State.IN_GAME));
		addPacket(new C_USE_SKILL(0xD3, State.IN_GAME));
		addPacket(new C_L2AUTH_LOGIN(0x11F, State.CONNECTED));
		addPacket(new C_READY_ENTER_WORLD_ACK(0x190, State.AUTHED, State.IN_GAME));
		addPacket(new C_ROUTE_INFO(0x174, State.CONNECTED, State.AUTHED, State.IN_GAME));
		addPacket(new C_CHARACTER_LIST(0x11C, State.AUTHED));
		addPacket(new C_ALIVE(0xC6, State.AUTHED, State.IN_GAME));
		addPacket(new C_SA_ACCOUNT_ITEM_QUERY(0x179, State.AUTHED));
		addPacket(new C_CHECK_EXIST(0x143, State.AUTHED));
		addPacket(new C_RESTORE_CHARACTER(0x11B, State.AUTHED));
		addPacket(new C_CREATE_CHARACTER(0x11D, State.AUTHED));
		addPacket(new C_DELETE_CHARACTER(0x11A, State.AUTHED));
		addPacket(new C_RECONNECT_AUTH(0x17A, State.AUTHED));
		addPacket(new C_CUR_STATUS(0x148, State.IN_GAME));
		addPacket(new C_QUERY_BLOCK(0x14A, State.IN_GAME));
		addPacket(new C_QUERY_BUDDY(0x104, State.IN_GAME));
		addPacket(new C_SIGN_CLIENT(0x144, State.IN_GAME));
		addPacket(new C_MOVE_ITEM_TO_ANOTHER_SLOT(0x116, State.IN_GAME));
		addPacket(new C_MOVE_NEW(0xC2, State.IN_GAME));
		addPacket(new C_QUIT_CUTSCENE(0x123, State.IN_GAME));
		addPacket(new C_SAVE(0xCA, State.IN_GAME));
		addPacket(new C_PING(0x10D, State.IN_GAME));
		addPacket(new C_SIMPLE_DICE(0x109, State.IN_GAME));
		addPacket(new C_USE_ITEM(0xCF, State.IN_GAME));
		addPacket(new C_SAY(0x99, State.IN_GAME));
		addPacket(new C_ACTION(0xC9, State.IN_GAME));
		addPacket(new C_INSTANCE_DUNGEON_COOLTIMES(0x1B3, State.IN_GAME));
		addPacket(new C_USE_EQUIPMENT_ITEM(0xCC, State.IN_GAME));
		addPacket(new C_LOOT(0x118, State.IN_GAME));
		addPacket(new C_MOVE_STACKABLE_ITEM(0x117, State.IN_GAME));
		addPacket(new C_LOOT_ITEM(0x119, State.IN_GAME));
		addPacket(new C_DESTROY_ITEM(0x13E, State.IN_GAME));
		addPacket(new C_REQUEST_SERIAL_KILLER_LIST(0x1AF, State.IN_GAME));
		addPacket(new C_TODAY_WORDS(0xF8, State.IN_GAME));
		addPacket(new C_TURN_OFF_ABNORMAL_STATUS(0xD1, State.IN_GAME));
		addPacket(new C_PARTY_MATCH(0x127, State.IN_GAME));
		addPacket(new C_START_DIALOG(0xFE, State.IN_GAME));
		addPacket(new C_HACTION(0xFC, State.IN_GAME));
		addPacket(new C_END_DIALOG(0xFF, State.IN_GAME));
		addPacket(new C_SEARCH_USERS(0x115, State.IN_GAME));
		addPacket(new C_GIVE_UP_QUEST(0x122, State.IN_GAME));
		addPacket(new C_CHANGE_TITLE(0x169, State.IN_GAME));
		addPacket(new C_DEAD_RESTART(0xEF, State.IN_GAME));
		//todo missing addPacket(new C_SYSTEM_CFG_LOAD(0x187, State.IN_GAME));
		addPacket(new C_CUSTOM_ANIM(0x12D, State.IN_GAME));
		addPacket(new C_CHANGE_ITEM_SKIN(0x2D8, State.IN_GAME));
		addPacket(new C_GIVE_ITEM_PROC(0x2D9, State.IN_GAME));
		addPacket(new C_COMPOUND_2H_WEAPON(0x1A5, State.IN_GAME));
		addPacket(new C_REMOVE_COMPOUND(0x1A2, State.IN_GAME));
		addPacket(new C_ENCHANT_ITEM(0x128, State.IN_GAME));
		addPacket(new C_DELETE_MACRO(0x142, State.IN_GAME));
		addPacket(new C_SAVE_MACRO(0x145, State.IN_GAME));
		addPacket(new C_REQUEST_ABYSS_RANKER_INFO(0x177, State.IN_GAME));
		addPacket(new C_REQUEST_ABYSS_GUILD_INFO(0x13C, State.IN_GAME));
		addPacket(new C_ACCOUNT_INSTANTDUNGEON(0x2DE, State.IN_GAME));
		addPacket(new C_WIND_PATH(0x12C, State.IN_GAME));
		addPacket(new C_SHARE_QUEST(0x14E, State.IN_GAME));
		addPacket(new C_POLL_ANSWER(0x163, State.IN_GAME));
		addPacket(new C_CHARGE_ITEM(0x124, State.IN_GAME));
		addPacket(new C_MATCHMAKER_REQ(0x1AB, State.IN_GAME));
		addPacket(new C_LEAVE_INSTANTDUNGEON(0xC4, State.IN_GAME));
		addPacket(new C_ADD_BLOCK(0x14C, State.IN_GAME));
		addPacket(new C_ADD_BUDDY(0x105, State.IN_GAME));
		addPacket(new C_REMOVE_BUDDY(0x102, State.IN_GAME));
		addPacket(new C_ANSWER(0xC0, State.IN_GAME));
		addPacket(new C_TURN_OFF_TOGGLE_SKILL(0xD0, State.IN_GAME));
		addPacket(new C_PERSONAL_SHOP(0x13D, State.IN_GAME));
		addPacket(new C_SHOP_MSG(0x13A, State.IN_GAME));
		addPacket(new C_CLIENTSIDE_NPC_MOVE(0x1A8, State.IN_GAME));
		addPacket(new C_PET_ORDER(0x13B, State.IN_GAME));
		addPacket(new C_CLIENTSIDE_NPC_ACTION(0x1A9, State.IN_GAME));
		addPacket(new C_CLIENTSIDE_NPC_ATTACK(0x1A6, State.IN_GAME));
		addPacket(new C_CLIENTSIDE_NPC_USE_SKILL(0x1A4, State.IN_GAME));
		//todo missing addPacket(new C_ACCEPT_TELEPORT(0xE5, State.IN_GAME)); //TODO after change Map
		addPacket(new C_PATH_FLY(0xC3, State.IN_GAME));
		addPacket(new C_COMBINE(0x167, State.IN_GAME));
		addPacket(new C_BUY_SELL(0xC1, State.IN_GAME));
		addPacket(new C_TRADE_IN(0x2DA, State.IN_GAME));
		addPacket(new C_VIEW_OTHER_INVENTORY(0x10E, State.IN_GAME));
		addPacket(new C_PARTY_BY_NAME(0x113, State.IN_GAME));
		addPacket(new C_DUEL(0x100, State.IN_GAME));
		addPacket(new C_ASK_XCHG(0xF5, State.IN_GAME));
		addPacket(new C_ADD_XCHG(0x132, State.IN_GAME));
		addPacket(new C_XCHG_GOLD(0x130, State.IN_GAME));
		addPacket(new C_CANCEL_XCHG(0x12F, State.IN_GAME));
		addPacket(new C_CHECK_XCHG(0x131, State.IN_GAME));
		addPacket(new C_ACCEPT_XCHG(0x12E, State.IN_GAME));
		addPacket(new C_SPLIT_GOLD(0x106, State.IN_GAME));
		addPacket(new C_GROUP_CHANGE_LOOTDIST(0x178, State.IN_GAME));
		addPacket(new C_GROUP_ITEM_DIST(0x17b, State.IN_GAME));
		addPacket(new C_PARTY(0x112, State.IN_GAME));
		addPacket(new C_TACTICS_SIGN(0x17F, State.IN_GAME));
		addPacket(new C_MAIL_WRITE(0x16E, State.IN_GAME));
		addPacket(new C_MAIL_READ(0x16C, State.IN_GAME));
		addPacket(new C_MAIL_DELETE(0x16B, State.IN_GAME));
		addPacket(new C_MAIL_POSTMAN(0x150, State.IN_GAME));
		addPacket(new C_MAIL_GETITEM(0x16A, State.IN_GAME));
		addPacket(new C_2ND_PASSWORD(0x1A0, State.AUTHED));
		addPacket(new C_MAIL_LIST(0x16F, State.IN_GAME));
		addPacket(new C_SA_GOODSLIST(0x15F, State.IN_GAME));
		addPacket(new C_ASK_PC_INFO(0xCD, State.IN_GAME));
		addPacket(new C_SWAP_ITEM_SLOT(0x140, State.IN_GAME));
		addPacket(new C_REMOVE_BLOCK(0x14D, State.IN_GAME));
		addPacket(new C_CHANGE_BLOCK_MEMO(0x141, State.IN_GAME));
		addPacket(new C_GUILD(0xC7, State.IN_GAME));
		addPacket(new C_REQUEST_GUILD_HISTORY(0xFD, State.IN_GAME));
		addPacket(new C_GUILD_FUND(0x126, State.IN_GAME));
		addPacket(new C_VENDOR_BUY(0x134, State.IN_GAME));
		addPacket(new C_VENDOR_COMMIT(0x135, State.IN_GAME));
		addPacket(new C_VENDOR_ITEMLIST_NAME(0x136, State.IN_GAME));
		addPacket(new C_VENDOR_MYLIST(0x137, State.IN_GAME));
		addPacket(new C_VENDOR_ITEMLIST_CATEGORY(0x139, State.IN_GAME));
		addPacket(new C_VENDOR_COLLECT(0x170, State.IN_GAME));
		addPacket(new C_VENDOR_CANCEL(0x172, State.IN_GAME));
		addPacket(new C_VENDOR_MYLOG(0x173, State.IN_GAME));
		addPacket(new C_NCGUARD(0x10A, State.IN_GAME));
		addPacket(new C_SELECT_ITEM(0x15B, State.IN_GAME));
		addPacket(new C_MINIGAME(0x01b9, State.IN_GAME));
		addPacket(new C_LOGOUT(0xF0, State.AUTHED, State.IN_GAME));
		//todo addPacket(new C_BUILDER_COMMAND(0xCB, State.IN_GAME));
		//todo addPacket(new C_BUILDER_CONTROL(0xC8, State.IN_GAME));
		//todo addPacket(new C_UNK_GF_HAS_DISABLED(0x0186, State.IN_GAME));
		addPacket(new C_SHOP_REQUEST(0x01B0, State.IN_GAME));
		//todo addPacket(new C_REQUEST_RANK_LIST(0x181, State.IN_GAME));
		//todo addPacket(new C_REQUEST_RANK_INFO(0x1BE, State.IN_GAME));
		//TODO continue

        addPacket(new CM_E0_UNK(0xE2, State.CONNECTED, State.AUTHED, State.IN_GAME));
		addPacket(new CM_EQUIPMENT_CHANGE(0x182, State.IN_GAME));
		addPacket(new CM_EQUIPMENT_CHANGE_USE(0x183, State.IN_GAME));
		addPacket(new CM_USER_CLASSIC_WARDROBE_FAVORITE(0x18A, State.IN_GAME));
        addPacket(new CM_USER_CLASSIC_WARDROBE_APPLY(0x18B, State.IN_GAME));
        addPacket(new CM_USER_CLASSIC_WARDROBE_REMOVE(0x18C, State.IN_GAME));
        addPacket(new CM_USER_CLASSIC_WARDROBE_DYE(0x18D, State.IN_GAME));
        addPacket(new CM_USER_CLASSIC_WARDROBE_EXTEND(0x188, State.IN_GAME));
        addPacket(new CM_USER_CLASSIC_WARDROBE_REGISTER(0x18F, State.IN_GAME));
        addPacket(new CM_QUEST_TELEPORT(0x1BC, State.IN_GAME));
		addPacket(new CM_BATTLE_PASS_REWARD(0x157, State.IN_GAME));
		addPacket(new CM_LEGION_UPLOAD_EMBLEM(0x114, State.IN_GAME));
		addPacket(new CM_BLACKCLOUD_MAIL(0x15F, State.IN_GAME));
		addPacket(new CM_BLACKCLOUD_MAIL_CLAIM(0x15C, State.IN_GAME));
		addPacket(new CM_REPORT_CHAT(0x18E, State.IN_GAME));
		//addPacket(new CM_BROKER_ADD_ITEM(0x190, State.IN_GAME));
		addPacket(new CM_NP_MESSAGE(0xF4, State.IN_GAME));
		addPacket(new CM_APPEARANCE(0x1AC, State.IN_GAME));
		addPacket(new CM_CUBE_EXPAND(0x1BB, State.IN_GAME));

        /*
        addPacket(new CM_LEGION_MODIFY_EMBLEM(0xAE, State.IN_GAME));
		addPacket(new CM_LEGION_UPLOAD_INFO(0x113, State.IN_GAME));
		addPacket(new CM_LEGION_UPLOAD_EMBLEM(0x114, State.IN_GAME));
		addPacket(new CM_LEGION_SEND_EMBLEM(0x81, State.IN_GAME));
		addPacket(new CM_LEGION_SEND_EMBLEM_INFO(0xA2, State.IN_GAME));
		addPacket(new CM_BLACKCLOUD_MAIL_OPEN(0x15B, State.IN_GAME));
		*/
        //0x15F
    }

    public AionPacketHandler getPacketHandler() {
        return handler;
    }

    private void addPacket(AionClientPacket prototype) {
        handler.addPacketPrototype(prototype);
    }

    @SuppressWarnings("synthetic-access")
    private static class SingletonHolder {
        protected static final AionPacketHandlerFactory instance = new AionPacketHandlerFactory();
    }
}