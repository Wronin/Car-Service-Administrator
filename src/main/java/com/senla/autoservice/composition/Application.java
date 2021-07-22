package com.senla.autoservice.composition;

import com.senla.autoservice.controller.IAdminController;
import com.senla.autoservice.dao.IAdminDao;
import com.senla.autoservice.dao.IMasterDao;
import com.senla.autoservice.controller.IMasterController;
import com.senla.autoservice.service.IAdminService;
import com.senla.autoservice.service.IMasterService;

import java.util.Map;

public class Application {

    public static ApplicationContext run(String pakageToScan, Map<Class, Class> ifc2ImplClass) throws ReflectiveOperationException {
        ObjectConfig config = new ObjectConfig(pakageToScan, ifc2ImplClass);
        ApplicationContext context = new ApplicationContext(config);
        ObjectFactory objectFactory = new ObjectFactory(context);
        context.setFactory(objectFactory);

        context.getObject(IMasterService.class);
        context.getObject(IMasterController.class);
        context.getObject(IMasterDao.class);

        context.getObject(IAdminService.class);
        context.getObject(IAdminController.class);
        context.getObject(IAdminDao.class);

//        context.getObject(IOrganizationService.class);
//        context.getObject(IOrganizationController.class);
//        context.getObject(IOrganizationDao.class);

        return context;
    }
}
