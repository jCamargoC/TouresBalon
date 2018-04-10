package com.touresbalon.common.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.touresbalon.common.BusinessException;
import com.touresbalon.common.ErrorsEnum;

public class EncryptDeserializer extends JsonDeserializer<String> {

	@Override
	public String deserialize(JsonParser parser, DeserializationContext ctx)
			throws IOException, JsonProcessingException {
		ObjectCodec oc = parser.getCodec();
		JsonNode node = oc.readTree(parser);
		String encryptedCardNumber;
		try {
			encryptedCardNumber = EncryptionUtils.encodePassword(node.asText());
			return encryptedCardNumber;
		} catch (Exception e) {
			throw new BusinessException(ErrorsEnum.ENCRYPT_ERROR);
		}
	}

}
