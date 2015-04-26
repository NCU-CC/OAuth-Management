package tw.edu.ncu.cc.manage.service.oauth.connector;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;

import tw.edu.ncu.cc.manage.dao.support.TrustAllX509TrustManager;

public class Connection {
	public static final String POST = "POST";
	public static final String GET = "GET";
	public static final String PUT = "PUT";
	public static final String DELETE = "DELETE";
	static {
		SSLContext sc = null;
		try {
			sc = SSLContext.getInstance("TLS");

			sc.init(null, new TrustManager[] { new TrustAllX509TrustManager() }, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
				public boolean verify(String string, SSLSession ssls) {
					return true;
				}
			});
		} catch (NoSuchAlgorithmException e) {
			sc = null;
		} catch (KeyManagementException e) {
			sc = null;
		}
	}

	public HttpURLConnection doConnection(URL url, String content, String method) throws IOException {
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

		httpConn.setRequestMethod(method);
		httpConn.setDoOutput(true);
		httpConn.setDoInput(true);
		httpConn.setRequestProperty("Content-Type", "application/json; charset=utf-8 ");
		if (content != null && content.length() > 0) {
			OutputStream os = null;
			try {
				os = httpConn.getOutputStream();
				DataOutputStream wr = new DataOutputStream(os);
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(wr, "UTF-8"));
				writer.write(content);
				writer.flush();
			} finally {
				if (os != null) {
					try {
						os.close();
					} catch (IOException e) {
						httpConn = null;
					}
				}
			}
		}
		return httpConn;
	}

	public String getStringFromConnection(HttpURLConnection connection) throws IOException {
		String result = null;
		if (connection != null) {
			InputStream is = null;
			try {
				is = connection.getInputStream();
				result = getStringFromConnection(is);

			} finally {
				if (is != null) {
					try {
						is.close();
					} catch (IOException e) {
						result = null;
					}
				}
			}
		}
		return result;
	}

	public String getStringFromErrorConnection(HttpURLConnection connection) throws IOException {
		String result = null;
		if (connection != null) {
			InputStream is = null;
			try {
				is = connection.getErrorStream();
				result = getStringFromConnection(is);
			} finally {
				if (is != null) {
					try {
						is.close();
					} catch (IOException e) {
						result = null;
					}
				}
			}
		}
		return result;
	}

	private String getStringFromConnection(InputStream ins) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(ins, "UTF-8"));
		String all = "";
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			all += inputLine + "\n";
		in.close();
		return all;
	}
}
