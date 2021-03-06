package com.ppro.spring.service.impl;

import java.util.*;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ppro.spring.dao.AbstractDAO;
import com.ppro.spring.dao.ProfileDAO;
import com.ppro.spring.model.*;
import com.ppro.spring.service.api.CRUDService;
import com.ppro.spring.service.api.ProfileService;
import com.ppro.spring.service.api.UserService;
import com.ppro.spring.utils.AppUtils;

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

    @Autowired
    @Qualifier("PageService")
    private CRUDService<Page> pageService;

    @Autowired
    private UserService userService;

    @Override
    protected AbstractDAO<Profile> getDAOInstance() {
        return profileDAO;
    }

    @Override
    public Profile loadProfile(String url) {
        Profile profile = profileDAO.getByURL(url);
        if (profile == null) {
            profile = createNewProfile(url);
            save(profile);
        }
        return profile;
    }

    private Profile createNewProfile(String url) {
        Profile profile = new Profile();
        profile.setUrl(url);
        String displayName = url.replace("http://","");
        profile.setDisplayName(displayName);

        profile.setCreationDate(new DateTime());

        final User user = userService.getUserByName(AppUtils.getActualLoggedUser());
        profile.setUser(user);
        return profile;
    }

    @Override
    public void addSearchResult(Profile profile, String subject, Integer position, Server server) {
        SearchResult searchResult = new SearchResult();
        searchResult.setCreationDate(new DateTime());
        searchResult.setProfile(profile);
        searchResult.setSearchedWord(subject);
        searchResult.setPosition(position);
        searchResult.setServer(server);
        //finally add to profile
        profile.getHistoryOfSearch().add(searchResult);
        searchResultService.save(searchResult);
    }

    @Override
    public List<SearchResult> getSearchedResultForSubject(Profile profile, String subject) {
        Set<SearchResult> searchResults = profile.getHistoryOfSearch();
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
        Map<String, List<SearchResult>> result = new LinkedHashMap<String, List<SearchResult>>();

        for (SearchResult searchResult : profile.getHistoryOfSearch()) {
            String key = searchResult.getSearchedWord();

            if (!result.containsKey(key)) {
                result.put(key,new LinkedList<SearchResult>());
            }
            result.get(key).add(searchResult);
        }
        //sort by time
        for (List<SearchResult> searchResults : result.values()) {
            Collections.sort(searchResults,new MyDateTimeComparator());
        }
        return result;
    }

    @Override
    public void addMapPages(String url, Set<String> result, int level) {
        Profile profile = loadProfile(url);

        DateTime creatingDate = new DateTime();

        for (String pageUrl : result) {
            Page page = new Page();
            page.setCreationDate(creatingDate);
            page.setLevel(level);
            page.setProfile(profile);
            page.setUrl(pageUrl);

            profile.getPages().add(page);
            pageService.save(page);
        }
    }
}
