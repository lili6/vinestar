/**
 * 
 */
package vine.common.constant;

/**
 * 业务请求结果常量
 * @author PanChao
 */
public class MessageResult {
	/** 保存消息提示数组的KEY */
	public static final String MESSAGE_RESULT_KEY = "msg";
	/** 保存消息提示名称(类型)的KEY */
	public static final String MESSAGE_RESULT_NAME_KEY = "k_m";
	/** 保存消息提示值的KEY */
	public static final String MESSAGE_RESULT_VALUE_KEY = "k_v";
	/** 来源消息中的签名串参数的KEY */
	public static final String MESSAGE_PARAM_SIGN = "sign";
	/** 来源消息中的时间戳参数的KEY */
	public static final String MESSAGE_PARAM_TIME = "time";
	/** 账号没有角色 */
	public static final int NO_ROLE = 1001;
	/** 没有提供消息ID */
	public static final int FILTER_NO_MESSAGEID = -1000;
	/** 时间范围内登录限制 */
	public static final int FILTER_LOGIN_LOCK = -1001;
	/** 服务器关闭 */
	public static final int FILTER_SERVER_CLOSED = -1002;
	/** 玩家数据锁定 */
	public static final int FILTER_USER_DATA_LOCK = -1003;
	/** 该玩家的游戏功能未解锁 */
	public static final int FILTER_GAMEFUN_NOT_OPEN = -1004;
	/** 请求的参数不正确 */
	public static final int REQUEST_PARAMS_ERROR = -1005;
	/** 请求的参数签名不正确 */
	public static final int REQUEST_PARAMS_SIGN_ERROR = -1006;
	/** 被踢下线后时间未到，不能登录 */
	public static final int FILTER_LOGIN_KICK_LOCK = -1007;
	/** 请求成功 */
	public static final int SUCCESS = 1;
	/** 请求失败 */
	public static final int FIALED = 0;
	/** 元宝不足 */
	public static final int POINT_NOT_ENOUGH = 100203;
	/** 金钱不足 */
	public static final int GOLD_NOT_ENOUGH = 100204;
	/** 修为不足 */
	public static final int PRACTICE_NOT_ENOUGH = 100003;
	/** 强化石不足 */
	public static final int STONE_NOT_ENOUGH = 100006;
	/** 背包不足或已满 */
	public static final int BAG_FULL = 100205;
	/** 武将已满 */
	public static final int HERO_FULL = 100206;
	/** 物品不足 */
	public static final int ITEM_NOT_ENOUGH = 100007;
	/** 精力不足 */
	public static final int ENERGY_NOT_ENOUGH = 100202;

	/**体力不足*/
	public static final int SP_NOT_ENOUGH = 100201;
	/**有己上阵英雄*/
	public static final int HERO_IS_POS = 120101;
	/**强化等级到上限*/
	public static final int MAX_ITEM_LV = 130002;
	/**装备等级不能超过人物等级*/
	public static final int MAX_ITEM_LV_ROLE = 130001;
	/** 等级不足 */
	public static final int LEVEL_NOT_ENOUGH = 120002;
	/**有装备,不能传功*/
	public static final int HERO_WITH_ITEM = 120203;
	/**有装备,不能传功*/
	public static final int HERO_AT_POSITION = 120106;
	/** 武将等级不能超过门派等级 */
	public static final int MAX_HERO_LV_FOR_ROLE = 120202;
	/** 武将传功达最高等级 */
	public static final int MAX_HERO_LV = 120201;
	/**绝学等级不能超过人物等级*/
	public static final int MAX_GIFT_LV = 120401;
	/**绝学升到  XX级*/
	public static final int GIFT_UP = 120402;
	/**重墨绝学成功*/
	public static final int GIFT_RESET = 120403;
	/**主殿等级不能超过人物等级 */
	public static final int MAIN_BUILD_LV = 110203;
	/**建筑等级不能超过主殿等级*/
	public static final int MAX_BUILD_LV = 110202;
	/** 门客栏位已满，花费{0}元宝购买一个新的栏位。(第二个栏位) */
	public static final int SLAVE_NOT_ENOUGH_TWO = 170205 ;
	/** 少侠，你手下门客已经很多了，清理下吧！ */
	public static final int SLAVE_MUST_CLEAR = 170206; 
	/** 门客栏位已满，花费{0}元宝购买一个新的栏位。(第三个栏位) */
	public static final int SLAVE_NOT_ENOUGH_THREE = 170207;
	/**秘籍升级*/
	public static final int ITEM__UP_LV = 130101;
	/**没有上阵侠客*/
	public static final int NO_HERO_POS = 100209;
	/** 超过一半体力 */
	public static final int OVER_HALF_SP = 100210;
	/** 超过一半精力 */
	public static final int OVER_HALF_ENERPY = 100211;
	/** 体力已满 */
	public static final int OVER_MAX_SP = 100212;
	/** 精力已满 */
	public static final int OVER_MAX_ENERPY = 100213;
	/** 建筑当日征收次数已满 */
	public static final int BUILDING_DAILY_REAP_MAX = 110301;
	/** 转生次数达到上限 */
	public static final int RELIFE_NUMBER_MAX = 120302;
	/** 强化成功 */
	public static final int STRENGTH_ITEM_OK = 130003;
	/** 强化成功，还一半钱 */
	public static final int STRENGTH_ITEM_OK_HALF = 130004;
	/** 强化成功，还所有钱 */
	public static final int STRENGTH_ITEM_OK_ALL = 130005;
	/** 已超出此次决斗时限，发起决斗失败 */
	public static final int FIGHTING_OUT_TIME = 140101;
	/** 士气不足, 无法发起挑战 */
	public static final int MORALE_NOT_ENOUGH = 100214;
	/** 士气已满 */
	public static final int MORALE_FULL = 100215;
	/** 武将：激活{0}特性{1} */
	public static final int HERO_FEATURE_ACTIVE = 120103;
	/** 武将：{1}特性{2}消失 */
	public static final int HERO_FEATURE_REMOVE = 120104;
	/** 已连胜{0}场，继续连胜{1}场将获得丰厚奖励。 */
	public static final int FIGHTING_WILL_WIN_THREE = 140102;
	/** 恭喜侠士连胜达到今日最大场次。 */
	public static final int FIGHTING_WIN_TIMES_FULL = 140103;
	/** 恭喜侠士通关{0}，成功解锁{1}。 */
	public static final int GATE_COMPLTE = 140201;
	/** 购买{0}成功。 */
	public static final int BUY_SUCCESS = 150001;
	/** 出售{0}成功。 */
	public static final int SELL_SUCCESS = 150101;
	/** 使用{0}成功，恢复体力。 */
	public static final int USE_SP_SUCCESS = 150201;
	/** 使用{0}成功，恢复精力 */
	public static final int USE_ENERY_SUCCESS = 150202;
	/** 众侠客豪饮{0}，士气增加，获得{1}%攻击力加成！ */
	public static final int USE_MORALE_SUCCESS = 150203;
	/** 使用{0}成功，获得{1}点金钱 */
	public static final int USE_GOLD_SUCCESS = 150204;
	/** 使用{0}成功，获得{1}点强化石 */
	public static final int USE_STONE_SUCCESS = 150205;
	/** 使用{0}成功，藏经阁进入{1}小时保护状态 */
	public static final int USE_BOOKPROTECTED_SUCCESS = 150206;
	/** 没有上阵的侠客。 */
	public static final int NO_POSITION_HERO = 100209;
	/** 不允许没有上阵的侠客 */
	public static final int NOT_ALLOW_NOPOSITION_HERO = 120105;
	/** 已存在同名门派，请少侠重新命名。 */
	public static final int ROLE_NAME_EXIST = 110001;
	/** 门派名不可用，请少侠重新命名。 */
	public static final int ROLE_NAME_INVALID = 110002;
	/** 建筑{0}升级到{1}级 */
	public static final int BUILD_UPGRADE = 110201;
	/** {0}在传功时顿悟，技能{1}提升至{2}级。 */
	public static final int TRANSMIT_SUCCESS = 120206;
	/** 转生成功，侠客达到{0}星。 */
	public static final int RELIFE_SUCCESS = 120301;
	/** 获得经验 */
	public static final int GIVE_EXP = 140301;
	/** 获得金钱 */
	public static final int GIVE_GOLD = 140302;
	/** 获得强化石 */
	public static final int GIVE_STONE = 140303;
	/** 征收金钱 */
	public static final int REAP_GOLD = 160101;
	/** 征收强化石 */
	public static final int REAP_STONE = 160102;
	/** 征收修为 */
	public static final int REAP_PRACTICE = 160103;
	/** 你哼着一曲十八摸，轻轻的从{0}怀里摸走了{1}点强化石。 */
	public static final int REAP_SLAVE_STONE = 170208;
	/** 你不顾{0}的苦苦哀求，挥着鞭子强令他交出了{1}点银两。 */
	public static final int REAP_SLAVE_GOLD = 170209;
	/** 你兴致大发，命令{0}当人肉沙包，一番痛殴后心满意足的获得了{1}点修为。 */
	public static final int REAP_SLAVE_PRACTICE = 170210;
	/** {0}机智的没有开启对应山庄建筑，你忧伤地无功而返。 */
	public static final int REAP_SLAVE_EMPTY = 170211;
	/** 未达到开启条件 */
	public static final int COND_NOT_ENOUGH = 100012;
	/** 你获得了{0}点经验 */
	public static final int FIGHTING_GIVE_EXP = 150301;
	/** 你获得了{0}点金钱 */
	public static final int FIGHTING_GIVE_GOLD = 150302;
	/** 你获得了{0}点元宝 */
	public static final int FIGHTING_GIVE_POINT = 150303;
	/** 你获得了{0}点强化石 */
	public static final int FIGHTING_GIVE_STONE = 150304;
	/** 你获得了{0}（物品、英雄） */
	public static final int FIGHTING_GIVE_ITEM = 150305;
	/** 武将上阵位未开启 */
	public static final int HERO_POSITION_NOT_OPEN = 120102;
	/** 临时封停账号 */
	public static final int ACCOUNT_TEMP_LOCKED = 100013;
	/** 永久封停账号 */
	public static final int ACCOUNT_LOCKED = 100014;
	/** {0}趁你不备上门踢馆，夺走{1}金钱和{2}个强化石。 */
	public static final int EMAIL_KICK_SUCCESS = 170001;
	/** {0}不自量力前来踢馆，被本门侠客赶下山去。 */
	public static final int EMAIL_KICK_FAILED = 170002;
	/** {0}掌门与你一见如故，愿和你结为知己好友。 */
	public static final int EMAIL_FRIEND_ADD = 170101;
	/** {0}掌门接受了你的好友邀请。 */
	public static final int EMAIL_FRIEND_SUCCESS = 170102;
	/** {0}召集高手前来本门挑战，{1}见风使舵归附其麾下。 */
	public static final int EMAIL_SLAVE_SUCCESS_MASTER = 170201;
	/** {0}召集高手前来本门挑战，本门实力不济只能暂时归附其麾下，以图东山再起。 */
	public static final int EMAIL_SLAVE_SUCCESS = 170202;
	/** {0}重整旗鼓，脱离本门控制。 */
	public static final int EMAIL_SLAVE_RESIST = 170203;
	/** 实力不如{0}，其麾下的{1}放弃向本门投诚。 */
	public static final int SLAVE_FAILED = 170204;
	/** 少门主已多次击败{0}，还是给他们留条活路吧。 */
	public static final int KICK_MORE = 170003;
	/** 已经使用高级道具五行奇阵保护。 */
	public static final int BOOK_PROTECT_HAS = 180001;
	/** 残卷有遗失，无法合成。 */
	public static final int BOOK_COMPOUND_NOT_ENGOUH = 180101;
	/** 不能添加自己为好友。 */
	public static final int FRIEND_CANNOT_ADD_SELF = 170103;
	/** 好友列表已满。 */
	public static final int FRIEND_FULL = 170104;
	/** 已经和对方结成好友。 */
	public static final int FRIEND_HAS = 170105;
	/** 该门派不存在。 */
	public static final int MENPAI_NOT_EXSIST = 100015;
	/** 绝学等级达到上限。 */
	public static final int GIFT_FULL = 120404;
	/** 升级{0}返回金钱{1} */
	public static final int BUILD_UPGRADE_GOLD = 110302;
	/** 成功与{0}结成好友。 */
	public static final int ADD_FRIEND_SUCCESS = 170106;
	/** 充值成功，你获得了{0}个元宝 */
	public static final int RECHARGE_SUCCESS = 100217;
	/** 好友请求已发送成功 */
	public static final int FRIEND_SEND = 170108;
	/** 请不要发送重复的好友请求。 */
	public static final int FRIEND_REPEAT_SEND = 170109;
	/** 侠客不可以传功（升级）（吃别的侠客） */
	public static final int HERO_CANNOT_UPGRADE = 120207;
	/** 当日购买次数已经用完，请提升你的VIP等级 */
	public static final int VIP_BUY_TIMES_EMPTY = 150002;
	/** 购买{0}需要VIP{1}，请提升你的VIP等级 */
	public static final int VIP_BUY_NOT_ENOUGH = 150003;
	/** 你获得了{0},{1}个 */
	public static final int GIVE_ITEM = 150306;
	/** 吃饱喝足，体力恢复{0}点。 */
	public static final int MEAL_ADD_SP = 190101;
	/** 体力超过上限，去江湖上闯荡一番再来吃饭吧。 */
	public static final int MEAL_ADD_FULL = 190102;
	/** 少门主豪气干云，获取求贤好感度{0}。 */
	public static final int TALENT_SCORE_ADD = 190201;
	/** 招揽侠客成功，消耗{0}点好感度。 */
	public static final int TALENT_SCORE_USE = 190202;
	/** VIP等级不足，无法进行强征 */
	public static final int VIP_REAP_NOT_ENOUGH = 160202;
	/** 当日强征次数已用完，提升VIP等级可增加强征次数。 */
	public static final int VIP_REAP_TIMES_EMPTY = 160203;
	/** 当日重置次数已用完，提升VIP等级可增加重置次数。  */
	public static final int VIP_RESET_GATE_TIMES_EMPTY = 190002;
	/** 背包已满，请及时清理背包 */
	public static final int BAG_FULL_NOTIFY = 150307;
	/** 当日使用次数已经用完，请提升你的VIP等级 */
	public static final int VIP_USE_ADD_SP_ENERY = 150207;
	/** 今日令牌已用完，请少侠明日再来。 */
	public static final int FIGHTING_TOKEN_NOT_ENOUGH = 140104;
	/** 突破成功，消耗魂魄{0} */
	public static final int HERO_BREAKTHROUGH_SUCCESS = 210001;
	/** 招募成功，消耗魂魄{0}。 */
	public static final int HERO_RECHARGE =  210002;
	/** {0}召集高手前来抢夺秘籍，被本门高手击败。 */
	public static final int EMAIL_GRAB_FAILED = 180201;
	/** {0}召集高手前来抢夺秘籍，本门高手携带秘籍逃跑。 */
	public static final int EMAIL_GRAB_SUCCESS = 180202;
	/** {0}召集高手前来抢夺秘籍，{1}不幸被其抢走。 */
	public static final int EMAIL_GRAB_SUCCESS_BOOK = 180203;
	/** 工匠正在升级其他的建筑，暂时无暇理会你的命令。 */
	public static final int BUILD_UPGRADE_CD = 160204;
	/** 无法抢夺已拥有的秘籍残页。 */
	public static final int BOOK_HAS_PIECE = 180205;
	/**缺少小喇叭*/
	public static final int NO_ENOUGH_BUGLE = 200100;
	/** 修为不足，{0}技能升级失败。*/
	public static final int NO_SKILL_PRESTIGE = 230001;
	/** 0}技能升级失败*/
	public static final int SKILL_UPGRADE_FAILURE = 230002;
	/** {0}技能从{1}升至{2}级成功！ */
	public static final int SKILL_UPGRADE_SUCC = 230003;
	/** 发送聊天信息不可为空！ */
	public static final int CANNOT_SEND_EMPTY_CHAT = 200101;
	/***/
	public static final int CHANNAGE_NUM_FULL = 140501;
}
