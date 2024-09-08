package com.masterhills.RewardsManagement.utility;

import org.hibernate.validator.cfg.defs.UUIDDef;

import java.util.UUID;

public class UUIDGenerator {

    private UUIDGenerator(){}

    public static UUID generateUUID(){
        return UUID.randomUUID();
    }


}
