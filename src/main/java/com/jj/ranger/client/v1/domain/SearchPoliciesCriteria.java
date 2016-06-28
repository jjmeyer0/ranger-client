package com.jj.ranger.client.v1.domain;

import java.util.List;


public class SearchPoliciesCriteria {
    private Integer pageSize;
    private Integer startIndex;
    private String policyName;
    private List<String> columns;
    private List<String> columnFamilies;
    private List<String> tables;
    private List<String> udfs;
    private List<String> databases;
    private String groupName;
    private String repositoryType;
    private Boolean isRecursive;
    private String repositoryName;
    private String username;
    private Boolean isEnabled;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public List<String> getColumnFamilies() {
        return columnFamilies;
    }

    public void setColumnFamilies(List<String> columnFamilies) {
        this.columnFamilies = columnFamilies;
    }

    public List<String> getTables() {
        return tables;
    }

    public void setTables(List<String> tables) {
        this.tables = tables;
    }

    public List<String> getUdfs() {
        return udfs;
    }

    public void setUdfs(List<String> udfs) {
        this.udfs = udfs;
    }

    public List<String> getDatabases() {
        return databases;
    }

    public void setDatabases(List<String> databases) {
        this.databases = databases;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getRepositoryType() {
        return repositoryType;
    }

    public void setRepositoryType(String repositoryType) {
        this.repositoryType = repositoryType;
    }

    public Boolean isRecursive() {
        return isRecursive;
    }

    public void setRecursive(Boolean recursive) {
        isRecursive = recursive;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    @Override
    public String toString() {
        return "SearchPoliciesCriteria{" +
                "pageSize=" + pageSize +
                ", startIndex=" + startIndex +
                ", policyName='" + policyName + '\'' +
                ", columns=" + columns +
                ", columnFamilies=" + columnFamilies +
                ", tables=" + tables +
                ", udfs=" + udfs +
                ", databases=" + databases +
                ", groupName='" + groupName + '\'' +
                ", repositoryType='" + repositoryType + '\'' +
                ", isRecursive=" + isRecursive +
                ", repositoryName='" + repositoryName + '\'' +
                ", username='" + username + '\'' +
                ", isEnabled=" + isEnabled +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchPoliciesCriteria that = (SearchPoliciesCriteria) o;

        if (pageSize != null ? !pageSize.equals(that.pageSize) : that.pageSize != null) return false;
        if (startIndex != null ? !startIndex.equals(that.startIndex) : that.startIndex != null) return false;
        if (policyName != null ? !policyName.equals(that.policyName) : that.policyName != null) return false;
        if (columns != null ? !columns.equals(that.columns) : that.columns != null) return false;
        if (columnFamilies != null ? !columnFamilies.equals(that.columnFamilies) : that.columnFamilies != null) return false;
        if (tables != null ? !tables.equals(that.tables) : that.tables != null) return false;
        if (udfs != null ? !udfs.equals(that.udfs) : that.udfs != null) return false;
        if (databases != null ? !databases.equals(that.databases) : that.databases != null) return false;
        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;
        if (repositoryType != null ? !repositoryType.equals(that.repositoryType) : that.repositoryType != null) return false;
        if (isRecursive != null ? !isRecursive.equals(that.isRecursive) : that.isRecursive != null) return false;
        if (repositoryName != null ? !repositoryName.equals(that.repositoryName) : that.repositoryName != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        return isEnabled != null ? isEnabled.equals(that.isEnabled) : that.isEnabled == null;

    }

    @Override
    public int hashCode() {
        int result = pageSize != null ? pageSize.hashCode() : 0;
        result = 31 * result + (startIndex != null ? startIndex.hashCode() : 0);
        result = 31 * result + (policyName != null ? policyName.hashCode() : 0);
        result = 31 * result + (columns != null ? columns.hashCode() : 0);
        result = 31 * result + (columnFamilies != null ? columnFamilies.hashCode() : 0);
        result = 31 * result + (tables != null ? tables.hashCode() : 0);
        result = 31 * result + (udfs != null ? udfs.hashCode() : 0);
        result = 31 * result + (databases != null ? databases.hashCode() : 0);
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (repositoryType != null ? repositoryType.hashCode() : 0);
        result = 31 * result + (isRecursive != null ? isRecursive.hashCode() : 0);
        result = 31 * result + (repositoryName != null ? repositoryName.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (isEnabled != null ? isEnabled.hashCode() : 0);
        return result;
    }
}
