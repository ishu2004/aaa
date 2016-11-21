/*
 * Copyright (c) 2016 Inocybe Technologies and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.aaa.idm.rest.test;

import com.sun.jersey.spi.container.servlet.WebComponent;
import com.sun.jersey.test.framework.AppDescriptor;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.WebAppDescriptor;
import org.junit.Before;
import org.opendaylight.aaa.api.StoreBuilder;
import org.opendaylight.aaa.idm.IdmLightApplication;
import org.opendaylight.yang.gen.v1.config.aaa.authn.idmlight.rev151204.AAAIDMLightModule;


public abstract class HandlerTest extends JerseyTest {

    protected IDMTestStore testStore = new IDMTestStore();

    @Override
    protected AppDescriptor configure() {
        return new WebAppDescriptor.Builder()
                                   .initParam(WebComponent.RESOURCE_CONFIG_CLASS, IdmLightApplication.class.getName())
                                   .build();
    }

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();
        new StoreBuilder(testStore).init();
        AAAIDMLightModule.setStore(testStore);
    }
}
