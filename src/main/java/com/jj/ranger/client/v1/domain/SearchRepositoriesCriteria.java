package com.jj.ranger.client.v1.domain;

public class SearchRepositoriesCriteria {
    private Integer pageSize;
    private Integer startIndex;
    private String name;
    private String type;
    private Boolean status;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean isStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SearchRepositoriesCriteria{" +
                "pageSize=" + pageSize +
                ", startIndex=" + startIndex +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchRepositoriesCriteria that = (SearchRepositoriesCriteria) o;

        if (pageSize != that.pageSize) return false;
        if (startIndex != that.startIndex) return false;
        if (status != that.status) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return type != null ? type.equals(that.type) : that.type == null;

    }

    @Override
    public int hashCode() {
        Integer result = pageSize;
        result = 31 * result + startIndex;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (status ? 1 : 0);
        return result;
    }
}
