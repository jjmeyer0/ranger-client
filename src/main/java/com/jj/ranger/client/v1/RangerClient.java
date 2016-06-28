package com.jj.ranger.client.v1;

import com.jj.ranger.client.v1.domain.Policy;
import com.jj.ranger.client.v1.domain.PolicySearchResults;
import com.jj.ranger.client.v1.domain.RangerLong;
import com.jj.ranger.client.v1.domain.Repository;
import com.jj.ranger.client.v1.domain.RepositorySearchResults;
import com.jj.ranger.client.v1.domain.SearchPoliciesCriteria;
import com.jj.ranger.client.v1.domain.SearchRepositoriesCriteria;
import com.jj.ranger.client.v1.domain.util.SearchCriteriaUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;

/**
 * This is a client class that allows a user to interact with the first version of Ranger's public APIs. Documentation for
 * the first version of Ranger's public APIs can be found here: https://cwiki.apache.org/confluence/display/RANGER/REST+APIs+for+Policy+Management
 */
@Component
public class RangerClient {
    private static final Logger LOG = LoggerFactory.getLogger(RangerClient.class);

    private RestTemplate restTemplate;
    private String rangerUri;

    @Inject
    public RangerClient(RestTemplate restTemplate, @Qualifier("rangerUriV1") String rangerUri) {
        this.restTemplate = restTemplate;
        this.rangerUri = rangerUri;
    }

    /**
     * GET /service/public/api/repository/{id}
     *
     * @param id The id of the repository to retrieve.
     * @return The {@link Repository} object for {@code id}.
     */
    public Repository getRepository(Long id) {
        LOG.info("Calling GET /service/public/api/repository/{}", id);
        Repository repository = restTemplate.getForObject(rangerUri + "/service/public/api/repository/{id}", Repository.class, id);
        LOG.info("Calling GET /service/public/api/repository/{} successful. Returning: {}", id, repository);
        return repository;
    }

    /**
     * POST /service/public/api/repository/
     *
     * @param repository The repository to post and create in Ranger.
     * @return The repository that was created in Ranger.
     */
    public Repository createRepository(Repository repository) {
        LOG.info("Calling POST /service/public/api/repository/ with body {}", repository);
        Repository updatedRepository = restTemplate.postForObject(rangerUri + "/service/public/api/repository", repository, Repository.class);
        LOG.info("Successful call to POST /service/public/api/repository/ returning updated repository: {}", updatedRepository);
        return updatedRepository;
    }

    /**
     * TODO: technically ranger returns repository after update. Maybe we should do the same.
     *
     * PUT /service/public/api/repository/{id}
     *
     * @param repository The repository to update.
     */
    public void updateRepository(Repository repository) {
        Long id = repository.getId();
        LOG.info("Calling PUT /service/public/api/repository/{} with body {}", id, repository);
        restTemplate.put(rangerUri + "/service/public/api/repository/{id}", repository, id);
        LOG.info("Successfully called PUT /service/public/api/repository/{} with body {}", id, repository);
    }

    /**
     * DELETE /service/public/api/repository/{id}
     *
     * @param id The id of the repository to delete.
     */
    public void deleteRepository(Long id) {
        LOG.info("Calling DELETE /service/public/api/repository/{}", id);
        restTemplate.delete(rangerUri + "/service/public/api/repository/{id}", id);
        LOG.info("Successfully called DELETE /service/public/api/repository/{}. Policy with this id is now deleted.", id);
    }

    /**
     * GET /service/public/api/repository/
     *
     * @param searchRepositoriesCriteria The search criteria for searching for repositories.
     * @return The list of repositories that match the search criteria.
     */
    public RepositorySearchResults searchRepositories(SearchRepositoriesCriteria searchRepositoriesCriteria) {
        String params = SearchCriteriaUtil.getParams(searchRepositoriesCriteria);
        LOG.info("Calling GET /service/public/api/repository?{}", params);
        RepositorySearchResults repositories = restTemplate.getForObject(rangerUri + "/service/public/api/repository?" + params, RepositorySearchResults.class);
        LOG.info("Successfully called GET /service/public/api/repository?{} returning {}", params, repositories);
        return repositories;
    }

    /**
     * GET /service/public/api/repository/count
     *
     * @return The total number of repositories.
     */
    public Long countRepositories() {
        LOG.info("Calling GET /service/public/api/repository/count");
        RangerLong count = restTemplate.getForObject(rangerUri + "/service/public/api/repository/count", RangerLong.class);
        LOG.info("Successfully called GET /service/public/api/repository/count returning value {} ", count);
        return count.getValue();
    }

    /**
     * GET /service/public/api/policy/{id}
     *
     * @param id The id of the policy to retrieve.
     * @return The policy that corresponds to {@code id}
     */
    public Policy getPolicy(Long id) {
        LOG.info("Calling GET /service/public/api/policy/{}", id);
        Policy policy = restTemplate.getForObject(rangerUri + "/service/public/api/policy/{id}", Policy.class, id);
        LOG.info("Successful call to GET /service/public/api/policy/{} returning policy: {}", id, policy);

        return policy;
    }

    /**
     * POST /service/public/api/policy
     * @param policy The policy to create in Ranger.
     * @return The policy that was created in ranger.
     */
    public Policy createPolicy(Policy policy) {
        LOG.info("Calling POST /service/public/api/policy with body {}", policy);
        Policy createdPolicy = restTemplate.postForObject(rangerUri + "/service/public/api/policy", policy, Policy.class);
        LOG.info("Successfully called POST /service/public/api/policy. Returning created policy: {}", createdPolicy);
        return createdPolicy;
    }

    /**
     * TODO: technically ranger returns policy after update. Maybe we should do the same.
     * PUT /service/public/api/policy/{id}
     *
     * @param policy The policy to update. It must have an id and exist in Ranger.
     */
    public void updatePolicy(Policy policy) {
        Long id = policy.getId();
        LOG.info("Calling PUT /service/public/api/policy/{} with body: {}", id, policy);
        restTemplate.put("localhost/service/public/api/policy/{id}", policy, id);
        LOG.info("PUT /service/public/api/policy/{} with body: {} successful. Returning {}", id, policy);
    }

    /**
     * DELETE /service/public/api/policy/{id}
     *
     * @param id The id of the policy to delete from Ranger.
     */
    public void deletePolicy(Long id) {
        LOG.info("Calling DELETE /service/public/api/policy/{}", id);
        restTemplate.delete(rangerUri + "/service/public/api/policy/{id}", id);
        LOG.info("Successfully executed: DELETE /service/public/api/policy/{}", id);
    }

    /**
     * GET /service/public/api/policy
     *
     * @param searchPoliciesCriteria The search criteria for searching for policies.
     * @return A list of policies that match the given criteria.
     */
    public PolicySearchResults searchPolicies(SearchPoliciesCriteria searchPoliciesCriteria) {
        String params = SearchCriteriaUtil.getParams(searchPoliciesCriteria);
        LOG.info("Calling GET /service/public/api/repository?{}", params);
        PolicySearchResults policies = restTemplate.getForObject(rangerUri + "/service/public/api/policy?" + params, PolicySearchResults.class);
        LOG.info("Successfully called GET /service/public/api/policy?{} returning {}", params, policies);
        return policies;
    }

    /**
     * GET /service/public/api/policy/count
     *
     * @return The total number of policies.
     */
    public Long countPolicies() {
        LOG.info("Calling GET /service/public/api/policy/count");
        RangerLong count = restTemplate.getForObject(rangerUri + "/service/public/api/policy/count", RangerLong.class);
        LOG.info("Successfully called GET /service/public/api/policy/count returning value: {}", count);
        return count.getValue();
    }
}
