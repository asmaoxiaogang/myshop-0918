package cn.aynuedu.orders.servlet;

import cn.aynuedu.orders.dao.OrderDao;
import cn.aynuedu.orders.pojo.Order;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import util.AlipayConfig;
import util.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static java.lang.System.out;

/**
 * @Author Mxg
 * @Description
 * @Date: 2020/9/11 21:40
 */

/**
 * 改处理器处理从showCart.jsp页面来的数据，即从购物车到订单页面的跳转
 */
@WebServlet("/order.action")
public class OrderServlet extends BaseServlet {
    private OrderDao orderDao = new OrderDao();

    public void addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        out.println("come on addOrder");
        int uid = Integer.parseInt(String.valueOf(request.getSession(false).getAttribute("userId")));
        out.println("当前用户id" + uid);
        int num = Integer.parseInt(request.getParameter("num"));
        out.println("数量" + num);
        int price = Integer.parseInt(request.getParameter("price"));
        out.println("价格" + price);
        int money = num * price;
        out.println("总额" + money);

        //状态描述为0(未支付状态)
        int status = 0;

        //获取当前时间去插入到数据中
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //设置日期格式
        Timestamp time = Timestamp.valueOf(df.format(new Date()));
        // new Date()为获取当前系统时间
        out.println("当前时间" + time);

        //先给一个默认值，前提是数据库address中有这条数据
        int aid = 1;

        //
        int uuId = UUID.randomUUID().toString().hashCode();
        if (uuId < 0){
            uuId = -uuId;
        }
        String var = String.valueOf(uuId);
        //

        Order order = new Order();

        order.setId(var);
        order.setUid(uid);
        order.setMoney(money);
        order.setStatus(status);
        order.setTime(time);
        order.setAid(aid);
        out.println("come on addOrderDao ");
        out.println(order.toString());
        orderDao.addOrderDao(order);
        response.sendRedirect("order.action?method=listOrder");

        /**
        * 第一版的设想推翻掉，理由先把订单处理了，再去选择地址信息的处理
        *这里规定先去选择地址信息，如果没有去填写新的地址信息后再进行商品的购买，订单的生成
        *  先获取到地址信息，在到插入订单数据库中，因为order表中需要拿到address表中的orderId
         // request.getRequestDispatcher("jsp/address/inputAddress.jsp").forward(request, response);
        */
    }

    public void listOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        out.println("come on listOrder");
        List<Order> list = orderDao.findAllOrder(Integer.parseInt(String.valueOf(request.getSession(false).getAttribute("userId"))));
        out.println("list:" + list.isEmpty());
        request.setAttribute("list", list);
        request.getRequestDispatcher("jsp/order/showOrder.jsp").forward(request, response);
    }

    public void pay(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = new String(request.getParameter("orderId").getBytes("ISO-8859-1"),"UTF-8");
        //付款金额，必填
        String total_amount = new String(request.getParameter("money").getBytes("ISO-8859-1"),"UTF-8");
        //订单名称，必填
        String subject = new String(request.getParameter("testName").getBytes("ISO-8859-1"),"UTF-8");
        //商品描述，可空
        //String body = new String(request.getParameter("details").getBytes("ISO-8859-1"),"UTF-8");
        String body = "";
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
        //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
        //		+ "\"total_amount\":\""+ total_amount +"\","
        //		+ "\"subject\":\""+ subject +"\","
        //		+ "\"body\":\""+ body +"\","
        //		+ "\"timeout_express\":\"10m\","
        //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

        //请求
        String result = null;
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        //输出
        out.println(result);
        response.getWriter().println(result);
    }


}
