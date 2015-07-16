package name.bpdp.vertx.blazegraph.impl;

import io.vertx.core.Vertx;
import io.vertx.serviceproxy.ProxyHelper;
import name.bpdp.vertx.blazegraph.BlazegraphService;

import java.io.FileNotFoundException;
import java.util.Properties;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedInputStream;

import org.openrdf.repository.Repository;

import com.bigdata.rdf.sail.BigdataSailRepository;
import com.bigdata.journal.IIndexManager;
import com.bigdata.rdf.sail.BigdataSail;

public class BlazegraphServiceImpl implements BlazegraphService {

    // A couple of factory methods to create an instance and a proxy

	public BlazegraphServiceImpl() throws Exception {

		Properties blazeProp;

		blazeProp = this.loadProperties("RWStore.properties");

        final BigdataSail sail = new BigdataSail(blazeProp);
		Repository repo = new BigdataSailRepository(sail);

		repo.initialize();

		System.out.println("Finish starting Blazegraph ...");
	
	}

    // Actual service operations here...

	public void save(String collection) {
		
		System.out.println("Koleksi = " + collection);

	}

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
