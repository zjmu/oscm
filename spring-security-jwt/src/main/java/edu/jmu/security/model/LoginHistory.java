package edu.jmu.security.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.jmu.jackson.InstantSerializer;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * 用户登录日志
 *
 * @author guantianmin
 * @date 2018/6/7 14:52
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginHistory implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long Id;
    private Long userId;
    @JsonSerialize(using = InstantSerializer.class)
    private Instant loginTime;
    private String loginIp;
    private String remark;
    private User user;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Instant getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Instant loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
