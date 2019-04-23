package edu.jmu.oscm.mapper;

import edu.jmu.oscm.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface myUserMapper {

    List<User> queryAllUser();

}
