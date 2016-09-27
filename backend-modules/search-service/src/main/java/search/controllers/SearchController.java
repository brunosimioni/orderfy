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
	
//	@Data
//	static class SuggestionRequest {
//		public String userId;
//		public String term;
//	}
//	
//	@Data
//	static class SuggestionResponse {
//		public int count;
//		public List<Suggestion> suggestions;
//	}

	@Autowired
    private SearchRepository searchRepository;

	@RequestMapping(path = "suggestions", method = RequestMethod.POST)
	public SuggResp.SuggRespMsg getTermSuggestion(@RequestBody SuggReq.SuggReqMsg req) {
		return searchRepository.getSuggestions(req.getUserId(), req.getTerm());
	}
}