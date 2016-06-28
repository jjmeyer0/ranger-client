package com.jj.ranger.client.v1.domain.util;

import com.jj.ranger.client.v1.domain.SearchPoliciesCriteria;
import com.jj.ranger.client.v1.domain.SearchRepositoriesCriteria;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public final class SearchCriteriaUtil {

    public static String getParams(SearchRepositoriesCriteria searchRepositoriesCriteria) {
        if (searchRepositoriesCriteria == null) {
            return "";
        }

        List<NameValuePair> queryString = new ArrayList<>();
        if (searchRepositoriesCriteria.getPageSize() != null) queryString.add(new BasicNameValuePair("pageSize", searchRepositoriesCriteria.getPageSize().toString()));
        if (searchRepositoriesCriteria.getStartIndex() != null) queryString.add(new BasicNameValuePair("startIndex", searchRepositoriesCriteria.getStartIndex().toString()));
        if (searchRepositoriesCriteria.getName() != null) queryString.add(new BasicNameValuePair("name", searchRepositoriesCriteria.getName()));
        if (searchRepositoriesCriteria.getType() != null) queryString.add(new BasicNameValuePair("type", searchRepositoriesCriteria.getType()));
        if (searchRepositoriesCriteria.isStatus() != null) queryString.add(new BasicNameValuePair("status", searchRepositoriesCriteria.isStatus().toString()));

        return URLEncodedUtils.format(queryString, "UTF-8");
    }

    public static String getParams(SearchPoliciesCriteria searchPoliciesCriteria) {
        if (searchPoliciesCriteria == null) {
            return "";
        }

        List<NameValuePair> queryString = new ArrayList<>();
        if (searchPoliciesCriteria.getPageSize() != null) queryString.add(new BasicNameValuePair("pageSize", searchPoliciesCriteria.getPageSize().toString()));
        if (searchPoliciesCriteria.getStartIndex() != null) queryString.add(new BasicNameValuePair("startIndex", searchPoliciesCriteria.getStartIndex().toString()));
        if (searchPoliciesCriteria.getPolicyName() != null) queryString.add(new BasicNameValuePair("policyName", searchPoliciesCriteria.getPolicyName()));
        if (searchPoliciesCriteria.getColumns() != null && !searchPoliciesCriteria.getColumns().isEmpty()) queryString.add(new BasicNameValuePair("columns", join(searchPoliciesCriteria.getColumns())));
        if (searchPoliciesCriteria.getColumnFamilies() != null && !searchPoliciesCriteria.getColumnFamilies().isEmpty()) queryString.add(new BasicNameValuePair("columnFamilies", join(searchPoliciesCriteria.getColumnFamilies())));
        if (searchPoliciesCriteria.getTables() != null && !searchPoliciesCriteria.getTables().isEmpty()) queryString.add(new BasicNameValuePair("tables", join(searchPoliciesCriteria.getTables())));
        if (searchPoliciesCriteria.getUdfs() != null && !searchPoliciesCriteria.getUdfs().isEmpty()) queryString.add(new BasicNameValuePair("udfs", join(searchPoliciesCriteria.getUdfs())));
        if (searchPoliciesCriteria.getDatabases() != null && !searchPoliciesCriteria.getDatabases().isEmpty()) queryString.add(new BasicNameValuePair("databases", join(searchPoliciesCriteria.getDatabases())));
        if (searchPoliciesCriteria.getGroupName() != null) queryString.add(new BasicNameValuePair("groupName", searchPoliciesCriteria.getGroupName()));
        if (searchPoliciesCriteria.getRepositoryType() != null) queryString.add(new BasicNameValuePair("repositoryType", searchPoliciesCriteria.getRepositoryType()));
        if (searchPoliciesCriteria.getRepositoryName() != null) queryString.add(new BasicNameValuePair("repositoryName", searchPoliciesCriteria.getRepositoryName()));
        if (searchPoliciesCriteria.isRecursive() != null) queryString.add(new BasicNameValuePair("isRecursive", searchPoliciesCriteria.isRecursive().toString()));
        if (searchPoliciesCriteria.getUsername() != null) queryString.add(new BasicNameValuePair("username", searchPoliciesCriteria.getUsername()));
        if (searchPoliciesCriteria.isEnabled() != null) queryString.add(new BasicNameValuePair("isEnabled", searchPoliciesCriteria.isEnabled().toString()));

        return URLEncodedUtils.format(queryString, "UTF-8");
    }

    private static String join(List<String> values) {
        String joined = "";
        for (String v : values) {
            if ("".equals(joined) && v != null) {
                joined = v;
            }

            if (!"".equals(v) && v != null) joined = joined + "," + v;
        }

        return joined;
    }
}
