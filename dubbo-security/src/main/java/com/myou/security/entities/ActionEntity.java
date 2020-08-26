package com.myou.security.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @Author myou
 * @Date 2020/8/5  5:23 下午
 */
@Entity
@Table(name = "tb_action", schema = "sercurty_auth")
public class ActionEntity extends BaseEntity {
    private Long actionId;
    private String actionName;
    private String actionUrl;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "action_id", nullable = false)
    public Long getActionId() {
        return actionId;
    }

    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }

    @Basic
    @Column(name = "action_name", nullable = false, length = 32)
    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    @Basic
    @Column(name = "action_url", nullable = false, length = 128)
    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionEntity that = (ActionEntity) o;
        return actionId == that.actionId &&
                Objects.equals(actionName, that.actionName) &&
                Objects.equals(actionUrl, that.actionUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actionId, actionName, actionUrl);
    }
}
