package portifolioOrange.com.example.orangeJuice.domain.security;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SimpleGrantedAuthorityDeserializer extends StdDeserializer<List<GrantedAuthority>> {

    public SimpleGrantedAuthorityDeserializer() {
        this(null);
    }

    public SimpleGrantedAuthorityDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public List<GrantedAuthority> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        List<GrantedAuthority> authorities = new ArrayList<>();

        JsonNode node = jsonParser.readValueAsTree();
        if (node.isArray()) {
            for (JsonNode authorityNode : node) {
                if (authorityNode.isTextual()) {
                    authorities.add(new SimpleGrantedAuthority(authorityNode.asText()));
                }
            }
        }

        return authorities;
    }
}