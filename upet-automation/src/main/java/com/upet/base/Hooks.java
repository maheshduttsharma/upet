package com.upet.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    @Before
    public void setup(Scenario sc){
        Base.gearUp(sc);
    }

    @After
    public void wrapup(){
        Base.goodbye();
    }
}
