package com.prismamp.consultas.api.util.rest;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.jboss.resteasy.client.ClientExecutor;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.client.core.executors.ApacheHttpClient4Executor;

public class RestClientFactory {

	public static <T> T crear(String url, Integer timeoutConexion, Integer timeoutRespuesta,
			Class<T> claseRestClient) {

		SchemeRegistry registry = new SchemeRegistry();
		registry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));

		TrustStrategy trustStrategy = new TrustStrategy() {
			@Override
			public boolean isTrusted(java.security.cert.X509Certificate[] arg0, String arg1)
					throws java.security.cert.CertificateException {
				return true;
			}
		};
		SSLSocketFactory factory;
		try {
			factory = new SSLSocketFactory(trustStrategy, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			registry.register(new Scheme("https", 443, factory));
		} catch (KeyManagementException | UnrecoverableKeyException | NoSuchAlgorithmException | KeyStoreException e) {
			e.printStackTrace();
		}

		PoolingClientConnectionManager mgr = new PoolingClientConnectionManager(registry);
		mgr.setMaxTotal(200);
		mgr.setDefaultMaxPerRoute(50);

		DefaultHttpClient httpClient = new DefaultHttpClient(mgr);
		HttpParams params = httpClient.getParams();
		HttpConnectionParams.setConnectionTimeout(params, timeoutConexion);
		HttpConnectionParams.setSoTimeout(params, timeoutRespuesta);

		ClientExecutor executor = new ApacheHttpClient4Executor(httpClient);

		return ProxyFactory.create(claseRestClient, url, executor);

	}

}
