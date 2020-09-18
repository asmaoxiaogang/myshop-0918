package cn.aynuedu.address.dao;

import cn.aynuedu.address.pojo.Address;
import util.BaseDao;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author Mxg
 * @Description
 * @Date: 2020/9/11 21:35
 */
public class AddressDao extends BaseDao {
    /**
     * 根据从前台获取到的数据，添加地址到数据库;
     * 关联页面为jsp/order/showOrder.jsp
     * @param address servlet处理前端数据后打包为address对象传递到sql执行
     */
    public void addAddressDao(Address address) {

        String sql = "insert into myshop.address values(?, '"+address.getDetail()+"', '"+address.getName()+"', '"+address.getPhone()+"', ?, ?)";
        Object[] parameters = {address.getId(), address.getUid(), address.getLevel()};
        try {
            super.update(sql, parameters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Address> listAddress(int uId) {
        List<Address> list = null;
        String sql = "select * from myshop.address where uid="+uId+"";
        try {
           list = super.queryBeanList(sql, Address.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
