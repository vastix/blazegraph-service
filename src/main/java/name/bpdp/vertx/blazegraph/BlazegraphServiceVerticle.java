/*
 * Copyright (c) 2011-2014 The original author or authors
 * ------------------------------------------------------
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 *
 *     The Eclipse Public License is available at
 *     http://www.eclipse.org/legal/epl-v10.html
 *
 *     The Apache License v2.0 is available at
 *     http://www.opensource.org/licenses/apache2.0.php
 *
 * You may elect to redistribute this code under either of these licenses.
 */

package name.bpdp.vertx.blazegraph;

import io.vertx.core.AbstractVerticle;
import io.vertx.serviceproxy.ProxyHelper;

//import name.bpdp.vertx.blazegraph.BlazegraphService;

import io.vertx.core.*;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.impl.LoggerFactory;

import name.bpdp.vertx.blazegraph.BlazegraphService;

/**
 * A verticle that starts an instance of a Blazegraph service
 *
 */
public class BlazegraphServiceVerticle extends AbstractVerticle {

	protected BlazegraphService service;

	@Override
	public void start() throws Exception {

		service = BlazegraphService.create(vertx);

		// Start it
		//service.start();

		//ProxyHelper.registerService(BlazegraphServiceVerticle.class, vertx, service, address);
	}

	@Override
	public void stop() throws Exception {

	}

}
