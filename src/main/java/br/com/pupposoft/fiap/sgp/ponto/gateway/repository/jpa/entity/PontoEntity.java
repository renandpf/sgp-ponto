package br.com.pupposoft.fiap.sgp.ponto.gateway.repository.jpa.entity;

import java.time.LocalDateTime;

import br.com.pupposoft.fiap.sgp.ponto.domain.Ponto;
import br.com.pupposoft.fiap.sgp.ponto.domain.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Ponto")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PontoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long usuarioId;
	private LocalDateTime dataHora;
	
	public PontoEntity(Ponto ponto) {
		id = ponto.getId();
		usuarioId = ponto.getUsuario().getId();
		dataHora = ponto.getDataHora();
	}
	
	public Ponto getDomain() {
		return Ponto.builder()
				.id(id)
				.dataHora(dataHora)
				.usuario(Usuario.builder().id(usuarioId).build())
				.build();
	}
}
