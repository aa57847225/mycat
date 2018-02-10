package cn.no7player.common.tenant;


/**
 * 存储租户信息 判断是操作哪个DB
 */
public class TenantContextHolder {
	
	private static ThreadLocal<String> tenanThreadLocal = new ThreadLocal<String>();
	
	public static final void setTenant(String scheme) {
		tenanThreadLocal.set(scheme);
	}
	
	public static final String getTenant() {
		String scheme = tenanThreadLocal.get();
		if (scheme == null) {
			scheme = "";
		}
		return scheme;
	}
	
	public static final void remove() {
		tenanThreadLocal.remove();
	}

}
