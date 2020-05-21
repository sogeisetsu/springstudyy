package org.suyuesheng.spring7.services;


import org.suyuesheng.spring7.mapper.UserMapper;
import org.suyuesheng.spring7.pojo.ResultInfo;
import org.suyuesheng.spring7.pojo.User;
import org.suyuesheng.spring7.util.GetDomainName;
import org.suyuesheng.spring7.util.GetUUID;
import org.suyuesheng.spring7.util.MailUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class UserService {
    public UserService() {
    }

    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public User findById(Integer id){
        if(id!=null){
            return userMapper.findById(id);
        }
        System.out.println("没有查询到相关id，请检查id");
        return null;
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    public boolean insertUser(User user){
        if(user.getUserName()!=null && !user.getUserName().equals("")&& userMapper.findByName(user.getUserName())==null){
            user.setCode(GetUUID.getUUID());
            if (user.getuId()==null||findById(user.getuId())==null) {
                String content= "<h1>欢迎注册</h1><hr><a href=\"http://localhost:8080/active?code="+user.getCode()+"\"> 请点击注册,您的注册码为"+user.getCode()+"</a><p>如有问题，请联系客服。</p><hr><p>如此邮件和您无关，请忽略该邮件，抱歉</p>";
                MailUtils.sendMail(user.getEmail(), content,"验证邮件" );
                return userMapper.insert(user);
            }else {
                return false;
            }
        }
        return false;
    }

    public boolean insertUser(User user, ResultInfo resultInfo){
        if(user.getUserName()!=null && !user.getUserName().equals("")&& userMapper.findByName(user.getUserName())==null){
            user.setCode(GetUUID.getUUID());
            if (user.getuId()==null||findById(user.getuId())==null) {
                resultInfo.setFlag(true);
                String content= "<h1>欢迎注册</h1><hr><a href=\"http://localhost:8080/active?code="+user.getCode()+"\"> 请点击注册,您的注册码为"+user.getCode()+"</a><p>如有问题，请联系客服。</p><hr><p>如此邮件和您无关，请忽略该邮件，抱歉</p>";
                MailUtils.sendMail(user.getEmail(), content,"验证邮件" );
                return userMapper.insert(user);
            }else {
                resultInfo.setFlag(false);
                resultInfo.setErrorMsg("用户id为空，或者用户id之前已经存在");
                return false;
            }
        }
        resultInfo.setFlag(false);
        resultInfo.setErrorMsg("用户名为空或该用户名已经存在，请尝试换一个用户名。The user name is empty or the user name already exists, please try another user name");
        return false;
    }
    public boolean insertUser(User user, ResultInfo resultInfo, HttpServletRequest request){
        if(user.getUserName()!=null && !user.getUserName().equals("")&& userMapper.findByName(user.getUserName())==null){
            user.setCode(GetUUID.getUUID());
            if (user.getuId()==null||findById(user.getuId())==null) {
                String url = request.getRequestURL().toString();
                String ur = GetDomainName.getDomainName(url) + "active?code=";
                resultInfo.setFlag(true);
                String content= "<h1>欢迎注册</h1><hr><a href=\""+ur+user.getCode()+"\"> 请点击注册,您的注册码为"+user.getCode()+"</a><p>如有问题，请联系客服。</p><hr><p>如此邮件和您无关，请忽略该邮件，抱歉</p>";
                MailUtils.sendMail(user.getEmail(), content,"验证邮件" );
                return userMapper.insert(user);
            }else {
                resultInfo.setFlag(false);
                resultInfo.setErrorMsg("用户id为空，或者用户id之前已经存在");
                return false;
            }
        }
        resultInfo.setFlag(false);
        resultInfo.setErrorMsg("用户名为空或该用户名已经存在，请尝试换一个用户名。The user name is empty or the user name already exists, please try another user name");
        return false;
    }

    /**
     * 激活用户
     * @param code
     * @return
     */
    public boolean activeUser(String code){
        try {
            User byCode = userMapper.findByCode(code);
            if (byCode!=null){
                userMapper.updateActive(code);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 登录
     * @param username
     * @param password
     * @param resultInfo
     * @return
     */
    public boolean login(String username,String password,ResultInfo resultInfo){
        try {
            User byName = userMapper.findByName(username);
            if(byName!=null){
                if (byName.getStatus().equals("Y")) {
                    if(password!=null&& !password.equals("")){
                        if(password.equals(byName.getPassword())){
                            resultInfo.setFlag(true);
                            return true;
                        }
                        resultInfo.setFlag(false);
                        resultInfo.setErrorMsg("密码错误");
                        return false;
                    }
                    resultInfo.setFlag(false);
                    resultInfo.setErrorMsg("密码错误，不可以为空");
                    return false;
                } else {
                    resultInfo.setFlag(false);
                    resultInfo.setErrorMsg("该用户未激活");
                    return false;
                }
            }
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("没有该用户");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo.setErrorMsg("陌生错误");
            return false;
        }
    }


    public User findByName(String name){
        User byName = userMapper.findByName(name);
        return byName;
    }

}
