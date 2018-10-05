package com.unionbank.webpay.parameters;

import com.unionbank.webpay.utils.PBEncrytor;
import com.unionbank.webpay.utils.LoggingUtil;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

public class ApplicationSettings {

    private static Logger logger = Logger.getLogger(ApplicationSettings.class);
    private static Settings settings = Settings.getInstance("");
    static public String HASH_KEY = settings.getProperty("HASH_KEY");
    static public String QUERY_URL = settings.getProperty("QUERY_URL");
    static public String WEBPAY_URL = settings.getProperty("WEBPAY_URL");
    static public String UBN_REDIRECT_URL = settings.getProperty("UBN_REDIRECT_URL");
    static public String PORDUCT_CODE = settings.getProperty("PORDUCT_CODE");
    
    
    // static public Map<String, String> chequeTypeMap = new TreeMap<String, String>();
    static PBEncrytor ENCRYPTOR = new PBEncrytor();

    static {
        try {
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        HASH_KEY = ENCRYPTOR.PBDecrypt(HASH_KEY);

    }
    static public DefaultHttpClient DefaultHttpClientInstance = null;

    static {
        if (DefaultHttpClientInstance != null) {
            DefaultHttpClientInstance.getConnectionManager().shutdown();
        }

        DefaultHttpClientInstance = new DefaultHttpClient();

        try {
            //HibernateSessionFactory.closeSession();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        LoggingUtil.logDebugInfo("Start ScoreBridge Service ...", logger);
        //HibernateSessionFactory.getSessionFactory();


    }
}
