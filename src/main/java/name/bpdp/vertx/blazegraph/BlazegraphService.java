package name.bpdp.vertx.blazegraph;

import io.vertx.core.Vertx;
import io.vertx.serviceproxy.ProxyHelper;

import io.vertx.codegen.annotations.GenIgnore;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.ProxyIgnore;
import io.vertx.codegen.annotations.VertxGen;

import name.bpdp.vertx.blazegraph.impl.BlazegraphServiceImpl;

@ProxyGen
public interface BlazegraphService {

    // A couple of factory methods to create an instance and a proxy

	static BlazegraphService create(Vertx vertx) {
		try {
			return new BlazegraphServiceImpl(vertx);
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
