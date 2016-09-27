package search.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import search.controllers.protobuf.SuggResp;

@Component
public class SearchRepository {

	public SuggResp.SuggRespMsg getSuggestions(String userId, String term) {
		
		List<SuggResp.SuggRespMsg.Suggestion> suggs = new ArrayList<SuggResp.SuggRespMsg.Suggestion>();
		suggs.add(suggestion(term, userId));
		suggs.add(suggestion(term, userId));
		suggs.add(suggestion(term, userId));
		suggs.add(suggestion(term, userId));
		
		return SuggResp.SuggRespMsg.newBuilder().setCount(suggs.size()).addAllSuggestions(suggs).build();
	}
	
	
	private SuggResp.SuggRespMsg.Suggestion suggestion(String term, String userId) {
		return SuggResp.SuggRespMsg.Suggestion.newBuilder().setContent("Suggested '"+Math.random()*100+"' for term: " + term  + " and for userId: " + userId).build();
	}
}
