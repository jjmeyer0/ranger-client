package com.jj.ranger.client.v1.domain;

import java.util.List;

public class Policy {
    private Long id;
    private String policyName;
    private String resourceName;
    private String description;
    private String repositoryName;
    private String repositoryType;
    private List<PermObj> permMapList;
    private String tables;
    private String columnFamilies;
    private String columns;
    private String databases;
    private String udfs;
    private String tableType;
    private String columnType;
    private String topologies;
    private String services;
    private boolean isEnabled;
    private Boolean isRecursive;
    private boolean isAuditEnabled;
    private String version;
    private String grantor;
    private boolean replacePerm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getRepositoryType() {
        return repositoryType;
    }

    public void setRepositoryType(String repositoryType) {
        this.repositoryType = repositoryType;
    }

    public List<PermObj> getPermMapList() {
        return permMapList;
    }

    public void setPermMapList(List<PermObj> permMapList) {
        this.permMapList = permMapList;
    }

    public String getTables() {
        return tables;
    }

    public void setTables(String tables) {
        this.tables = tables;
    }

    public String getColumnFamilies() {
        return columnFamilies;
    }

    public void setColumnFamilies(String columnFamilies) {
        this.columnFamilies = columnFamilies;
    }

    public String getColumns() {
        return columns;
    }

    public void setColumns(String columns) {
        this.columns = columns;
    }

    public String getDatabases() {
        return databases;
    }

    public void setDatabases(String databases) {
        this.databases = databases;
    }

    public String getUdfs() {
        return udfs;
    }

    public void setUdfs(String udfs) {
        this.udfs = udfs;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getTopologies() {
        return topologies;
    }

    public void setTopologies(String topologies) {
        this.topologies = topologies;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public Boolean getRecursive() {
        return isRecursive;
    }

    public void setRecursive(Boolean recursive) {
        isRecursive = recursive;
    }

    public boolean isAuditEnabled() {
        return isAuditEnabled;
    }

    public void setAuditEnabled(boolean auditEnabled) {
        isAuditEnabled = auditEnabled;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getGrantor() {
        return grantor;
    }

    public void setGrantor(String grantor) {
        this.grantor = grantor;
    }

    public boolean isReplacePerm() {
        return replacePerm;
    }

    public void setReplacePerm(boolean replacePerm) {
        this.replacePerm = replacePerm;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyName='" + policyName + '\'' +
                ", resourceName='" + resourceName + '\'' +
                ", description='" + description + '\'' +
                ", repositoryName='" + repositoryName + '\'' +
                ", repositoryType='" + repositoryType + '\'' +
                ", permMapList=" + permMapList +
                ", tables='" + tables + '\'' +
                ", columnFamilies='" + columnFamilies + '\'' +
                ", columns='" + columns + '\'' +
                ", databases='" + databases + '\'' +
                ", udfs='" + udfs + '\'' +
                ", tableType='" + tableType + '\'' +
                ", columnType='" + columnType + '\'' +
                ", topologies='" + topologies + '\'' +
                ", services='" + services + '\'' +
                ", isEnabled=" + isEnabled +
                ", isRecursive=" + isRecursive +
                ", isAuditEnabled=" + isAuditEnabled +
                ", version='" + version + '\'' +
                ", grantor='" + grantor + '\'' +
                ", replacePerm=" + replacePerm +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Policy policy = (Policy) o;

        if (isEnabled != policy.isEnabled) return false;
        if (isAuditEnabled != policy.isAuditEnabled) return false;
        if (replacePerm != policy.replacePerm) return false;
        if (id != null ? !id.equals(policy.id) : policy.id != null) return false;
        if (policyName != null ? !policyName.equals(policy.policyName) : policy.policyName != null) return false;
        if (resourceName != null ? !resourceName.equals(policy.resourceName) : policy.resourceName != null) return false;
        if (description != null ? !description.equals(policy.description) : policy.description != null) return false;
        if (repositoryName != null ? !repositoryName.equals(policy.repositoryName) : policy.repositoryName != null) return false;
        if (repositoryType != null ? !repositoryType.equals(policy.repositoryType) : policy.repositoryType != null) return false;
        if (permMapList != null ? !permMapList.equals(policy.permMapList) : policy.permMapList != null) return false;
        if (tables != null ? !tables.equals(policy.tables) : policy.tables != null) return false;
        if (columnFamilies != null ? !columnFamilies.equals(policy.columnFamilies) : policy.columnFamilies != null) return false;
        if (columns != null ? !columns.equals(policy.columns) : policy.columns != null) return false;
        if (databases != null ? !databases.equals(policy.databases) : policy.databases != null) return false;
        if (udfs != null ? !udfs.equals(policy.udfs) : policy.udfs != null) return false;
        if (tableType != null ? !tableType.equals(policy.tableType) : policy.tableType != null) return false;
        if (columnType != null ? !columnType.equals(policy.columnType) : policy.columnType != null) return false;
        if (topologies != null ? !topologies.equals(policy.topologies) : policy.topologies != null) return false;
        if (services != null ? !services.equals(policy.services) : policy.services != null) return false;
        if (isRecursive != null ? !isRecursive.equals(policy.isRecursive) : policy.isRecursive != null) return false;
        if (version != null ? !version.equals(policy.version) : policy.version != null) return false;
        return grantor != null ? grantor.equals(policy.grantor) : policy.grantor == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (policyName != null ? policyName.hashCode() : 0);
        result = 31 * result + (resourceName != null ? resourceName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (repositoryName != null ? repositoryName.hashCode() : 0);
        result = 31 * result + (repositoryType != null ? repositoryType.hashCode() : 0);
        result = 31 * result + (permMapList != null ? permMapList.hashCode() : 0);
        result = 31 * result + (tables != null ? tables.hashCode() : 0);
        result = 31 * result + (columnFamilies != null ? columnFamilies.hashCode() : 0);
        result = 31 * result + (columns != null ? columns.hashCode() : 0);
        result = 31 * result + (databases != null ? databases.hashCode() : 0);
        result = 31 * result + (udfs != null ? udfs.hashCode() : 0);
        result = 31 * result + (tableType != null ? tableType.hashCode() : 0);
        result = 31 * result + (columnType != null ? columnType.hashCode() : 0);
        result = 31 * result + (topologies != null ? topologies.hashCode() : 0);
        result = 31 * result + (services != null ? services.hashCode() : 0);
        result = 31 * result + (isEnabled ? 1 : 0);
        result = 31 * result + (isRecursive != null ? isRecursive.hashCode() : 0);
        result = 31 * result + (isAuditEnabled ? 1 : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (grantor != null ? grantor.hashCode() : 0);
        result = 31 * result + (replacePerm ? 1 : 0);
        return result;
    }
}
