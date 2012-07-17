package com.ds.cvbank.service;

import com.ds.cvbank.model.Candidate;
import io.searchbox.client.ElasticSearchClient;
import io.searchbox.client.ElasticSearchResult;
import io.searchbox.core.Index;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author Dogukan Sonmez
 */

@Service
public class Recruiter {

    private static Logger logger = Logger.getLogger(Recruiter.class.getName());

    @Autowired
    ElasticSearchClient elasticSearchClient;

    public boolean addNewCandidate(Candidate candidate){
        ElasticSearchResult result;
        try {
            result = elasticSearchClient.execute(new Index("cvbank", "candidate", candidate));
        } catch (IOException e) {
            logger.error("Exception occurred while adding new candidate. Exception: ",e);
            return false;
        }
        return result.isSucceeded();
    }

}
