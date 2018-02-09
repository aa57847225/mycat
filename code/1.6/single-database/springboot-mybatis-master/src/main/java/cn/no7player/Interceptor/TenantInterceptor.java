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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.Properties;


@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class})})
@Component
public class TenantInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {

		System.out.println("============asdsadsadadas");
		String tenant = TenantContextHolder.getTenant();

		if(tenant == null || tenant == "") {
			System.out.println("tenant 为空，不需要改写sql语句");
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
			System.out.println("处理之前" + sql);
			//对 sql 增加 mycat 注解

			//String tenant = "db4";
			sql = "/*!mycat:schema=" + tenant + "*/" + sql;

			System.out.println("加入处理后:" + sql);
			ReflectHelper.setFieldValue(boundSql, "sql", sql);
		}
//		String tenant = TenantContextHolder.getTenant();

//		if(tenant == null || tenant == "") {
//			System.out.println("tenant 为空，不需要改写sql语句");
//			return invocation.proceed();
//		}
//
//		if (invocation.getTarget() instanceof RoutingStatementHandler) {
//
//			System.out.println("aaaaaaa");
//			RoutingStatementHandler statementHandler = (RoutingStatementHandler) invocation
//					.getTarget();
//			StatementHandler delegate = (StatementHandler) ReflectHelper
//					.getFieldValue(statementHandler, "delegate");
//			BoundSql boundSql = delegate.getBoundSql();
//			Object obj = boundSql.getParameterObject();
//
//
//			// 通过反射获取delegate父类BaseStatementHandler的mappedStatement属性
//			MappedStatement mappedStatement = (MappedStatement) ReflectHelper
//					.getFieldValue(delegate, "mappedStatement");
//			// 拦截到的prepare方法参数是一个Connection对象
//			Connection connection = (Connection) invocation.getArgs()[0];
//			// 获取当前要执行的Sql语句，也就是我们直接在Mapper映射语句中写的Sql语句
//			String sql = boundSql.getSql();
//			// 给当前的page参数对象设置总记录数
//			System.out.println("处理之前" + sql);
//			//对 sql 增加 mycat 注解
//
//
//			sql = "/*!mycat:schema=" + tenant + " */" + sql;
//
//			System.out.println("加入处理后:" + sql);
//
//
//
//			ReflectHelper.setFieldValue(boundSql, "sql", sql);
//
//		}
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