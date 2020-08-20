package mvc.xin.controller.json.services;

import mvc.xin.controller.json.mapper.UserMapper;
import mvc.xin.controller.json.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements IUserServices{
    @Autowired
    private UserMapper userMapper;
    public boolean insertUser(User user) {
        boolean b=false;
        try {
            b = userMapper.insertUser(user);
            return b;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }
}
