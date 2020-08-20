package mvc.xin.controller.json.mapper;


import mvc.xin.controller.json.pojo.User;

import java.util.Date;
import java.util.List;

public interface UserMapper {
    public List<User> findAll();

    public boolean insertUser(User user);

    public Date findDate(String username);
}
