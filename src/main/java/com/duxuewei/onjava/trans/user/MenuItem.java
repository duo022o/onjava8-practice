package com.duxuewei.onjava.trans.user;

import java.io.Serializable;
import java.util.List;

public class MenuItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private String Id;
    private String Code;
    private String ParentCode;
    private String ParentId;
    private String Name;
    private String NgUrl;
    private String TargetUrl;
    private String Icon;
    private boolean Visible;
    private int SortOrder;
    private List<MenuItem> Children;
    private List<String> UserIds;
    private List<OperateModel> RowOperates;
    private List<OperateModel> PageOperates;
    private String DataPermissionRuleId;
    private String DataPermissionRuleKey;

    public String getDataPermissionRuleKey() {
        return DataPermissionRuleKey;
    }

    public void setDataPermissionRuleKey(String dataPermissionRuleKey) {
        DataPermissionRuleKey = dataPermissionRuleKey;
    }

    public String getDataPermissionRuleId() {
        return DataPermissionRuleId;
    }

    public void setDataPermissionRuleId(String dataPermissionRuleId) {
        DataPermissionRuleId = dataPermissionRuleId;
    }

    public List<MenuItem> getChildren() {
        return Children;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        this.Code = code;
    }

    public String getParentCode() {
        return ParentCode;
    }

    public void setParentCode(String parentCode) {
        this.ParentCode = parentCode;
    }

    public String getParentId() {
        return ParentId;
    }

    public void setParentId(String parentId) {
        this.ParentId = parentId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getNgUrl() {
        return NgUrl;
    }

    public void setNgUrl(String ngUrl) {
        this.NgUrl = ngUrl;
    }

    public String getTargetUrl() {
        return TargetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.TargetUrl = targetUrl;
    }

    public String getIcon() {
        return Icon;
    }

    public void setIcon(String icon) {
        this.Icon = icon;
    }

    public boolean isVisible() {
        return Visible;
    }

    public void setVisible(boolean visible) {
        this.Visible = visible;
    }

    public int getSortOrder() {
        return SortOrder;
    }

    public List<String> getUserIds() {
        return UserIds;
    }

    public void setUserIds(List<String> userIds) {
        UserIds = userIds;
    }

    public void setSortOrder(int sortOrder) {
        this.SortOrder = sortOrder;
    }

    public void setChildren(List<MenuItem> children) {
        this.Children = children;
    }

    public List<OperateModel> getRowOperates() {
        return RowOperates;
    }

    public void setRowOperates(List<OperateModel> rowOperates) {
        RowOperates = rowOperates;
    }

    public List<OperateModel> getPageOperates() {
        return PageOperates;
    }

    public void setPageOperates(List<OperateModel> pageOperates) {
        PageOperates = pageOperates;
    }

}