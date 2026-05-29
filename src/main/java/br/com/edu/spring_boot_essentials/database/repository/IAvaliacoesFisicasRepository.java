package br.com.edu.spring_boot_essentials.database.repository;

import br.com.edu.spring_boot_essentials.database.model.AlunosEntity;
import br.com.edu.spring_boot_essentials.database.model.AvaliacoesFisicasEntity;
import br.com.edu.spring_boot_essentials.dto.AvaliacoesFisicasProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAvaliacoesFisicasRepository extends JpaRepository<AvaliacoesFisicasEntity, Integer> {

    @NativeQuery(value = """
        SELECT a.id idAluno,
               a.nome nomeAluno,
               af.id idAvaliacao, 
               af.peso peso,
               af.altura altura,
               af.percentual_gordura_corporal percentualGorduraCorporal
        FROM avaliacoes_fisicas af
        INNER JOIN alunos a ON a.avaliacao_fisica_id = af.id
        """)
    List<AvaliacoesFisicasProjection> getAllAvaliacoes();

    @NativeQuery(value = """
        SELECT a.id idAluno,
               a.nome nomeAluno,
               af.id idAvaliacao, 
               af.peso peso,
               af.altura altura,
               af.percentual_gordura_corporal percentualGorduraCorporal
        FROM avaliacoes_fisicas af
        INNER JOIN alunos a ON a.avaliacao_fisica_id = af.id
        """,
    countQuery = """
        SELECT COUNT(af.id)
        FROM avaliacoes_fisicas af
        INNER JOIN alunos a ON a.avaliacao_fisica_id = af.id
        """)
    Page<AvaliacoesFisicasProjection> getAllAvaliacoesPage(Pageable pageable);

}

