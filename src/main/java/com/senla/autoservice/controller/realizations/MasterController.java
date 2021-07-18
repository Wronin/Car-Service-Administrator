package com.senla.autoservice.controller.realizations;

import com.senla.autoservice.composition.annotations.InjectByClassType;
import com.senla.autoservice.composition.annotations.Singleton;
import com.senla.autoservice.controller.IMasterController;
import com.senla.autoservice.service.IMasterService;

@Singleton
public class MasterController implements IMasterController {

    @InjectByClassType
    private IMasterService iMasterService;

    public MasterController() {
    }

    @Override
    public void addMaster(String name, String pos, int salary, int free) {
        iMasterService.addMaster(name, pos, salary, free);
    }

    @Override
    public void deleteMaster(String name) {
        iMasterService.dellMaster(name);
    }

    @Override
    public void getCurrentMaster(int tmp) {
        iMasterService.getCurrentMaster(tmp);
    }

    @Override
    public void showMasters() {
        iMasterService.showMasters();
    }
}
