package cn.aynuedu.address.servlet;

import cn.aynuedu.address.dao.AddressDao;
import cn.aynuedu.address.pojo.Address;
import cn.aynuedu.orders.dao.OrderDao;
import cn.aynuedu.orders.pojo.Order;
import util.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static java.lang.System.out;

/**
 * @Author Mxg
 * @Description
 * @Date: 2020/9/11 21:40
 */

/**
 * 该处理器配合orderservlet使用，在用户点击结算后展示购买商品信息，并附上信息录入。
 */
@WebServlet("/address.action")
public class AddressServlet extends BaseServlet {
    private AddressDao addressDao = new AddressDao();
    private OrderDao orderDao = new OrderDao();

    /**
     * 添加新的地址信息到数据库中和registerAddress.jsp有关
     * @param request
     * @param response
     */
    public void addAddress(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("come on addAddress");
        int uid =  Integer.parseInt(String.valueOf(request.getSession(false).getAttribute("userId")));
        System.out.println("uid" + uid);
        String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
        System.out.println("name:" + name);
        String province = new String(request.getParameter("province").getBytes("ISO-8859-1"), "UTF-8");
        String phone = request.getParameter("phone");
        System.out.println(phone);
        String city = new String(request.getParameter("city").getBytes("ISO-8859-1"), "UTF-8");
        String area = new String(request.getParameter("area").getBytes("ISO-8859-1"), "UTF-8");
        String street = new String(request.getParameter("street").getBytes("ISO-8859-1"), "UTF-8");
        String details = new String(request.getParameter("details").getBytes("ISO-8859-1"), "UTF-8");

        //对select下拉框内数据的整合，是真正意义上的detail
        String detail = province + city + area + street + details;
        System.out.println("details:" + detail);
        //这里的level标志信息插入的顺序或是判断是否重复跟数据库查询有关，设计到数据的合并,这里就先不去
        //完成这个了。。。
        int level = 1;

        Address address = new Address();
        address.setDetail(detail);
        address.setName(name);
        address.setPhone(phone);
        address.setUid(uid);
        address.setLevel(level);

        System.out.println("como on address.action/addAddressDao");
        addressDao.addAddressDao(address);
        System.out.println("重定向");
        response.sendRedirect("address.action?method=listAddressServlet");



    }

    public void listAddressServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("come on listAddressServlet...");
        int uid =  Integer.parseInt(String.valueOf(request.getSession(false).getAttribute("userId")));
        List<Address> list = addressDao.listAddress(uid);
        request.setAttribute("addressList", list);
        List<Order> orderList = orderDao.findAllOrder(Integer.parseInt(String.valueOf(request.getSession(false).getAttribute("userId"))));
        out.println("come on listAddressServlet findAllOrder OrderList:" + orderList.isEmpty());
        out.println(orderList.toString());
        request.setAttribute("orderList", orderList);
        request.setAttribute("list", list);
        request.getRequestDispatcher("/jsp/order/showOrder.jsp").forward(request, response);
    }
}
