package xyz.bpdp.vertx.blazegraph;

import io.vertx.codetrans.annotations.CodeTranslate;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestOptions;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.core.DeploymentOptions;

import xyz.bpdp.vertx.blazegraph.BlazegraphServiceVerticle;

@RunWith(VertxUnitRunner.class)
public class BlazegraphServiceTest {

	Vertx vertx = Vertx.vertx();

	@Before
	public void before(TestContext context) {

		JsonObject config = new JsonObject().put("address", "vastix.blazegraph");
		DeploymentOptions depOptions = new DeploymentOptions().setConfig(config);

		vertx.deployVerticle("service:xyz.bpdp.blazegraph-service", depOptions, res -> {
			if (res.succeeded()) {
				System.out.println("Start service - succeed");
			} else {
				System.out.println("Start service - failed");
			}
		});

	}

	@After
	public void after(TestContext context) {
		vertx.close();
	}

	@Test
	public void test1(TestContext context) {
		String s = "value1";
		context.assertEquals("value1", s);
	}

	@Test
	public void test2(TestContext context) {
		String s = "value2";
		context.assertEquals("value2", s);
	}

}
