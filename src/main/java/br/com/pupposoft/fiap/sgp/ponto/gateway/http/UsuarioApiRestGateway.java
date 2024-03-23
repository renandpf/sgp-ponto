package br.com.pupposoft.fiap.sgp.ponto.gateway.http;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.pupposoft.fiap.sgp.ponto.domain.Usuario;
import br.com.pupposoft.fiap.sgp.ponto.exception.ErrorNaIntegracaoComUsuarioServiceException;
import br.com.pupposoft.fiap.sgp.ponto.gateway.UsuarioGateway;
import br.com.pupposoft.fiap.sgp.ponto.gateway.http.json.UsuarioJson;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Slf4j
@Component
public class UsuarioApiRestGateway implements UsuarioGateway {

	private ObjectMapper objectMapper;
			
	@Value("${usuario-service.base.url}")
	private String basePath;
	
	@Override
	public Usuario obtemPorUserId(Long userId) {
		
		try {
			OkHttpClient client = new OkHttpClient().newBuilder()
					  .build();
					MediaType mediaType = MediaType.parse("text/plain");
					RequestBody body = RequestBody.create("", mediaType);
					Request request = new Request.Builder()
					  .url("http://localhost:8080/usuarios/" + userId)
					  .method("GET", body)
					  .build();
					Response response = client.newCall(request).execute();
					
					ResponseBody responseBody = response.body();
					
					UsuarioJson usuarioJson = objectMapper.readValue(responseBody.string(), UsuarioJson.class);
					
					return usuarioJson.getDomain();
					
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ErrorNaIntegracaoComUsuarioServiceException();
		}
		

	}

}