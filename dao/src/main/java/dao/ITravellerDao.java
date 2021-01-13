package dao;

import domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {

    @Select("select* from traveller where id in (select travellerId from order_travellers where orderId=#{id} ")
    List<Traveller> findByOrdersId(String id);
}
