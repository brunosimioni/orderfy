Simple way of debugging protobuf request/responses by using curl and command line

# Files

- curl-request-suggestions.data: data sample to request suggestions
- search-suggestion-request.proto: request message
- search-suggestion-response.proto: response message

# Testing
cat curl-request-suggestions.data | ~/Downloads/protoc-3.1.0-linux-x86_64/bin/protoc --encode search.SuggReqMsg search-suggestion-request.proto | curl -v -sS -X POST -H "Content-Type: application/x-protobuf" --data-binary @- http://localhost:8080/search/suggestions  | ~/Downloads/protoc-3.1.0-linux-x86_64/bin/protoc --decode search.SuggRespMsg search-suggestion-response.proto
