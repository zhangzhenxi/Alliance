package pub.fury.alliance.member;

import java.util.HashMap;

/**
 * Created by zhenxi.
 *
 * @author zhenxi
 * @since 2017/9/6
 */
class MemberMap {
	
	static void initMemberClassPathMap(HashMap<String, String> memberMap) {
		memberMap.put("alipay", "AlipayMember");
		memberMap.put("wechat", "WechatMember");
	}
}
