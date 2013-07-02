package com.lee.core.test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.AbstractSessionFactoryBean;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * Title: sse-rm<br>
 * Description: 单对象测试抽象类<br>
 * Copyright: Copyright (c) 2013<br>
 * Company: SSE<br>
 * @author lihuibin
*/
public abstract class AbstractTestCase<T>  {
    
    protected Class<T> clazzT;
	
	protected T bean1 = null;
	
	protected ApplicationContext context;
	
    private SessionFactory sessionFactory;
    
    private Session session;
	
 
	@Before
	public void prepare() throws Exception {

		context = new ClassPathXmlApplicationContext(this.getConfig());
		
		sessionFactory = (SessionFactory) context.getBean(SessionFactory.class);
        session = SessionFactoryUtils.getSession(sessionFactory, true);
        session.setFlushMode(FlushMode.MANUAL);
        TransactionSynchronizationManager.bindResource(sessionFactory,
                new SessionHolder(session));

		judgeParaType();
		
		bean1 = (T) context.getBean(this.clazzT);
	}

	protected abstract String getSessionFactoryId();
	
	@After
    public void close() throws Exception {

        TransactionSynchronizationManager.unbindResource(sessionFactory);

        SessionFactoryUtils.releaseSession(session, sessionFactory);
    }


    @SuppressWarnings("unchecked")
    protected void judgeParaType() {
        
        Class<?> curClass = getClass();

		while (curClass != Object.class) {
			Type t = curClass.getGenericSuperclass();
			if (t instanceof ParameterizedType) {
				Type[] args = ((ParameterizedType) t).getActualTypeArguments();
				System.out.println(args.length);
				if (args[0] instanceof Class) {
					clazzT = (Class<T>) args[0];
					
					break;
				}
			}
			curClass = curClass.getSuperclass();
		}
    }

    public abstract String[] getConfig() ;
	
	
}
