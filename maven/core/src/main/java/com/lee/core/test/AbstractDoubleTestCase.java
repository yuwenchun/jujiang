package com.lee.core.test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Before;

/**
 * Title: sse-rm<br>
 * Description: 双对象测试抽象类<br>
 * Copyright: Copyright (c) 2013<br>
 * Company: SSE<br>
 * @author lihuibin
*/
public abstract class AbstractDoubleTestCase<T, E> extends AbstractTestCase<T> {
	
    protected Class<E> clazzE;
	
	protected E bean2 = null;
	 
	@Before
    public void prepare() throws Exception {
        // TODO Auto-generated method stub
        super.prepare();
        
        bean2 = (E) context.getBean(this.clazzE);
        
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void judgeParaType() {
        Class<?> clazz = getClass();

        while (clazz != Object.class) {
            Type t = clazz.getGenericSuperclass();
            if (t instanceof ParameterizedType) {
                Type[] args = ((ParameterizedType) t).getActualTypeArguments();
              
                if (args[0] instanceof Class) {
                    this.clazzT = (Class<T>) args[0];
                    this.clazzE = (Class<E>) args[1];
                    
                    break;
                }
            }
            clazz = clazz.getSuperclass();
        }
    }

}
