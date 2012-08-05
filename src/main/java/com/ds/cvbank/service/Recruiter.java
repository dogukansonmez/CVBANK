package com.ds.cvbank.service;

import com.ds.cvbank.model.Candidate;
import com.ds.cvbank.model.SearchBox;
import io.searchbox.client.ElasticSearchClient;
import io.searchbox.client.ElasticSearchResult;
import io.searchbox.core.Get;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import org.apache.log4j.Logger;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.termQuery;

/**
 * @author Dogukan Sonmez
 */

@Service
public class Recruiter {

    private static Logger logger = Logger.getLogger(Recruiter.class.getName());

    @Autowired
    ElasticSearchClient elasticSearchClient;

    public boolean addNewCandidate(Candidate candidate){
        ElasticSearchResult result = null;
        try {
            result = elasticSearchClient.execute(new Index(candidate,candidate.getEmail()));
        } catch (IOException e) {
            logger.error("Exception occurred while adding new candidate. Exception: " ,e);
            return false;
        }
        if(!result.isSucceeded()){
            logger.error("Cannot add new candidate Exception:" + result.getErrorMessage());
        }
        return result.isSucceeded();
    }


    public List<Candidate> searchForCandidates(SearchBox searchBox) {
       BoolQueryBuilder query = buildQBoolQuery(searchBox);
        logger.info("Query" + query.toString());
        ElasticSearchResult searchResult = null;
        try {
            Search search =   new Search(query);
            search.addIndex("cvbank");
            search.addType("candidate");
            searchResult = elasticSearchClient.execute(search);
        } catch (IOException e) {
          logger.error("Search error:",e);
           return new ArrayList<Candidate>();
        }

        logger.info("Search result : " + searchResult.isSucceeded());
        return searchResult.getSourceAsObjectList(Candidate.class);
    }

    private BoolQueryBuilder buildQBoolQuery(SearchBox searchBox) {
        String[] mustHave = searchBox.getAllTheseWords().split(",");
        String[] shouldHave = searchBox.getAnyOfTheseWords().split(",") ;
        String[] mustNot = searchBox.getNoneOfTheseWords().split(",");
        BoolQueryBuilder query = new BoolQueryBuilder();
        for(String term:mustHave){
            if(term.trim().length()> 0){
                logger.info("term : " + term);
                query.must(termQuery("content", term));
            }
        }

        for(String term:shouldHave){
            if(term.trim().length()> 0){
                logger.info("term : " + term);
                query.should(termQuery("content", term));
            }
        }

        for(String term:mustNot){
            if(term.trim().length()> 0){
                logger.info("term : " + term);
                query.mustNot(termQuery("content", term));
            }
        }
        return query;
    }

    public Candidate getCandidate(String email) {
        ElasticSearchResult searchResult;
        try {
            searchResult = elasticSearchClient.execute(new Get(new String[]{email}));
        } catch (IOException e) {
            logger.error("Search error:",e);
            return new Candidate();
        }

        logger.info("Get result : " + searchResult.isSucceeded());
        return searchResult.getSourceAsObject(Candidate.class);
    }
}
