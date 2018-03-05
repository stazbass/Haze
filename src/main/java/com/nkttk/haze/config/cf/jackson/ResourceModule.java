package com.nkttk.haze.config.cf.jackson;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;

/**
 * Created by cryptobat on 12/21/2016.
 */
public class ResourceModule extends Module {
    @Override
    public String getModuleName() {
        return null;
    }

    @Override
    public Version version() {
        return null;
    }

    @Override
    public void setupModule(SetupContext context) {

    }
}
