package com.myou.security.models.dto;

/**
 * @Author myou
 * @Date 2020/8/17  3:33 下午
 */
public class ActionDTO {
    private Long actionId;
    private String actionName;

    public Long getActionId() {
        return actionId;
    }

    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    private String actionUrl;
}
