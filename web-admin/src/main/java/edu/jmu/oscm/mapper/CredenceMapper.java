package edu.jmu.oscm.mapper;


import edu.jmu.oscm.model.Credence;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 描述
 * 业务凭证表
 *
 * @author zjc
 * @date 2018/07/30
 */
@Mapper
public interface CredenceMapper {
    /**
     * 增加一条业务数据
     *
     * @param credence 一条业务数据实体
     * @return 返回添加成功与否
     */
    Boolean addCredence(Credence credence);

    /**
     * 删除id一条业务数据
     *
     * @param credence_id 每条业务凭证的id
     * @return 返回删除成功与否
     */
    Boolean deleteCredence(Integer credence_id);

    /**
     * 根据时间删除一条业务数据
     *
     * @param happenDate 业务数据的发生时间
     * @return 返回删除成功与否
     */
    Boolean deleteCredenceByDate(String happenDate);

    /**
     * 根据全部业务数据
     *
     * @return 返回删除成功与否
     */
    Boolean deleteAll();

    /**
     * 批量添加业务数据
     *
     * @param credences 一组业务数据队列
     * @return 返回添加成功与否
     */
    Boolean addCredences(List<Credence> credences);
//    public int updateCredence(Credence credence);

    /**
     * 查找全部数据
     *
     * @return 返回查找的全部数据
     */
    List<Credence> findAll();

    /**
     * 根据时间模糊查找数据
     *
     * @param happenDate 发生时间
     * @return 返回查找的数据
     */
    List<Credence> findByLike(@Param(value = "happenDate") String happenDate);

    /**
     * 根据凭证id查找数据
     *
     * @param credence_id 一条记录的id
     * @return 返回查找的数据
     */
    Credence findByID(@Param(value = "credenceId") Integer credence_id);

    /**
     * 查找某个月的某个科目编码的条数
     *
     * @param subject_id  科目编码
     * @param happen_date 发生日期（年月）
     * @return 返回符合条件的list
     */
    List<Credence> findBorrowLend(@Param(value = "subject_id") String subject_id, @Param(value = "happen_date") String happen_date);

    /**
     * 查找某个月的某个科目编码 以及子科目 的条数 如6002 600201
     *
     * @param subject_id  科目编码
     * @param happen_date 发生日期（年月）
     * @return 返回符合条件的list
     */
    List<Credence> findBorrowLendLike(@Param(value = "subject_id") String subject_id, @Param(value = "happen_date") String happen_date);


}
