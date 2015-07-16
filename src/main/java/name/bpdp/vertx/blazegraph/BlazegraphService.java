package name.bpdp.vertx.blazegraph;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

import io.vertx.core.Vertx;
import io.vertx.serviceproxy.ProxyHelper;

import io.vertx.codegen.annotations.GenIgnore;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.ProxyIgnore;
import io.vertx.codegen.annotations.VertxGen;

import name.bpdp.vertx.blazegraph.impl.BlazegraphServiceImpl;

@ProxyGen
public interface BlazegraphService {

	static BlazegraphService create(JsonObject config) {
		try {
			return new BlazegraphServiceImpl();
		} catch (Exception e) {
			return null; 
		}
	}

    static BlazegraphService createProxy(Vertx vertx, String address) {
      return ProxyHelper.createProxy(BlazegraphService.class, vertx, address);
    }


    // Actual service operations here...

    void save(String collection);
}
