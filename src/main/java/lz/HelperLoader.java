package lz;


import lz.bean.View;
import lz.controller.UserController;
import lz.helper.AopHelper;
import lz.helper.BeanHelper;
import lz.helper.ClassHelper;
import lz.mvc.ControllerHelper;
import lz.helper.IocHelper;
import lz.utils.*;

import java.util.Map;


public final class HelperLoader {

    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class,
                AopHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
            System.out.println("HelperLoader***********" + cls.getName());
        }
    }

    public static void main(String[] args) {
        init();
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        System.out.println(beanMap.size());
        UserController o = (UserController) beanMap.get(UserController.class);
        View userList = o.getUserList();
    }
}
