package com.jj.ranger.v1.client;

import com.jj.ranger.client.v1.RangerClient;
import com.jj.ranger.client.v1.domain.Policy;
import com.jj.ranger.client.v1.domain.PolicySearchResults;
import com.jj.ranger.client.v1.domain.RangerLong;
import com.jj.ranger.client.v1.domain.Repository;
import com.jj.ranger.client.v1.domain.RepositorySearchResults;
import com.jj.ranger.client.v1.domain.util.SearchCriteriaUtil;
import com.jj.ranger.v1.domain.DomainTestUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

public class RangerClientTest {
    RestTemplate restTemplate;
    String rangerUri = "localhost";
    RangerClient rangerClient;

    @Before
    public void setUp() throws Exception {
        restTemplate = mock(RestTemplate.class);
        rangerClient = new RangerClient(restTemplate, rangerUri);
    }

    @Test
    public void getRepositoryByIdShouldProperlyReturnCorrespondingRepository() throws Exception {
        when(restTemplate.getForObject("localhost/service/public/api/repository/{id}", Repository.class, 1L)).thenReturn(DomainTestUtils.repository(1L));

        Repository repository = rangerClient.getRepository(1L);
        assertEquals(DomainTestUtils.repository(1L), repository);
    }

    @Test
    public void createRepositoryShouldProperlyPostToRangerAndReturnSuccessfullyCreatedRepository() throws Exception {
        Repository repository = DomainTestUtils.repository(1L);
        when(restTemplate.postForObject("localhost/service/public/api/repository", repository, Repository.class)).thenReturn(repository);

        Repository actual = rangerClient.createRepository(repository);

        assertEquals(DomainTestUtils.repository(1L), actual);
    }

    @Test
    public void updateMethodShouldProperlyCallRestTemplateWithExpectedIdAndRepository() throws Exception {
        rangerClient.updateRepository(DomainTestUtils.repository(1L));

        verify(restTemplate).put("localhost/service/public/api/repository/{id}", DomainTestUtils.repository(1L), 1L);
        verifyNoMoreInteractions(restTemplate);
    }

    @Test
    public void deleteRepositoryShouldCorrectlyCallRestTemplate() throws Exception {
        rangerClient.deleteRepository(1L);
        verify(restTemplate).delete("localhost/service/public/api/repository/{id}", 1L);
        verifyNoMoreInteractions(restTemplate);
    }

    @Test
    public void searchRepositoriesShouldProperlyExecuteAgainstRestTemplate() throws Exception {
        when(restTemplate.getForObject("localhost/service/public/api/repository?" + SearchCriteriaUtil.getParams(DomainTestUtils.searchRepositoriesCriteria()), RepositorySearchResults.class))
                .thenReturn(DomainTestUtils.repositorySearchResults());
        RepositorySearchResults actual = rangerClient.searchRepositories(DomainTestUtils.searchRepositoriesCriteria());

        assertEquals(DomainTestUtils.repositorySearchResults(), actual);
    }

    @Test
    public void rangerClientCountRepositoriesShouldProperlyExecuteAgainstExpectedEndpointAndReturnValidLong() throws Exception {
        when(restTemplate.getForObject("localhost/service/public/api/repository/count", RangerLong.class)).thenReturn(DomainTestUtils.rangerLong(1L));
        assertEquals(1L, rangerClient.countRepositories().longValue());
    }

    @Test
    public void getPolicyByIdShouldProperlyReturnExpectedPolicyWhenExecutingAgainstRestTemplateWithCorrespondingId() throws Exception {
        when(restTemplate.getForObject("localhost/service/public/api/policy/{id}", Policy.class, 1L)).thenReturn(DomainTestUtils.policy(1L));
        Policy actual = rangerClient.getPolicy(1L);
        assertEquals(DomainTestUtils.policy(1L), actual);
    }

    @Test
    public void createPolicyShouldProperlyCreateAndReturnCreatedPolicy() throws Exception {
        Policy toCreate = DomainTestUtils.policy(null);
        when(restTemplate.postForObject("localhost/service/public/api/policy", toCreate, Policy.class)).thenReturn(DomainTestUtils.policy(1L));
        Policy actual = rangerClient.createPolicy(toCreate);

        assertEquals(DomainTestUtils.policy(1L), actual);
    }

    @Test
    public void updatePolicyShouldProperlyCallRestTemplateWithExpectedValues() throws Exception {
        rangerClient.updatePolicy(DomainTestUtils.policy(1L));

        verify(restTemplate).put("localhost/service/public/api/policy/{id}", DomainTestUtils.policy(1L), 1L);
        verifyNoMoreInteractions(restTemplate);
    }

    @Test
    public void deletePolicyShouldCorrectlyCallRestTemplate() throws Exception {
        rangerClient.deletePolicy(1L);
        verify(restTemplate).delete("localhost/service/public/api/policy/{id}", 1L);
        verifyNoMoreInteractions(restTemplate);
    }

    @Test
    public void searchPoliciesShouldProperlyExecuteAgainstRestTemplate() throws Exception {
        when(restTemplate.getForObject("localhost/service/public/api/policy?" + SearchCriteriaUtil.getParams(DomainTestUtils.searchPoliciesCriteria()), PolicySearchResults.class))
                .thenReturn(DomainTestUtils.policySearchResults());
        PolicySearchResults actual = rangerClient.searchPolicies(DomainTestUtils.searchPoliciesCriteria());

        assertEquals(DomainTestUtils.policySearchResults(), actual);
    }

    @Test
    public void rangerClientCountPoliciesShouldProperlyExecuteAgainstExpectedEndpointAndReturnValidLong() throws Exception {
        when(restTemplate.getForObject("localhost/service/public/api/policy/count", RangerLong.class)).thenReturn(DomainTestUtils.rangerLong(1L));
        assertEquals(1L, rangerClient.countPolicies().longValue());
    }
}
