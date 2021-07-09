package lz.aspect;

import lz.annotation.Aspect;
import lz.proxy.AspectProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

@Aspect(pkg = "lz.controller", cls = "UserController")
public class EfficientAspect2 extends AspectProxy {
    private static final Logger LOGGER = LoggerFactory.getLogger(EfficientAspect2.class);

    private long begin;

    /**
     * 切入点判断
     */
    @Override
    public boolean intercept(Method method, Object[] params) throws Throwable {
        return method.getName().equals("getUserList");
    }

    @Override
    public void before(Method method, Object[] params) throws Throwable {
        System.out.println("---------- begin 2----------");
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Method method, Object[] params) throws Throwable {
        System.out.println(String.format("time: %dms", System.currentTimeMillis() - begin));
        System.out.println("----------- end2 -----------");
    }
}

