package br.com.tools.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tools.entity.Transacao;
import br.com.tools.enums.TipoStatusTransacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    List<Transacao> findAllByDescricaoStatusIn(List<TipoStatusTransacao> status);

    Optional<Transacao> findByIdAndDescricaoStatusIn(Long id, List<TipoStatusTransacao> status);
}
