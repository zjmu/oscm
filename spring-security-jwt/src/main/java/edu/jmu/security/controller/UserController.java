package edu.jmu.security.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import edu.jmu.security.JwtTokenUtil;
import edu.jmu.security.model.User;
import edu.jmu.security.service.UserService;
import edu.jmu.util.BasicResponse;
import edu.jmu.util.BusinessWrapper;
import edu.jmu.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.List;

/**
 * 用户控制器
 *
 * @author guantianmin
 * @date 2019/3/6 14:40
 */
@RestController
@RequestMapping("/security")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @GetMapping("/user")
    public BasicResponse<User> getUserInfo(HttpServletRequest request) {
        String authToken = request.getHeader(tokenHeader);
        final String token = authToken.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        return BusinessWrapper.wrap(response -> {
            User user = userService.queryUser(username);
            ResponseUtil.set(response, 0, "查询用户信息成功", user);
        }, logger);
    }

    @GetMapping("/users")
    public BasicResponse<List<User>> queryUserList(@RequestParam(required = false) String username,
                                                   @RequestParam(required = false) String nickname,
                                                   @RequestParam(defaultValue = "1", required = false) Integer pageNum,
                                                   @RequestParam(defaultValue = "20", required = false) Integer pageSize) {
        return BusinessWrapper.wrap(response -> {
            Page page = PageHelper.startPage(pageNum, pageSize);
            List<User> users = userService.findByUsernameAndNickname(username, nickname);
            ResponseUtil.set(response, 0, "查询用户信息成功", users, pageNum, pageSize, page.getTotal());
        }, logger);
    }

    @PostMapping("/users")
    public BasicResponse<Long> add(@RequestBody User user, HttpServletRequest request) {
        return BusinessWrapper.wrap(response -> {
            user.setEnabled(true);
            user.setRegisterTime(Instant.now());
            user.setLastLoginIp("");
            user.setLastPasswordResetDate(Instant.now());
            user.setStatus(2);
            userService.addUser(user);
            ResponseUtil.set(response, 0, "添加用户成功", user.getId());
        }, logger);
    }

    @PutMapping("/users")
    public BasicResponse<Boolean> update(@RequestBody User user) {
        return BusinessWrapper.wrap(response -> {
            ResponseUtil.set(response, 0, "更新用户成功", userService.updateUser(user));
        }, logger);
    }

    @DeleteMapping("/users/{id}")
    public BasicResponse<Boolean> delete(@PathVariable Long id) {
        return BusinessWrapper.wrap(response -> {
            ResponseUtil.set(response, 0, "删除用户成功", userService.deleteUser(id));
        }, logger);
    }
}
