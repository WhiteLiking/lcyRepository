package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016091700529602";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCVt5Yl8Q2HA+Mvf34xvy0rq3sejhspIxKBAkyWwtWl+AqMrx0Ys2WoiWWYZ7XEtZZMSTlbRNLRlZ3HoOe6bGWbTld+crzPdvv1xP0WtsvoAe2aPcJTJ+n6U48Oh8DM/TTrmAThRSh1wIb9BOpofNOz0MQqUAsYv6KPGyIgSquLmc1nHdT2eh1ZitWxWdss7J1WBR4JPO4UDdw8aeF/sfGlLLpOBDP+mcmADoa+O3EPPQdn42+dz2gI4NpIRty01mbpU6S40z7ElmFFL4lY5tVo2NlLqlVQHVSPHecgYEv9IG5PjD5H5vJVqKkkCgzzU/nQSci7rgF0Xg8O2pJ1aAfnAgMBAAECggEAYHdY/Htz/uGnWWxpcD5BKZklDEv9/iSGAK/tj1pcdML8cSdHtSmqP8y/tFJmkSd7fw3TMhaHS9l+PylTBhBf65Cv2V6uf3Kn5/SUKjV/7q6HXNGcSx41qUB7tZ4MwUgI+CAMTOXVqwFxOMgZDVgYxAyoyKaob7rSUCjodSwHmjtxJn6DRxPvwkj1lCAWY8XG46VuNAqFwJ8BZqw5D0FdmFb7ShxjQE2PgakmH+s88bAf1QaWfsju6PSjd/r2Tu1WL6jiY0fzTs2V4x5fjMqOpdvHBcxTw5Yxrf9Ev7rRSebsUOtOt11dyMr/72SJfDfxpjORHOuKUzZ45V1fH18L4QKBgQDj12Vu79KKfQbW2e0g9v2GuVeNsANrRI3+HgtbOnsjtzGQyW4ysWZs9hDS4t/4LTRK+ZHsObRBCZdAIOD/hQ07qcjv1q/AhVH9azQwwTe8Rs/njVKbRZlo4ClkP4ICu8jYS0AUMzbldqkcEOqjV0oZIbwPZJeg5tQFfxXgO+koVwKBgQCoOHDhhWIZRvTFOSdenReKCGmIHnBDLY9pZMybxWPtpOmmYtaP6TUVmcegagLaEJfvPuOfKTTgk4L5jiXr3uJgQiwpe1wIxSIb0BxMMA0quUXZP2YBqeRTDz1XXKqm52j/AGbRNPtjQRiugcD/ECT6S39g1lc+ftOqWGwjgm6i8QKBgGL2ghZnkLmaiMf1rGvvHDvScVcXpsSG6G4COsiLZEUlIyBSfc0DBQw67R/Mb5/qcpZGRL2oasT9F3dBULlr302U97RFOd2TiwNZ9zdeFYlv8IoQ9lp/Jp1JEHF8rEnnqttYBCNCA4wzuEx6hJAiMAsuffLprHq1CE7C3ouhOirNAoGAP2xQOub0Ln2PKZC75DMsPdGgID8BqoJR8LWdYxmP7Hhh02auaMHPTt6U4kk13AunjP9UCJ0bn5ReLELIz15QUWSBi/5Dm9bfXkcfdCYlwLbru9XoWrY4LIyxXu/EM3tKHeKD4VqtcSWI7bpkDoaCuo+ebd9CM4DTwwTleJnjprECgYAZm031ZflLYKrofzWe011MWHTQhp2VMppFM2ipUeGPvQldKRanLO6bIjYL6vKCf6lQC5rkkqbh1wmwwI/tiy4ZolLWCJCJWcKh5CKbkkC7Y949MtU5n49z2rD0MZfUOWd8Ulct1qFTRvf1k7q6r85A4zv6uB9b+foQDvrgZlezEg==";
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA/A1pjXZwoSIEQptWc3NBTrOUJZt4uW2ibgmJgwHPo/0nfgR3VvxLzOmXTRx6RgVM7hw/9v8+j9qryfUD7OqoLDawcDiGau83QCoxWgBGVa8jYr1SQmmvbIFr+tRv9qjNB86xM/0/65WXxJp0qa4PPKKKHEBi9HqDrDKw/NIhj+O5F60wGn2KHhO03T1R6kOwc988rIWljGsoeAJ13cHQSMfanwhw2aO0J7c4/qg7T45Zjxj9iOqcXatvuthn1vHmfwzTmQkVKoU4xNO9/ECtxStMtAPHDx1NQiWHmQ8Rh23eKCNnnfH5Gw6yaD+MX8AU5gEuO2WmiTYMYCTnPNozzQIDAQAB";
	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/myProductManager/HeadMainPage";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/myProductManager/HeadMainServlet?target=returnMainPage";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
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

