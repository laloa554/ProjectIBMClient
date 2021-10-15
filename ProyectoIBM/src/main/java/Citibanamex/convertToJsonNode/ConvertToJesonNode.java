package Citibanamex.convertToJsonNode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertToJesonNode {
	public JsonNode getJsonNode(String json) {
		JsonNode jsonNode = null;
		try {
			jsonNode = new ObjectMapper().readTree(json);
			return jsonNode;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
