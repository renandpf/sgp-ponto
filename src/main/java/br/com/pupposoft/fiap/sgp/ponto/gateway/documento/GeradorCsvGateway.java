package br.com.pupposoft.fiap.sgp.ponto.gateway.documento;

import java.io.StringWriter;
import java.util.List;

import org.springframework.stereotype.Component;

import com.opencsv.CSVWriter;

import br.com.pupposoft.fiap.sgp.ponto.domain.Ponto;
import br.com.pupposoft.fiap.sgp.ponto.gateway.GeradorDocumentoGateway;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class GeradorCsvGateway implements GeradorDocumentoGateway {

	@Override
	public byte[] gerar(List<Ponto> pontos) {
		try {
			StringWriter stringWriter = new StringWriter();

			CSVWriter csvWriter = new CSVWriter(stringWriter);

			csvWriter.writeNext(new String[]{"ID", "DataHora"});
			pontos.forEach(ponto -> {
				String[] linha = {String.valueOf(ponto.getId()), ponto.getDataHora().toString()};
				csvWriter.writeNext(linha);
			});

			csvWriter.close();

			String csvContent = stringWriter.toString();

			return csvContent.getBytes();

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new RuntimeException("Erro ao gerar documento de ponto");//NOSONAR
		}

	}

}
