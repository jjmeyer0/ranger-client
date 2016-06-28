package com.jj.ranger.client.v1.domain;

import java.util.List;

public class PermObj {
    private List<String> userList;
    private List<String> groupList;
    private List<String> permList;
    private String ipAddress;

    public List<String> getUserList() {
        return userList;
    }

    public void setUserList(List<String> userList) {
        this.userList = userList;
    }

    public List<String> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<String> groupList) {
        this.groupList = groupList;
    }

    public List<String> getPermList() {
        return permList;
    }

    public void setPermList(List<String> permList) {
        this.permList = permList;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "PermObj{" +
                "userList=" + userList +
                ", groupList=" + groupList +
                ", permList=" + permList +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PermObj permObj = (PermObj) o;

        if (userList != null ? !userList.equals(permObj.userList) : permObj.userList != null) return false;
        if (groupList != null ? !groupList.equals(permObj.groupList) : permObj.groupList != null) return false;
        if (permList != null ? !permList.equals(permObj.permList) : permObj.permList != null) return false;
        return ipAddress != null ? ipAddress.equals(permObj.ipAddress) : permObj.ipAddress == null;

    }

    @Override
    public int hashCode() {
        int result = userList != null ? userList.hashCode() : 0;
        result = 31 * result + (groupList != null ? groupList.hashCode() : 0);
        result = 31 * result + (permList != null ? permList.hashCode() : 0);
        result = 31 * result + (ipAddress != null ? ipAddress.hashCode() : 0);
        return result;
    }
}
