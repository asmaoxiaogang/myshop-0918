package util;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author Mxg
 * @Description
 * @Date: 2020/9/17 14:32
 */
public class AlipayConfig {
    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    /**
     * 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
      */

    public static String app_id = "2016102300743543";

    /**
     * 商户私钥，您的PKCS8格式RSA2私钥
     */
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCJvtJuaFReV8MS5/8XaHnelD5UYiNw5E7Ta8S6tb+ImSoOgQBCLk1KgiAgGnvy65xNbxxA9j298OKDdugrj3Bx19OpMKuaUAA7KBhWBtf8EIH9cv712lesi+V82vMsK/RIvEOsNGqeIGFQkBJVjdH47ud2BVS+WHwVG8YQpZds64UiTdwDYb02uvXZbVQHj7uy7pHQiW/3sezB8KIKyFXpl4Ax+XNB2sZaZro82VkBb1FyfZXvekNHQY0Ci7DCEZ46gOdW9ifrL0wyADTKVDOtoGkpEvpUp+MFLyBQeqkReXRu+SdimbFZ46ulkaKtGMisYBe/YgYDxIzhfPkjl6LFAgMBAAECggEATfHyJ9HXtA8bbu5i1f8jv0TJxHxIK9C1nkOEblb8TDLHrq9m0wxaZkgeH6x86ShUKSkvpr7wjzPpKZU2qbegXHtR5ZKJ+Gc+yjrVEpEK1TMOK7pP9hUYuaXsNWu8YQl6UVJfROngTxxplOoBxfHbmG6wAYPgwVlW1acCvFbHyjTjbkL8Usn4V+C3lV7zeZcmdlgHRlMUe6ke0eOFRiroqqjKXd73i0RgUFMY/wrZybxt/A/VKQ7HtQ+7wKFWQx+TDC1S9DXV5ndobJLBk4yRYWTwKYRC2bqDKCUuE+WyPNFrIDLqN6L2SoJNrqLFZsPfTAjx5A2WlBy3MC02VTtDAQKBgQC/yB3ynim5QpF32puP34oJ+gXQRcFEy/8Kwl9FpuVCCppM62utOfAY1KTS9TQJaHrXut7bQfj2nAJqkbh2Cj38LUrV/kCR946tvz0E7rmOVLaM7/lQMcYoZSl8O6mSPobS1WvzLKO8VtRfWGwynhgT0qMAVnOD8rQ0zrQWRYJcBQKBgQC33pzS+5KFQ0/pUtU2QNdhmFZRL3rF2XAO0BtfZu4VDfDGTKBOL24tV3StOyb6rAbRnhDwVgQe+on+G37qh2jljvAXLQj83ghTChVMPbkjHxBMr0AHfkohtfp02ZxbEi6j00LJPLXyDBsGaIVJVexEHEMC5qISsdrUVgudVHWnwQKBgQChPiKXwwz3exWNPJqAS4TmwHS02IEXU6B6LlQl3p1wejOjKmhcu5K3fcmaqJh4tIRb7vzCQeSNizuo2B3L+O6GoJoD84Hcd9RZFqm6BPCzz1uwgW8PUtn1SqCnmA4JLFL03oWlbcm4ZxSlmVVW9X7u47Eybn0u2hdTMttMwmJI9QKBgEMDocjL5BUp+WAizo7dhyKM8TjZwzeFDnB3rOJSk4ec8xpzJyIX62IfM+lHW+eU909C+w19bDcWPWEeCF3WSIcSV7M6uMHg8svBKw4EmQuR8NDiNsYEY2Rx/PzFq1UOBW20O+04cV/sxZTKV3npFRml606NXJjPteAaFFWdSNyBAoGAU0jvcwzwsBpTKVJrKVms7iYKKbnRujfr/uuNPGouZEorK8VmPrqD5bWBPHXysh0Z59W01hg66O/2Ety0KGxpBYlWRFo/mbQP1OmE+LhqW+ScF3DTF51bMK1xGTkdBjAwAIh1Ek0pEFIYQ2uIBknA7oFdnczPoM4VvboD9eWutmM=";
    /**
     *支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
     */
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiLCfdlKfEMTsfnGGPY6hzSMFF/iEQTgFT9xA1mHmsLXlbjd94neCttwcD7MsE1/uzZ6qLtNo0/I3+HEKFE0i76GrBII05lpEw1j0/fbPl25dUVpeB4mGsZdbyzm+0W0noQ2Iyyaae2FMq/t1XmQsMz8bLSnB7Pu5fjeT2ZzAOLbbMa+S70+DCRoRSc9gVh2wPwm6YdlQKIAaLTU1K3LSZtedifNdsngWpfmfAn0ZpnJzjfQ17a64TZjvGcluac035Yi/D45zxLuVi2kzQgm++iBRlFXOJqQjnlhrMlxFwUxQ9j29QOdeZT12d/XYGpPbbHHkHlQHHHY6bdZkkLDkkwIDAQAB";

    /**
     *服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     */
    public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    /**
     * 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     *
     */
    //public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";
    public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    /**
     * 支付宝网关
     */
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
