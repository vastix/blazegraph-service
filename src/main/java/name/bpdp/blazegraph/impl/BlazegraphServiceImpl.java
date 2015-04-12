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

package name.bpdp.blazegraph.impl;

import io.vertx.core.*;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.impl.LoggerFactory;
import name.bpdp.blazegraph.BlazegraphService;

import java.io.FileNotFoundException;
import java.util.Properties;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedInputStream;

import org.openrdf.repository.Repository;

import com.bigdata.rdf.sail.BigdataSailRepository;
import com.bigdata.journal.IIndexManager;
import com.bigdata.rdf.sail.BigdataSail;

/**
 * @author <a href="http://bpdp.name">bpdp</a>
 */
public class BlazegraphServiceImpl implements BlazegraphService {

  private static final Logger log = LoggerFactory.getLogger(BlazegraphService.class);

  private final Vertx vertx;
  private final JsonObject config;

  public BlazegraphServiceImpl(Vertx vertx, JsonObject config) {
    this.vertx = vertx;
    this.config = config;
  }

  @Override
  public void start() throws Exception {

		Properties blazeProp;

		blazeProp = this.loadProperties("RWStore.properties");

        final BigdataSail sail = new BigdataSail(blazeProp);
		Repository repo = new BigdataSailRepository(sail);

        repo.initialize();

  }

  @Override
  public void stop() {
  }

	/**
	* Load a Properties object from a file.
	* 
	* @param resource
	* @return
	* @throws Exception
	*/

	private Properties loadProperties(String resource) throws Exception {

		Properties p = new Properties();
		InputStream is = getClass().getClassLoader().getResourceAsStream(resource);

		if (is != null) {
			p.load(is);
		} else {
			throw new FileNotFoundException("Property file not found in classpath");
		}

		return p;
	}

}
