package com.ppro.spring.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ppro.spring.model.Profile;
import com.ppro.spring.model.SearchResult;
import com.ppro.spring.service.api.ProfileService;
import com.ppro.spring.utils.AppUtils;

/**
 * Created with IntelliJ IDEA.
 * User: lukas
 * Date: 1.1.15
 */
@Controller
public class ProfileController {

    @Autowired
    @Qualifier(value = "ProfileService")
    private ProfileService profileService;

    @RequestMapping(value = "/profily", method = RequestMethod.GET)
    public ModelAndView getAllProfiles() {
        ModelAndView mav = new ModelAndView();
        final Set<Profile> profiles = profileService.getAll();
        mav.addObject("searchResult", profiles);
        return AppUtils.goToPageByModelAndView(mav, "profiles");
    }

    @RequestMapping(value = "/newSearch", method = RequestMethod.GET)
    public String newSearchPosition(@RequestParam("profileID") String profileID, RedirectAttributes redirectAttributes) {
        Profile profile = profileService.getByID(profileID);
        redirectAttributes.addFlashAttribute("url", profile.getUrl());

        return "redirect:pozice";
    }

    @RequestMapping(value = "/newSearchKeyword", method = RequestMethod.GET)
    public String newSearchPositionWithKeyword(@RequestParam("profileID") String profileID,@RequestParam("subject") String keyword, RedirectAttributes redirectAttributes) {
        Profile profile = profileService.getByID(profileID);
        redirectAttributes.addFlashAttribute("url", profile.getUrl());
        redirectAttributes.addFlashAttribute("keyword", keyword);

        return "redirect:pozice";
    }

    @RequestMapping(value = "/profil", method = RequestMethod.GET)
    public ModelAndView getDetailOfProfile(@RequestParam("profileID") String profileID) {
        ModelAndView mav = new ModelAndView();
        Profile profile = profileService.getByID(profileID);
        Map<String, List<SearchResult>> mapResults = profileService.getSearchResults(profile);
        mav.addObject("profile", profile);
        mav.addObject("mapResults", mapResults);

        return AppUtils.goToPageByModelAndView(mav, "detailProfile");
    }

    @RequestMapping(value = "/getSearchResults", method = RequestMethod.GET)
    public ModelAndView getSearchResults(@RequestParam("profileID") String profileID, @RequestParam(value = "subject") String subject) {
        ModelAndView mav = new ModelAndView();
        Profile profile = profileService.getByID(profileID);
        Map<String, List<SearchResult>> mapResults = profileService.getSearchResults(profile);

        mav.addObject("mapResults", mapResults);
        mav.addObject("subject", subject);
        return AppUtils.goToPageByModelAndView(mav, "detailSearchResult");
    }
}
