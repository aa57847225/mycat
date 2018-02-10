package cn.no7player.Interceptor;

import cn.no7player.common.tenant.TenantContextHolder;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.Properties;

/**
 * 定义 mybatis 拦截器。
 * 如果存在 tenant信息。则使用 tenant 来判断操作哪个DB
 */
@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class})})
@Component
public class TenantInterceptor implements Interceptor {

	private Logger logger = Logger.getLogger(TenantInterceptor.class);

	@Override
	public Object intercept(Invocation invocation) throws Throwable {

		String tenant = TenantContextHolder.getTenant();

		if(tenant == null || tenant == "") {
			logger.info("==========tenant 为空，不需要改写sql语句=======");
			return invocation.proceed();
		}

		if (invocation.getTarget() instanceof RoutingStatementHandler) {
			RoutingStatementHandler statementHandler = (RoutingStatementHandler) invocation
					.getTarget();
			StatementHandler delegate = (StatementHandler) ReflectHelper
					.getFieldValue(statementHandler, "delegate");

			BoundSql boundSql = delegate.getBoundSql();
			Object obj = boundSql.getParameterObject();


			// 通过反射获取delegate父类BaseStatementHandler的mappedStatement属性
			MappedStatement mappedStatement = (MappedStatement) ReflectHelper
					.getFieldValue(delegate, "mappedStatement");
			// 拦截到的prepare方法参数是一个Connection对象
			Connection connection = (Connection) invocation.getArgs()[0];
			// 获取当前要执行的Sql语句，也就是我们直接在Mapper映射语句中写的Sql语句
			String sql = boundSql.getSql();
			// 给当前的page参数对象设置总记录数
			logger.info("==============处理之前" + sql);

			//对 sql 增加 mycat 注解
			sql = "/*!mycat:schema=" + tenant + "*/" + sql;

			logger.info("==============加入处理后:" + sql);
			ReflectHelper.setFieldValue(boundSql, "sql", sql);
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		// TODO Auto-generated method stub
		if (target instanceof StatementHandler) {
			return Plugin.wrap(target, this);
		} else {
			return target;
		}
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub

	}

}