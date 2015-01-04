package com.ppro.spring.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ppro.spring.dao.AbstractDAO;
import com.ppro.spring.dao.ProfileDAO;
import com.ppro.spring.model.Profile;
import com.ppro.spring.model.SearchResult;
import com.ppro.spring.service.api.CRUDService;
import com.ppro.spring.service.api.ProfileService;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 1.1.15
 */
@Service("ProfileService")
public class ProfileServiceImpl extends AbstractCRUDService<Profile> implements ProfileService {

    @Autowired
    private ProfileDAO profileDAO;

    @Autowired
    @Qualifier("SearchResultService")
    private CRUDService<SearchResult> searchResultService;

    @Override
    protected AbstractDAO<Profile> getDAOInstance() {
        return profileDAO;
    }

    @Override
    public Profile loadProfile(String url) {
        String profileID = url.replace("http://","");
        Profile profile = getByID(profileID);
        if (profile == null) {
            profile = new Profile();
            profile.setDisplayName(profileID);
            profile.setUrl(url);
            save(profile);
        }
        return profile;
    }

    @Override
    public void addSearchResult(Profile profile, String subject, Integer position) {
        SearchResult searchResult = new SearchResult();
        searchResult.setCreationDate(new DateTime());
        searchResult.setProfile(profile);
        searchResult.setSearchedWord(subject);
        searchResult.setPosition(position);
        //finally add to profile
        profile.getHistoryOfSearch().add(searchResult);
        searchResultService.save(searchResult);
    }

    @Override
    public List<SearchResult> getSearchedResultForSubject(Profile profile, String subject) {
        List<SearchResult> searchResults = profile.getHistoryOfSearch();
        List<SearchResult> result = new ArrayList<SearchResult>();
        for (SearchResult searchResult : searchResults) {
            if (subject.equals(searchResult.getSearchedWord())) {
                result.add(searchResult);
            }
        }
        return result;
    }

    @Override
    public Map<String, List<SearchResult>> getSearchResults(Profile profile) {
        Map<String, List<SearchResult>> result = new HashMap<String, List<SearchResult>>();

        for (SearchResult searchResult : profile.getHistoryOfSearch()) {
            String key = searchResult.getSearchedWord();

            if (!result.containsKey(key)) {
                result.put(key,new ArrayList<SearchResult>());
            }
            result.get(key).add(searchResult);
        }
        return result;
    }
}
