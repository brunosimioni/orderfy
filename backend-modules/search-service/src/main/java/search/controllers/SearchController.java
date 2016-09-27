package search.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import search.controllers.protobuf.SuggReq;
import search.controllers.protobuf.SuggResp;
import search.repositories.SearchRepository;

@RestController
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
    private SearchRepository searchRepository;

	@RequestMapping(path = "suggestions", method = RequestMethod.POST)
	public SuggResp.SuggRespMsg getTermSuggestion(@RequestBody SuggReq.SuggReqMsg req) {
		return searchRepository.getSuggestions(req.getUserId(), req.getTerm());
	}

	@RequestMapping(path = "anysuggestion", method = RequestMethod.GET)
	public SuggResp.SuggRespMsg getAnySuggestion() {
		return searchRepository.getSuggestions("someid", "anyterm");
	}
}
