package com.jj.ranger;

import com.jj.ranger.client.v1.RangerClient;
import com.jj.ranger.client.v1.domain.SearchPoliciesCriteria;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan
public class Application {

    public static void main(String args[]) throws Exception {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        RangerClient client = ctx.getBean(RangerClient.class);

        client.getPolicy(5L); // This may fail w/ a 404 if policy with id of 5 doesn't exist.

        client.countPolicies();

        SearchPoliciesCriteria searchPoliciesCriteria = new SearchPoliciesCriteria();
        searchPoliciesCriteria.setRepositoryType("hive");
        client.searchPolicies(searchPoliciesCriteria);

        System.exit(0);
    }
}
