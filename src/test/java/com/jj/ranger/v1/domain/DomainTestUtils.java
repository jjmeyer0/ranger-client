package com.jj.ranger.v1.domain;

import com.jj.ranger.client.v1.domain.Policy;
import com.jj.ranger.client.v1.domain.PolicySearchResults;
import com.jj.ranger.client.v1.domain.RangerLong;
import com.jj.ranger.client.v1.domain.Repository;
import com.jj.ranger.client.v1.domain.RepositorySearchResults;
import com.jj.ranger.client.v1.domain.SearchPoliciesCriteria;
import com.jj.ranger.client.v1.domain.SearchRepositoriesCriteria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DomainTestUtils {
    public static RangerLong rangerLong(long value) {
        RangerLong rangerLong = new RangerLong();
        rangerLong.setValue(value);
        return rangerLong;
    }

    public static Repository repository(Long id) {
        Repository repository = new Repository();
        repository.setId(id);
        repository.setName("name");
        repository.setDescription("description");
        repository.setRepositoryType("repositoryType");
        repository.setConfig("config");
        repository.setActive(true);
        repository.setVersion("version");

        return repository;
    }

    public static Policy policy(Long id) {
        Policy policy = new Policy();
        policy.setId(id);
        policy.setPolicyName("policyName");
        policy.setResourceName("resourceName");
        policy.setDescription("description");
        policy.setRepositoryName("repositoryName");
        policy.setRepositoryType("repositoryType");
        policy.setPermMapList(new ArrayList<>());
        policy.setTables("tables");
        policy.setColumnFamilies("columnFamilies");
        policy.setColumns("columns");
        policy.setDatabases("databases");
        policy.setUdfs("udfs");
        policy.setTableType("tableType");
        policy.setColumnType("columnType");
        policy.setTopologies("topologies");
        policy.setServices("services");
        policy.setEnabled(true);
        policy.setRecursive(true);
        policy.setAuditEnabled(true);
        policy.setVersion("version");
        policy.setGrantor("grantor");
        policy.setReplacePerm(true);

        return policy;
    }

    public static SearchPoliciesCriteria searchPoliciesCriteria() {
        SearchPoliciesCriteria criteria = new SearchPoliciesCriteria();
        criteria.setPageSize(10);
        criteria.setStartIndex(0);
        criteria.setPolicyName("policyName");
        criteria.setColumns(Arrays.asList("1", "2"));
        criteria.setColumnFamilies(Arrays.asList("1", "2"));
        criteria.setTables(Arrays.asList("1", "2"));
        criteria.setUdfs(Arrays.asList("1", "2"));
        criteria.setDatabases(Arrays.asList("1", "2"));
        criteria.setGroupName("groupName");
        criteria.setRepositoryType("repositoryType");
        criteria.setRecursive(true);
        criteria.setRepositoryName("repositoryName");
        criteria.setUsername("username");
        criteria.setEnabled(true);

        return criteria;
    }

    public static SearchRepositoriesCriteria searchRepositoriesCriteria() {
        SearchRepositoriesCriteria criteria = new SearchRepositoriesCriteria();
        criteria.setPageSize(10);
        criteria.setStartIndex(0);
        criteria.setName("name");
        criteria.setType("type");
        criteria.setStatus(true);

        return criteria;
    }

    public static PolicySearchResults policySearchResults() {
        PolicySearchResults policySearchResults = new PolicySearchResults();
        policySearchResults.setStartIndex(0);
        policySearchResults.setPageSize(10);
        policySearchResults.setTotalCount(1);
        policySearchResults.setResultSize(1);
        policySearchResults.setSortType("sortType");
        policySearchResults.setSortBy("sortBy");
        policySearchResults.setQueryTimeMS(1L);
        policySearchResults.setvXPolicies(Collections.singletonList(policy(1L)));

        return policySearchResults;
    }

    public static RepositorySearchResults repositorySearchResults() {
        RepositorySearchResults repositorySearchResults = new RepositorySearchResults();
        repositorySearchResults.setStartIndex(0);
        repositorySearchResults.setPageSize(10);
        repositorySearchResults.setTotalCount(1);
        repositorySearchResults.setResultSize(1);
        repositorySearchResults.setSortType("sortType");
        repositorySearchResults.setSortBy("sortBy");
        repositorySearchResults.setQueryTimeMS(1L);
        repositorySearchResults.setvXRepositories(Collections.singletonList(repository(1L)));

        return repositorySearchResults;
    }
}
