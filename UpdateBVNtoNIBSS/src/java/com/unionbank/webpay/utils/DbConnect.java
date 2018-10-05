/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.webpay.utils;

import com.unionbank.webpay.db.HibernateSessionFactory;
import com.unionbank.webpay.db.dao.MerchantsDAO;
import com.unionbank.webpay.db.dao.TransactionQueryResponse;
import com.unionbank.webpay.db.dao.TransactionsDAO;
import com.unionbank.webpay.db.dao.vwTransactionsDAO;
import com.unionbank.webpay.parameters.Settings;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

/**
 *
 * @author aajibade
 */
public class DbConnect {

    PBEncrytor Pb = new PBEncrytor();
    private Settings settings = Settings.getInstance("");
    String user = settings.getProperty("user-user");
    String password = Pb.PBDecrypt(settings.getProperty("password-password"));
    String host_host = settings.getProperty("host-host");
    String user_live = settings.getProperty("user-live");
    String password_live = Pb.PBDecrypt(settings.getProperty("password-live"));
    String host_live = settings.getProperty("host-live");
    String user_alert = settings.getProperty("user-alert");
    String password_alert = Pb.PBDecrypt(settings.getProperty("password-alert"));
    String host_alert = settings.getProperty("host-alert");

    public static void main(String args[]) throws Exception {
        DbConnect dd = new DbConnect();
        // dd.gettTransactionList();

       // System.out.println("<<<<>>>" + dd.logTransactionDataUpgraded("19119", "2929229", "566", new BigDecimal("344499"), "101", "2015-08-05"));
        //   dd.logMerchantData("Test Merchant", "http://", "3939339", "191");
//        System.out.println("retrieveSavedHashKey<<>> "+dd.retrieveSavedHashKey("102"));
    }

    /*public static List<MerchantsDAO> getMerchantlist(String which) {
     //  String checkClause = "where  sPhone_Number ='" + phonenumber + "'   ";
     String checkClause = " where auth_flag = '" + which + "' order by DATE_CREATED desc";
     List<MerchantsDAO> tTransactionsList = null;
     try {
     tTransactionsList = (ArrayList<MerchantsDAO>) PersistenceAgent.loadTableRecords("MerchantsDAO", checkClause);

     } catch (Exception e) {
     e.printStackTrace();
     }
     return tTransactionsList;

     }*/
    public static TransactionsDAO gettTransactionList(String TNX_REF) {
        //  String checkClause = "where  sPhone_Number ='" + phonenumber + "'   ";
        String checkClause = " where TNX_REF = '" + TNX_REF + "' ";
        TransactionsDAO tr = new TransactionsDAO();
        List<TransactionsDAO> tTransactionsList = null;
        try {
//            tTransactionsList = (ArrayList<TransactionsDAO>) PersistenceAgent.loadTableRecords("TransactionsDAO", checkClause);
            tr = tTransactionsList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tr;

    }

    public List<TransactionsDAO> gettTransactionList() {
        String result = null;
        TransactionsDAO userProfileInfo = null;
        List<TransactionsDAO> testDataList = new ArrayList<TransactionsDAO>();
        try {
            Session session = HibernateSessionFactory.getSession();
            session.beginTransaction();

            String sql = "select b.MERCHANT_NAME MERCHANT_NAME, a.TNX_REF TNX_REF,a.PAY_REF PAY_REF,"
                    + "a.DATE_CREATED DATE_CREATED,a.RESPONSE_DESC RESPONSE_DESC RESPONSE_DESC,a.RESPONSE_CODE_UPDATE_DATE "
                    + "RESPONSE_CODE_UPDATE_DATE from UBNPAY_Transactions a , UBNPAY_Merchants b\n"
                    + "where a.PAY_ITEM_ID=b.PAY_ITEM_ID  and rownum <=100  order by DATE_CREATED desc";

            System.out.println("sql<<>>>>" + sql);
            testDataList = session.createSQLQuery(sql)
                    // .addScalar("forwardDate", Hibernate.STRING)
                    .addScalar("MERCHANT_NAME", Hibernate.STRING)
                    .addScalar("TNX_REF", Hibernate.STRING)
                    .addScalar("PAY_REF", Hibernate.STRING)
                    .addScalar("DATE_CREATED", Hibernate.DATE)
                    .addScalar("RESPONSE_DESC", Hibernate.STRING)
                    .addScalar("RESPONSE_CODE_UPDATE_DATE", Hibernate.STRING)
                    .setResultTransformer(Transformers.aliasToBean(TransactionsDAO.class))
                    .list();
            session.getTransaction().commit();

            if (session != null && (session.isOpen())) {
                session.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return testDataList;
    }

    public static List<vwTransactionsDAO> getTransactionList() {
        String checkClause = "";
        List<vwTransactionsDAO> tTransactionsList = null;
        try {
//            tTransactionsList = (ArrayList<vwTransactionsDAO>) PersistenceAgent.loadTableRecords("vwTransactionsDAO", checkClause);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tTransactionsList;

    }

    /* public static MerchantsDAO getMerchant(String mechPayID) {
     //  String checkClause = "where  sPhone_Number ='" + phonenumber + "'   ";
     String checkClause = " where PAY_ITEM_ID = '" + mechPayID + "' ";
     MerchantsDAO merct = new MerchantsDAO();
     List<MerchantsDAO> tTransactionsList = null;
     try {
     tTransactionsList = (ArrayList<MerchantsDAO>) PersistenceAgent.loadTableRecords("MerchantsDAO", checkClause);
     merct = tTransactionsList.get(0);
     } catch (Exception e) {
     e.printStackTrace();
     }
     return merct;

     }*/
  
    public void EnableDisableTXN(String transID, String flag) {

        MerchantsDAO odCircle = new MerchantsDAO();
        try {
            String whereCaluse = " where merchant_id = " + transID + " ";
       //     List<MerchantsDAO> OdCircleList = PersistenceAgent.loadTableRecords("MerchantsDAO", whereCaluse);
        //    odCircle = OdCircleList.get(0);

            odCircle.setDisableFlag(flag);
        //    PersistenceAgent.logTransactions(odCircle);
        } catch (Exception ex) {
            ex.printStackTrace();
            java.util.logging.Logger.getLogger(MerchantsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*<input name="txn_ref" type="hidden"  id="txn_ref"  value="<%=txn_ref%>" >
     <input name="hash" type="hidden"  id="hash"  value="<%=hash%>" >
     <input name="product_id" type="hidden"  id="product_id"  value="<%=product_id%>" >
     <input name="pay_item_id" type="hidden"  id="pay_item_id"  value="<%=pay_item_id%>" >
     <input name="amount" type="hidden"  id="amount"  value="<%=amount%>" >                                
     <input name="currency" type="hidden"  id="currency"  value="<%=currency%>" >
     <input name="site_redirect_url" type="hidden"  id="site_redirect_url"  value="<%=site_redirect_url%>" >
     <input name="ubn_txn_ref" type="hidden"  id="site_redirect_url"  value="<%=txn_id%>" >*/
   
    public boolean updateResponseCodeUpgraded(String TNX_REF, TransactionQueryResponse qResponse) {
        boolean isupdate = false;
        int dd = 0;
        PreparedStatement pstmt = null;
        Connection conn = null;
        java.text.SimpleDateFormat sformatter_check = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
        String current_date_check = sformatter_check.format(new java.util.Date());
        String tPaymentReference ="",responseCode="",responseDescription="";
        if (qResponse.getPaymentReference()==null){
            tPaymentReference="";
        }else{
            tPaymentReference=qResponse.getPaymentReference();
        }
        if (qResponse.getResponseCode()==null){
            responseCode="";
        }else{
            responseCode=qResponse.getResponseCode();
        }
        if ( qResponse.getResponseDescription()==null){
            responseDescription="";
        }else{
            responseDescription= qResponse.getResponseDescription();
        }
         
        String TXN_ID = current_date_check;
        try {
            System.out.println("connected ");

            System.out.println("connecting to db ..... ");
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(host_host, user, password);
            System.out.println("connected ");
            String query = "UPDATE   UBNPAY_Transactions set PAY_REFERENCE ='" + tPaymentReference + "',RESPONSE_CODE='" + responseCode + "' ,RESPONSE_DESC ='" + responseDescription + "' "
                    + ""
                    + "  where TNX_REF ='" + TNX_REF + "' ";

            System.out.println("query " + query);
            pstmt = conn.prepareStatement(query);

            System.out.println("query " + query);
            dd = pstmt.executeUpdate();
            if (dd > 0) {
                isupdate = true;
            }


            // isupdate = pstmt.execute();
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception ex) {
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("isupdate<<<<>>>>>" + isupdate);
        return isupdate;
    }

    public boolean logTransactionDataUpgraded(String customerName, String customerEmail, String CustomerID, String ubn_txn_ref, String merch_txn_ref, String currency, BigDecimal amount, String Merchant_pay_item_id, String txnDateTime) {
        boolean isupdate = false;
        int dd = 0;
        PreparedStatement pstmt = null;
        Connection conn = null;
        java.text.SimpleDateFormat sformatter_check = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
        String current_date_check = sformatter_check.format(new java.util.Date());

        String TXN_ID = current_date_check;
        try {
            System.out.println("connected ");

            System.out.println("connecting to db ..... ");
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn = DriverManager.getConnection(host_host, user, password);
            System.out.println("connected ");

            /*              VARCHAR2(255 CHAR),
             VARCHAR2(255 CHAR),
             VARCHAR2(255 CHAR)*/
            String query = "INSERT INTO UBNPAY_Transactions  ("
                    + " TXN_ID,"
                    + " TNX_REF,"
                    + " PAY_REF,"
                    + " AMOUNT_LOCAL,"
                    + " PAY_ITEM_ID,"
                    + " CURRENCY_C,"
                    + " MERCH_TXN_REF,"
                    + " CUSTOMER_NAME,"
                    + " CUSTOMER_EMAIL,"
                    + " CUSTOMER_ID"
                    + "  ) VALUES ("
                    + " ?,?,?,?,?,?,?,?,?,?)";

            //  String format="yyyy-MM-dd";
            //  date2=date2.split(" ")[0];
            //  String innts="TO_DATE("+date2.toString()+","+format+")";

            //         System.out.println("date2 " + date2);
            System.out.println("query " + query);
            pstmt = conn.prepareStatement(query);

            pstmt.setString(1, TXN_ID);
            pstmt.setString(2, ubn_txn_ref);
            pstmt.setString(3, merch_txn_ref);
            pstmt.setBigDecimal(4, amount);
            pstmt.setString(5, Merchant_pay_item_id);
            pstmt.setString(6, currency);
            pstmt.setString(7, merch_txn_ref);
            pstmt.setString(8, customerName);
            pstmt.setString(9, customerEmail);
            pstmt.setString(10, CustomerID);

            // System.out.println("query " + pstmt.);
            //pstmt.setString(5 ,datetime);
            //  pstmt.setString(5, innts );
            // 'TO_DATE(datetime,'YYYY-MM-DD HH24:MI:SS')'
            // System.out.println("query2  pstmt.toString " + pstmt.String());

            System.out.println("query " + query);
            dd = pstmt.executeUpdate();
            if (dd > 0) {
                isupdate = true;
            }


            // isupdate = pstmt.execute();
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception ex) {
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("isupdate<<<<>>>>>" + isupdate);
        return isupdate;
    }

    public boolean logTransactionData(String ubn_txn_ref, String merch_txn_ref, String currency, BigDecimal amount, String Merchant_pay_item_id, String txnDateTime) throws Exception {
        boolean whichWay = false;
        java.text.SimpleDateFormat sformatter_check = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String current_date_check = sformatter_check.format(new java.util.Date());

        Date date2 = sformatter_check.parse(txnDateTime);
        System.out.println("record exist amount " + amount);
        System.out.println("record exist Merchant_pay_item_id" + Merchant_pay_item_id);
        System.out.println("record existubn_txn_ref " + ubn_txn_ref);
        // System.out.println("record exist item_id" + item_id);
        TransactionsDAO tmertData = new TransactionsDAO();
      /*  tmertData.setAmountLocal(amount);
        tmertData.setPayRef(merch_txn_ref);
        tmertData.setDateCreated(date2);
        tmertData.setPayItemId(Merchant_pay_item_id);
        tmertData.setProductId("");
        tmertData.setTnxRef(ubn_txn_ref);
        tmertData.setCurrencyC(currency);
        tmertData.setMerchTxnRef(merch_txn_ref);*/
//        whichWay = PersistenceAgent.logTransactions(tmertData);
        System.out.println("record whichWay " + whichWay);

        return whichWay;

    }

    public boolean logMerchantData(String merchtname, String site_rurl, String mackey, String item_id) throws Exception {
        boolean whichWay = false;
        java.text.SimpleDateFormat sformatter_check = new java.text.SimpleDateFormat("dd-MMM-yyyy");
        String current_date_check = sformatter_check.format(new java.util.Date());
        //  try {

        System.out.println("record exist merchtname " + merchtname);
        System.out.println("record exist site_rurl" + site_rurl);
        System.out.println("record exist mackey" + mackey);
        System.out.println("record exist item_id" + item_id);
        MerchantsDAO tmertData = new MerchantsDAO();
        tmertData.setAuthFlag("N");
        //tmertData.setMerchantID(299);
        tmertData.setDateCreated(new java.util.Date());
        tmertData.setDisableFlag("N");
        tmertData.setMacKey(mackey);
        tmertData.setMerchantName(merchtname);
        tmertData.setPayItemId(item_id);
        tmertData.setSiteRedirectUrl(site_rurl);
        //whichWay = PersistenceAgent.logTransactions(tmertData);
        System.out.println("record whichWay " + whichWay);
        //  } else {
        //      System.out.println("record exist " + sPhone_Number);
        // }
        //  } catch (Exception ex) {

        // ex.printStackTrace();
        //  }

        return whichWay;

    }
    //logRequest(tnx_ref,product_id,pay_item_id,amount);

    public boolean logTransactionRequest(String tnx_ref, String product_id, String pay_item_id, String amount) {
        boolean whichWay = false;
        java.text.SimpleDateFormat sformatter_check = new java.text.SimpleDateFormat("dd-MMM-yyyy");
        String current_date_check = sformatter_check.format(new java.util.Date());
        try {
            // String checkClause = "where  sFirst_Name ='" + sFirst_Name + "'  and sLast_Name  ='" + sLast_Name + "'  and sPhone_Number ='" + sPhone_Number + "'   ";
            //  List<SenderdataDAO> tTransactionsList = (ArrayList<SenderdataDAO>) PersistenceAgent.loadTableRecords("SenderdataDAO", checkClause);
            // System.out.println("Record Does notExist Bros<<>>>>" +whichWay);
            //  if (tTransactionsList.size() == 0) {
            System.out.println("record  tnx_ref " + tnx_ref);
            System.out.println("record  product_id" + product_id);
            System.out.println("record  pay_item_id" + pay_item_id);
            System.out.println("record  amount" + amount);

            /*    TransactionsDAO txndata = new TransactionsDAO();
             txndata.sesetAuthFlag("N");
             tmertData.setDateCreated(new java.util.Date());
             tmertData.setDisableFlag("N");
             tmertData.setMacKey(mackey);
             tmertData.setMerchantName(merchtname);
             //tmertData.setPayItemId(mackey);
             tmertData.setSiteRedirectUrl(site_rurl);
             whichWay = PersistenceAgent.logTransactions(tmertData);*/
            //  } else {
            //      System.out.println("record exist " + sPhone_Number);
            // }
        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return whichWay;

    }
}
