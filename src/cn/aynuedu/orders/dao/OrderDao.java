package cn.aynuedu.orders.dao;

import cn.aynuedu.orders.pojo.Order;
import util.BaseDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author Mxg
 * @Description
 * @Date: 2020/9/11 21:35
 */
public class OrderDao extends BaseDao {
    /**
     * 插入订单
     */
    public void addOrderDao(Order order) {
        String sql = "insert into myshop.order values('"+order.getId()+"', ?, ?, ?, '"+order.getTime()+"', ?)";
//        Object[] parameters = {order.getId(), order.getUid(), order.getMoney(), order.getStatus(), order.getTime(), order.getAid()};
        Object[] parameters = {order.getUid(), order.getMoney(), order.getStatus(), order.getAid()};
        try {
            super.update(sql, parameters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询当前用户Uid所对应的所有订单信息
     * @param uid 当前用户Id号
     * @return
     */
    public List<Order> findAllOrder(int uid) {
        List<Order> list = null;
        String sql = "select * from myshop.order where uid = "+uid+"";
        try {
            list = super.queryBeanList(sql, Order.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 根据订单id删除无用数据
     * @param orderId 订单表中的Id
     */
    public void deleteOrderId(int orderId) {
        String sql = "delete from myshop.order where id = "+orderId+"";
        try {
            super.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据订单id去修改对应的支付状态
     * @param orderId 订单表中的id属性唯一表示当前数据
     *
     */
    public void modifyStatus(int orderId) {
        String sql = "update myshop.order set status="+1+" where id="+orderId+"";
        try {
            super.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
