/*
 * Copyright (c) 2015 Bambang Purnomosidi - Kipo project
 * -----------------------------------------------------
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

package name.bpdp.blazegraph;

import io.vertx.codegen.annotations.GenIgnore;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.ProxyIgnore;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import name.bpdp.blazegraph.impl.BlazegraphServiceImpl;
import io.vertx.serviceproxy.ProxyHelper;

/**
 * Blazegraph service
 *
 * @author <a href="http://bpdp.name">Bambang Purnomosidi</a>
 */
@VertxGen
@ProxyGen
public interface BlazegraphService {

  /**
   * Create a service locally
   *
   * @param vertx  the Vert.x instance
   * @param config  the configuration
   * @return the service
   */
  static BlazegraphService create(Vertx vertx, JsonObject config) {
    return new BlazegraphServiceImpl(vertx, config);
  }

  /**
   * Create an event bus proxy to a service which lives somewhere on the network and is listening on the specified
   * event bus address
   *
   * @param vertx  the Vert.x instance
   * @param address  the address on the event bus where the service is listening
   * @return
   */
  static BlazegraphService createEventBusProxy(Vertx vertx, String address) {
    return ProxyHelper.createProxy(BlazegraphService.class, vertx, address);
  }

  /**
   * Start the service
   */
  @ProxyIgnore
  public void start() throws Exception;

  /**
   * Stop the service
   */
  @ProxyIgnore
  public void stop();
}
