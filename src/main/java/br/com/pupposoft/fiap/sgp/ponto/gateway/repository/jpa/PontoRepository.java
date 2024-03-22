package br.com.pupposoft.fiap.sgp.ponto.gateway.repository.jpa;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pupposoft.fiap.sgp.ponto.gateway.repository.jpa.entity.PontoEntity;

public interface PontoRepository extends JpaRepository<PontoEntity, Long>{
	Optional<PontoEntity> findByUsuarioIdAndDataHora(Long usuarioId, LocalDateTime dataHora);
}
