package cn.no7player.common.tenant;


/**
 * 存储租户信息 判断是操作哪个DB
 */
public final class TenantContextHolder {

    private TenantContextHolder(){}

    private static ThreadLocal<String> tenanThreadLocal = new ThreadLocal<String>();

	/**
	 * 增加 scheme
	 * @param scheme
	 */
    public static void setTenant(String scheme) {
        tenanThreadLocal.set(scheme);
    }

	/**
	 * 获取schema
	 * @return
	 */
    public static String getTenant() {
        String scheme = tenanThreadLocal.get();
        if (scheme == null) {
            scheme = "";
        }
        return scheme;
    }

	/**
	 * 移除schema
	 */
    public static void remove() {
        tenanThreadLocal.remove();
    }

}
